package com.example.dashboard_cba.components

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.Manifest
import com.example.dashboard_cba.R
import com.example.dashboard_cba.MainActivity

// Función para crear un canal de notificación en dispositivos Android 8.0 y versiones superiores.
fun CreateChannelNotification(
    idChannel: String,
    context: Context,
    name: String,
    descriptionText: String
) {
    // Verifica si el dispositivo tiene una versión de Android 8.0 o superior.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        // Define la importancia del canal de notificación.
        val importance = NotificationManager.IMPORTANCE_HIGH

        // Crea el objeto NotificationChannel con la información proporcionada.
        val channel = NotificationChannel(
            idChannel,
            name,
            importance
        ).apply {
            description = descriptionText
        }

        // Obtiene el gestor de notificaciones del sistema.
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Crea el canal de notificación.
        notificationManager.createNotificationChannel(channel)
    }
}

// Función para mostrar una notificación sencilla en el dispositivo.
fun notificacionSencilla(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContext: String,
    priority: Int = NotificationCompat.PRIORITY_HIGH
) {
    // Crea un intent para abrir la actividad principal (MainActivity).
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    // Crea un PendingIntent para la actividad principal.
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    // Construye la notificación sencilla con el contenido proporcionado.
    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_shopping_cart_24)
        .setContentTitle(textTitle)
        .setContentText(textContext)
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    // Muestra la notificación utilizando NotificationManagerCompat.
    with(NotificationManagerCompat.from(context)) {
        // Verifica si se tienen los permisos para mostrar notificaciones.
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Considerar la solicitud de permisos aquí.
            // El código a continuación necesita manejar el caso donde el usuario
            // otorga los permisos. Ver la documentación para ActivityCompat#requestPermissions.
            return
        }
        notify(idNotification, builder)
    }
}

// Función para mostrar una notificación con contenido extenso en el dispositivo.
fun notificacionExtensa(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContext: String,
    bigIcono: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_HIGH
) {
    // Crea un intent para abrir la actividad principal (MainActivity).
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    // Construye la notificación con contenido extenso.
    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_shopping_cart_24)
        .setContentTitle(textTitle)
        .setContentText(textContext)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat.BigTextStyle()
                .bigText(textContext)
        )
        .setPriority(priority)
        .build()

    // Muestra la notificación utilizando NotificationManagerCompat.
    with(NotificationManagerCompat.from(context)) {
        // Verifica si se tienen los permisos para mostrar notificaciones.
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Considerar la solicitud de permisos aquí.
            // El código a continuación necesita manejar el caso donde el usuario
            // otorga los permisos. Ver la documentación para ActivityCompat#requestPermissions.
            return
        }
        notify(idNotification, builder)
    }
}

// Función para mostrar una notificación con imagen en el dispositivo.
fun notificacionImagen(
    context: Context,
    idChannel: String,
    idNotification: Int,
    textTitle: String,
    textContext: String,
    bigIcono: Bitmap,
    bigImagen: Bitmap,
    priority: Int = NotificationCompat.PRIORITY_HIGH
) {
    // Crea un intent para abrir la actividad principal (MainActivity).
    val intent = Intent(
        context,
        MainActivity::class.java
    ).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    // Crea un PendingIntent para la actividad principal.
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context,
        0,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    // Construye la notificación con imagen.
    val builder = NotificationCompat.Builder(
        context,
        idChannel
    )
        .setSmallIcon(R.drawable.ic_shopping_cart_24)
        .setContentTitle(textTitle)
        .setContentText(textContext)
        .setLargeIcon(bigIcono)
        .setStyle(
            NotificationCompat
                .BigPictureStyle()
                .bigPicture(bigImagen)
                .setBigContentTitle("Tienda Sena CBA")
        )
        .setPriority(priority)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .build()

    // Muestra la notificación utilizando NotificationManagerCompat.
    with(NotificationManagerCompat.from(context)) {
        // Verifica si se tienen los permisos para mostrar notificaciones.
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Considerar la solicitud de permisos aquí.
            // El código a continuación necesita manejar el caso donde el usuario
            // otorga los permisos. Ver la documentación para ActivityCompat#requestPermissions.
            return
        }
        notify(idNotification, builder)
    }
}