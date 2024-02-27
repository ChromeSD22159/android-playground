package syntax.com.playground.ui.chapter

import androidx.lifecycle.ViewModel
import syntax.com.playground.data.LoremRepository
import syntax.com.playground.data.model.Chapter

class ChapterViewModel: ViewModel() {

    private val loremRepository = LoremRepository()
    private val chapterList = loremRepository.getChapterList(1000)

    private var _currentChapter = chapterList.first()

    val currentChapter: Chapter
        get() = _currentChapter

    fun nextChapter() {
        if (_currentChapter.chapterNumber + 1 < chapterList.size) {
            _currentChapter = chapterList[_currentChapter.chapterNumber + 1]
        }
    }
}