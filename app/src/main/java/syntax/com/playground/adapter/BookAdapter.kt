package syntax.com.playground.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import syntax.com.playground.data.Book
import syntax.com.playground.databinding.BookItemBinding

class BookAdapter(
    private val context: Context,
    private val dataSet: List<Book>
): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context))
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = dataSet[position]
        holder.binding.textViewBookTitle.text = context.resources.getString(book.stringRefence)
    }
}