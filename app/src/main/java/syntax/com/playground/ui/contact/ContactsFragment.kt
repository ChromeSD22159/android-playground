package syntax.com.playground.ui.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import syntax.com.playground.adapter.ContactAdapter
import syntax.com.playground.data.model.Contact
import syntax.com.playground.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private lateinit var vb: FragmentContactsBinding
    private val viewModel: ContactViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentContactsBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observer beobachtet die LiveData und reagiert sofort bei Veränderungen
        viewModel.contacts.observe(viewLifecycleOwner) {
            vb.rvContacts.adapter = ContactAdapter(it, viewModel)
        }

        vb.tietSearch.addTextChangedListener {
            viewModel.filterContacts(it.toString())

        }

        vb.btNew.setOnClickListener {
            val name = vb.tietNewContact.text.toString()
            val newContact = Contact(name, "555-444-333")
            viewModel.addNewContact(newContact)

            vb.tietNewContact.text?.clear()
        }
    }
}