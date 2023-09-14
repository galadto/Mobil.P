package pe.edu.ulima.pm20232.aulavirtual.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import pe.edu.ulima.pm20232.aulavirtual.screenmodels.FormViewModel
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Black100
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Gray1200
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange400
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange500
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.Orange800
import pe.edu.ulima.pm20232.aulavirtual.ui.theme.White400

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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_ulima), // Replace with your SVG resource ID
                    contentDescription = "Universidad de Lima",
                    modifier = Modifier.size(120.dp),
                    colorFilter = ColorFilter.tint(Orange500),
                )
                Text(
                    text = "Gimnasio ULima",
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier =  Modifier.padding(top = 20.dp, bottom = 20.dp),
                    style = MaterialTheme.typography.h4.copy(
                        fontSize = 40.sp,
                        fontFamily = FontFamily(Font(R.font.caslon_classico_sc_regular)),
                        color = if (isSystemInDarkTheme()) Black100 else Orange400 // Apply the custom text color here
                    )
                )
            }
        }
    }
}

@Composable
fun LoginForm(screenWidthDp: Int, screenHeightDp: Int, viewModel: FormViewModel, textoSuperior: String, iconoForm1: ImageVector, textoForm1: String, iconoForm2: ImageVector, textoForm2: String, textoBoton: String){
    Box( // caja gris (light)
        modifier = Modifier.fillMaxSize().padding(top = (screenHeightDp * 0.35).dp,).background(
            White400
        ),
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
                    Text(text = textoSuperior, fontWeight = FontWeight.Normal, fontSize = 13.sp)
                    TextFieldWithLeadingIcon(
                        leadingIcon = iconoForm1, // Replace with your desired icon
                        placeholder = textoForm1,
                        text = viewModel.texto1,
                        onTextChanged = {
                            println(it)
                            viewModel.texto1 = it
                        }
                    )
                    TextFieldWithLeadingIcon(
                        leadingIcon = iconoForm2, // Replace with your desired icon
                        placeholder = textoForm2,
                        text = viewModel.texto2,
                        onTextChanged = {
                            println(it)
                            viewModel.texto2 = it
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
                                Text(textoBoton)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldWithLeadingIcon(
    leadingIcon: ImageVector,
    placeholder: String,
    text: String,
    onTextChanged: (String) -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }
    val borderColor = if (isFocused) Color.Blue else Color.Gray

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            //.border(1.dp, borderColor)
            .padding(5.dp)
            .background(color = Color.Transparent)
        ,
        value = text,
        onValueChange = {
            onTextChanged(it)
        },
        placeholder = {
            Text(text = placeholder, fontSize = 16.sp)
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.LightGray,
            unfocusedIndicatorColor = Orange800
        ),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                tint = (if (isSystemInDarkTheme()) White400 else Orange400),
                modifier = Modifier
                    .padding(4.dp)
                    .size(24.dp)
                    .clickable { /* Handle icon click if needed */ }
            )
        },
    )
}

@Composable
fun LoginScreenComposable(viewModel: FormViewModel, textoSuperior: String, iconoForm1: ImageVector, textoForm1: String, iconoForm2: ImageVector, textoForm2: String, textoBoton: String) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    TopScreen()
    LoginForm(screenWidthDp, screenHeightDp, viewModel, textoSuperior, iconoForm1, textoForm1, iconoForm2, textoForm2, textoBoton)
}