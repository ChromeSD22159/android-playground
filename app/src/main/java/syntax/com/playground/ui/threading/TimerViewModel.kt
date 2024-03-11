package syntax.com.playground.ui.threading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel: ViewModel() {
    private var _timerValue = MutableLiveData<Long>(0)
    val timerValue: LiveData<Long>
        get() = _timerValue

    private var timerJob: Job? = null
    private var delay = 1000L

    fun startTimer() {
        if (timerJob == null) {

            var counter = 0L
            delay = 1000L

            timerJob = viewModelScope.launch {
                while (true) {
                    delay(delay)
                    counter ++
                    _timerValue.postValue(counter)
                }
            }
        }
    }

    fun stopTimer() {
        timerJob?.cancel()
        timerJob = null
    }

    fun goFaster() {
        delay /=2
    }

    fun goSlower() {
        delay *=2
    }
}