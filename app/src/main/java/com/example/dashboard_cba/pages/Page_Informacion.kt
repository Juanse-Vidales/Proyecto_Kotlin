package com.example.dashboard_cba.pages

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboard_cba.R

@Composable
fun InfomacionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes text1: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxHeight(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
            Text(
                text = stringResource(text1),
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxHeight(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun Page_Informacion() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(Informacion_Data) { item ->
            InfomacionCard(item.drawable, item.text, item.text1)
        }
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

private val Informacion_Data = listOf(
    DrawableInformacion(R.drawable.noticia1, R.string.Noticia1, R.string.Noticia1_Texto),
    DrawableInformacion(R.drawable.noticia2, R.string.Noticia2, R.string.Noticia2_Texto),
    DrawableInformacion(R.drawable.noticia3, R.string.Noticia3, R.string.Noticia3_Texto),
    DrawableInformacion(R.drawable.noticia4, R.string.Noticia4, R.string.Noticia4_Texto),
    DrawableInformacion(R.drawable.noticia5, R.string.Noticia4, R.string.Noticia5_Texto),
    DrawableInformacion(R.drawable.noticia6, R.string.Noticia4, R.string.Noticia6_Texto)
)

class DrawableInformacion(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    @StringRes val text1: Int
)
