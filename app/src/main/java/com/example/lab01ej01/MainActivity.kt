package com.example.lab01ej01

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.lab01ej01.ui.theme.Lab01Ej01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab01Ej01Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xfff9e37c)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.rostrocaric1),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Jeefry Zamata",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            color = Color.DarkGray
        )

        Spacer(modifier = Modifier.height(48.dp))
        ContactInfo("+11 (123) 444 555 666", "@AndroidDev", "jee.zam@android.com")
    }
}

@Composable
fun ContactInfo(phone: String, twitter: String, email: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icono2),
                contentDescription = "Contact 01",
                modifier = Modifier.size(16.dp)
            )
            Text(text = phone, fontSize = 14.sp)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icono3),
                contentDescription = "Contact 02",
                modifier = Modifier.size(16.dp)
            )
            Text(text = twitter, fontSize = 14.sp)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Contact 03",
                modifier = Modifier.size(16.dp)
            )
            Text(text = email, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBusinessCard() {
    Lab01Ej01Theme {
        BusinessCard()
    }
}

