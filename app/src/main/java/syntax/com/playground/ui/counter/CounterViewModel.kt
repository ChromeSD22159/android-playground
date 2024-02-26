package syntax.com.playground.ui.counter

import androidx.lifecycle.ViewModel
import syntax.com.playground.data.Repository
import syntax.com.playground.data.model.Chapter

class CounterViewModel: ViewModel() {

    private val repository = Repository()
    private val chapterList = repository.getChapterList(1000)

    private var _currentChapter = chapterList.first()

    val currentChapter: Chapter
        get() = _currentChapter

    fun nextChapter() {
        if (_currentChapter.chapterNumber + 1 < chapterList.size) {
            _currentChapter = chapterList[_currentChapter.chapterNumber + 1]
        }
    }
}