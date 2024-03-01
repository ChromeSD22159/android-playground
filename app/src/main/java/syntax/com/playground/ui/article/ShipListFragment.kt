package syntax.com.playground.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import syntax.com.playground.adapter.ArticleAdapter
import syntax.com.playground.databinding.ArticleListFragmentBinding
import syntax.com.playground.ui.SharedViewModel

class ShipListFragment: Fragment() {

    private lateinit var binding: ArticleListFragmentBinding
    private val viewModel: ArticleViewModel by activityViewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ArticleListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = ArticleAdapter(viewModel.shipList, viewModel, sharedViewModel)
    }
}