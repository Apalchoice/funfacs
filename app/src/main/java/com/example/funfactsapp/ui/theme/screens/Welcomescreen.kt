package com.example.funfactsapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfactsapp.ui.theme.FactComposable
import com.example.funfactsapp.ui.theme.FactsViewModel
import com.example.funfactsapp.ui.theme.TextComponent
import com.example.funfactsapp.ui.theme.TextWithShadow
import com.example.funfactsapp.ui.theme.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelect: String?) {
    println("=====Inside+WelcomeScreen")
    println("=====$username and $animalSelect")

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
        modifier= Modifier
            .fillMaxWidth()
            .padding(18.dp))
        {
            TopBar(value = "Welcome $username \uD83D\uDE0D")
            TextComponent(textValue = "Thank you! for sharing your data", textSize =24.sp )
            Spacer(modifier = Modifier.size(60.dp))

            val finalText=if (animalSelect=="Dog")"You are Dog Lover " else "You are a Lion Lover"


            TextWithShadow(value = finalText)

            val factsViewModel:FactsViewModel= viewModel()
            
            FactComposable(
                value =factsViewModel.generateRandomFact(animalSelect!!) )

        }

    }

}
@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "animalSelect")

}