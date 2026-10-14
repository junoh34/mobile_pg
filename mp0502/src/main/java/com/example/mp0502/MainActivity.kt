package com.example.mp0502

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit	var	cbObj1: CheckBox
    lateinit	var	cbObj2:	CheckBox
    lateinit	var	cbObj3:	CheckBox
    lateinit	var	cbObj4:	CheckBox
    lateinit	var	btnObj: Button
    lateinit	var	tvObj: TextView
    var	flag	=	false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cbObj1=findViewById(R.id.checkBox1)
        cbObj2=findViewById(R.id.checkBox2)
        cbObj3=findViewById(R.id.checkBox3)
        cbObj4=findViewById(R.id.checkBox4)
        btnObj=findViewById(R.id.button)
        tvObj=findViewById(R.id.textViewResult)

        val names = mapOf(
            R.id.checkBox1 to "소방차",
            R.id.checkBox2 to "청진기",
            R.id.checkBox3 to "휘핑기",
            R.id.checkBox4 to "장갑"
        )

        val answerIds = setOf(R.id.checkBox1, R.id.checkBox4)

        val selected = linkedSetOf<Int>()



        val listener = CompoundButton.OnCheckedChangeListener{ buttonView, isChecked ->
            if (isChecked) {
                selected.add(buttonView.id)
                Toast.makeText(this, "${names[buttonView.id]}를 선택했습니다.", Toast.LENGTH_SHORT).show()
            } else {
                selected.remove(buttonView.id)
            }
        }

        cbObj1.setOnCheckedChangeListener(listener)
        cbObj2.setOnCheckedChangeListener(listener)
        cbObj3.setOnCheckedChangeListener(listener)
        cbObj4.setOnCheckedChangeListener(listener)

        btnObj.setOnClickListener {
            if (btnObj.text == "재시작하기") {
                // 초기화
                cbObj1.isChecked = false
                cbObj2.isChecked = false
                cbObj3.isChecked = false
                cbObj4.isChecked = false
                btnObj.text = "결과보기"
                tvObj.text = "소방관의 용품을 선택해주세요"
            } else {
                // 정답 여부를 버튼 아래 텍스트로 출력
                tvObj.text = if (selected == answerIds) "맞았습니다" else "틀렸습니다"
                btnObj.text = "재시작하기"
            }
        }
    }
}