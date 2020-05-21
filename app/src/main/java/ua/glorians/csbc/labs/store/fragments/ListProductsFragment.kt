package ua.glorians.csbc.labs.store.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_category.*
import kotlinx.android.synthetic.main.fragment_list_products.*
import ua.glorians.csbc.labs.store.R
import ua.glorians.csbc.labs.store.adapters.ProductAdapter
import ua.glorians.csbc.labs.store.model.Category
import ua.glorians.csbc.labs.store.model.Product


class ListProductsFragment(context: Context) : Fragment() {


    private val context1 = context // Не робіть так
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("context", context1.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_products, container, false)
    }

    override fun onStart() {
        initAdapter()
        super.onStart()
    }

    private fun initInfoFragment() {
        val test = R.id.container.toString()
        Log.d("test", test)
        val infoFragment = InfoProductFragment(context1)
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragments, infoFragment)
            .addToBackStack(infoFragment.toString())
            .commit()
    }

    private fun initAdapter () {
        val parcelableCategory = arguments?.getParcelable<Category>("category")

        Log.d("CATEGORY", parcelableCategory.toString())
        val list = parcelableCategory?.listProduct
        Log.d("LIST PRODUCT", list.toString())

        // Адаптер Category
        listProduct.layoutManager = LinearLayoutManager(context1)

        listProduct.adapter =
            ProductAdapter(
                list!!,
                object :
                    ProductAdapter.Callback {
                    override fun onItemClicked(product: Product) {
                        Log.d("Click product", product.name)
                        initInfoFragment()
                    }
                })

    }



}
