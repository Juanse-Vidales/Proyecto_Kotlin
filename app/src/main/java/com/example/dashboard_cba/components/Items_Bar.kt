// Define una clase sellada llamada "Items_Bar" que representa elementos de una barra de íconos en un dashboard.

import com.example.dashboard_cba.R

sealed class Items_Bar(
    val icon: Int,   // Almacena el ID del ícono asociado al elemento de la barra.
    val title: String,  // Almacena el título o nombre descriptivo del elemento de la barra.
    val ruta: String   // Almacena una ruta asociada al elemento de la barra.
) {
    // Subclase que representa el primer botón de la barra con su ícono, título y ruta asociada.
    object Boton1 : Items_Bar(R.drawable.ic_bike_24, "Inicio", "boton1")

    // Subclase que representa el segundo botón de la barra con su ícono, título y ruta asociada.
    object Boton2 : Items_Bar(R.drawable.ic_moto_24, "Contenidos", "boton2")

    // Subclase que representa el tercer botón de la barra con su ícono, título y ruta asociada.
    object Boton3 : Items_Bar(R.drawable.ic_recycling_24, "Información", "boton3")
}
