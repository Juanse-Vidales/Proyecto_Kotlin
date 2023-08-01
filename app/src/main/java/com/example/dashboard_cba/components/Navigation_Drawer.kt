package com.example.dashboard_cba.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.dashboard_cba.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Composición del menú lateral (Drawer).
@Composable
fun DrawerMenu(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController,
    menu_items: List<MenuItem>
){
    Column {
        // Imagen de fondo del menú.
        Image(
            painterResource(id = R.drawable.bg_tienda_cba),
            contentDescription = "Menu de Opciones",
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        // Espaciado entre la imagen de fondo y los elementos del menú.
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(15.dp)
        )
        // Obtiene la ruta actual de la navegación.
        val currentRoute = Current_Route(navController as NavHostController)
        // Crea cada elemento del menú a partir de la lista de MenuItem.
        menu_items.forEach { item ->
            DrawerItem(
                item = item,
                selected = currentRoute == item.ruta
            ) {
                // Navega hacia la ruta correspondiente al hacer clic en el elemento del menú.
                navController.navigate(item.ruta) {
                    launchSingleTop = true
                }
                // Cierra el menú lateral después de hacer clic en un elemento del menú.
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
        }
    }
}

// Composición de un elemento del menú lateral (DrawerItem).
@Composable
fun DrawerItem(
    item: MenuItem,
    selected: Boolean,
    onItemClick: (MenuItem) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .background(
                if (selected) MaterialTheme.colors.primaryVariant.copy(alpha = 0.25f)
                else Color.Transparent
            )
            .padding(8.dp)
            .clickable { onItemClick(item) }, // Permite que el elemento sea clickeable.
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono del elemento del menú.
        Image(
            painterResource(id = item.icon),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        // Texto del elemento del menú.
        Text(
            text = item.title,
            style = MaterialTheme.typography.body1,
            color = if (selected) MaterialTheme.colors.secondaryVariant
            else MaterialTheme.colors.onBackground
        )
    }
}