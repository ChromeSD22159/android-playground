package syntax.com.playground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import syntax.com.playground.adapter.ArticleAdapter
import syntax.com.playground.data.DataSource
import syntax.com.playground.databinding.ArticleListFragmentBinding

class ArticleListFragment: Fragment() {

    private lateinit var binding: ArticleListFragmentBinding
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

        val articleList = DataSource().loadArticels(10000)
        binding.recyclerView.adapter = ArticleAdapter(articleList)
    }
}