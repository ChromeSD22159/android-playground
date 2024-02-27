package syntax.com.playground.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import syntax.com.playground.R
import syntax.com.playground.databinding.FragmentContactDetailBinding

class ContactDetailFragment : Fragment() {

    private lateinit var vb: FragmentContactDetailBinding
    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentContactDetailBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedContact.observe(viewLifecycleOwner) {
            vb.tvDetailName.text = it.name
            vb.tvDetailNumber.text = it.number
        }
    }
}