# Proyecto_Kotlin
Proyecto de Kotlin realizado durante el tercer trimestre del Tecnólogo en Análisis y Desarrollo de Software, es una aplicación hecha con Jet Pack Compose, dicha aplicación cumple la función de reproducir una tienda de venta de productos agrícolas del SENA CBA de Mosquera.


# Descripción del Funcionamiento del Proyecto
-*El proyecto consta de varias partes, entre las cuales se encuentra una página tipo splash que tiene un video en el fondo, con un logo del SENA en el centro.*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/24a4979d-04ae-4193-bbad-c67a128447cf)

-*Seguido de esto se encuentra una página de tipo login que le permite al usuario loguearse o registrarse a su preferencia, también los textos cambiaran dependiendo si se loguea o registra, además que en el momento en que se loguee o registre le enviara una notificación con una descripción de lo que acaba de hacer.* 

-*Dicha página también incluye un video de fondo con una card con el formulario, la card consta de un color azul aguamarina en un estilo claro. El botón de iniciar sesión o registrarse no estará activo hasta que los campos previos se hayan diligenciado.*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/edd2e326-e159-4696-86c0-7e36a9707b0d)

-*Después de esta página se encuentra una que envía al usuario a una página principal donde se muestra la ubicación del SENA CBA en Google Maps, donde se podrá interactuar con el mapa y ver más de cerca las ubicaciones que se encuentran cerca del mismo.*

![WhatsApp Image 2023-07-27 at 3 19 49 PM](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/951a2097-e896-47e4-b86a-b05cee0058d1)

-*En la parte inferior de la página se encuentran de 3 objetos, de izquierda a derecha serian: un botón de "Inicio" con el logo de un ciclista, un botón de "Contenidos" con el logo de una moto scooter, un botón de "Información" con el logo de reciclaje y un menú del tipo hamburguesa que aún se encuentra en su etapa de desarrollo. Cada una de estas dirige a una página diferente de la aplicación.*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/d4151f97-3fa7-4ed7-8640-0b723cb0c73d)

-*En la parte superior de la página se encuentra un total de 4 objetos y un texto, de izquierda a derecha serian: un menú de tipo hamburguesa que dirige a los demás categorías de productos, un texto que dice "Tienda Sena CBA", un icono de recarga que aún se encuentra en su etapa de desarrollo, un icono de configuración aún se encuentra en su etapa de desarrollo y un icono de tres puntos que muestra una opción de cambio de idioma y de compartir, estas funciones aún se encuentran en su etapa de desarrollo*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/4403b325-3aba-475e-902e-87c7c817b547)

-*En la pestaña de "Inicio" se encuentra información acerca de CampeSena, que es, su estrategia, su objetivo entre otra información relevante para la persona que le interesa.*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/9d8e5525-36c9-4de8-bf6f-2868f1752a8a)

-*En la página de "Contenidos" se encuentran los productos de la aplicación, dichos productos se encuentran en cards, las cards tienen la imagen del producto, el nombre del producto y una descripción del producto, además de constar de un icono de agregar a favoritos en color rojo, este icono al usarlo envía una notificación, también se encuentran los botones de comprar y más detalles, estos botones también tienen unas notificaciones que se envían al usarlos*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/fa0a149f-a7d1-43d7-ac01-6a4864812dc6)

-*En la página de "Información" se encuentra la manera de acceder a Campe SENA, explica las diferentes maneras de acceder al mismo, además de que también muestra cuáles son sus beneficios*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/377e19ff-1c4d-47c0-b8c7-ff854d0ac21d)

-*Al usar el menú hamburgués que se encuentra en la parte superior izquierda se mostrara una imagen horizontal de Campe SENA, seguidos hacia abajo se encuentran las diversas paginas visitables, entre ellas están: La Página Principal, La página de las Flores, la página de las Frutas y Verduras, la página de los Huevos, la página de los lácteos, la página de Ver Más*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/f85c3c6b-da91-4854-90f9-e8da2142b8e8)

