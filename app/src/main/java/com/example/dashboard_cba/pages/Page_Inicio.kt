package com.example.dashboard_cba.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dashboard_cba.R

@Composable
fun Page_Inicio() {
    val scrollState = rememberLazyListState()

    Box(Modifier.fillMaxSize()) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
        ) {
            item {
                Column {
                    Text(
                        text = "CampeSENA es una estrategia del SENA para promover el reconocimiento de la labor del campesinado colombiano, " +
                                "fortalecer su economía y facilitar el acceso de esta población a los diferentes programas y servicios del SENA, " +
                                "con justicia social, ambiental y económica.\n\nCon esta estrategia, el SENA busca propiciar el reconocimiento del " +
                                "campesinado en la vida social, cultural y económica del país con líneas de acción transversales para atender a esta " +
                                "población y generar capacidades para la articulación y consolidación de modelos asociativos campesinos.\n\nEl objetivo " +
                                "principal es fortalecer las capacidades, conocimientos y habilidades de la población campesina, y abrirle la puerta a nuevas " +
                                "opciones que le permitan incrementar sus ingresos y mejorar su calidad de vida.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 60.dp)
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    Image(
                        painter = painterResource(R.drawable.campesena1),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "¿Qué es CampeSENA?",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 60.dp)
                    )
                    Text(
                        text = "Es una estrategia del SENA para promover el reconocimiento de la labor del campesinado colombiano, fortalecer su economía y facilitar" +
                                "el acceso de esta población a los diferentes programas y servicios del SENA, con justicia social, ambiental y económica.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 60.dp)
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    Image(
                            painter = painterResource(R.drawable.campesena1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    Text(
                        text = "¿Para qué sirve?",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 60.dp)
                    )
                    Text(
                        text = "Con esta estrategia el SENA busca propiciar el reconocimiento del campesinado en la vida social, cultural y económica del país con líneas " +
                                "de acción transversales para atender a esta población y generar capacidades para la articulación y consolidación de modelos asociativos " +
                                "campesinos.",
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 60.dp)
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                }
            }
        }
    }
}