package pe.edu.ulima.pm20232.aulavirtual.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.PasswordScreenViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.*
import androidx.compose.material.Text as Text1



@Composable
fun TopScreen(){
    Column(modifier =Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth().background(Gray1200).weight(3f).padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            val paddingPercentage = 60;
            val paddingValue = with(LocalDensity.current) {
                (paddingPercentage * 0.02f * 16.dp.toPx()).dp
            }
            Column(
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
            }
            Column(
                modifier = Modifier.padding(top = paddingValue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ulima), // Replace with your SVG resource ID
                    contentDescription = "Universidad de Lima",
                    modifier = Modifier.size(120.dp),
                    colorFilter = ColorFilter.tint(Orange500),
                )
                Text1(
                    text = "Gimnasio ULima",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    //fontSize = 40.sp,
                    modifier =  Modifier.padding(top = 20.dp, bottom = 20.dp),
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.caslon_classico_sc_regular)),
                        color = if (isSystemInDarkTheme()) White400 else Orange500 // Apply the custom text color here
                    )
                )
            }
        }
    }
}

@Composable
fun LoginForm(screenWidthDp: Int, screenHeightDp: Int, viewModel: PasswordScreenViewModel){
    Box( // caja gris (light)
        modifier = Modifier.fillMaxSize().padding(top = (screenHeightDp * 0.35).dp,).background(White400),
    ) {
        Box(modifier = Modifier.padding(
            start = (screenWidthDp * 0.125).dp,
            top = (40.dp)
        ),){
            Box(
                modifier = Modifier
                    .size(
                        (screenWidthDp * 0.75).dp,
                        (screenHeightDp * 0.42 ).dp
                    ) // Adjust the size as needed
                    //.border(1.dp, Gray800)
                    .background(White400)
                    .shadow(
                        elevation = 5.dp,
                        shape = MaterialTheme.shapes.medium,
                        //color = Color.Gray
                    )
                    .padding(start = 20.dp, top = 30.dp, bottom = 20.dp, end = 20.dp),
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text1(text ="SOLICITE CAMBIO DE CONTRASEÑA", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.AccountBox, // Replace with your desired icon
                        placeholder = "DNI",
                        text = viewModel.dni,
                        onTextChanged = {
                            println(it)
                            viewModel.dni = it
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = Icons.Default.Email, // Replace with your desired icon
                        placeholder = "Correo",
                        text = viewModel.email,
                        onTextChanged = {
                            println(it)
                            viewModel.email = it
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button({ viewModel.btnAccessPressed() },
                            modifier = Modifier.fillMaxWidth().height(55.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Orange500, // Button background color
                                contentColor = Color.Black // Text and icon color
                            ),
                            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text1("ENVIAR CORREO")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PasswordScreen(viewModel: PasswordScreenViewModel) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    TopScreen()
    LoginForm(screenWidthDp, screenHeightDp, viewModel)
}