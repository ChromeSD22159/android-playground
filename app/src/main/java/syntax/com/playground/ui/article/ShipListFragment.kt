package syntax.com.playground.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import syntax.com.playground.adapter.ArticleAdapter
import syntax.com.playground.databinding.ArticleListFragmentBinding

class ShipListFragment: Fragment() {

    private lateinit var binding: ArticleListFragmentBinding
    private val viewModel: ArticleViewModel by viewModels()

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
        binding.recyclerView.adapter = ArticleAdapter(viewModel.shipList)
    }
}