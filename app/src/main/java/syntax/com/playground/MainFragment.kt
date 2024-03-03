package syntax.com.playground

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import syntax.com.playground.ui.settings.SettingsViewModel

open class MainFragment : Fragment() {

    private val viewModel: SettingsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupColorChangeListener()
    }

    fun setupColorChangeListener() {
        viewModel.backgroundColor.observe(viewLifecycleOwner) {
            this.view?.setBackgroundColor(it)
        }
    }
}