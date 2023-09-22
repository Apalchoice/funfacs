package com.example.funfactsapp.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfactsapp.data.UserDataUiEvents
import com.example.funfactsapp.data.UserInputScreenState

class UserInputViewModel:ViewModel() {
    companion object{
        const val TAG="UserInputViewModel"
    }
    var uiState= mutableStateOf(UserInputScreenState())

    fun onEvent(event:UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEnter->{
                uiState.value=uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG,"onEvent:UserNameEnter->>")
                Log.d(TAG,"${uiState.value}")

            }
            is UserDataUiEvents.AnimalSelect->{
                uiState.value=uiState.value.copy(
                    animalSelect = event.animalValue
                )
                Log.d(TAG,"onEvent:AnimalSelect->>")
                Log.d(TAG,"${uiState.value}")

            }
        }
    }
    fun isValidState():Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty()&& !uiState.value.animalSelect.isNullOrEmpty()
    }
}


