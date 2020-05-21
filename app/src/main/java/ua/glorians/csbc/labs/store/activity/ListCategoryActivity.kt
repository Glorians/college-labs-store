package ua.glorians.csbc.labs.store.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_category.*
import ua.glorians.csbc.labs.store.model.Category
import ua.glorians.csbc.labs.store.adapters.CategoryAdapter
import ua.glorians.csbc.labs.store.R
import ua.glorians.csbc.labs.store.fragments.ListProductsFragment
import ua.glorians.csbc.labs.store.model.Product

class ListCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)
        initToolbar()
        initAdapter()
    }



    private fun initAdapter () {
        val list = dataCategory() //Масив з об'єктами типу Category

        // Адаптер Category
        listCategory.layoutManager = LinearLayoutManager(this)
        listCategory.adapter = CategoryAdapter( list,
                object :
                    CategoryAdapter.Callback {
                    override fun onItemClicked(category: Category) {
                        Log.d("Click Category", category.headline)
                        initFragmentListProduct(
                            categoryTransferFragment(category)
                        )
                    }
                })
    }

    private fun categoryTransferFragment (category: Category): Bundle {
        val bundle = Bundle()
        bundle.putParcelable("category", category)
        bundle.putString("str", "test")
        return bundle
    }

    private fun initFragmentListProduct(bundle: Bundle) {
        val listProductFragment = ListProductsFragment(this)
        listProductFragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.container, listProductFragment).commit()
    }

    private fun dataProduct (n: Int): MutableList<Product> {

        val listProduct = mutableListOf<Product>()

        val listProductHeadline = resources.getStringArray(R.array.products_category_laptop_pc)

        var i = 0
        val count: Int = listProductHeadline.size //Кількість каталогів, які потрібно створити
        while (i < count) {

            listProduct.add(
                Product(
                    listProductHeadline[i],
                    R.drawable.vivobook,
                    "laptop"
                )
            )
            i++
        }
        return listProduct
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
                    i.toString(), // Опис каталогу... Лень... Пускай буде цифри
                    dataProduct(i)
                )
            )
            i++
        }
        listCategoryIcon.recycle() // Звільняємо пам'ять
        return listCategory // Повертаємо результат
    }

    // Кнопка назад
    private fun initToolbar () {
        toolbar1.setNavigationIcon(R.drawable.ic_back_white)
        toolbar1.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
