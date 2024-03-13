package syntax.com.playground.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import syntax.com.playground.R
import syntax.com.playground.adapters.MealByCategoryAdapter
import syntax.com.playground.databinding.FragmentMealByCategoryBinding

class MealByCategoryFragment : Fragment() {

    private lateinit var vb: FragmentMealByCategoryBinding
    private val viewModel: MealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentMealByCategoryBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mealsByCategory.observe(viewLifecycleOwner) {
            vb.rvMealsByCat.adapter = MealByCategoryAdapter(it)
        }
    }
}