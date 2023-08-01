package com.example.dashboard_cba.components

import Items_Bar
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


// Composición del BottomAppBar que representa la barra inferior del dashboard.
@Composable
fun BottomMenu(
    navController: NavController,
    menu_items_bar: List<Items_Bar>
){
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
    ) {
        BottomNavigation(
            modifier = Modifier.padding(
                0.dp,
                0.dp,
                60.dp,
                0.dp
            )
        ) {
            // Obtiene la ruta actual de la navegación.
            val currentRouteBar = Current_Route(navController = navController as NavHostController)

            // Crea cada elemento del BottomNavigation a partir de la lista de Items_Bar.
            menu_items_bar.forEach{item ->
                BottomNavigationItem(
                    selected = currentRouteBar == item.ruta, // Indica si el elemento está seleccionado según la ruta actual.
                    onClick = {navController.navigate(item.ruta)}, // Navega hacia la ruta correspondiente al hacer clic.
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = {Text(item.title)}
                )
            }
        }
    }
}

// Composición del botón flotante (FloatingActionButton) que muestra una snackbar cuando se hace clic.
@Composable
fun Fab(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){
    FloatingActionButton(
        onClick = {
            scope.launch {
                // Muestra una snackbar con un mensaje y un botón de acción.
                scaffoldState.snackbarHostState.showSnackbar(
                    "Próximamente disponible",
                    actionLabel = "Aceptar",
                    duration = SnackbarDuration.Indefinite
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    ) {
        Icon(
            imageVector = Icons.Filled.List,
            contentDescription = "Recompensas"
        )
    }
}