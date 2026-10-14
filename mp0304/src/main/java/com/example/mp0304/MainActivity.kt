package com.example.mp0304

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var nameObj: EditText
    lateinit var passwdObj: EditText
    lateinit var emailObj: EditText
    lateinit var dateObj: EditText
    lateinit var phoneObj: EditText
    lateinit var resultObj: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nameObj = findViewById<EditText>(R.id.edtName)
        passwdObj = findViewById<EditText>(R.id.edtPasswd)
        emailObj = findViewById<EditText>(R.id.edtEmail)
        dateObj = findViewById<EditText>(R.id.edtDate)
        phoneObj = findViewById<EditText>(R.id.edtPhone)
        resultObj = findViewById<TextView>(R.id.txtResult)
    }

    fun onBtnClick(view: View?) {
        if (
            nameObj.text.toString().isEmpty() ||
            passwdObj.text.toString().isEmpty() ||
            emailObj.text.toString().isEmpty() ||
            dateObj.text.toString().isEmpty() ||
            phoneObj.text.toString().isEmpty()
        ) {
            resultObj.text = "모든 항목을 입력해 주세요."
        } else {
            resultObj.text = "성명: ${nameObj.text} \n" +
                    "비밀번호: ${passwdObj.text} \n" +
                    "이메일: ${emailObj.text} \n" +
                    "생년월일: ${dateObj.text} \n" +
                    "연락처: ${phoneObj.text}"
        }
    }
}