package ua.glorians.csbc.labs.store

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// Адаптер для катеторій
class CategoryAdapter (private val items: MutableList<Category>, val callback: Callback):
    RecyclerView.Adapter<CategoryAdapter.HolderCategory>() {

    // Створюємо майбутній item по шаблону item_category
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = HolderCategory(LayoutInflater.from(parent.context).inflate(R.layout.item_category,
    parent, false))

    // Кількість items
    override fun getItemCount() = items.size

    // Позиція item
    override fun onBindViewHolder(holder: HolderCategory, position: Int) {
        holder.bind(items[position])
    }

    // Шаблон item (Як він буде виглядати)
    inner class HolderCategory(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val headline = itemView.findViewById<TextView>(R.id.Headline) // Заголовок категорії
        private val icon = itemView.findViewById<ImageView>(R.id.iconCategory) // Іконка категорії

        fun bind(item: Category) {
            headline.text = item.headline
            icon.setImageResource(item.icon)
            // Вішаємо прослуховувач подій, потрібен для натискання на item...
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    // Інтерфейс для кліку по item
    interface  Callback {
        fun onItemClicked(category: Category)
    }
    }



