package ua.glorians.csbc.labs.store.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_registration.*
import ua.glorians.csbc.labs.store.R

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Кнопка назад
        toolbar.setNavigationIcon(R.drawable.ic_back_white)
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        btn.setOnClickListener{
            val intent = Intent(this, UserProfileActivity::class.java)
            if (checkInput()) {
                intent.putExtra("name", name.text.toString())
                startActivity(intent)
            }
        }
    }

    private fun checkInput (): Boolean {
        val nameTest = name.text.toString()

        return if (nameTest.length < 2) {
            Toast.makeText(this, "Введіть ім'я", LENGTH_LONG).show()
            false
        }
        else true

    }
}
