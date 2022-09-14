package com.example.basicjetpackapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicjetpackapp.R
import com.example.basicjetpackapp.ui.theme.BasicJetpackAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicJetpackAppTheme {
                MainContent()
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun MainContent() {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    val context = LocalContext.current



    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.full),
            contentDescription = "App Logo",
            modifier = Modifier
                .weight(1f)
                .size(180.dp)
        )
        Card(
            Modifier
                .weight(2f)
                .padding(12.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )
                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "E-mail") },

                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        )
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Black,
                            focusedLabelColor = Color.Black,
                            cursorColor = Color.Black
                        ),

                        )

                    Spacer(modifier = Modifier.padding(10.dp))


                    Button(
                        onClick = {
//                                if (emailValue.value == "vipin" && passwordValue.value == "123456") {
                            context.startActivity(Intent(context, Dashboard::class.java))
//
                            Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT)
                                .show()
//
//                                } else {
//                                    Toast.makeText(
//                                        context,
//                                        "wrong credentials",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
//
//                                }
                        },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(60.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
                    ) {
                        Text(
                            text = "Sign In",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp, color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.padding(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Don't have Account?",
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic
                        )
                        TextButton(onClick = {
                            Toast.makeText(context, "Work in Progress", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Text(text = "SignUp Here" , color = Color.Black)
                        }
                    }

                }
            }
        }
    }


}


