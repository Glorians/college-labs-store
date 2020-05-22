package ua.glorians.csbc.labs.store.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_info_product.*
import ua.glorians.csbc.labs.store.R
import ua.glorians.csbc.labs.store.model.Product


class InfoProductFragment(context: Context) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_product, container, false)
    }

    override fun onStart() {
        super.onStart()
        val product = arguments?.getParcelable<Product>("product")
        imageProduct.setImageResource(product!!.image)
        nameProduct.text = product.name
    }
}
