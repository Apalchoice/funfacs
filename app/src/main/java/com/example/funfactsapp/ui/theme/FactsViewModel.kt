package com.example.funfactsapp.ui.theme

import androidx.lifecycle.ViewModel

class FactsViewModel:ViewModel() {
     fun generateRandomFact(selectedAnimal:String):String{
         return if(selectedAnimal=="Dog"){
             getDogFacts().random()
         }else{
             getLionFacts().random()
         }



    }




    fun getDogFacts():List<String>{
        val dogFacts= listOf(

            "Dogs can read our emotions",
             "Tail wags have multiple meanings",
        "Dogs can see more than just black and white.",
        "They curl up into a ball for protection",
        "Canines can sweat through their paws",
        "They can help with health problems",
        "3 dogs survived the Titanic",
        "They have wet noses for a reason"
        )
        return dogFacts

    }
    fun getLionFacts():List<String>{
        val lionFacts= listOf(
            "Nearly all wild lions live in Africa, but one small population exists elsewhere",
        "Male lions can weigh 30 stone",
        "They start off spotty",
        "The magnificent manes on male lions tell a story",
        "Lion cubs are reared together",
        "Lions can get their water from plants",
        "Lions are big eaters",
        "They hunt during storms"
        )
        return lionFacts

    }
}