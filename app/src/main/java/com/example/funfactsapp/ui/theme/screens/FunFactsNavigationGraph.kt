package com.example.funfactsapp.ui.theme.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.funfactsapp.ui.theme.UserInputViewModel

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel= viewModel()) {
    val navController= rememberNavController()

    NavHost(navController =navController , startDestination = Routes.USER_INPUT_SCREEN){
        composable(Routes.USER_INPUT_SCREEN){
            UserInputScreen(userInputViewModel)
        }
        composable("${Routes.WELCOME_SCREEN}/{${Routes.USER_NAME}}/{${Routes.ANIMAL_SELECT}}",
            arguments = listOf(
                navArgument(name=Routes.USER_NAME){type= NavType.StringType},
                navArgument(name =Routes.ANIMAL_SELECT){type= NavType.StringType}
            )
        ){
            val username=it?.arguments?.getString(Routes.USER_NAME)
            val animalSelect=it?.arguments?.getString(Routes.ANIMAL_SELECT)
            WelcomeScreen(username,animalSelect)
        }
    }

}