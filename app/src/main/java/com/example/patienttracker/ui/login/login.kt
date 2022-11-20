package com.example.patienttracker.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patienttracker.ui.theme.PatientTrackerTheme

@Composable
fun EmailInput() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        label = { Text(text = "Enter Your Email", color = Color.White) },
        onValueChange = {
            text = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                focusedBorderColor =  Color(0xFFB1D4E0),
                unfocusedBorderColor = Color.Black
       ),
    )
}

@Composable
fun PasswordInput() {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        label = { Text(text = "Enter Your Password", color = Color.White) },
        onValueChange = {
            password = it
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            focusedBorderColor =  Color(0xFFB1D4E0),
            unfocusedBorderColor = Color.Black
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
       trailingIcon = {
           val image = if (passwordVisible)
               Icons.Filled.Visibility
           else Icons.Filled.VisibilityOff
           // Please provide localized description for accessibility services
           val description = if (passwordVisible) "Hide password" else "Show password"

           IconButton(onClick = {passwordVisible = !passwordVisible}){
               Icon(imageVector  = image, description)
           }
       }
    )
}


@Composable
fun LoginScreen(){
    Box( modifier = Modifier
        .background(color = Color(0xFF0C2D48))
        .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(modifier = Modifier
            .padding(15.dp)
            .align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            EmailInput()
           PasswordInput()
            Button(
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFB1D4E0)),
                modifier = Modifier
                    .padding(5.dp)
                    .width(270.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }
}



@Preview(showBackground = true, widthDp = 390, heightDp = 800)
@Composable
fun DefaultPreview() {
    PatientTrackerTheme {
        LoginScreen()
    }
}