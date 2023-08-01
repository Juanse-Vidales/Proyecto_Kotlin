package com.example.dashboard_cba
/**
 * Clase [MainActivity] que representa la actividad principal de la aplicación.
 * Esta actividad se inicia al iniciar la aplicación y se encarga de configurar el contenido
 * de la interfaz de usuario.
 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dashboard_cba.components.TiendaApp
import com.example.dashboard_cba.ui.theme.Dashboard_CBATheme

class MainActivity : ComponentActivity() {
    /**
     * Método [onCreate] que se llama cuando se crea la actividad.
     * Aquí se configura el contenido de la interfaz de usuario utilizando Jetpack Compose.
     * Se establece el tema de la aplicación y se coloca el componente [TiendaApp] dentro
     * del tema para construir la interfaz de usuario.
     *
     * savedInstanceState El estado anterior de la actividad, que contiene datos que
     * pueden haberse guardado anteriormente.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Establecer el tema de la aplicación utilizando Dashboard_CBATheme
            Dashboard_CBATheme {
                // Colocar el componente TiendaApp dentro del tema para construir la interfaz de usuario
                TiendaApp()
            }
        }
    }
}
