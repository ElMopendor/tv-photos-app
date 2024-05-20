package com.luisdev.tvphotosapp.presentation.screens.overview.search

import android.view.KeyEvent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.LocalContentColor
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalFocusManager
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.luisdev.tvphotosapp.R
import com.luisdev.tvphotosapp.presentation.screens.overview.OverviewScreenViewModel


@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchView(
    overviewScreenViewModel: OverviewScreenViewModel
){


    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    val searchText by remember { overviewScreenViewModel.getSearchText }
    val showBasicTextField by remember { overviewScreenViewModel.getShowTextField }




    if (showBasicTextField) {


        Surface(
            shape = ClickableSurfaceDefaults.shape(shape = ShapeDefaults.ExtraSmall),
            scale = ClickableSurfaceDefaults.scale(focusedScale = 1f),
            colors = ClickableSurfaceDefaults.colors(
                containerColor = MaterialTheme.colorScheme.inverseOnSurface,
                focusedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                pressedContainerColor = MaterialTheme.colorScheme.inverseOnSurface,
                focusedContentColor = MaterialTheme.colorScheme.onSurface,
                pressedContentColor = MaterialTheme.colorScheme.onSurface
            ),
            border = ClickableSurfaceDefaults.border(
                focusedBorder = Border(
                    border = BorderStroke(
                        width = if (isFocused) 2.dp else 1.dp,
                        color = animateColorAsState(
                            targetValue = if (isFocused) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.border, label = ""
                        ).value
                    ),
                    shape = ShapeDefaults.ExtraSmall
                )
            ),
            tonalElevation = 2.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp),
            onClick = {
                focusRequester.requestFocus()
            }

        ) {
            BasicTextField(
                value = searchText,
                onValueChange = { newSearchText ->
                    overviewScreenViewModel.setSearchText(newSearchText)

                },
                decorationBox = {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .padding(start = 20.dp),
                    ) {
                        it()
                        if (searchText.isEmpty()) {
                            Text(
                                modifier = Modifier.graphicsLayer { alpha = 0.6f },
                                text = stringResource(R.string.search_text_placeholder),
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    )
                    .focusRequester(focusRequester)
                    .onKeyEvent {
                        if (it.nativeKeyEvent.action == KeyEvent.ACTION_UP) {
                            when (it.nativeKeyEvent.keyCode) {
                                KeyEvent.KEYCODE_DPAD_DOWN -> {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }

                                KeyEvent.KEYCODE_DPAD_UP -> {
                                    focusManager.moveFocus(FocusDirection.Up)
                                }

                                KeyEvent.KEYCODE_BACK -> {
                                    overviewScreenViewModel.setShowTextField(false)
                                    focusManager.moveFocus(FocusDirection.Exit)
                                }

                            }
                        }
                        true
                    },
                cursorBrush = Brush.verticalGradient(
                    colors = listOf(
                        LocalContentColor.current,
                        LocalContentColor.current,
                    )
                ),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    imeAction = ImeAction.Search
                ),

                keyboardActions = KeyboardActions(
                    onSearch = {
                        overviewScreenViewModel.getSearchQuery(searchText)

                        focusManager.clearFocus()
                    }
                ),
                maxLines = 1,
                interactionSource = interactionSource,
                textStyle = MaterialTheme.typography.titleSmall.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}