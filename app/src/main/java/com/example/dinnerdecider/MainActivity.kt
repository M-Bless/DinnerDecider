package com.example.dinnerdecider

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dinnerdecider.ui.theme.DinnerDeciderTheme
import java.util.Random

class MainActivity : ComponentActivity() {

    val foodList= arrayListOf("Chinese","Hamburger","Pizza","McDonalds","Barros Pizza")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decideBtn=findViewById<Button>(R.id.decideBtn)
        decideBtn.setOnClickListener{
            val random = Random()
            val randomFood=random.nextInt(foodList.count())

            // Find the TextView by its ID
            val selectedFoodTxt = findViewById<TextView>(R.id.selectedFoodTxt)
            selectedFoodTxt.text=foodList[randomFood]
        }

        val addFoodBtn=findViewById<Button>(R.id.addFoodBtn)
        val addFoodTxt=findViewById<EditText>(R.id.addFoodTxt)
        addFoodBtn.setOnClickListener{
            val newFood=addFoodTxt.text.toString()
            foodList.add(newFood)
            addFoodTxt.text.clear()
            println(foodList)
        }
    }
}