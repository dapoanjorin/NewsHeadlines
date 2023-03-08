package com.dapo.headlinenews.ui.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.dapo.remote.model.Article

@Composable
fun NewsItem(
    article: Article,
    openBrowser: (String?) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable {
                openBrowser(article.url)
            }
            .fillMaxWidth()
            .height(170.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberImagePainter(article.urlToImage) {
                transformations(
                    RoundedCornersTransformation(10f)
                )
            }, contentDescription = null
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.6f))
        )
        Column(Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = article.description ?: "",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = article.author ?: "",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 12.sp
                )
            )
        }
    }
}