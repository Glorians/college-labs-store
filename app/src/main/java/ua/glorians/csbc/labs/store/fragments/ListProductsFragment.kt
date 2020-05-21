package ua.glorians.csbc.labs.store.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_category.*
import ua.glorians.csbc.labs.store.R
import ua.glorians.csbc.labs.store.adapters.CategoryAdapter
import ua.glorians.csbc.labs.store.adapters.ProductAdapter
import ua.glorians.csbc.labs.store.model.Product


class ListProductsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list_products, container, false)
    }

    private fun initAdapter () {
        val parcelableArray = arguments?.getParcelableArray("arrayProduct")
        val listProduct: MutableList<Product>
        val i = 0
        while (i > parcelableArray!!.size) {
            listProduct.add(parcelableArray[i])
        }



        // Адаптер Category
        listCategory.layoutManager = LinearLayoutManager(this)
        listCategory.adapter = ProductAdapter( list,
            object :
                CategoryAdapter.Callback {
                override fun onItemClicked(product: Product) {
                    Log.d("Click product", category.headline)
                }
            })
    }


}
