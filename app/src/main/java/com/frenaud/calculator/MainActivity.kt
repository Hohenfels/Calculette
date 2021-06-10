package com.frenaud.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currentOp : String = ""
    var previousNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonNumberEvent(view : View) {
        val buttonNumber = view as Button
        val showNumber = findViewById<TextView>(R.id.textView)
        var value : String = showNumber.text.toString()

        when(buttonNumber.id) {
            R.id.zero_button -> {value += "0" }
            R.id.one_button -> { value += "1" }
            R.id.two_button -> { value += "2" }
            R.id.three_button -> { value += "3" }
            R.id.four_button -> { value += "4" }
            R.id.five_button -> { value += "5" }
            R.id.six_button -> { value += "6" }
            R.id.seven_button -> { value += "7" }
            R.id.eight_button -> { value += "8" }
            R.id.nine_button -> { value += "9" }
            R.id.dot_button -> { value += "." }
        }
        showNumber.text = value
    }

    fun buttonOpEvent(view : View) {
        val buttonOp = view as Button
        val showNumber = findViewById<TextView>(R.id.textView)

        when(buttonOp.id) {
            R.id.multiply_button -> { currentOp = "*" }
            R.id.divide_button -> { currentOp = "/"}
            R.id.minus_button -> { currentOp = "-" }
            R.id.plus_button -> { currentOp = "+" }
        }
        previousNumber = showNumber.text.toString()
        showNumber.text = ""
    }

    fun buttonDoOpEvent(view : View) {
        val showNumber = findViewById<TextView>(R.id.textView)
        var resultNumber : Double? = null

        when(currentOp) {
            "*" -> { resultNumber = previousNumber.toDouble() * showNumber.text.toString().toDouble() }
            "/" -> { resultNumber = previousNumber.toDouble() / showNumber.text.toString().toDouble() }
            "-" -> { resultNumber = previousNumber.toDouble() - showNumber.text.toString().toDouble() }
            "+" -> { resultNumber = previousNumber.toDouble() + showNumber.text.toString().toDouble() }
        }
        when (resultNumber) {
            null -> { showNumber.text = "" }
            else -> { showNumber.text = resultNumber.toString() }
        }
    }

    fun buttonClearEvent(view : View) {
        val showNumber = findViewById<TextView>(R.id.textView)

        showNumber.text = ""
        currentOp = ""
        previousNumber = ""
    }
}