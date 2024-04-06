package kz.edu.sdu.dogs

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.ModelView


@Composable
internal fun App(modelView : ModelView)
{
        var buttonClicked by remember { mutableStateOf(false) }
        var textValue by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            OutlinedTextField(
                value = textValue,
                onValueChange = { textValue = it },
                label = { Text("Enter text") },
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(onClick = {
                buttonClicked = true
            }) {
                Text(text = "Submit")
            }

            LaunchedEffect(buttonClicked) {
                if (buttonClicked) {
                    modelView.request(textValue)
                    buttonClicked = false
                }
            }

            if(!"{${modelView.showAge()}}".equals(null)){
                Text(text =
                "${modelView.showAge()}", fontSize = 30.sp,
                    fontWeight = FontWeight.Bold)
            }else{
                Text(text = "Try again", fontSize = 30.sp,
                    fontWeight = FontWeight.Bold)
            }
        }

    }
