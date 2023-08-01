package com.example.dashboard_cba.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dashboard_cba.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.widgets.DisappearingScaleBar
import com.google.maps.android.compose.widgets.ScaleBar

val senaCBA = LatLng (4.69615, -74.21572)
val tiendaCBA = LatLng (4.69612, -74.21569)
val unidadLacteosCBA = LatLng (4.69609, -74.21566)
val unidadAgricolaCBA = LatLng (4.69606, -74.21563)

@Composable
fun Page_Principal(){
    Column() {
        MapasScreen()
    }
}

@Composable
fun MapasScreen(){
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(senaCBA, 15f)
    // objeto para pasar al mapa
    val cameraPositionState = rememberCameraPositionState{
        position = defaultCameraPosition
    }
    // variable para determinar si mapa se cargo
    var isMapLoaded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        GoogleMapView(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            }
        )
        if (!isMapLoaded){
            AnimatedVisibility(
                modifier = Modifier
                    .matchParentSize(),
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    val senaCbaState = rememberMarkerState(position = senaCBA)
    val tiendaCbaState = rememberMarkerState(position = tiendaCBA)
    val unidadLacteosCbaState = rememberMarkerState(position = unidadLacteosCBA)
    val unidadAgricolaCbaState = rememberMarkerState(position = unidadAgricolaCBA)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
            onMapLoaded = onMapLoaded
        ){
            Marker(
                state = unidadAgricolaCbaState,
                title = "Unidad de Produccion Agricola CBA"
            )
            MarkerInfoWindowContent(
                state = unidadLacteosCbaState,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            ) {
                Text(
                    text = "Unidad de Produccion Lacteos CBA",
                    color = Color.Black
                )
            }
            MarkerInfoWindow(
                state = tiendaCbaState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.sena)
            ){
                Box(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.onPrimary,
                            shape = RoundedCornerShape(1.dp,1.dp,1.dp,1.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bg_tienda_cba),
                            contentDescription = null,
                            // contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(70.dp)
                                .fillMaxWidth()
                                .clip(CircleShape)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )
                        Text(
                            text = "Tienda Sena CBA",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
            content()
        }
        ScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopEnd),
            cameraPositionState = cameraPositionState
        )
        DisappearingScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopStart),
            cameraPositionState = cameraPositionState
        )
    }
}