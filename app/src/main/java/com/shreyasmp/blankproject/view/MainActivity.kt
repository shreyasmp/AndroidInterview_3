package com.shreyasmp.blankproject.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shreyasmp.blankproject.ui.theme.BlankProjectTheme
import com.shreyasmp.blankproject.viewmodel.InstrumentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<InstrumentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlankProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SearchViewBar(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SearchViewBar(viewModel: InstrumentViewModel) {
//    LazyColumn(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        viewModel.instrumentList.value.let { instruments ->
//            items(instruments) { it ->
//                it.name?.let { it1 -> Text(text = it1) }
//            }
//        }18
//    }
    Column {
        viewModel.instrumentList.value?.forEach {
            it.name?.let { it1 -> Text(text = it1) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BlankProjectTheme {
        Greeting("Android")
    }
}