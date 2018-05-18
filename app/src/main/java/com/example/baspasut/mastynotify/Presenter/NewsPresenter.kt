package com.example.baspasut.mastynotify.Presenter

import com.example.baspasut.mastynotify.Repository.*
import java.util.*

class NewsPresenter (val view : NewsView) : Observer {

    var newsList  = ArrayList<News>()

    fun start(){
        var steam = SteamRepo()
        var blizzard = BlizzardRepo()
        var ea = EaRepo()
        steam.addObserver(this)
        blizzard.addObserver(this)
        ea.addObserver(this)
        steam.loadAllNews()
        blizzard.loadAllNews()
        ea.loadAllNews()
    }

    override fun update(p0: Observable?, p1: Any?) {
        if(p0 is NewsRepo) {
            newsList.addAll((p0 as NewsRepo).getNews())
        }
        updateUI()
    }

    private fun updateUI() {
        var temp = ""
        for( news in newsList ){
            when (news.origin){
                "steam" -> {
                    temp += "<br/><font color='black'>" +"<strong>"+ news.title +"</strong><br/>"+news.contents+"<a href='"+news.url+"'> Read more</a>"+"</font><br/>"
                }
                "blizzard" -> {
                    temp += "<br/><font color='blue'>" +"<strong>"+ news.title +"</strong><br/>"+news.contents+"<a href='"+news.url+"'> Read more</a>"+"</font><br/>"
                }
                "ea" -> {
                    temp += "<br/><font color='#FF7700'>" +"<strong>"+ news.title +"</strong><br/>"+news.contents+"<a href='"+news.url+"'> Read more</a>"+"</font><br/>"
                }
            }
        }
        view.updateNews(temp)
    }

}