package syntax.com.playground.ui.chapter

import androidx.lifecycle.ViewModel
import syntax.com.playground.data.LoremRepository
import syntax.com.playground.data.model.Chapter

class ChapterViewModel: ViewModel() {

    private val chapterList = LoremRepository().getChapterList(1000)
    private var _currentChapter = chapterList.first()
    private var currentIndex = _currentChapter.chapterNumber

    val currentChapter: Chapter
        get() = _currentChapter

    fun nextChapter() {
        if (_currentChapter.chapterNumber + 1 < chapterList.size) {
            currentIndex = _currentChapter.chapterNumber + 1
        } else {
            currentIndex = 0
        }
        _currentChapter = chapterList[currentIndex]
    }
}