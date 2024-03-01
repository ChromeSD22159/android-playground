package syntax.com.playground.ui.chapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import syntax.com.playground.databinding.FragmentChapterBinding
import syntax.com.playground.ui.SharedViewModel

class ChapterFragment : Fragment() {

    private lateinit var vb: FragmentChapterBinding
    private val viewModel: ChapterViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentChapterBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateView()

        vb.addBTN.setOnClickListener {
            viewModel.nextChapter()
            updateView()
        }
    }

    private fun updateView() {
        vb.counterTV.text = viewModel.currentChapter.chapterTitle
    }
}