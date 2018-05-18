package com.example.baspasut.mastynotify

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun gotoSite(view : View){
        val steamIntent : Intent;
        var temp = ""
        when(view){
            steamButton -> {
                temp = "https://store.steampowered.com/news/"
            }
            blizzardButton -> {
                temp = "https://news.blizzard.com/en-us"
            }
            eaButton -> {
                temp = "https://www.ea.com/news"
            }
        }
        steamIntent = Intent(Intent.ACTION_VIEW,Uri.parse(temp))
        startActivity(steamIntent)
    }

    fun update_button_clicked(view : View){
        val intent = Intent(this, NewsBoard::class.java)
        startActivity(intent)
    }

}
