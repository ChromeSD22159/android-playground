package syntax.com.playground.ui.settings

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import syntax.com.playground.MainFragment
import syntax.com.playground.R
import syntax.com.playground.databinding.FragmentSettingsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : MainFragment() {

    private lateinit var vb: FragmentSettingsBinding
    private val viewModel: SettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentSettingsBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupColorChangeListener()
        setupRadioButtonsChangeListener()
    }

    private fun setupRadioButtonsChangeListener() {
        vb.rgBackgroundColor.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                vb.rbRed.id -> viewModel.setBackgroundColor(Color.RED)
                vb.rbGreen.id -> viewModel.setBackgroundColor(Color.GREEN)
                vb.rbBlue.id -> viewModel.setBackgroundColor(Color.BLUE)
                vb.rbWhite.id -> viewModel.setBackgroundColor(Color.WHITE)
            }
        }
    }
}