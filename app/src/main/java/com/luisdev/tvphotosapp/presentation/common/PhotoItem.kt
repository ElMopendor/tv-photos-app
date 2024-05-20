package com.luisdev.tvphotosapp.presentation.common

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.luisdev.tvphotosapp.R
import com.luisdev.tvphotosapp.data.entities.Photo
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun PhotoItem(item: Photo){
    Box(
        modifier = Modifier
            .width(250.dp)
            .height(200.dp)
            .padding(16.dp)

    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            onClick = {},
            shape = CardDefaults.shape(shape = RoundedCornerShape(15.dp))

        ) {
            Box(
                modifier = Modifier.fillMaxSize()

            ) {
                GlideImage(
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                    model = item.urls.small,
                    contentDescription = item.description ?:item.altDescription,
                    loading = placeholder(ColorDrawable(0xff37959F.toInt()))


                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 95f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Column {
                        Text(
                            item.altDescription ?: item.description ?: "Sin descripción"  ,
                            style = TextStyle(color = Color.White, fontSize = 10.sp),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        val formattedDate: String   = item.createdAt.format(DateTimeFormatter.ofPattern("MMM d  uuuu"))
                        Text("${item.userResponse.name} / $formattedDate" , style = TextStyle(color = Color.White, fontSize = 10.sp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }


    }
}