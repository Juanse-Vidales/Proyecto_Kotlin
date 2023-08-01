package com.example.dashboard_cba.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    menuItem: List<MenuItem>
) {
    // Estado para controlar si el menú desplegable debe mostrarse o no.
    var showMenu by rememberSaveable {
        mutableStateOf(false)
    }

    // Obtiene la ruta actual de la pantalla para determinar el título de la AppBar.
    val currentRoute = Current_Route(navController = navController as NavHostController)
    var myTytle = "Tienda sena CBA"

    // Recorre los elementos del menú para determinar el título actual de la AppBar.
    menuItem.forEach { item ->
        if (currentRoute == item.ruta) myTytle = item.title
    }

    // Composición de la AppBar.
    TopAppBar(
        title = { Text(text = myTytle) }, // Muestra el título actual de la AppBar.
        navigationIcon = {
            // Icono de menú que abre el Drawer cuando se hace clic.
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Icono de menú"
                )
            }
        },
        actions = {
            // Icono de refresco con funcionalidad a implementar.
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Refrescar")
            }

            // Icono de configuración con funcionalidad a implementar.
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Configurar")
            }

            // Icono de "Más Opciones" que muestra o esconde el menú desplegable.
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Más Opciones")
            }

            // Menú desplegable con opciones adicionales.
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier.width(150.dp)
            ) {
                // Opción de cambio de idioma con funcionalidad a implementar.
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Idioma")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Idioma")
                }

                // Opción de compartir con funcionalidad a implementar.
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Compartir")
                }
            }
        }
    )
}