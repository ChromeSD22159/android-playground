package syntax.com.playground.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import syntax.com.playground.R
import syntax.com.playground.data.model.Contact
import syntax.com.playground.databinding.ItemContactBinding
import syntax.com.playground.ui.SharedViewModel
import syntax.com.playground.ui.contact.ContactViewModel

/**
 * Dem ContactAdapter übergeben wir zwei Parameter.
 * @param listOfContacts Eine Liste von Konktakten.
 * @param contactViewModel Das ContactViewModel um Kontakt bei Klick auszuwählen.

 */
class ContactAdapter(
    private val listOfContacts: List<Contact>,
    private val contactViewModel: ContactViewModel,
    private val sharedViewModel: SharedViewModel
): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    inner class ContactViewHolder(val vb: ItemContactBinding): RecyclerView.ViewHolder(vb.root)

    /**
     * Wird aufgerufen, wenn RecyclerView einen neuen [ViewHolder] des gegebenen Typs benötigt, um
     * ein Element darzustellen.
     *
     *
     * Dieser neue ViewHolder sollte mit einer neuen Ansicht erstellt werden, die die Elemente
     * des gegebenen Typs darstellen kann. Du kannst entweder manuell eine neue Ansicht erstellen oder sie aus einer XML
     * Layout-Datei aufblasen.
     *
     *
     * Der neue ViewHolder wird verwendet, um Elemente des Adapters mit
     * [.onBindViewHolder] anzuzeigen. Da er wiederverwendet wird, um
     * verschiedene Elemente im Datensatz darzustellen, ist es eine gute Idee, Verweise auf Unteransichten
     * der Ansicht zu speichern, um unnötige [View.findViewById] Aufrufe zu vermeiden.
     *
     * @param parent Die ViewGroup, in die die neue Ansicht eingefügt wird, nachdem sie an eine
     * Adapterposition gebunden wurde.
     * @param viewType Der Ansichtstyp der neuen Ansicht.
     *
     * @return Ein neuer ViewHolder, der eine Ansicht des gegebenen Ansichtstyps enthält.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val vb = ItemContactBinding.inflate(LayoutInflater.from(parent.context))
        return ContactViewHolder(vb)
    }

    /**
     * Gibt die Gesamtanzahl der Elemente im Datensatz zurück, der vom Adapter gehalten wird.
     *
     * @return Die Gesamtanzahl der Elemente in diesem Adapter.
     */

    override fun getItemCount(): Int {
        return listOfContacts.size
    }

    /**
     * Wird von RecyclerView aufgerufen, um die Daten an der angegebenen Position anzuzeigen. Diese Methode sollte
     * den Inhalt des [ViewHolder.itemView] aktualisieren, um das Element an der gegebenen
     * Position widerzuspiegeln.
     *
     *
     * Beachte, dass im Gegensatz zu [android.widget.ListView], RecyclerView diese Methode nicht
     * erneut aufrufen wird, wenn sich die Position des Elements im Datensatz ändert, es sei denn, das Element selbst wird
     * ungültig oder die neue Position kann nicht bestimmt werden. Aus diesem Grund solltest du
     * den `position` Parameter nur verwenden, während du das zugehörige Datenelement innerhalb
     * dieser Methode abrufst und solltest keine Kopie davon behalten. Wenn du später die Position eines Elements benötigst
     * (z.B. in einem Klick-Listener), verwende [ViewHolder.getAdapterPosition], welcher
     * die aktualisierte Adapterposition haben wird.
     *
     * Überschreibe [.onBindViewHolder], stattdessen, wenn der Adapter effizientes partielles Binden
     * handhaben kann.
     *
     * @param holder Der ViewHolder, der aktualisiert werden sollte, um den Inhalt des
     * Elements an der gegebenen Position im Datensatz darzustellen.
     * @param position Die Position des Elements innerhalb des Datensatzes des Adapters.
     */

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = listOfContacts[position]
        holder.vb.tvContactName.text = contact.name

        /**
         * OnClickListener setzt Kontakt im ViewModel && navigiert zum zum Detail Fragment.
         */
        holder.vb.root.setOnClickListener {
            Log.e("ViewModel", "ContactAdapter contactViewModel: $contactViewModel")
            contactViewModel.setSelectedContact(contact)
            holder.itemView.findNavController().navigate(R.id.contactDetailFragment)
        }
    }
}