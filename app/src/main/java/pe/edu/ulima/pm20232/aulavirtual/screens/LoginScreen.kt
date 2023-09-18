package pe.edu.ulima.pm20232.aulavirtual.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.composables.LoginScreenComposable
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.FormViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.*
import androidx.compose.material.Text as Text1

@Composable
fun goToReset(){ //funcion para hacer la parte inferior del login que es si olvidaste contraseña
    Box(//cajita que contine la parte de olvidaste tu ocntraseña
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp),//tamaño del exterior del boton
        contentAlignment = Alignment.BottomCenter
    ){
        Row() {
            Text1(text = "Olvidaste tu contraseña? ", textAlign = TextAlign.End, color = Gray800, fontSize = 13.sp)
            Text1(text = "Recupérala aquí", textAlign = TextAlign.End, color = Orange400, fontSize = 13.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun LoginScreen(viewModel: FormViewModel) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    // se cargan los valores que usara el archivo login screen composable
    LoginScreenComposable(viewModel, "INGRESA ESTA INFORMACIÓN", Icons.Default.Person, "Usuario", Icons.Default.Lock, "Contraseña", "LOGIN")
    goToReset()
}
