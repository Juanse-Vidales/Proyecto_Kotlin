package com.example.dashboard_cba.pages.home

import android.net.Uri
import android.widget.VideoView
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import com.example.dashboard_cba.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    // Estado para controlar la visibilidad del SplashScreen.
    val isVisible = remember { mutableStateOf(true) }

    // Efecto lanzado una vez al componerse para ocultar el SplashScreen después de 2000 ms (2 segundos).
    LaunchedEffect(Unit) {
        delay(3000) // Espera 3000 ms (3 segundos).
        isVisible.value = false // Oculta el SplashScreen.
    }

    // Uri del video almacenado en los recursos de la aplicación.
    val videoUri = "android.resource://${LocalContext.current.packageName}/${R.raw.sena1}"

    // Id de la imagen del logo (reemplaza "R.drawable.logo" por el id de tu imagen del logo).
    val logoId = R.drawable.logo

    // Composición del contenido del SplashScreen dentro de un Box que ocupa todo el espacio disponible.
    Box(modifier = Modifier.fillMaxSize()) {
        // Estado para la animación de rotación del video.
        val rotationState = remember { Animatable(initialValue = 0f) }

        // Efecto lanzado cuando cambia la visibilidad del SplashScreen para realizar la animación de rotación.
        LaunchedEffect(isVisible.value) {
            if (isVisible.value) {
                rotationState.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = 5000) // Animación de rotación durante 5000 ms (5 segundos).
                )
            }
        }

        // Vista de Android para mostrar el video en el SplashScreen.
        AndroidView(
            factory = {
                VideoView(it).apply {
                    setVideoURI(Uri.parse(videoUri)) // Establece la URI del video.
                    start() // Inicia la reproducción del video.
                }
            },
            modifier = Modifier.fillMaxSize(), // Ocupa todo el espacio disponible.
        )
        // Image del Compose para mostrar el logo en el centro.
        Image(
            painter = painterResource(logoId),
            contentDescription = "Logo",
            modifier = Modifier.align(alignment = androidx.compose.ui.Alignment.Center)
        )
    }
}
