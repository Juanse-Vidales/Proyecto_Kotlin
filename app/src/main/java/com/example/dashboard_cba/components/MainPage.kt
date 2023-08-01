package com.example.dashboard_cba.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.dashboard_cba.ui.theme.Dashboard_CBATheme

// Función principal que representa la página principal del dashboard.
@Composable
fun MainPage() {
    // Inicializa el controlador de navegación para la aplicación.
    val navController = rememberNavController()

    // Crea el estado para la barra de Scaffold (app bar) permitiendo conocer su configuración.
    val scaffoldState = rememberScaffoldState()

    // Crea un ámbito de corutinas para abrir/cerrar el menú lateral.
    val scope = rememberCoroutineScope()

    // Lista de opciones de navegación para el menú lateral (Drawer).
    val navigationItems = listOf(
        MenuItem.Page01,
        MenuItem.Page02,
        MenuItem.Page03,
        MenuItem.Page04,
        MenuItem.Page05,
        MenuItem.Page06,
    )

    // Lista de opciones de navegación para la barra inferior (BottomBar).
    val navigationItemsBottomBar = listOf(
        Items_Bar.Boton1,
        Items_Bar.Boton2,
        Items_Bar.Boton3,
    )

    // Composición del Scaffold, que define la estructura general de la pantalla del dashboard.
    Scaffold(
        scaffoldState = scaffoldState, // Estado del Scaffold (app bar).
        topBar = {
            TopBar(
                scope,
                scaffoldState,
                navController,
                navigationItems
            )
        }, // Componente de la barra superior (app bar).

        drawerContent = {
            DrawerMenu(
                scope,
                scaffoldState,
                navController,
                menu_items = navigationItems
            )
        }, // Componente del menú lateral (Drawer).

        bottomBar = {
            BottomMenu(
                navController,
                menu_items_bar = navigationItemsBottomBar
            )
        }, // Componente de la barra inferior (BottomBar).

        floatingActionButton = {
            Fab(
                scope,
                scaffoldState
            )
        }, // Componente del botón flotante (FloatingActionButton).

        isFloatingActionButtonDocked = true // Indica si el botón flotante está siempre visible o se oculta en el desplazamiento.
    ) { padding ->
        // Contenido del Scaffold (app bar, menú, barra inferior, etc.)
        ContentScaffold(
            padding = padding
        )
        // Host de navegación para gestionar las transiciones entre las pantallas del dashboard.
        Navigation_Host(navController)
    }
}

// Función que define el contenido del Scaffold.
@Composable
fun ContentScaffold(padding: PaddingValues) {
    // ... (implementa el contenido para el Scaffold aquí)
}

// Vista previa de la página principal del dashboard.
@Preview
@Composable
fun MainPagePreview() {
    // Crea el tema para el dashboard y muestra la MainPage.
    Dashboard_CBATheme {
        // Contenedor de superficie usando el color de fondo del tema.
        MainPage()
    }
}