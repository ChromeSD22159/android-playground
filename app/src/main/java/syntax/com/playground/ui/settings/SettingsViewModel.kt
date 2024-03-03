package syntax.com.playground.ui.settings

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.R

class SettingsViewModel: ViewModel() {

    private var _backgroundColor = MutableLiveData(Color.WHITE)
    val backgroundColor: LiveData<Int>
        get() = _backgroundColor

    fun setBackgroundColor(color: Int) {
        _backgroundColor.value = color
    }
}