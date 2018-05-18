package com.example.baspasut.mastynotify.Repository

import java.util.*

abstract class NewsRepo : Observable(){

    abstract fun loadAllNews()
    abstract fun getNews(): ArrayList<News>

}