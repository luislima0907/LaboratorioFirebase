package gt.edu.miumg.luis.laboratoriofirebase.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gt.edu.miumg.luis.laboratoriofirebase.view.login.BlankView
import gt.edu.miumg.luis.laboratoriofirebase.view.login.RegisterView
import gt.edu.miumg.luis.laboratoriofirebase.view.login.TabView
import gt.edu.miumg.luis.laboratoriofirebase.view.notas.HomeView
import gt.edu.miumg.luis.laboratoriofirebase.viewmodel.LoginViewModel
import gt.edu.miumg.luis.laboratoriofirebase.viewmodel.NotesViewModel

@Composable
fun NavManager(
    loginViewModel: LoginViewModel,
    viewModel: NotesViewModel
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "blank"){
        composable("login"){
            TabView(navController =  navController, loginViewModel = loginViewModel)
        }
        composable("register"){
            RegisterView(navController = navController, loginViewModel = loginViewModel)
        }
        composable("home"){
            HomeView(navController =  navController, viewModel = viewModel)
        }
        composable("blank"){
            BlankView(navController = navController)
        }
    }
}