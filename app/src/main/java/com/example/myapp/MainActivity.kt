package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()

                }
            }
        }
    }
}
@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp), backgroundColor = Color.White, shape = RoundedCornerShape(corner = CornerSize(15.dp)), elevation = 5.dp) {
             Column(modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top,
             horizontalAlignment = Alignment.CenterHorizontally) {
                 Createimage()
                 Divider(modifier = Modifier.padding(3.dp,3.dp),Color.Gray, thickness = 2.dp)

                 Createinfo()
                 
                 Button(onClick = {
                     buttonClickedState.value = !buttonClickedState.value
                 }) {
                     Text(text = "About Me", style = MaterialTheme.typography.button)
                     
                 }
                 if (buttonClickedState.value){
                     Content()
                 }
                 else{
                     Box() {
                         
                     }
                 }
             }



        }
    }


}

@Composable
private fun Createinfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Adarsh Giri",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )

        Text(
            text = "Android Dev..",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "CSE",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "@LNCT - IDEALAB",
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.primaryVariant
        )

    }
}


@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            border = BorderStroke(width = 2.dp, color = Color.Gray)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3","Project 4","Project 5","Project 6"))
        }

    }


}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(data){
            item -> 
            Card(modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight()
                .fillMaxWidth(), shape = RectangleShape,
            elevation = 4.dp){
                Row(modifier = Modifier
                    .padding(5.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(15.dp)) {
                    Createimage(modifier = Modifier.size(120.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "hey good to see u", style = MaterialTheme.typography.body1)
                    }

                    }
                }
            }
                
            }
        }



@Composable
 fun Createimage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(100.dp)
            .padding(5.dp),
        shape = CircleShape, border = BorderStroke(width = 0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Picture Of Adarsh",
            modifier = Modifier.size(200.dp),
            contentScale = ContentScale.Crop
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
       CreateBizCard()
    }
}