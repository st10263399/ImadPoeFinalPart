package com.ishveer.st10263399_imad5112_part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2: AppCompatActivity() {

    private lateinit var edtNum: EditText
    private lateinit var textDisplay: TextView

    private val numbersArray = IntArray(10)
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNum = findViewById(R.id.edtNum)
        textDisplay = findViewById(R.id.textDisplay)

        val addButton: Button = findViewById(R.id.button)
        val clearButton: Button = findViewById(R.id.btnClear)
        val averageButton: Button = findViewById(R.id.btnAvg)
        val minMaxButton: Button = findViewById(R.id.btnMinMax)

        addButton.setOnClickListener { addNumberToArray() }
        clearButton.setOnClickListener { clearArray() }
        averageButton.setOnClickListener { calculateAverage() }
        minMaxButton.setOnClickListener { findMinMax() }
    }

    private fun addNumberToArray() {
        val numberStr = edtNum.text.toString()
        val number: Int

        try {
            number = numberStr.toInt()
        } catch (e: NumberFormatException) {
            return
        }

        if (count < 10) {
            numbersArray[count++] = number
            edtNum.text.clear()
        }
    }


    private fun clearArray() {
        numbersArray.fill(0)
        count = 0
        textDisplay.text = ""
    }

    private fun calculateAverage() {
        val average = numbersArray.take(count).average()
        textDisplay.text = "Average: $average"
    }

    private fun findMinMax() {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        for (i in 0 until count) {
            if (numbersArray[i] < min) {
                min = numbersArray[i]
            }
            if (numbersArray[i] > max) {
                max = numbersArray[i]
            }
        }

        val result = "Min: $min, Max: $max"
        textDisplay.text = result
    }

}




//Reference list:
//(2019). YouTube. 3 October. Available at: https://www.youtube.com/watch?v=jv9LFydMiwA
//(Accessed: 26 Novenber 2023).




