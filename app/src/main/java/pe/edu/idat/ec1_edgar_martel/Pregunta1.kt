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
fun Pregunta01(){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(25.dp)){

        var vIndicador by rememberSaveable {
            mutableStateOf("")
        }

        var vTasa by rememberSaveable {
            mutableStateOf("")
        }

        var vResultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "ALCOHOLEMIA", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, style = TextStyle(fontSize = 40.sp), fontWeight = FontWeight.Bold)

            miEspacio(20)

            OutlinedTextField(
                value = vIndicador ,
                onValueChange ={vIndicador=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ingrese el indicador del vehículo: [C: Camión A: Autobus T: Turismo M: Motocicleta]")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            miEspacio(20)
            OutlinedTextField(
                value = vTasa ,
                onValueChange ={vTasa=it},
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Tasa máxima")},
                maxLines =1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            miEspacio(20)
            Button(onClick = { vResultado= evaluar(vIndicador,vTasa.toDouble())}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "EVALUAR")
            }
            Text(text = vResultado, style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue))
        }
    }
}

@Composable
fun miEspacio(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun evaluar(indicador:String,tasa: Double):String{
    var resultado="Todo conforme"

    if ((indicador=="C"||indicador=="A"||indicador=="M") && tasa>0.3){
        resultado= "La tasa $tasa ha excedido el límite."
    }

    if (indicador=="T" && tasa>0.5){
        resultado= "La tasa $tasa ha excedido el límite."
    }


    return resultado
}