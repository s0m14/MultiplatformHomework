package kz.edu.sdu.dogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import model.ModelView
import java.awt.Desktop
import java.io.File
import java.net.URI

@Composable
fun App(modelView : ModelView,modifier: Modifier) {
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