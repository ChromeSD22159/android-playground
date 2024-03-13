package syntax.com.playground.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import syntax.com.playground.main.MainFragment
import syntax.com.playground.adapters.ArticleAdapter
import syntax.com.playground.databinding.ArticleListFragmentBinding
import syntax.com.playground.ui.settings.SettingsViewModel

class CanListFragment: MainFragment() {
    private lateinit var binding: ArticleListFragmentBinding
    private val viewModel: ArticleViewModel by activityViewModels()
    private val settingsViewModel: SettingsViewModel by activityViewModels()

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
        settingsViewModel.backgroundColor.observe(viewLifecycleOwner) { bgColor: Int ->
            binding.root.setBackgroundColor(bgColor)
            binding.recyclerView.adapter = ArticleAdapter(viewModel.canList, viewModel)
        }
    }
}