package ua.glorians.csbc.labs.store.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.glorians.csbc.labs.store.R
import ua.glorians.csbc.labs.store.model.Product


// Адаптер для Product
class ProductAdapter (private val items: MutableList<Product>, val callback: Callback):
    RecyclerView.Adapter<ProductAdapter.HolderProduct>() {

    // Створюємо майбутній item по шаблону item_product
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = HolderProduct(LayoutInflater.from(parent.context).inflate(
        R.layout.item_category,
        parent, false))

    // Кількість items
    override fun getItemCount() = items.size

    // Позиція item
    override fun onBindViewHolder(holder: HolderProduct, position: Int) {
        holder.bind(items[position])
    }

    // Шаблон item (Як він буде виглядати)
    inner class HolderProduct(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val headline = itemView.findViewById<TextView>(R.id.Headline) // Заголовок категорії
        private val icon = itemView.findViewById<ImageView>(R.id.iconCategory) // Іконка категорії

        fun bind(item: Product) {
            headline.text = item.name
            icon.setImageResource(item.image)

            // Вішаємо прослуховувач подій, потрібен для натискання на item...
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    // Інтерфейс для кліку по item
    interface  Callback {
        fun onItemClicked(product: Product)
    }
}



