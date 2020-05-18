package ua.glorians.csbc.labs.store.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import ua.glorians.csbc.labs.store.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar((toolbar))

        // Заділ на майбутнє При натисканні повинна відкриватись менюшка
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Menu Clicked", Toast.LENGTH_SHORT).show()
        }

        // Відкриваємо магазин натиском кнопки
        btn_start_activity_category.setOnClickListener() {
            val intent = Intent(this, ListCategoryActivity::class.java)
            startActivity(intent)
        }

        // Відкриваємо активність з регестрацією
        btnRegistration.setOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    // Створюємо меню в toolbar (верхня панель)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    // Прослуховувач подій на кнопки в меню (toolbar)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId

        when(itemview) {

            R.id.developer -> startActivity(Intent(this, DeveloperActivity::class.java))
            R.id.app_info -> startActivity(Intent(this, InfoActivity::class.java))
        }
        return false
    }
}
