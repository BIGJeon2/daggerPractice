package com.jeon.daggerpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
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
import com.jeon.daggerpractice.api.Cafe
import com.jeon.daggerpractice.impl.CompoCoffee
import com.jeon.daggerpractice.impl.StarCoffee
import com.jeon.daggerpractice.model.CafeInfo
import com.jeon.daggerpractice.module.CompoCoffeeQualifier
import com.jeon.daggerpractice.module.StarCoffeeQualifier
import com.jeon.daggerpractice.obj.CompoCompany
import com.jeon.daggerpractice.ui.theme.DaggerPracticeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Qualifier

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @CompoCoffeeQualifier
    @Inject
    lateinit var compoCafe: Cafe
    @StarCoffeeQualifier
    @Inject
    lateinit var starCafe: Cafe
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DaggerPracticeTheme {
                CustomTopBar {
                    innerContent()
                }
            }
        }
        starCafe.showCompanyInfo()
        compoCafe.showCompanyInfo()
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
        }
    )
}

@Composable
private fun innerContent(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomTopBar {
        innerContent()
    }
}