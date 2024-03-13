package syntax.com.playground.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.data.repo.ContactRepository
import syntax.com.playground.data.model.contact.Contact

class ContactViewModel: ViewModel() {

    private val repository = ContactRepository()
    private val allContacts = repository.loadContacts()
    private var _contacts = MutableLiveData(allContacts)
    val contacts: LiveData<MutableList<Contact>>
        get() = _contacts

    /**
     * Live Data für ausgewählten Kontakt
     */
    private var _selectedContact = MutableLiveData(_contacts.value!!.first())
    val selectedContact: LiveData<Contact>
        get() = _selectedContact

    /**
     * Funktion um Kontakte zu filtern
     * Überschreibt den Inhalt der LiveData
    */
    fun filterContacts(input: String) {
        _contacts.value = allContacts.filter {
            it.name.lowercase().contains(input.lowercase())
        }.toMutableList()
    }

    /**
     * Funktion um neuen Kontakt hinzuzufügen
     * Danach wird auch hier der Inhalt der LiveData überschrieben
    */
    fun addNewContact(contact: Contact) {
        _contacts.value!!.add(contact)
    }

    /**
     * Funktion um ausgewählten Kontakt zu setzen
    */
    fun setSelectedContact(contact: Contact) {
        _selectedContact.value = contact
    }
}