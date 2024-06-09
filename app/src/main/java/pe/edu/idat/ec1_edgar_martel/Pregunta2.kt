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
fun Pregunta02(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)){

        var vNumero1 by rememberSaveable {
            mutableStateOf("")
        }

        var vNumero2 by rememberSaveable {
            mutableStateOf("")
        }

        var vResultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "OPERACIONES", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 40.sp), fontWeight = FontWeight.Bold)

            miEspacio(20)

            OutlinedTextField(
                value = vNumero1 ,
                onValueChange ={vNumero1=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Número 1") },
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            miEspacio(20)
            OutlinedTextField(
                value = vNumero2 ,
                onValueChange ={vNumero2=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Número 2") },
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            miEspacio(20)
            Button(onClick = { vResultado= operacion(vNumero1.toInt(),vNumero2.toInt()) }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "EVALUAR")
            }
            Text(text = vResultado, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue))
        }
    }
}


fun operacion(numero1:Int,numero2:Int):String{
    var resultado=""
    var valor=0

    if(numero1==numero2){
        valor=numero1*numero2
    }else if(numero1>numero2){
        valor=numero1-numero2
    }else{
        valor=numero1+numero2
    }

    resultado="El resultado es $valor"

    return resultado
}