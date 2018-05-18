package com.example.baspasut.mastynotify

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.MenuItem
import android.widget.TextView
import com.example.baspasut.mastynotify.Presenter.NewsPresenter
import com.example.baspasut.mastynotify.Presenter.NewsView
import kotlinx.android.synthetic.main.activity_news_board.*

class NewsBoard : AppCompatActivity() , NewsView {

    var presenter = NewsPresenter(this)

    override fun updateNews(text : String) {
        newsText.setText(Html.fromHtml("<font color='black'><strong>BLACK = Steam</strong></font><br/>" +
                "<font color='blue'><strong>BLUE = Blizzard</strong></font><br/>" +
                "<font color='#FF7700'><strong>ORANGE = EA</strong></font><br/>"
                +text), TextView.BufferType.SPANNABLE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_board)

        newsText.movementMethod = LinkMovementMethod()
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        presenter.start()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
