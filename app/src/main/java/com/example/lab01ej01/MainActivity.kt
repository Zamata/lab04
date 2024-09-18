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
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.lab01ej01.ui.theme.Lab01Ej01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab01Ej01Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xffB9A7FC)
                ) {
                    UserPost()
                }
            }
        }
    }
}

@Composable
fun UserPost(modifier: Modifier = Modifier) {
    var title by rememberSaveable { mutableStateOf("") }
    var content by rememberSaveable { mutableStateOf("") }
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var postConfirmed by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Eliminar Publicación",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color= Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Contenido") },
            modifier = Modifier.height(50.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Button(onClick = { showDialog = true }) {
            Text("Publicar Post")
        }

        if (postConfirmed) {
            Text(
                text = "Publicación Realizada!",
                color = Color.Gray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Confirmación") },
                text = { Text(text = "¿Estás seguro de publicar la siguiente publicación?") },
                confirmButton = {
                    Button(onClick = {
                        postConfirmed = true
                        showDialog = false
                    }) {
                        Text("Confirmar")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewUserPostScreen() {
    Lab01Ej01Theme {
        UserPost()
    }
}
