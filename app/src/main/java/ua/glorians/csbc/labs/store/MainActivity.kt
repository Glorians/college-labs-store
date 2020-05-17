package ua.glorians.csbc.labs.store

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar((toolbar))

        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Menu Clicked", Toast.LENGTH_SHORT).show()
        }

        btn_start_activity_category.setOnClickListener() {
            val intent = Intent(this, ListCategoryActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview) {

            R.id.developer -> Toast.makeText(applicationContext,"Dev Clicked", Toast.LENGTH_SHORT).show()
            R.id.app_info -> Toast.makeText(applicationContext, "App Info Cliked", Toast.LENGTH_SHORT).show()
        }
        return false
    }
}
