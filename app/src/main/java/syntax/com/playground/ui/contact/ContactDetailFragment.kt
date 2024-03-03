package syntax.com.playground.ui.contact

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import syntax.com.playground.MainFragment
import syntax.com.playground.databinding.FragmentContactDetailBinding

class ContactDetailFragment : MainFragment() {

    private lateinit var vb: FragmentContactDetailBinding
    private val vm: ContactViewModel by activityViewModels()

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

        vm.selectedContact.observe(viewLifecycleOwner) { contact ->
            vb.tvDetailName.text = contact.name
            vb.tvDetailNumber.text = contact.number
        }
    }
}