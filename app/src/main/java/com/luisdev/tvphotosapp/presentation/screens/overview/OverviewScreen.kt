package com.luisdev.tvphotosapp.presentation.screens.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.luisdev.tvphotosapp.presentation.screens.overview.search.Body
import com.luisdev.tvphotosapp.presentation.screens.overview.search.Header
import com.luisdev.tvphotosapp.presentation.screens.overview.search.SearchView

@Composable
fun OverviewScreen(
    overviewScreenViewModel: OverviewScreenViewModel = hiltViewModel()
) {


    LaunchedEffect(true){
        overviewScreenViewModel.init()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {

        //HEADER
        Header( overviewScreenViewModel)

        //SEARCH INPUT TEXT
        SearchView(overviewScreenViewModel )

        //BODY
        Body(overviewScreenViewModel)


    }


}