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

        val listener = CompoundButton.OnCheckedChangeListener{ buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.checkBox1 -> Toast.makeText(applicationContext,
                        "소방차를 선택했습니다.",	Toast.LENGTH_LONG).show()
                    R.id.checkBox2 -> Toast.makeText(applicationContext,
                        "거품기를 선택했습니다.",	Toast.LENGTH_LONG).show()
                    R.id.checkBox3 -> Toast.makeText(applicationContext,
                        "청진기를 선택했습니다.",	Toast.LENGTH_LONG).show()
                    R.id.checkBox4 -> Toast.makeText(applicationContext,
                        "장갑을 선택했습니다.",	Toast.LENGTH_LONG).show()
                }
            } /*여기 추가하는게 실습인데 전에 한것처럼 when 사용해서 작성*/
        }

        cbObj1.setOnCheckedChangeListener(listener)
        cbObj2.setOnCheckedChangeListener(listener)
        cbObj3.setOnCheckedChangeListener(listener)
        cbObj4.setOnCheckedChangeListener(listener)

        btnObj.setOnClickListener {
            if (!flag) {
                if (cbObj1.isChecked && cbObj4.isChecked) {
                    tvObj.text = "맞았습니다"
                    btnObj.text = "재시작하기"
                    flag = true
                } else {
                    tvObj.text = "틀렸습니다"
                    btnObj.text = "재시작하기"
                    flag = true
                }
            } else {
                cbObj1.isChecked = false
                cbObj2.isChecked = false
                cbObj3.isChecked = false
                cbObj4.isChecked = false
                btnObj.text = "결과보기"
                tvObj.text = "소방관의 용품을 선택해주세요"
                flag = false
            }
        } /*여기도 체우는데 위에 falg는 flase로 해서 무조건 실행하게 만듬, 이러고 조건해서 만들기,
        버튼을 누르면 true가 되어서 재시작이 되게 만듬, flag라는게 실습할때 못봤던거 같은데 모르겠다.*/
    }
}