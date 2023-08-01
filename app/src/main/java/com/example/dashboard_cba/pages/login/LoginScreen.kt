package com.example.dashboard_cba.pages.login

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.widget.VideoView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.dashboard_cba.R
import com.example.dashboard_cba.components.CreateChannelNotification
import com.example.dashboard_cba.components.PageScreen
import com.example.dashboard_cba.pages.home.SplashScreen
import kotlinx.coroutines.delay
import com.example.dashboard_cba.components.notificacionSencilla
import com.example.dashboard_cba.components.notificacionImagen

@Composable
fun LoginScreen(navController: NavController) {
    // Estado para controlar si se muestra el formulario de inicio de sesión o la pantalla de splash.
    val showLoginForm = rememberSaveable { mutableStateOf(true) }
    val showSplashScreen = remember { mutableStateOf(true) }
    val videoUri = "android.resource://${LocalContext.current.packageName}/${R.raw.sena2}"

    // Efecto lanzado para mostrar la pantalla de inicio por un tiempo determinado.
    LaunchedEffect(key1 = showSplashScreen.value) {
        delay(2000) // Puedes ajustar el tiempo de espera según tus necesidades
        showSplashScreen.value = false
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        // Si se debe mostrar la pantalla de splash, mostrarla.
        if (showSplashScreen.value) {
            SplashScreen()
        } else {
            // Si no, mostrar el contenido principal dentro de un contenedor Box.
            Box(modifier = Modifier.fillMaxSize()) {
                // Reproductor de video en segundo plano.
                val videoView = VideoView(LocalContext.current).apply {
                    setVideoURI(Uri.parse(videoUri))
                    setOnCompletionListener {
                        // Reiniciar el video cuando llega al final.
                        start()
                    }
                    start()
                }

                AndroidView(
                    factory = { videoView },
                    modifier = Modifier.fillMaxSize(),
                )

                // Colocar el contenido dentro de la Card con un color de fondo diferente.
                Card(
                    modifier = Modifier
                        .offset(y = 150.dp)
                        .align(Alignment.Center)
                        .padding(16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = MaterialTheme.colors.secondary.copy(alpha = 0.7f), // Cambiar el color de fondo aquí
                    elevation = 4.dp
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Mostrar el formulario de inicio de sesión o el formulario de creación de cuenta.
                        if (showLoginForm.value) {
                            Text(text = "Inicia Sesión")
                            UserForm(isCreateAccount = false) { email, password ->
                                Log.d("TiendaApp", "Inicio sesión con $email y $password")
                                // TODO: Implementar el inicio de sesión y la navegación a la pantalla principal.
                                navController.navigate(PageScreen.Dashboard.name)
                            }
                        } else {
                            Text(text = "Crear Cuenta Nueva")
                            UserForm(isCreateAccount = true) { email, password ->
                                Log.d("TiendaApp", "Creando cuenta con $email y $password")
                                // TODO: Implementar la creación de cuenta y la navegación a la pantalla principal.
                                navController.navigate(PageScreen.Dashboard.name)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Alternar entre el texto para cambiar entre el formulario de inicio de sesión y el formulario de creación de cuenta.
                            val text1 = if (showLoginForm.value) "¿No tienes cuenta?" else "¿Ya tienes cuenta?"
                            val text2 = if (showLoginForm.value) "Registrate" else "Inicia Sesión"
                            Text(text = text1)
                            Text(
                                text = text2,
                                modifier = Modifier.clickable { showLoginForm.value = !showLoginForm.value }
                                    .padding(start = 5.dp),
                                color = Color.Blue
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserForm(
    isCreateAccount: Boolean,
    onDone: (String, String) -> Unit = { _, _ ->}
) {
    // ID de la notificación y contexto.
    val idNotification = 0
    val context: Context = LocalContext.current

    // Canal de notificación y texto para notificaciones.
    val idChannel: String = stringResource(R.string.CanalTienda)
    val name = stringResource(R.string.CanalTienda)
    val descriptionText = stringResource(R.string.Canal_de_Notificaciones_Tienda_CBA)
    val textShort = "Usted acaba de iniciar sesión en la Tienda CBA"
    val textLong = "Saludos! Usted acaba de registrarse en la tienda CBA " +
            "al usted registrarse podra tener acceso a muchos beneficios. " +
            "Puede hablar con una persona a cargo para poder saber de ellos." +
            "Gracias y hasta otro momento"

    // Icono e imagen para las notificaciones.
    val iconoBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_contact_mail_black_48dp
    )
    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.bg_tienda_cba
    )

    // Estado para el email, contraseña y visibilidad de la contraseña.
    val email = rememberSaveable {
        mutableStateOf("")
    }
    val password = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable {
        mutableStateOf(false)
    }

    // Estado para validar si el email y contraseña no están vacíos.
    val validState = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    // Controlador del teclado para ocultar el teclado después de enviar.
    val keyboardController = LocalSoftwareKeyboardController.current

    // Efecto lanzado al componerse para crear el canal de notificación.
    LaunchedEffect(Unit) {
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo de entrada para el email.
        EmailInput(
            emailState = email
        )

        // Campo de entrada para la contraseña.
        PasswordInput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )

        // Espaciado.
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

        // Botón de envío.
        SubmitButton(
            textId = if (isCreateAccount) "Crear Cuenta" else "Iniciar Sesión",
            inputValid = validState
        ) {
            // Callback cuando se hace clic en el botón de envío.
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()

            // Mostrar notificación de imagen o notificación sencilla dependiendo del tipo de cuenta.
            if (isCreateAccount) {
                notificacionImagen(
                    context,
                    idChannel,
                    idNotification + 2,
                    "Notificación con Imagen",
                    textLong,
                    iconoBig,
                    imagenBig
                )
            } else {
                notificacionSencilla(
                    context,
                    idChannel,
                    idNotification,
                    "Notificación Sencilla",
                    textShort
                )
            }
        }
    }
}


@Composable
fun SubmitButton(
    textId: String,
    inputValid: Boolean,
    onClic: (isCreateAccount: Boolean) -> Unit
) {
    Button(
        onClick = { onClic(textId == "Crear Cuenta") },
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape,
        enabled = inputValid
    ) {
        Text(
            text = textId,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}


@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
) {
    // Transformación visual para mostrar o ocultar la contraseña.
    val visualTransformation =
        if (passwordVisible.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation()

    OutlinedTextField(
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = labelId) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (passwordState.value.isNotBlank())
                PasswordVisibleIcon(passwordVisible)
            else null
        }
    )
}


@Composable
fun PasswordVisibleIcon(
    passwordVisible: MutableState<Boolean>
) {
    val image =
        if (passwordVisible.value)
            Icons.Default.VisibilityOff
        else
            Icons.Default.Visibility

    IconButton(onClick = {
        passwordVisible.value = !passwordVisible.value
    }) {
        Icon(
            imageVector = image,
            contentDescription = ""
        )
    }
}


@Composable
fun EmailInput(
    emailState: MutableState<String>,
    labelId: String = "Email"
) {
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType = KeyboardType.Email
    )
}


@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    keyboardType: KeyboardType,
    isSingleLine: Boolean = true
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(
                bottom = 10.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}