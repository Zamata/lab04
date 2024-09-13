package com.example.lab01ej01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab01ej01.ui.theme.Lab01Ej01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01Ej01Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xfff9e37c)
                ) {
                    CheckBoxComponent()
                }
            }
        }
    }
}

// Componente de CheckBox
@Composable
fun CheckBoxComponent() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(checkedColor = Color.Green)
        )
        Text(text = "Aceptar Términos y Condiciones")
    }
}

// Función Preview que los muestra uno por uno
@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    Lab01Ej01Theme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            //BusinessCard()
            CheckBoxComponent() // Mostrar CheckBox
        }
    }
}
