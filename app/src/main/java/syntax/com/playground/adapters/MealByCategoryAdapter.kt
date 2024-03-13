package syntax.com.playground.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import syntax.com.playground.data.model.meal.Meal
import syntax.com.playground.databinding.ItemMealByCatBinding

class MealByCategoryAdapter(
    private val mealList: List<Meal>
): RecyclerView.Adapter<MealByCategoryAdapter.MealByCatViewHolder>() {

    inner class MealByCatViewHolder(val vb: ItemMealByCatBinding): RecyclerView.ViewHolder(vb.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealByCatViewHolder {
        val binding = ItemMealByCatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealByCatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: MealByCatViewHolder, position: Int) {
        val meal = mealList[position]

        holder.vb.tvMealByCatName.text = meal.meal
        holder.vb.ivMealByCat.load(meal.image)
    }

}