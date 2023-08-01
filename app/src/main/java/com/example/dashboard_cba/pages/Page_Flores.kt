package com.example.dashboard_cba.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dashboard_cba.R
import com.example.dashboard_cba.components.notificacionExtensa
import com.example.dashboard_cba.components.notificacionImagen
import com.example.dashboard_cba.components.notificacionSencilla

@Composable
fun FloresCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes text1: Int,
    modifier: Modifier = Modifier
) {
    val idNotification = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.CanalTienda)
    val textShort = "Usted acaba de intentar comprar un producto"
    val textShort1 = "Usted acaba de darle a un producto como favorito." +
            "Muchas gracias"
    val textLong = "Saludos! Gracias por interesarse en uno de nuestros productos. "

    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_contact_mail_black_48dp
    )

    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    val showDialog = remember { mutableStateOf(false) }

    Card(
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(shape = MaterialTheme.shapes.medium)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(text),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp)) // Add some space between text and button
                Button(
                    onClick = {
                        showDialog.value = true
                        notificacionExtensa(
                            context,
                            idChannel,
                            idNotification + 1,
                            "Notificación Extensa",
                            textLong,
                            iconoBig
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp) // Tamaño ajustado del botón
                ) {
                    Text(
                        text = "Más detalles",
                        fontSize = 12.sp // Tamaño de fuente ajustado del botón
                    )
                }

                // Agregar el AlertDialog aquí
                if (showDialog.value) {
                    AlertDialog(
                        onDismissRequest = { showDialog.value = false },
                        title = {
                            Box(
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .padding(16.dp)
                            ){
                                Image(
                                    painter = painterResource(drawable),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                IconButton(
                                    onClick = {
                                        notificacionImagen(
                                            context,
                                            idChannel,
                                            idNotification + 2,
                                            "Notificación con Imagen",
                                            textShort1,
                                            iconoBig,
                                            imagenBig
                                        )
                                    },
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(top = 8.dp, end = 8.dp)
                                        .align(Alignment.TopEnd)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "Favorito",
                                        tint = Color.Red
                                    )
                                }
                            }
                        },
                        text = {
                            Text(
                                text = stringResource(text1),
                                style = MaterialTheme.typography.h6,
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp
                            )
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    notificacionSencilla(
                                        context,
                                        idChannel,
                                        idNotification,
                                        "Notificación Sencilla",
                                        textShort
                                    )
                                }, // Cierra la tarjeta emergente al hacer clic en el botón "Aceptar"
                            ) {
                                Text(
                                    text = "Comprar",
                                    fontSize = 15.sp // Tamaño de fuente ajustado del botón
                                )
                            }
                        },
                        dismissButton = {
                            Button(
                                onClick = { showDialog.value = false }, // Cierra la tarjeta emergente al hacer clic en el botón "Cancelar"
                            ) {
                                Text(text = "Cancelar")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Page_Flores() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(FloresData) { item ->
            FloresCard(item.drawable, item.text, item.text1)
        }
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

private val FloresData = listOf(
    DrawableFlores(R.drawable.rosas, R.string.Rosa, R.string.Rosa_Texto),
    DrawableFlores(R.drawable.narcisos, R.string.Narciso, R.string.Narciso_Texto),
    DrawableFlores(R.drawable.jazmines, R.string.Jazmin, R.string.Jazmin_Texto),
    DrawableFlores(R.drawable.margaritas, R.string.Margarita, R.string.Margarita_Texto),
)

class DrawableFlores(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    @StringRes val text1: Int
)