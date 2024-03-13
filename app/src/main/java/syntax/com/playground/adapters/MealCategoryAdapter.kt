package syntax.com.playground.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import syntax.com.playground.R
import syntax.com.playground.data.model.meal.MealCategory
import syntax.com.playground.data.repo.TAG
import syntax.com.playground.databinding.ItemMealCategoryBinding
import syntax.com.playground.ui.meal.MealViewModel

class MealCategoryAdapter(
    val mealCategorires: List<MealCategory>,
    val viewModel: MealViewModel
): RecyclerView.Adapter<MealCategoryAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val vb: ItemMealCategoryBinding): ViewHolder(vb.root)

    /**
     * Wird aufgerufen, wenn RecyclerView einen neuen [ViewHolder] des gegebenen Typs benötigt, um
     * ein Element darzustellen.
     *
     *
     * Dieser neue ViewHolder sollte mit einer neuen Ansicht erstellt werden, die die Elemente
     * des gegebenen Typs darstellen kann. Du kannst entweder manuell eine neue Ansicht erstellen oder sie aus einer XML
     * Layout-Datei aufblasen.
     *
     *
     * Der neue ViewHolder wird verwendet, um Elemente des Adapters mit
     * [.onBindViewHolder] anzuzeigen. Da er wiederverwendet wird, um
     * verschiedene Elemente im Datensatz darzustellen, ist es eine gute Idee, Verweise auf Unteransichten
     * der Ansicht zu speichern, um unnötige [View.findViewById] Aufrufe zu vermeiden.
     *
     * @param parent Die ViewGroup, in die die neue Ansicht eingefügt wird, nachdem sie an eine
     * Adapterposition gebunden wurde.
     * @param viewType Der Ansichtstyp der neuen Ansicht.
     *
     * @return Ein neuer ViewHolder, der eine Ansicht des gegebenen Ansichtstyps enthält.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val vb = ItemMealCategoryBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(vb)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return mealCategorires.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val mealCategory = mealCategorires[position]

        holder.vb.tvCategoryText.text = mealCategory.name
        holder.vb.ivCategoryImage.load(mealCategory.image)

        holder.vb.root.setOnClickListener {
            viewModel.loadMealsByCategory(mealCategory.name)
            holder.itemView.findNavController().navigate(R.id.mealByCategoryFragment)
        }
    }
}