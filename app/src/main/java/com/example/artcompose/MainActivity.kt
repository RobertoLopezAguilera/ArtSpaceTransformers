package com.example.artcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artcompose.ui.theme.ArtComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtComposeTheme {
                ArtComposeImage()
            }
        }
    }
}

@Preview//(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtComposeImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentWidth(Alignment.CenterHorizontally)
    )

}

@Composable
fun ArtComposeImage(modifier : Modifier=Modifier){
    var imagen by remember {mutableStateOf(1) }
    val imagenResource = getImage(imagen)
    val textoResource = getTexto(imagen)
    val tituloResource= getTitulo(imagen)

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Spacer(modifier = Modifier.height(60.dp))


        Row(horizontalArrangement = Arrangement.Start) {
            Image(painter = painterResource(id = imagenResource), contentDescription =null)

        }

        Row(horizontalArrangement = Arrangement.Center) {
            Text(stringResource(id = tituloResource))
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Text(stringResource(id = textoResource), textAlign = TextAlign.Center)
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                if (imagen>0 || imagen<4){
                    imagen--
                }
                if(imagen<=0){
                    imagen=1
                }
            }) {
                Text(text = "Previos")
            }
            Button(onClick = {
                if (imagen>0 || imagen<4){
                    imagen++
                }
                if(imagen>=4){
                    imagen=4
                }
            }) {
                Text(text = "Next ")
            }
        }
    }
}

private fun getImage(id:Int):Int{
    val imagenResource = when(id) {
        1->R.drawable.optimus
        2->R.drawable.bumblebe
        3->R.drawable.sentinel
        else->R.drawable.megratron
    }
    return  imagenResource
}

private fun getTexto(id:Int):Int{
    val textoResource = when(id) {
        1->R.string.creacionT1
        2->R.string.creacionT2
        3->R.string.creacionT3
        else->R.string.creacionT4
    }

    return  textoResource
}

private fun getTitulo(id:Int):Int{
    val tituloResource = when(id) {
        1->R.string.t1
        2->R.string.t2
        3->R.string.t3
        else->R.string.t4
    }
    return tituloResource
}