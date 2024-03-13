package syntax.com.playground.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import syntax.com.playground.adapters.MealCategoryAdapter
import syntax.com.playground.databinding.FragmentMealCategoriesBinding
import syntax.com.playground.main.MainActivity

/**
 * A simple [Fragment] subclass.
 * Use the [MealCategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MealCategoriesFragment : Fragment() {

    private lateinit var vb: FragmentMealCategoriesBinding
    private val viewModel: MealViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.loadAllMealCategories()
        vb = FragmentMealCategoriesBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allMealCategories.observe(viewLifecycleOwner) {
            vb.rvMealsByCat.adapter = MealCategoryAdapter(it, viewModel)
        }
    }
}