package syntax.com.playground.ui.chapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import syntax.com.playground.MainFragment
import syntax.com.playground.data.model.Chapter
import syntax.com.playground.databinding.FragmentChapterBinding

class ChapterFragment : MainFragment() {

    private lateinit var vb: FragmentChapterBinding
    private val viewModel: ChapterViewModel by viewModels()

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

        viewModel.currentChapter.observe(viewLifecycleOwner) {
            setAllTextViews(it)
        }

        viewModel.isNextButtonActive.observe(viewLifecycleOwner) {
            vb.btnNext.isEnabled = it
        }

        viewModel.isBackButtonActive.observe(viewLifecycleOwner) {
            vb.btnBack.isEnabled = it
        }

        vb.btnNext.setOnClickListener {
            viewModel.nextChapter()
        }

        vb.btnBack.setOnClickListener {
            viewModel.previousChapter()
        }
    }

    private fun setAllTextViews(chapter: Chapter) {
        vb.tvContent.text = buildString {
            append("Nr.: ${chapter.chapterNumber}\n")
            append(chapter.chapterTitle)
        }
        vb.tvIndex.text = chapter.chapterNumber.toString()
        vb.tvMax.text = buildString {
            append("/ ")
            append(viewModel.maxIndex.toString())
        }
    }
}