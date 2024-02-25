package syntax.com.playground.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import syntax.com.playground.data.model.Article
import syntax.com.playground.databinding.ListCanItemBinding
import syntax.com.playground.databinding.ListShipItemBinding
import syntax.com.playground.ui.article.CanListFragmentDirections
import syntax.com.playground.ui.article.ShipListFragmentDirections

const val POSITION = "POSITION"
const val IMAGEREF = "IMAGEREF"
const val DESCRIPTION = "DESCRIPTION"

class ArticleAdapter(
    private val articleList: List<Article>
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
            holder.binding.tvPosition.text = position.toString()

            holder.binding.root.setOnClickListener {
                val imageRef = article.image
                val position = position
                val articleDescription = article.text
                holder
                    .itemView
                    .findNavController()
                    .navigate(
                        ShipListFragmentDirections.actionShipListFragmentToArticleDetailFragment(
                            imageRef,
                            position, articleDescription))
            }

        } else if (holder is CanItemViewHolder) {
            holder.binding.canImage.setImageResource(article.image)
            holder.binding.canText.text = article.text
            holder.binding.tvPosition.text = position.toString()

            holder.binding.root.setOnClickListener {
                val imageRef = article.image
                val articleDescription = article.text
                holder.itemView.findNavController().navigate(CanListFragmentDirections.actionCanListFragmentToArticleDetailFragment(imageRef, position, articleDescription))
            }
        }
    }
}
