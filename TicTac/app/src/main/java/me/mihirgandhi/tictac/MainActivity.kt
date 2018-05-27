package me.mihirgandhi.tictac

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var currentPlayer: Int = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var winner: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buttonClick(view: View) {
        val buttonClicked = view as Button
        var cellId = 0
        when (buttonClicked.id) {
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

    fun playGame(cellId: Int, button: Button) {
        if (currentPlayer == 1) {
            button.text = "X"
            button.setBackgroundColor(Color.GREEN)
            button.isEnabled = false
            currentPlayer = 2
            player1.add(cellId)
            findWinner()
            if (winner == -1){
                autoPlayGame()
            }
        } else {
            button.text = "O"
            button.setBackgroundColor(Color.RED)
            button.isEnabled = false
            currentPlayer = 1
            player2.add(cellId)
            findWinner()
        }
    }

    fun findWinner() {
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            winner = 1
            disableAllBs()
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            disableAllBs()
            winner = 2
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            disableAllBs()
            winner = 1
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            winner = 2
            disableAllBs()
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            winner = 1
            disableAllBs()
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            Toast.makeText(this, "Playaer 1 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            Toast.makeText(this, "Playaer 2 wins", Toast.LENGTH_LONG).show()
            disableAllBs()
            winner = 2
        }
    }

    fun disableAllBs() {
        b1.isEnabled = false
        b2.isEnabled = false
        b3.isEnabled = false
        b4.isEnabled = false
        b5.isEnabled = false
        b6.isEnabled = false
        b7.isEnabled = false
        b8.isEnabled = false
        b9.isEnabled = false
    }

    fun autoPlayGame(){
        var emptyCells = ArrayList<Int>()
        for (cellId in 1..9){
            if (!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }

        var r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells.get(randIndex)
        var buttonSelected = b1
        when(cellId){
            1-> buttonSelected = b1
            2-> buttonSelected = b2
            3-> buttonSelected = b3
            4-> buttonSelected = b4
            5-> buttonSelected = b5
            6-> buttonSelected = b6
            7-> buttonSelected = b7
            8-> buttonSelected = b8
            9-> buttonSelected = b9
        }
        playGame(cellId,buttonSelected)
    }
}
