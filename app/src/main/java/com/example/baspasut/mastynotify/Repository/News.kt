package com.example.baspasut.mastynotify.Repository

class News (val id : Int = 0,
            val title : String = "",
            val url : String = "",
            val contents : String = "",
            val origin : String = "") {

    override fun toString(): String {
        return title
    }

}