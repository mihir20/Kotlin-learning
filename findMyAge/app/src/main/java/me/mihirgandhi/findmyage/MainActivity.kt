package me.mihirgandhi.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.mihirgandhi.findmyage.R.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        getAgeButton.setOnClickListener {
            val birthYear:Int = birthYear.text.toString().toInt()
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val yearsOld = (currentYear - birthYear)
            age.text = "your age is " + yearsOld
        }
    }
}
