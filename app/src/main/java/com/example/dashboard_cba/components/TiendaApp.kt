package com.example.dashboard_cba.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_cba.pages.login.LoginScreen

// Enumeración que define las pantallas posibles en la aplicación.
enum class PageScreen() {
    Start,
    Dashboard
}

// Composición de la aplicación de la tienda.
@Composable
fun TiendaApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PageScreen.Start.name // Define la pantalla de inicio en el NavHost.
    ) {
        composable(route = PageScreen.Start.name) {
            // Composición de la pantalla de inicio (LoginScreen) cuando se navega a PageScreen.Start.
            Scaffold(
                topBar = {null}
            ) { padding ->
                ScaffoldContent(
                    padding = padding
                )
                LoginScreen(navController)
            }
        }
        composable(PageScreen.Dashboard.name) {
            // Composición de la pantalla del dashboard (MainPage) cuando se navega a PageScreen.Dashboard.
            MainPage()
        }
    }
}

// Composición del contenido del Scaffold.
@Composable
fun ScaffoldContent(
    padding: PaddingValues,
) {
    Column(
        modifier = Modifier
            .padding(
                top = 16.dp,
                bottom = padding.calculateBottomPadding()
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            // Aquí se puede componer el contenido que aparecerá en el Scaffold.
            // Por ejemplo, se puede añadir elementos adicionales dentro de este Row.
        }
    }
}