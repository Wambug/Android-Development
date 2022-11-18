package com.example.patienttracker.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patienttracker.R
import com.example.patienttracker.ui.theme.PatientTrackerTheme
import org.xml.sax.ContentHandler

class Home {
    @Composable
    fun Homepage() {
        Column (Modifier.background(color =Color(0xFF0C2D48) )){
            Text(text = "Hello User,",Modifier.padding(15.dp, top = 10.dp), color = Color.White)
            AppointmentCard()
            DepartmentCard(dept = listOf("Departments","Appointments","Records","More"))
            Divider()
            ListViewCard()
        }
    }
    // UI card for showing upcoming appointments
    @Composable
    fun AppointmentCard() {
        val height = 240.dp
        val width  = 480.dp
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .padding(15.dp)
                .background(Color(0xFF16796F), shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.TopCenter,
        )
        {

        }
    }
    // UI card for showing departments
    @Composable
    fun DepartmentCard(dept:List<String>) {

        var selected by remember {
            mutableStateOf(0)
        }
        LazyRow(modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(22.dp, Alignment.CenterHorizontally),
        ) {
            items(dept.size) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(60.dp)
                            .height(60.dp)
                            .padding(5.dp)
                            .clickable {
                                selected = it
                            }
                            .shadow(ambientColor = Color.White, elevation = 5.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                Color(0xFF0C2D48)

                            ),
                    ) {
                        when {
                            dept[it] == "Departments" -> {
                                Image(painter = painterResource(id = R.drawable.department),
                                    contentDescription ="Department",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            dept[it] == "Appointments" -> {
                                Image(painter = painterResource(id = R.drawable.medical),
                                    contentDescription ="Appointment",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            dept[it] == "Records" -> {
                                Image(painter = painterResource(id = R.drawable.patient),
                                    contentDescription ="records",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                            dept[it] == "More" -> {
                                Image(painter = painterResource(id = R.drawable.application),
                                    contentDescription ="See more",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                    Text(text = dept[it],color = Color.White)

                }
            }
        }
    }

    // UI card for lists
    @Composable
    fun ListViewCard() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text("Testing")
                Text("Bruh")
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PatientTrackerTheme {
            Homepage()
        }
    }
}