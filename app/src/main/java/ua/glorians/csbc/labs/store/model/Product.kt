package ua.glorians.csbc.labs.store.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (val name: String?, val image: Int, val description: String?): Parcelable

