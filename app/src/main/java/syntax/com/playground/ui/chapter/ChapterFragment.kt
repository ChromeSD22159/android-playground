package syntax.com.playground.ui.chapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import syntax.com.playground.MainFragment
import syntax.com.playground.R
import syntax.com.playground.data.model.Chapter
import syntax.com.playground.databinding.FragmentChapterBinding
import syntax.com.playground.ui.settings.SettingsViewModel

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

        vb.btnNext.setOnClickListener {
            viewModel.nextChapter()

        }
    }

    private fun setAllTextViews(chapter: Chapter) {
        vb.tvContent.text = chapter.chapterTitle
        vb.tvIndex.text = chapter.toString()
        vb.tvMax.text = getString(R.string.max_index, viewModel.maxIndex.toString())
    }
}