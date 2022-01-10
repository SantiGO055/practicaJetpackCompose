package com.santi.practicajetpackcompose

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Textos
* @param name Recibe el texto a renderizar
 * @param color Recibe el color que tendra el texto
 * @param style Recibe la tipografia a utilizar en el texto
 * @param lines Recibe el numero de lineas (parrafo) a renderizar. Por defecto si no se pasa valor renderizara el maximo
 *
* */
@Composable
fun MyText(name: String, color: Color, style: androidx.compose.ui.text.TextStyle, lines: Int = Int.MAX_VALUE) {
    Text(text = name, color = color, style = style, maxLines = lines)
}

@Composable
fun MyTexts(message: MyMessage) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        Modifier
            .padding(start = 8.dp)
            .clickable { //true o false
                expanded = !expanded
            }) {
        MyText(
            message.title,
            MaterialTheme.colors.primary,
            MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(16.dp))
        MyText(
            message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2,
            if(expanded) Int.MAX_VALUE else 1
        )
    }


}

@Composable
fun BotonConListado(){
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(

                text = { Text("Call api")},
                onClick = { getPerritos() })
        },
        floatingActionButtonPosition = FabPosition.Center,


    ) {
        MyMessages(messages)
    }


}
@Composable
fun textoBoton(){
    Text(text = "call api")
}

@Preview(showSystemUi = true)
@Composable
fun preview(){
    BotonConListado()
}

@Composable
fun MyComponent(message: MyMessage) {


    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
    ) {

        MyImage()
        Spacer(modifier = Modifier.width(16.dp))
        MyTexts(message)
    }
}