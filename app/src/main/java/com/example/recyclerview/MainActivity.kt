package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView : RecyclerView
    private lateinit var newsArrayList : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        newsArrayList = ArrayList()

        val newImgArray = arrayOf(
            R.drawable.pic0 ,
            R.drawable.pic1 ,
            R.drawable.pic2 ,
            R.drawable.pic3 ,
            R.drawable.pic4 ,
            R.drawable.pic5 ,
            R.drawable.pic6
        )
        val heading = arrayOf(
            "Doraemon, the iconic blue robotic cat from the 22nd century, is a time-traveling companion to Nobita Nobi. He possesses a magical pocket ",
            "Nobita, a clumsy and academically challenged boy, is Doraemon’s best friend. He often finds himself in trouble" ,
            "Shizuka is the kind and gentle girl-next-door who captures Nobita’s heart. She is intelligent, graceful, and an excellent student." ,
            "Gian, the tough and brash neighborhood bully, is known for his imposing size and short temper. Despite his rough exterior" ,
            "Suneo, the wealthy and fashionable boy, flaunts his material possessions and often boasts about his family’s wealth." ,
            "Dorami, Doraemon’s younger sister, shares his robotic cat features. She is sweet, responsible, and always ready to help." ,
            "Mini-Dora, a tiny version of Doraemon, adds a touch of whimsy to the group. With its exclusive language and miniature form"
        )

        var i = 0
        while (i!= heading.size){
            val news = News(heading[i] , newImgArray[i])
            newsArrayList.add(news)
            i++
        }

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.adapter = MyAdapter(newsArrayList , this)

    }
}