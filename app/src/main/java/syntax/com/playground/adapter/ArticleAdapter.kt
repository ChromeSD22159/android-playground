package syntax.com.playground.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import syntax.com.playground.R
import syntax.com.playground.data.model.Article
import syntax.com.playground.databinding.ListCanItemBinding
import syntax.com.playground.databinding.ListShipItemBinding
import syntax.com.playground.ui.SharedViewModel
import syntax.com.playground.ui.article.ArticleViewModel
import syntax.com.playground.ui.article.CanListFragmentDirections
import syntax.com.playground.ui.article.ShipListFragmentDirections

enum class ViewType(val value: Int) {
    SHIP(1),
    CAN(2)
}

class ArticleAdapter(
    private val articleList: List<Article>,
    private val viewModel: ArticleViewModel,
    private val sharedViewModel: SharedViewModel
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ShipItemViewHolder(val binding: ListShipItemBinding): RecyclerView.ViewHolder(binding.root)
    inner class CanItemViewHolder(val binding: ListCanItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemViewType(position: Int): Int {
        return when (articleList[position].isShip) {
            true -> ViewType.SHIP.value
            false -> ViewType.CAN.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ViewType.SHIP.value) {
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
            setupShipItem(holder.binding, article, position)
        } else if (holder is CanItemViewHolder) {
            setupCanItem(holder.binding, article, position)
        }
    }

    private fun setupCanItem(
        vb: ListCanItemBinding,
        article: Article,
        position: Int
    ) {
        vb.canImage.setImageResource(article.image)
        vb.canText.text = article.text
        vb.tvPosition.text = position.toString()

        vb.root.setOnClickListener {
            setViewModel(article, position)
            navigate(it)
        }
    }

    private fun setupShipItem(
        vb: ListShipItemBinding,
        article: Article,
        position: Int
    ) {
        vb.shipImage.setImageResource(article.image)
        vb.shipText.text = article.text
        vb.tvPosition.text = position.toString()

        vb.root.setOnClickListener {
            setViewModel(article, position)
            navigate(it)
        }
    }

    private fun navigate(it: View) {
        it.findNavController().navigate(R.id.articleDetailFragment)
    }

    private fun setViewModel(article: Article, position: Int) {
        viewModel.setArticleDescription(article.text)
        viewModel.setImageRef(article.image)
        viewModel.setPosition(position)
    }
}
