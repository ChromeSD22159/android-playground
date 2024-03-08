package syntax.com.playground.ui.threading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class TimerViewModel: ViewModel() {
    private var _timerValue = MutableLiveData<Long>(0)
    val timerValue: LiveData<Long>
        get() = _timerValue

    private lateinit var timerJob: Job


    fun startTimer() {
        //TODO
    }

    fun pauseTimer() {
        //TODO
    }

    fun resetTimer() {
        //TODO
    }

    fun goFaster() {
        //TODO
    }

    fun goSlower() {
        //TODO
    }
}