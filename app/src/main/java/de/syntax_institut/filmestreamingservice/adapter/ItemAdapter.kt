package de.syntax_institut.filmestreamingservice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.filmestreamingservice.R
import de.syntax_institut.filmestreamingservice.data.model.Movie
import de.syntax_institut.filmestreamingservice.databinding.ListItemBinding

/**
 * Der Item Adapter weist den views im ViewHolder den Inhalt zu
 */
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Movie>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ItemViewHolder(binding)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val movie = dataset[position]
        holder.binding.tvItemMovieTitle.text = context.resources.getString(movie.stringResource)
        setButtonImage(movie.isFavorite, holder.binding.btnLike)
        holder.binding.btnLike.setOnClickListener {
            movie.isFavorite = !movie.isFavorite
            setButtonImage(movie.isFavorite, holder.binding.btnLike)
        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

    private fun setButtonImage(isFavorite: Boolean, button: ImageButton) {
        if (isFavorite) {
            button.setImageResource(R.drawable.iv_like_liked)
        } else {
            button.setImageResource(R.drawable.iv_like)
        }
    }
}
