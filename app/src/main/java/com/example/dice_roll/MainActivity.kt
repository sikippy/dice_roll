package com.example.dice_roll

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.button)
        val imageDice : ImageView = findViewById(R.id.dice1)
        val imageDice2 : ImageView = findViewById(R.id.dice2)
        rollButton.setOnClickListener(){
            val value : ArrayList<Int> = Dice(6).roll()
           imageDice.setImageResource(setImage("dice_${value[0]}",this.applicationContext))
           imageDice2.setImageResource(setImage("dice_${value[1]}",this.applicationContext))
                //if 2 dice are 6 is lucky message
            if (value[0]==value[1])  Toast.makeText(this@MainActivity, "You are a lucky winner",Toast.LENGTH_SHORT).show()
            }
        }
    }


class Dice(val numberDices:Int){
    fun roll(): ArrayList<Int>{
        val ret = ArrayList<Int>(numberDices-1)
        for(i in 0..numberDices-1) {
            val a = (1..numberDices).random()
            ret.add(a)
        }
        return ret
    }
}

fun setImage(name: String?, context: Context): Int {
    val resources: Resources = context.getResources()
    val resourceId: Int = resources.getIdentifier(
        name, "drawable",
        context.getPackageName()
    )
    return resourceId
}