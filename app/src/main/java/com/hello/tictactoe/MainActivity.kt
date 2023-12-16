package com.hello.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.hello.tictactoe.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun clickable(view: View) {
        val buttonSelected = view as ImageButton
        var called = 0
        when(buttonSelected.id){
            R.id.imageButton1 -> called = 1
            R.id.imageButton2 -> called = 2
            R.id.imageButton3 -> called = 3
            R.id.imageButton4 -> called = 4
            R.id.imageButton5 -> called = 5
            R.id.imageButton6 -> called = 6
            R.id.imageButton7 -> called = 7
            R.id.imageButton8 -> called = 8
            R.id.imageButton9 -> called = 9
        }
        play(called, buttonSelected)
//        Log.d("TAG", "clickable: $called")
    }

    private fun winner(){
        var winner = 0
//        For first player
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }

//        For second player
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner == 1){
            Toast.makeText(this, "Player 1 won 😊", Toast.LENGTH_SHORT).show()
        }
        if(winner == 2){
            Toast.makeText(this, "Player 2 won 😊", Toast.LENGTH_SHORT).show()
        }
    }

    private var currentPlayer = 1
    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private fun play(called: Int, buttonSelected: ImageButton) {
        if(currentPlayer == 1){
            if(!player2.contains(called)){
                buttonSelected.setBackgroundResource(R.drawable.game_circle)
                player1.add(called)
                currentPlayer = 2
            }

        }else{
            if(!player1.contains(called)){
                buttonSelected.setBackgroundResource(R.drawable.game_cross)
                player2.add(called)
                currentPlayer = 1
            }
        }
        winner()
    }

}