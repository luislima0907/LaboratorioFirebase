package gt.edu.miumg.luis.laboratoriofirebase.view.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import gt.edu.miumg.luis.laboratoriofirebase.components.Alert
import gt.edu.miumg.luis.laboratoriofirebase.viewmodel.LoginViewModel

@Composable
fun RegisterView(
    navController: NavController,
    loginViewModel: LoginViewModel
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }

        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                loginViewModel.register(userName = userName, email =  email, password = password){
                    navController.navigate("home")
                }
            },
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        ) {
            Text("Registrar")
        }
        if (loginViewModel.showAlert){
            Alert(
                title = "Error",
                message = "No se pudo registrar el usuario",
                confirmText = "Aceptar",
                onConfirm = { loginViewModel.closeAlert()}
            ) {

            }
        }
    }
}