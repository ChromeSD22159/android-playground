package syntax.com.playground.ui.contact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

        viewModel.contacts.observe(viewLifecycleOwner) {
            vb.rvContacts.adapter = ContactAdapter(it, viewModel)
        }

        vb.tietSearch.addTextChangedListener {
            viewModel.filterContacts(it.toString())
        }

        vb.tietSearch.addTextChangedListener (object : TextWatcher {
                /**
                 * Diese Methode wird aufgerufen, um Sie zu benachrichtigen, dass innerhalb von s
                 * die count Zeichen, beginnend bei start,
                 * kurz davor sind, durch neuen Text mit der Länge after ersetzt zu werden.
                 * Es ist ein Fehler, zu versuchen, Änderungen an s von
                 * diesem Callback aus vorzunehmen.
                 */
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    Log.d("addTextChangedListener", "beforeTextChanged - CharSequence: $s")
                    Log.d("addTextChangedListener", "beforeTextChanged - start: $start")
                    Log.d("addTextChangedListener", "beforeTextChanged - count: $count")
                    Log.d("addTextChangedListener", "beforeTextChanged - after: $after")
                }

                /**
                 * Diese Methode wird aufgerufen, um Sie zu benachrichtigen, dass innerhalb von s,
                 * die count Zeichen, beginnend bei start,
                 * gerade alten Text ersetzt haben, der die Länge before hatte.
                 * Es ist ein Fehler, zu versuchen, Änderungen an s von
                 * diesem Callback aus vorzunehmen.
                 */
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    Log.i("addTextChangedListener", "onTextChanged - CharSequence: $s")
                    Log.i("addTextChangedListener", "onTextChanged - start: $start")
                    Log.i("addTextChangedListener", "onTextChanged - before: $before")
                    Log.i("addTextChangedListener", "onTextChanged - count: $count")
                }

                /**
                 * Diese Methode wird aufgerufen, um Sie zu benachrichtigen, dass irgendwo innerhalb
                 * von s der Text geändert wurde.
                 * Es ist zulässig, weitere Änderungen an s von
                 * diesem Callback aus vorzunehmen, aber seien Sie vorsichtig, sich nicht in eine unendliche
                 * Schleife zu begeben, denn jede Änderung, die Sie vornehmen, wird dazu führen, dass diese Methode
                 * erneut rekursiv aufgerufen wird.
                 * (Sie werden nicht darüber informiert, wo die Änderung stattgefunden hat, weil andere
                 * afterTextChanged()-Methoden möglicherweise bereits andere Änderungen vorgenommen haben
                 * und die Offsets ungültig gemacht haben. Aber wenn Sie hier wissen müssen,
                 * können Sie [Spannable.setSpan] in [.onTextChanged]
                 * verwenden, um Ihren Platz zu markieren und dann hier nachzuschauen, wo der Span
                 * gelandet ist.
                 */
                override fun afterTextChanged(s: Editable?) {
                    Log.e("addTextChangedListener", "afterTextChanged - Editable: ${s.toString()}")
                }
            }
        )


        vb.btNew.setOnClickListener {
            val name = vb.tietNewContact.text.toString()
            val newContact = Contact(name, "555-444-666")
            viewModel.addNewContact(newContact)
            vb.tietNewContact.text?.clear()
        }
    }
}