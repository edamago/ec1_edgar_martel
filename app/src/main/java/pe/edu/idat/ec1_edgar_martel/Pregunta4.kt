package pe.edu.idat.ec1_edgar_martel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pregunta04(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)){

        var vResultado by rememberSaveable {
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "SUMATORIA", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 40.sp), fontWeight = FontWeight.Bold)
            Button(onClick = { vResultado= evaluar()}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "EVALUAR")
            }
            Text(text = vResultado, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue))
        }
    }
}

fun evaluar():String{
    var resultado="Todo conforme"
    var valor=0
    for (numero in 23..99){
        val numeroCadena = numero.toString()

        for(c in numeroCadena){
            valor+=c.toString().toInt()
        }
    }
    resultado="La sumatorio de los dígitos entre 23 y 99 es: $valor"
    return resultado
}