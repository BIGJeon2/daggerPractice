package com.jeon.daggerpractice

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jeon.daggerpractice.model.Coffee
import com.jeon.daggerpractice.model.Latte
import com.jeon.daggerpractice.model.Milk
import com.jeon.daggerpractice.module.Ingredient
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
        colors = TopAppBarDefaults.topAppBarColors(Color.Blue),
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = "Icon"
            )
        })
}

@Composable
private fun innerContent(){
    val context = LocalContext.current
    Column {
        nonInjection(context)
        injection(context)
    }
}

@Composable
private fun nonInjection(context: Context){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                val coffeeInfo = BeverageInfo(
                    "Coffee",
                    listOf(Ingredient.SHOT, Ingredient.WATER),
                    3500,
                    listOf(Ingredient.SHOT, Ingredient.WATER, Ingredient.SYRUP)
                )
                val coffee = Coffee(context, coffeeInfo)
                toastMessage(coffee)
            }
        ) {
            Text(text = "Coffee")
        }
        Button(
            onClick = {
                val latteInfo = BeverageInfo(
                    "Lattee",
                    listOf(Ingredient.SHOT, Ingredient.MILK),
                    4500,
                    listOf(Ingredient.SHOT, Ingredient.MILK, Ingredient.SYRUP)
                )
                val latte = Latte(context, latteInfo)
                toastMessage(latte)
            }
        ) {
            Text(text = "latte")
        }
        Button(
            onClick = {
                val milkInfo = BeverageInfo(
                    "Milk",
                    listOf(Ingredient.MILK),
                    3000,
                    listOf(Ingredient.SYRUP)
                )
                val milk = Milk(context, milkInfo)
                toastMessage(milk)
            }
        ) {
            Text(text = "Milk")
        }
    }
}

@Composable
private fun injection(context: Context){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                val coffeeInfo = BeverageInfo(
                    "Coffee",
                    listOf(Ingredient.SHOT, Ingredient.WATER),
                    3500,
                    listOf(Ingredient.SHOT, Ingredient.WATER, Ingredient.SYRUP)
                )
                val coffee = Coffee(context, coffeeInfo)
                toastMessage(coffee)
            }
        ) {
            Text(text = "Coffee")
        }
        Button(
            onClick = {
                val latteInfo = BeverageInfo(
                    "Lattee",
                    listOf(Ingredient.SHOT, Ingredient.MILK),
                    4500,
                    listOf(Ingredient.SHOT, Ingredient.MILK, Ingredient.SYRUP)
                )
                val latte = Latte(context, latteInfo)
                toastMessage(latte)
            }
        ) {
            Text(text = "latte")
        }
        Button(
            onClick = {
                val milkInfo = BeverageInfo(
                    "Milk",
                    listOf(Ingredient.MILK),
                    3000,
                    listOf(Ingredient.SYRUP)
                )
                val milk = Milk(context, milkInfo)
                toastMessage(milk)
            }
        ) {
            Text(text = "Milk")
        }
    }
}

private fun toastMessage(beverage: Beverage){
    beverage.showInfo()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomTopBar {
        innerContent()
    }
}