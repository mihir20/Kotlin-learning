package me.mihirgandhi.tictac

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentPlayer:Int = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun buttonClick(view: View){
        var buttonClicked = view as Button
        var cellId = 0
        when(buttonClicked.id){
            b1.id -> cellId = 1
            b2.id -> cellId = 2
            b3.id -> cellId = 3
            b4.id -> cellId = 4
            b5.id -> cellId = 5
            b6.id -> cellId = 6
            b7.id -> cellId = 7
            b8.id -> cellId = 8
            b9.id -> cellId = 9
        }
        playGame(cellId, buttonClicked)
    }

     fun playGame(cellId:Int, button: Button){
       if (currentPlayer == 1){
           button.text = "X"
           button.setBackgroundColor(Color.GREEN)
           button.isEnabled = false
           currentPlayer = 2
           player1.add(cellId)
       }else{
           button.text = "O"
           button.setBackgroundColor(Color.RED)
           button.isEnabled = false
           currentPlayer = 1
           player2.add(cellId)
       }
   }
}
