package ua.glorians.csbc.labs.store.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_profile.*
import ua.glorians.csbc.labs.store.R

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        val name = intent.getStringExtra("name")
        namePerson.text = name
        toolbar1.title = "Кабінет клієнта: $name"

        // Кнопка назад
        toolbar1.setNavigationIcon(R.drawable.ic_back_white)
        toolbar1.setNavigationOnClickListener{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
