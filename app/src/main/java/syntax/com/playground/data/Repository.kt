package syntax.com.playground.data

import syntax.com.playground.data.model.Question

class Repository {

    private val questionsList: List<Question> = listOf(
        Question("Was ist die Hauptstadt von Frankreich?", "Paris", "Rom", 1),
        Question("Wie viele Kontinente gibt es auf der Erde?", "5", "7", 2),
        Question("Welches Element hat das chemische Symbol 'O'?", "Gold", "Sauerstoff", 2),
        Question("Wer schrieb 'Faust'?", "Thomas Mann", "Johann Wolfgang von Goethe", 2),
        Question("Was ist der größte Planet im Sonnensystem?", "Jupiter", "Mars", 1),
        Question("Wie viele Farben hat ein Regenbogen?", "7", "5", 1),
        Question("Welches Tier gilt als der schnellste Läufer an Land?", "Gepard", "Löwe", 1),
        Question("Wie viele Nullen hat eine Milliarde?", "9", "6", 1),
        Question("Wer malte die 'Mona Lisa'?", "Leonardo da Vinci", "Michelangelo", 1),
        Question("In welchem Zustand ist Wasser bei 100°C?", "Flüssig", "Gasförmig", 2),
        Question("Was ist die Hauptstadt von Japan?", "Tokio", "Kyoto", 1),
        Question("Wer schrieb 'Romeo und Julia'?", "William Shakespeare", "Charles Dickens", 1),
        Question("Was ist das chemische Symbol für Silber?", "Ag", "Au", 1),
        Question("Wie viele Streifen hat die US-Flagge?", "13", "11", 1),
        Question("Welches Tier wird oft als 'König der Tiere' bezeichnet?", "Löwe", "Tiger", 1),
        Question("Welches Organ pumpt Blut durch den menschlichen Körper?", "Herz", "Leber", 1),
        Question("Wie viele Planeten hat unser Sonnensystem?", "8", "9", 1),
        Question("Welcher Ozean ist der größte?", "Pazifik", "Atlantik", 1),
        Question("Welches Land gewann die Fußball-Weltmeisterschaft 2014?", "Deutschland", "Brasilien", 1),
        Question("Wie viele Zähne hat ein normaler erwachsener Mensch?", "32", "28", 1),
        Question("In welchem Land liegt die Stadt Casablanca?", "Marokko", "Ägypten", 1),
        Question("Wer ist der Autor von '1984'?", "George Orwell", "Aldous Huxley", 1),
        Question("Wie heißt der längste Fluss der Welt?", "Nil", "Amazonas", 2),
        Question("Welches Land ist für seine Windmühlen und Tulpen bekannt?", "Niederlande", "Belgien", 1),
        Question("Wie viele Tasten hat ein Standard-Piano?", "88", "52", 1),
        Question("Was ist die härteste Substanz im menschlichen Körper?", "Zahnemail", "Knochen", 1),
        Question("Was ist das größte Tier, das jemals gelebt hat?", "Blauwal", "Afrikanischer Elefant", 1),
        Question("Wie viele Herzkammern hat ein Mensch?", "4", "6", 1),
        Question("Was ist die tiefste Stelle im Weltmeer?", "Marianengraben", "Tonga-Graben", 1),
        Question("Wer ist der Schöpfer der iPhone- und iPad-Technologie?", "Steve Jobs", "Bill Gates", 1)
    )

    fun loadData(): List<Question> {
        return questionsList
    }

}