package ua.glorians.csbc.labs.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import javax.security.auth.callback.Callback


class CategoryAdapter (private val listCategory: MutableList<Category>, val callback: Callback): RecyclerView.Adapter<CategoryAdapter.HolderCategory>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = HolderCategory(LayoutInflater.from(parent.context).inflate(R.layout.item_category,
    parent, false))

    override fun getItemCount() = listCategory.size

    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
        holder.bind(listCategory[position])
    }

    inner class HolderCategory(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val headline = itemView.findViewById<TextView>(R.id.Headline)
        private val icon = itemView.findViewById<ImageView>(R.id.iconCategory)

        fun bind(item: Category) {
            headline.text = item.headline
            icon.setImageResource(item.icon)
            itemView.setOnClickListener(
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(listCategory[adapterPosition])
            )
        }
    }

    interface  Callback {
        fun onItemClicked(category: Category)
    }
    }

