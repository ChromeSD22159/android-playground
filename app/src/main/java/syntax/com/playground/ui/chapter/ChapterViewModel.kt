package syntax.com.playground.ui.chapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.data.LoremRepository
import syntax.com.playground.data.model.Chapter

class ChapterViewModel: ViewModel() {

    private val repo = LoremRepository()
    private val chapterList = repo.getChapterList(1000)
    val maxIndex = chapterList.size

    private val _currentChapter = MutableLiveData(chapterList.first())
    val currentChapter: LiveData<Chapter>
        get() = _currentChapter
    private var currentIndex = _currentChapter.value!!.chapterNumber

    fun nextChapter() {
        currentIndex = if (_currentChapter.value!!.chapterNumber + 1 < chapterList.size) {
            _currentChapter.value!!.chapterNumber + 1
        } else {
            0
        }
        _currentChapter.value = chapterList[currentIndex]
    }
}