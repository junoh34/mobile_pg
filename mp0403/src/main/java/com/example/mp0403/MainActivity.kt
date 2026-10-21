package com.example.mp0403

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgBody: ImageView
    lateinit var imgDress: ImageView
    lateinit var imgNeck: ImageView
    lateinit var imgCrown: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imgBody = findViewById(R.id.imgBody)
        imgDress= findViewById(R.id.imgDress)
        imgNeck = findViewById(R.id.imgNeck)
        imgCrown = findViewById(R.id.imgCrown)

        imgDress.visibility = View.INVISIBLE
        imgNeck.visibility = View.INVISIBLE
        imgCrown.visibility = View.INVISIBLE
    } /*View.INVISIBLE 이걸로 보이게 가능, 혼자할 때 이거 몰라서 당황했었음*/

    /*view 입력으로 받고 view.id가 있다면 when 실행, case 처럼 : 대신 -> 사용*/
    fun onClickChoice(view: View) {
        when(view.id) {
            R.id.imgDress1 -> {
                imgDress.visibility = View.VISIBLE
                imgDress.setImageResource(R.drawable.dress1)
            }
            R.id.imgDress2 -> {
                imgDress.visibility = View.VISIBLE
                imgDress.setImageResource(R.drawable.dress2)
            }
            R.id.imgDress3 -> {
                imgDress.visibility = View.VISIBLE
                imgDress.setImageResource(R.drawable.dress3)
            }
            R.id.imgCrown1 -> {
                imgCrown.visibility = View.VISIBLE
                imgCrown.setImageResource(R.drawable.crown1)
            }
            R.id.imgCrown2 -> {
                imgCrown.visibility = View.VISIBLE
                imgCrown.setImageResource(R.drawable.crown2)
            }
            R.id.imgNeck1 -> {
                imgNeck.visibility = View.VISIBLE
                imgNeck.setImageResource(R.drawable.necklace1)
            }
            R.id.imgNeck2 -> {
                imgNeck.visibility = View.VISIBLE
                imgNeck.setImageResource(R.drawable.necklace2)
            }
        }
    } /*이거 클릭하면 이렇게 되게 일일이 설정함, 이것보다 xml때문에 혼자 만든게 이상하게 완성됨*/
    fun onClickReset(view: View?) {
        imgDress.visibility = View.INVISIBLE
        imgNeck.visibility = View.INVISIBLE
        imgCrown.visibility = View.INVISIBLE
    }
}