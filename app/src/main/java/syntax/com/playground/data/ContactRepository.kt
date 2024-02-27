package syntax.com.playground.data

import syntax.com.playground.data.model.Contact

class ContactRepository {

    private val contactsList: MutableList<Contact> = mutableListOf(
        Contact("Anna Bauer", "0123-4567890"),
        Contact("Maximilian Schmidt", "0123-4567891"),
        Contact("Sophia Becker", "0123-4567892"),
        Contact("Lukas Wagner", "0123-4567893"),
        Contact("Emma Müller", "0123-4567894"),
        Contact("Felix Schneider", "0123-4567895"),
        Contact("Mia Schwarz", "0123-4567896"),
        Contact("Leon Hofmann", "0123-4567897"),
        Contact("Lina Fischer", "0123-4567898"),
        Contact("Jonas Richter", "0123-4567899"),
        Contact("Marie Weber", "0123-4567800"),
        Contact("Paul Meyer", "0123-4567801"),
        Contact("Charlotte Krause", "0123-4567802"),
        Contact("Elias Lang", "0123-4567803"),
        Contact("Emily Neumann", "0123-4567804"),
        Contact("Anton Brandt", "0123-4567805"),
        Contact("Lilly Zimmermann", "0123-4567806"),
        Contact("Finn Koch", "0123-4567807"),
        Contact("Amelie Braun", "0123-4567808"),
        Contact("Noah Frank", "0123-4567809"),
        Contact("Maria Koch", "0123-4567890"),
        Contact("Peter Bondt", "0123-4567891"),
        Contact("Helga Lorem", "0123-4567892"),
        Contact("Erwin Wagner", "0123-4567893"),
        Contact("Emanuel Müller", "0123-4567894"),
        Contact("GHendrik Schneider", "0123-4567895"),
        Contact("Felix Schwarz", "0123-4567896"),
        Contact("Martin Hofmann", "0123-4567897"),
        Contact("Lorena Souttern", "0123-4567898"),
        Contact("Joana Richy", "0123-4567899"),
        Contact("Marie Jane", "0123-4567800"),
        Contact("Paul van Dorten", "0123-4567801"),
        Contact("Herniette Mitchek", "0123-4567802"),
        Contact("Elvias Langosoia", "0123-4567803"),
        Contact("Emerlad Hemptown", "0123-4567804"),
        Contact("Antonia Brandtia", "0123-4567805"),
        Contact("Lorken Doudt", "0123-4567806"),
        Contact("Mine Kine", "0123-4567807"),
        Contact("Sascha Hascha", "0123-4567808"),
        Contact("Frieda Franko", "0123-4567809")
    )

    fun loadContacts(): MutableList<Contact> {
        return contactsList
    }
}