-*En la página de Flores se encuentran únicamente los productos de tipo flores, que vienen construidos en cards con sus respectivos botones e iconos funcionales*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/9c23224f-fff5-4d18-a9e8-3a6a8ec36b9e)

-*En la página de Frutas y Verduras se encuentran únicamente los productos de tipo Futas y Verduras, que vienen construidos en cards con sus respectivos botones e iconos funcionales*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/1069665f-14f5-4af1-8bef-fad9534989b1)

-*En la página de Huevos se encuentran únicamente los productos de tipo Huevos, que vienen construidos en cards con sus respectivos botones e iconos funcionales*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/30a9f322-34e9-4541-aed7-116a04962c8a)

-*En la página de Lácteos se encuentran únicamente los productos de tipo Lácteos, que vienen construidos en cards con sus respectivos botones e iconos funcionales*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/e7df0b66-44a6-41cb-8cd9-5fa3f153f29f)

-*En la página de Ver Más se encuentran únicamente los productos de tipo Condimentos, que vienen construidos en cards con sus respectivos botones e iconos funcionales*

![image](https://github.com/IanMoonn/Proyecto_Kotlin/assets/110430143/1501f230-c639-4ac8-b62f-3f3f57fe5724)

# Funcionamiento del código del Proyecto

-**MainActivity:**

  * *Clase [MainActivity] que representa la actividad principal de la aplicación. Esta actividad se inicia al iniciar la aplicación y se encarga de configurar el contenido de la interfaz de usuario.*

-***Carpeta Components:***

-**ItemsBar:**

  * *Define una clase sellada llamada "Items_Bar" que representa elementos de una barra de íconos en un dashboard.*

-**MainPage:**

  -*Función principal que representa la páginas del dashboard.*
  
-**MenuItem:**

* *Define una clase sellada llamada "MenuIetm" que representa elementos de una barra de lateral en un dashboard.*

-**NavigationBottom:**

  * *Composición del BottomAppBar que representa la barra inferior del dashboard.*  
  
-**NavigationDrawer:**

  * *Composición del menú lateral (Drawer).*

-**NavigationHost:**

  * *Menú del Drawer.*  
  
-**NotificactionsChannel:**

  * *Función para crear un canal de notificación en dispositivos Android 8.0 y versiones superiores.*

-**TiendaApp:**

  * *Enumeración que define las pantallas posibles en la aplicación.*  
  
-**TopBar:**

  * *Define la funcion del menu desplegable.*

-***Carpeta Pages:***

-**Page_Contenidos:**

  * *Pagina principal donde se muestran todos los productos.*  

-**Page_Contenidos:**

  * *Pagina principal donde se muestran todos los productos.*  
  
-**Page_Flores:**

  * *Pagina de flores donde se muestran unicamente los productos relacionados con flores.*  
  
-**Page_Frutas_verduras:**

  * *Pagina de frutas y verduras donde se muestran unicamente los productos relacionados con frutas y verduras.*  
  
-**Page_Huevos:**

   * *Pagina de huevos donde se muestran unicamente los productos relacionados con huevos.*  
  
-**Page_Informacion:**

  * *Pagina donde se encuentra toda la informacion relacionada con CampeSENA.*  
  
-**Page_Inicio:**

  * *Pagina donde se explica que es CampeSena.*  
  
-**Page_Lacteos:**

  * *Pagina de frutas y verduras donde se muestran unicamente los productos relacionados con frutas y verduras.*  
  
-**Page_Principal:**

  * *Pagina principal donde se muestra el Goole Maps funcional.*  
   
-**Page_Ver_Mas:**

  * *Pagina donde se muestan productos del tipo condimentos.*  
  
-***Carpeta Home:***

-**SplashScreen:**

  * *Función principal que muestra el splash previo al login.*
  
-***Carpeta Login:***

-**LoginScreen:**

  * *Función principal que muestra el formulario del login.*
  
-***Carpeta Utils:***

-**Constants:**

  * *Objeto [Constants] que contiene constantes utilizadas en la aplicación.*
