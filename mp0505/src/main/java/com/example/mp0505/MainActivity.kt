package com.example.mp0505

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit	var	sObj1: Switch
    lateinit	var	sObj2:	Switch
    lateinit	var	tvObj: TextView
    lateinit	var	ivObj1: ImageView
    lateinit	var	ivObj2:	ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sObj1=findViewById(R.id.switch1)
        sObj2=findViewById(R.id.switch2)
        sObj2.textOn = ""
        sObj2.textOff = ""
        tvObj=findViewById(R.id.textView2)
        ivObj1=findViewById(R.id.imageView1)
        ivObj2=findViewById(R.id.imageView2)

        sObj1.setOnCheckedChangeListener{	buttonView,	isChecked->
            if	(isChecked)
                ivObj1.visibility = View.INVISIBLE
            else
                ivObj1.visibility = View.VISIBLE
        }
        /*전에 ai시켜보니까 check 이벤트 처리 함수를 쓰는게 아니라 함수 선언해서 함수를 호출하는 식으로 함,
        * 이 방법이 더 좋은거 아닌가 생각이 들기도 하면서 일단 기초니까 이게 좋아보임, 힘들긴 함*/
        sObj2.setOnCheckedChangeListener{	buttonView,		isChecked->
            if	(isChecked)	{
                tvObj.setBackgroundColor(Color.argb(40,	200,200,200))
                ivObj2.setImageResource(R.drawable.light32)
                sObj2.setThumbResource(R.drawable.on3)
            }
            else	{
                tvObj.setBackgroundColor(Color.argb(200,	200,200,200))
                ivObj2.setImageResource(R.drawable.light31)
                sObj2.setThumbResource(R.drawable.off3)
            }
        }
    }
}