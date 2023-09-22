package com.example.funfactsapp.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.R
import com.example.funfactsapp.data.UserDataUiEvents
import com.example.funfactsapp.ui.theme.AnimalCard
import com.example.funfactsapp.ui.theme.ButtonComponent
import com.example.funfactsapp.ui.theme.TextComponent
import com.example.funfactsapp.ui.theme.TextFieldComponent
import com.example.funfactsapp.ui.theme.TopBar
import com.example.funfactsapp.ui.theme.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel
)

    { Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)

        ) {
            TopBar("Hello Champ!! \uD83D\uDE0D ")

            TextComponent(
                textValue = "Let Us Learn Something Awesome About You!Exciting",
                textSize = 24.sp
            )
            Spacer(modifier = Modifier.size(20.dp))


            TextComponent(
                textValue = "We shall prepare a detailed page based on your information.Lets GO  ",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEnter(it)
                )
            })
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What Animal Are You?", textSize = 18.sp)


            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.dog1, animalSelect = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelect(it)
                    )

                }, selected = userInputViewModel.uiState.value.animalSelect == "Dog")

                AnimalCard(
                    image = R.drawable.lion, animalSelect = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelect(it)
                        )

                    },
                    selected = userInputViewModel.uiState.value.animalSelect == "Lion"
                )

            }

            Spacer(modifier = Modifier.weight(1f))


            if (userInputViewModel.isValidState()) {
                ButtonComponent {
                    println("=============ComingHere")
                    println("=============${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelect}")
                    showWelcomeScreen(
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalSelect
                        )
                    )

                }
            }
        }
    }
}

fun showWelcomeScreen(pair: Pair<String, String>) {

}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
    
}

