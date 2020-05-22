package ua.glorians.csbc.labs.store.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category (val headline: String, val icon: Int, val description: String?, val listProduct: MutableList<Product>) : Parcelable