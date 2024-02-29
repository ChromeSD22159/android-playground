package syntax.com.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    private val _layout = MutableLiveData<Int>(0)

    val layout: LiveData<Int>
        get() = _layout

    fun updateLayout(checkedId: Int) {
        _layout.value = checkedId
    }
}