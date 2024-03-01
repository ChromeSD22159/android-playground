package syntax.com.playground.ui.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import syntax.com.playground.databinding.FragmentSettingsBinding
import syntax.com.playground.ui.SharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {

    private lateinit var vb: FragmentSettingsBinding
    private val viewModel: SharedViewModel by activityViewModels()

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

        vb.rgSpanCount.setOnCheckedChangeListener { group, checkedId ->
           // viewModel.updateSpanCount(group.findViewById<RadioButton>(checkedId).tag.toString())
        }

        vb.rgLayout.setOnCheckedChangeListener { group, checkedId ->
            //viewModel.updateLayout(group.findViewById<RadioButton>(checkedId).tag.toString(), requireContext())
        }
    }
}