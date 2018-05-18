package com.example.baspasut.mastynotify.Repository

import android.os.AsyncTask
import org.json.JSONArray
import java.net.URL
import java.util.ArrayList

class EaRepo : NewsRepo() {

    val newsList = ArrayList<News>()

    override fun loadAllNews() {
        object : AsyncTask<String, Void, String>(){

            override fun doInBackground(vararg params: String?): String {
                var json = URL("http://www.printmov.com/THAL/ea.json").readText()
                return json
            }

            override fun onPostExecute(result: String) {
                val jsonObj = JSONArray(result.substring(result.indexOf("["), result.lastIndexOf("]") + 1))
                for (i in 0..jsonObj!!.length() - 1) {
                    val currentJson = jsonObj.getJSONObject(i)
                    val artist = News(i
                            , currentJson.getString("title")
                            , currentJson.getString("url")
                            , currentJson.getString("contents")
                            , "ea")
                    getNews().add(artist)
                }
                setChanged()
                notifyObservers()
            }

        }.execute()
    }

    override fun getNews(): ArrayList<News> {
        return newsList
    }

}