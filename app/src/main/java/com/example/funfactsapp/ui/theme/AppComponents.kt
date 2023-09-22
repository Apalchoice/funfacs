package com.example.funfactsapp.ui.theme

import android.hardware.lights.Light
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.R
import com.example.funfactsapp.R.drawable.dog1
import com.example.funfactsapp.Utility
import com.example.funfactsapp.data.UserDataUiEvents
import java.security.Key


@Composable
fun TopBar(value:String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment =Alignment.CenterVertically
    ){
}



}
@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}

@Composable
fun TextComponent(
                  textValue:String,
                  textSize:TextUnit,
                  colorValue: Color= Color.Black) {
    Text(text = textValue,
    fontSize=textSize,
    color=colorValue,fontWeight = FontWeight.Light
    )

}
@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "CHOICE LTD", textSize =24.sp )
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged :(name:String) ->Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager= LocalFocusManager.current
    OutlinedTextField(
        modifier=Modifier.fillMaxWidth(),
        value =currentValue ,
        onValueChange = {
                        currentValue=it
                        onTextChanged(it)

        },
        placeholder = {
            Text(text = "Enter your Name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }

    )
    
}
@Composable
fun AnimalCard(image:Int,selected:Boolean,
               animalSelect: (animalName:String)->Unit
) {
    val localFocusManager= LocalFocusManager.current

    Card(
        shape= RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                ),

        ){
            
        }
        Image(
            modifier= Modifier
                .padding(16.dp)
                .wrapContentWidth()
                .wrapContentHeight()
                .clickable {
                    val animalName = if (image == R.drawable.dog1) "Dog" else "Lion"
                    animalSelect(animalName)
                    localFocusManager.clearFocus()


                },
            painter = painterResource(id = image) ,
            contentDescription ="Animal Image" )


    }

    
}
@Preview
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.dog1, false,{"Dog"})

}

@Composable
fun ButtonComponent(
    goToDetailsScreen:()->Unit
) {

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()

        }) {
        TextComponent(textValue = "Go To  Details Screen"
            ,textSize =18.sp,
            colorValue = Color.Magenta)
    }

}

@Composable
fun TextWithShadow(value: String) {
    val shadowOffset= Offset(x=1f,y=2f)
    Text(
        text = value,
        fontSize = 24.sp,
        fontWeight =FontWeight.Light,
        style = TextStyle(
            shadow= Shadow(Utility.generateRandomColor(),shadowOffset,2f)
        )
    )
    
}

@Composable
fun FactComposable(value: String) {
    Card(modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column (
            modifier = Modifier.padding(18.dp,24.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.quotes),
                contentDescription ="Quote image",
                modifier = Modifier.rotate(180f)
            )
            Spacer(modifier = Modifier.size(24.dp))

            TextWithShadow(value = value)

            Spacer(modifier = Modifier.size(24.dp))

            Image(
                painter = painterResource(id = R.drawable.quotes),
                contentDescription ="Quote image",
            )



        }

    }

}
@Preview
@Composable
fun FactComposablePreview() {
    FactComposable(value = "ABCD")

}
