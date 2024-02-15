package syntax.com.playground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import syntax.com.playground.adapter.ArticleAdapter
import syntax.com.playground.data.DataSource
import syntax.com.playground.databinding.ArticleListFragmentBinding

class ShipListFragment: Fragment() {

    private lateinit var binding: ArticleListFragmentBinding
    private val shipList = DataSource().loadShips(10000)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ArticleListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = ArticleAdapter(shipList)
    }
}