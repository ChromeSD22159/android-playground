package syntax.com.playground.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import syntax.com.playground.adapter.DESCRIPTION
import syntax.com.playground.adapter.IMAGEREF
import syntax.com.playground.adapter.POSITION
import syntax.com.playground.databinding.FragmentArticleDetailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailFragment : Fragment() {

    private lateinit var binding: FragmentArticleDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArticleDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            binding.ivArticle.setImageResource(it.getInt(IMAGEREF))
            binding.tvPostion.text = it.getInt(POSITION).toString()
            binding.tvArticleDetail.text= it.getString(DESCRIPTION)
        }

        binding.btHome.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}