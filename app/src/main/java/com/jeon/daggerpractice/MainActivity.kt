package com.jeon.daggerpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeon.daggerpractice.ui.theme.DaggerPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerPracticeTheme {
                CustomTopBar{
                    innerContent()
                }
            }
        }
    }
}

@Composable
private fun CustomTopBar(content: @Composable () -> Unit) {
    DaggerPracticeTheme {
        Scaffold (
            topBar = {
                myTopBar()
            }
        ){ innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                content()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun myTopBar(){
    TopAppBar(
        title = {
            Text(text = "Dagger Practice")
                },
        colors = TopAppBarDefaults.topAppBarColors(Color.Green),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Icon"
            )
        })
}

@Composable
private fun myBottomBar(){
    BottomAppBar(
        modifier = Modifier.padding(20.dp)
    ) {

    }
}

@Composable
private fun innerContent(){
    Text(text = "first page")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomTopBar {
        innerContent()
    }
}