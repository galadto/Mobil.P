package pe.edu.ulima.pm20232.aulavirtual.screenmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PasswordScreenViewModel: ViewModel() {
    var dni: String by mutableStateOf("")
    var email: String by mutableStateOf("")

    fun btnAccessPressed(): Unit{
        println("Email: $email")
        if(dni.length != 8){
            println("DNI: Longitud incorrecta")
        }else{
            println("ERROR: Esta entrega del trabajo solo es estética")
        }
    }
}