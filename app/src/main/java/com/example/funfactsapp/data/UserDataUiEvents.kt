package com.example.funfactsapp.data

sealed class UserDataUiEvents{
    data class UserNameEnter(val name:String):UserDataUiEvents()
    data class AnimalSelect(val animalValue:String):UserDataUiEvents()
}
