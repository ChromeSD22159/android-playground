package syntax.com.playground.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import syntax.com.playground.databinding.FragmentArticleDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailFragment : Fragment() {

    private lateinit var binding: FragmentArticleDetailBinding
    private val viewModel: ArticleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticleDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivArticle.setImageResource(viewModel.imageRef)
        binding.tvPostion.text = viewModel.position.toString()
        binding.tvArticleDetail.text= viewModel.articleDescription

        binding.btHome.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}