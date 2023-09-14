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
import androidx.compose.ui.unit.dp
import pe.edu.ulima.pm20232.aulavirtual.composables.LoginScreenComposable
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.FormViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray800

@Composable
fun PasswordScreen(viewModel: FormViewModel) {
    /*Column(
        modifier = Modifier.padding(top = paddingValue),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(32.dp),
            tint = Gray800
        )
    }*/
    LoginScreenComposable(viewModel, "SOLICITE CAMBIO DE CONTRASEÑA", Icons.Default.AccountBox, "DNI", Icons.Default.Email, "Correo", "ENVIAR CORREO")
}