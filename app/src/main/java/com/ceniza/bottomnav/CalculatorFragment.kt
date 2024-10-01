package com.ceniza.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.DecimalFormat

class CalculatorFragment : Fragment() {

    private lateinit var etFirstNumber: EditText
    private lateinit var etSecondNumber: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var tvResult: TextView
    private val decimalFormat = DecimalFormat("#.##")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_calculator, container, false)


        etFirstNumber = view.findViewById(R.id.etFirstNumber)
        etSecondNumber = view.findViewById(R.id.etSecondNumber)
        btnAdd = view.findViewById(R.id.btnAdd)
        btnSubtract = view.findViewById(R.id.btnSubtract)
        btnMultiply = view.findViewById(R.id.btnMultiply)
        btnDivide = view.findViewById(R.id.btnDivide)
        tvResult = view.findViewById(R.id.tvResult)


        btnAdd.setOnClickListener { calculate('+') }
        btnSubtract.setOnClickListener { calculate('-') }
        btnMultiply.setOnClickListener { calculate('*') }
        btnDivide.setOnClickListener { calculate('/') }

        return view
    }

    private fun calculate(operation: Char) {
        val num1 = etFirstNumber.text.toString().toDoubleOrNull()
        val num2 = etSecondNumber.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            tvResult.text = "Please enter valid numbers"
            return
        }

        val result = when (operation) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    tvResult.text = "Cannot divide by zero"
                    return
                }
            }
            else -> 0.0
        }
        tvResult.text = "Result: ${decimalFormat.format(result)}"
    }
}
