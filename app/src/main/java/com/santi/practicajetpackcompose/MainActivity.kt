package com.santi.practicajetpackcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.santi.practicajetpackcompose.ui.theme.PracticaJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PracticaJetpackComposeTheme {
                MyComponent()
            }
            //todo lo de aca adentro se pinta en la pantalla

        }
    }



}

@Composable
fun MyText(name: String, color: Color, style: androidx.compose.ui.text.TextStyle){
    Text(text = name, color = color, style = style)
}

@Composable
fun MyTexts() {
    Column {
        MyText(
            "Hola Jetpack compose",
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            "Breve descripcion",
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }

}

@Composable
fun MyComponent(){
    Row(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(8.dp)) {
        MyImage()
        Spacer(modifier = Modifier.width(16.dp))
        MyTexts()
    }
}
@Composable
fun MyImage() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "imagen de prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Gray)
            .size(64.dp) //imagen redonda y color de fondo
            .background(MaterialTheme.colors.primary)
    )
}
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponentNight(){
    PracticaJetpackComposeTheme {
        MyComponent()
    }
}

@Preview
@Composable
fun PreviewComponentLight(){
    PracticaJetpackComposeTheme {
        MyComponent()
    }
}



