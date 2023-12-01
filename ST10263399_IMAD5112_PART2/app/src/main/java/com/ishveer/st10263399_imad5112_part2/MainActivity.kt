package com.ishveer.st10263399_imad5112_part2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {


    private lateinit var Number1: EditText
    private lateinit var Number2: EditText
    private lateinit var AdditionButton: Button
    private lateinit var SubtractionButton: Button
    private lateinit var MultiplicationButton: Button
    private lateinit var DivisionButton: Button
    private lateinit var SquareRootButton: Button
    private lateinit var PowerButton: Button

    private lateinit var btnStats: Button

    private lateinit var  ResultTextView:TextView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        Number1 = findViewById(R.id.Number1)
        Number2 = findViewById(R.id.Number2)
        AdditionButton = findViewById(R.id.AdditionButton)
        SubtractionButton = findViewById(R.id.SubtractionButton)
        MultiplicationButton = findViewById(R.id.MultiplicationButton)
        DivisionButton = findViewById(R.id.DivisionButton)
        SquareRootButton = findViewById(R.id.squareRootButton)
        PowerButton = findViewById(R.id.PowerButton)
        ResultTextView = findViewById(R.id.ResultTextView)
        btnStats = findViewById(R.id.btnStats)

        AdditionButton.setOnClickListener { performOperation("+") }
        SubtractionButton.setOnClickListener { performOperation("-") }
        MultiplicationButton.setOnClickListener { performOperation("*") }
        DivisionButton.setOnClickListener { performOperation("/") }
        SquareRootButton.setOnClickListener { performSquareRoot() }
        PowerButton.setOnClickListener { performPower() }
        btnStats.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)


        }


    }

    private fun performOperation(operator: String) {
        val Number1 = Number1.text.toString().toDouble()
        val Number2 = Number2.text.toString().toDouble()

        when (operator) {
            "+" -> displayResult("$Number1 + $Number2 = ${Number1 + Number2}")
            "-" -> displayResult("$Number1 - $Number2 = ${Number1 - Number2}")
            "*" -> displayResult("$Number1 * $Number2 = ${Number1 * Number2}")
            "/" -> {
                if (Number2 == 0.0) {
                    displayResult("Error: Division by 0 is not allowed")
                } else {
                    displayResult("$Number1 / $Number2 = ${Number1 / Number2}")
                }
            }
        }
    }
    private fun performSquareRoot() {
        val Number1 = Number1.text.toString().toDouble()

        if (Number1 < 0) {
            val result = sqrt(-Number1)
            displayResult("sqrt($Number1) = ${result}i")
        } else {
            val result = sqrt(Number1)
            displayResult("sqrt($Number1) = $result")
        }
    }

    private fun performPower() {
        val Number1 = Number1.text.toString().toDouble()
        val Number2 = Number2.text.toString().toInt()

        val result = Number1.pow(Number2)
        displayResult("$Number1*$Number2 = $result")
    }

    private fun displayResult(result: String) {
        ResultTextView.text=result
     }




}

//Reference list:
//(2019). YouTube. 3 October. Available at: https://www.youtube.com/watch?v=jv9LFydMiwA
//(Accessed: 27 September 2023).
