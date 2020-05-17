package ua.glorians.csbc.labs.store.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_category.*
import ua.glorians.csbc.labs.store.Category
import ua.glorians.csbc.labs.store.CategoryAdapter
import ua.glorians.csbc.labs.store.R

class ListCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_category)

        val list = dataCategory()
        Log.d("DEBUG", list[0].headline)
        Log.d("DEBUG", list[0].icon.toString())
        listCategory.layoutManager = LinearLayoutManager(this)
        listCategory.adapter = CategoryAdapter(
            list,
            object : CategoryAdapter.Callback {

                override fun onItemClicked(item: Category) {
                    // На будущее

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

    private fun dataCategory () : MutableList<Category>{
        val listCategory = mutableListOf<Category>()

        val listCategoryHeadline = resources.getStringArray(R.array.category)
        val listCategoryIcon = resources.obtainTypedArray(R.array.categoryIcons)
        var i = 0
        val count: Int = listCategoryHeadline.size
        while (i < count) {
            listCategory.add(
                Category(
                    listCategoryHeadline[i],
                    listCategoryIcon.getResourceId(i, -1),
                    i.toString()
                )
            )
            i++
        }

        return listCategory

    }
}
