package pe.edu.idat.ec1_edgar_martel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Pregunta03(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)){

        var vNumero by rememberSaveable {
            mutableStateOf("")
        }

        var vResultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "IMPRIMIR FECHA", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 40.sp), fontWeight = FontWeight.Bold)

            miEspacio(20)

            OutlinedTextField(
                value = vNumero ,
                onValueChange ={vNumero=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese un número") },
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            miEspacio(20)
            Button(onClick = { vResultado= imprimirMes(vNumero.toInt())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "EVALUAR")
            }
            Text(text = vResultado, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue))
        }
    }
}


fun imprimirMes(numero:Int):String{
    var resultado="NO ES UN MES CORRECTO"
    when (numero) {
        1 -> resultado="Enero"
        2 -> resultado="Febrero"
        3 -> resultado="Marzo"
        4 -> resultado="Abril"
        5 -> resultado="Mayo"
        6 -> resultado="Junio"
        7 -> resultado="Julio"
        8 -> resultado="Agosto"
        9 -> resultado="Setiembre"
        10 -> resultado="Octubre"
        11 -> resultado="Noviembre"
        12 -> resultado="Diciembre"
        else -> resultado="NO ES UN MES CORRECTO"
    }
    return resultado
}
