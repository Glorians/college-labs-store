package ua.glorians.csbc.labs.store.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_category.*
import ua.glorians.csbc.labs.store.Category
import ua.glorians.csbc.labs.store.CategoryAdapter
import ua.glorians.csbc.labs.store.R

class ListCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)


        // Кнопка назад
        toolbar1.setNavigationIcon(R.drawable.ic_back_white)
        toolbar1.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val list = dataCategory() //Масив з об'єктами типу Category

        // Адаптер Category
        listCategory.layoutManager = LinearLayoutManager(this)
        listCategory.adapter = CategoryAdapter(
            list,
            object : CategoryAdapter.Callback {
                // На майбутнє
                override fun onItemClicked(item: Category) {
//                Toast.makeText(this, resources.getString(item.headline), Toast.LENGTH_SHORT).show()
//                println(resources.getString(item.headline))
//                val detailsFragment =
//                    DetailsFragment.newInstance(item)
//                fragmentManager!!.beginTransaction()
//                    .replace(R.id.fragment_list, detailsFragment, "detailsFragment")
//                    .addToBackStack(null)
//                    .commit()
                }
            })
    }

    // Метод який сворює об'єкти Category
    private fun dataCategory () : MutableList<Category>{

        // Створюємо масив для майбутнєго результата
        val listCategory = mutableListOf<Category>()

        //Дані з values Ім'я каталогу та його іконка
        val listCategoryHeadline = resources.getStringArray(R.array.category)
        val listCategoryIcon = resources.obtainTypedArray(R.array.categoryIcons)

        var i = 0
        val count: Int = listCategoryHeadline.size //Кількість каталогів, які потрібно створити

        while (i < count) {
            listCategory.add(
                Category(
                    listCategoryHeadline[i], // Назва каталогу
                    listCategoryIcon.getResourceId(i, -1), // Іконка каталогу
                    i.toString() // Опис каталогу... Лень... Пускай буде цифри
                )
            )
            i++
        }
        return listCategory // Повертаємо результат
    }
}
