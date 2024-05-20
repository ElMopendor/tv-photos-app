package com.luisdev.tvphotosapp.presentation.screens.overview.search


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvLazyVerticalGrid
import androidx.tv.foundation.lazy.grid.itemsIndexed
import androidx.tv.material3.Text
import com.luisdev.tvphotosapp.data.network.api.DataState
import com.luisdev.tvphotosapp.presentation.common.PhotoItem
import com.luisdev.tvphotosapp.presentation.screens.overview.OverviewScreenViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.stringResource
import com.luisdev.tvphotosapp.R



@Composable
fun Body(
    overviewScreenViewModel: OverviewScreenViewModel
){

    val searchState  =  overviewScreenViewModel.searchState.observeAsState()

    val searchText by remember { overviewScreenViewModel.getSearchText }

    val searchedList by remember { overviewScreenViewModel.getSearchedList }


    if(searchState.value is DataState.Failure){
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "${stringResource(R.string.text_no_search_results)} $searchText"
            )
        }
    }
    else if(searchedList.isEmpty()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(R.string.text_loading_more)
            )
        }
    }
    else{
        Column {

            Box (
                modifier = Modifier.weight( 1f )
            ) {


                TvLazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize(),
                    columns = TvGridCells.Adaptive(250.dp)

                ) {

                    itemsIndexed(searchedList) { index, item ->
                        PhotoItem(item = item)
                        if (index == searchedList.size - 1) {
                            LaunchedEffect(
                                key1 = index,
                                block ={ overviewScreenViewModel.getSearchQuery(false)}
                            )
                        }
                    }

                }
            }
            if(searchState.value is DataState.Init){
                Box(modifier = Modifier
                    .height(if (searchState.value !is DataState.Success) 60.dp else 0.dp)
                    .fillMaxWidth()){
                    Text(
                        stringResource(R.string.text_loading_more),
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
        }
    }
}
