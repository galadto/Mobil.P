package pe.edu.ulima.pm20232.aulavirtual.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pe.edu.ulima.pm20232.aulavirtual.R
import pe.edu.ulima.pm20232.aulavirtual.composables.LoginScreenComposable
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.FormViewModel

@Composable
fun Flechita() {
    Column(
        modifier = Modifier.padding(top = 20.dp, start = 20.dp).zIndex(4f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = Color.Gray
        )
    }
}

@Composable
fun PasswordScreen(viewModel: FormViewModel) {
    Flechita()
    LoginScreenComposable(viewModel, "SOLICITE CAMBIO DE CONTRASEÑA", Icons.Default.AccountBox, "DNI", Icons.Default.Email, "Correo", "ENVIAR CORREO")
}