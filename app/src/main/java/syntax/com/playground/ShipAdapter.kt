package syntax.com.playground

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import syntax.com.playground.databinding.ListItemBinding

class ShipAdapter(
    val context: Context,
    val shipList: List<Ship>
): RecyclerView.Adapter<ShipAdapter.ShipItemViewHolder>() {

    inner class ShipItemViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShipItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ShipItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return shipList.size
    }

    override fun onBindViewHolder(holder: ShipItemViewHolder, position: Int) {
        val ship = shipList[position]
        holder.binding.canImage.setImageResource(ship.image)
        holder.binding.canText.text = ship.text
    }
}