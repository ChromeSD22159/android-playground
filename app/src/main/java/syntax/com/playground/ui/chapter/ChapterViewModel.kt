package syntax.com.playground.ui.chapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.data.repo.LoremRepository
import syntax.com.playground.data.model.chapter.Chapter

class ChapterViewModel: ViewModel() {

    private val repo = LoremRepository()
    private val chapterList = repo.getChapterList(5)
    val maxIndex = chapterList.size

    private val _isNextButtonActive = MutableLiveData(true)
    val isNextButtonActive: LiveData<Boolean>
        get() = _isNextButtonActive

    private val _isBackButtonActive = MutableLiveData(false)
    val isBackButtonActive: LiveData<Boolean>
        get() = _isBackButtonActive

    private val _currentChapter = MutableLiveData(chapterList.first())
    val currentChapter: LiveData<Chapter>
        get() = _currentChapter
    private var currentIndex = _currentChapter.value!!.chapterNumber

    fun nextChapter() {
        if (_currentChapter.value!!.chapterNumber + 1 <= chapterList.size) {
            currentIndex++
        }
        _currentChapter.value = chapterList[currentIndex]
        setButtonState()
    }

    fun previousChapter() {
        if (_currentChapter.value!!.chapterNumber - 1 > 0) {
            currentIndex--
        }
        _currentChapter.value = chapterList[currentIndex]
        setButtonState()
    }

    private fun setButtonState() {
        _isNextButtonActive.value = currentChapter.value!!.chapterNumber < chapterList.size
        _isBackButtonActive.value = currentIndex != 0
    }
}