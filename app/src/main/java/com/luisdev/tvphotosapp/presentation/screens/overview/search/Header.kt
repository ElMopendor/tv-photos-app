package com.luisdev.tvphotosapp.presentation.screens.overview.search


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.IconButton
import androidx.tv.material3.IconButtonDefaults
import androidx.tv.material3.OutlinedButton
import androidx.tv.material3.Text
import com.luisdev.tvphotosapp.R
import com.luisdev.tvphotosapp.presentation.screens.overview.OverviewScreenViewModel

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun Header(
    overviewScreenViewModel: OverviewScreenViewModel
){


    val searchText by remember { overviewScreenViewModel.getSearchText }
    val showBasicTextField by remember { overviewScreenViewModel.getShowTextField }


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding( 16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            IconButton(
                onClick = {
                    overviewScreenViewModel.setShowTextField(true)
                },
                colors = IconButtonDefaults.colors(
                    containerColor = Color(55, 149, 159),
                    contentColor = Color.White,
                )

            ) {
                Icon(Icons.Rounded.Search, contentDescription = stringResource(R.string.search_text_placeholder))

            }
            OutlinedButton(
                onClick = {
                    overviewScreenViewModel.getSearchQuery(true)
                },
                border = ButtonDefaults.border(
                    border = Border(border = BorderStroke(0.dp, Color.Transparent)),
                )
            ) {
                Text("PHOTO SEARCH")
            }

        }

        if(!showBasicTextField) {

            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                if(searchText!="")
                    "${stringResource(R.string.text_search_results_for)} \"$searchText\""
                else stringResource(R.string.text_trending)
            )

        }
    }
}