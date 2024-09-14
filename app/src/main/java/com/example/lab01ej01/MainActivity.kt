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
                    CheckBoxComponent() // Mostrar CheckBox
                    AlertDialogComponent() // Mostrar AlertDialog
                    SliderComponent() // Mostrar Slider
                    ViewHolaCurso()
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

// Componente de AlertDialog
@Composable
fun AlertDialogComponent() {
    var showDialog by remember { mutableStateOf(false) } // Estado para el AlertDialog

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showDialog = true }) {
            Text(text = "Mostrar Diálogo")
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Confirmación") },
                text = { Text(text = "¿Estás seguro de realizar esta acción?") },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }
    }
}

// Componente de Slider
@Composable
fun SliderComponent() {
    var sliderPosition by remember { mutableStateOf(0.5f) } // Valor inicial del slider

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Selecciona un valor: ${sliderPosition * 100}", fontSize = 32.sp)
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            modifier = Modifier.padding(horizontal = 13.dp)
        )
    }
}

@Composable
fun ViewHolaCurso() {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Cambiado de fillMaxWith() a fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Course!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold // Cambiado de FontWeigh a FontWeight
        )
        Spacer(modifier = Modifier.height(16.dp)) // Cambiado de heigh() a height()
        Text(
            text = "Hello, Student!",
            fontSize = 20.sp // Cambiado de 20.xD a 20.sp
        )
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
            AlertDialogComponent() // Mostrar AlertDialog
            SliderComponent() // Mostrar Slider
        }
    }
}
