package syntax.com.playground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import syntax.com.playground.databinding.ListCanItemBinding
import syntax.com.playground.databinding.ListShipItemBinding

class ArticleAdapter(
    val articleList: List<Article>
): RecyclerView.Adapter<ViewHolder>() {

    private val shipType = 1
    private val canType = 2

    inner class ShipItemViewHolder(val binding: ListShipItemBinding): ViewHolder(binding.root)
    inner class CanItemViewHolder(val binding: ListCanItemBinding): ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        val article = articleList[position]
        return if(article.isShip) {
            shipType
        } else {
            canType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == shipType) {
            val binding = ListShipItemBinding.inflate(LayoutInflater.from(parent.context))
            ShipItemViewHolder(binding)
        } else {
            val binding = ListCanItemBinding.inflate(LayoutInflater.from(parent.context))
            CanItemViewHolder(binding)
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articleList[position]

        if (holder is ShipItemViewHolder) {
            holder.binding.shipImage.setImageResource(article.image)
            holder.binding.shipText.text = article.text
        } else if (holder is CanItemViewHolder) {
            holder.binding.canImage.setImageResource(article.image)
        }
    }
}