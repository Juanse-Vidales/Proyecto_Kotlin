package com.example.dashboard_cba.components

import com.example.dashboard_cba.R

// Clase sellada que representa los elementos del menú lateral (Drawer).
sealed class MenuItem(
    val icon: Int,      // Almacena el ID del ícono asociado al elemento del menú.
    val title: String,  // Almacena el título o nombre descriptivo del elemento del menú.
    val ruta: String    // Almacena una ruta asociada al elemento del menú. (Probablemente para navegación o identificación posterior).
) {
    // Subclase que representa el primer elemento del menú con su ícono, título y ruta asociada.
    object Page01 : MenuItem(R.drawable.ic_principal, "Principal", "page01")

    // Subclase que representa el segundo elemento del menú con su ícono, título y ruta asociada.
    object Page02 : MenuItem(R.drawable.ic_flores, "Flores", "page02")

    // Subclase que representa el tercer elemento del menú con su ícono, título y ruta asociada.
    object Page03 : MenuItem(R.drawable.ic_frutas_verduras, "Frutas y Verduras", "page03")

    // Subclase que representa el cuarto elemento del menú con su ícono, título y ruta asociada.
    object Page04 : MenuItem(R.drawable.ic_huevos, "Huevos", "page04")

    // Subclase que representa el quinto elemento del menú con su ícono, título y ruta asociada.
    object Page05 : MenuItem(R.drawable.ic_lacteos, "Lacteos", "page05")

    // Subclase que representa el sexto elemento del menú con su ícono, título y ruta asociada.
    object Page06 : MenuItem(R.drawable.ic_ver_mas, "Ver Más", "page06")
}
