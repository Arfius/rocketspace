package zoom.arfius.rocketspace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import zoom.arfius.searchrocket.Search
import zoom.arfius.orientation.Orientation

class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun searchRocket(view:View){
        val i = Intent(this, Search::class.java)
        startActivity(i)
    }

    fun orientation(view:View){
        val i = Intent(this, Orientation::class.java)
        startActivity(i)
    }



}
