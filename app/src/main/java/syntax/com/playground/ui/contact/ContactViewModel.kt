package syntax.com.playground.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.data.ContactRepository
import syntax.com.playground.data.model.Contact

class ContactViewModel: ViewModel() {

    private val repository = ContactRepository()
    private val allContacts = repository.loadContacts()

    // Private var - public val nur jetzt mit LiveData
    private var _contacts = MutableLiveData<MutableList<Contact>>(allContacts)

    val contacts: LiveData<MutableList<Contact>>
        get() = _contacts

    // Live Data für ausgewählten Kontakt
    private var _selectedContact = MutableLiveData<Contact>()
    val selectedContact: LiveData<Contact>
        get() = _selectedContact

    fun filterContacts(input: String) {
        val filteredContacts = mutableListOf<Contact>()

        for (contact in allContacts) {
            if (contact.name.lowercase().contains(input.lowercase())) {
                filteredContacts.add(contact)
            }
        }
        _contacts.value = filteredContacts
    }

    fun addNewContact(contact: Contact) {
        allContacts.add(contact)
    }
}