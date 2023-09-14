package pe.edu.ulima.pm20232.aulavirtual.screenmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {
    var texto1: String by mutableStateOf("")
    var texto2: String by mutableStateOf("")

    fun btnAccessPressed(): Unit{
        println("Form1: $texto1")
        println("Form2: $texto2")
        /*if(texto1.length != 8){
            println("DNI: Longitud incorrecta")
        }else{
            println("ERROR: Esta entrega del trabajo solo es estética")
        }*/
    }
}