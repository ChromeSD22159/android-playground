package syntax.com.playground.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import syntax.com.playground.data.Repository
import syntax.com.playground.data.model.Question

// ViewModel um die Logik unserer App zu organisiseren
class QuizViewModel : ViewModel() {

    // Daten werden jetzt hier geladen, nicht mehr im Fragment
    private val repository = Repository()
    private val questions = repository.loadData()

    // Live Data um die aktuelle Frage zu halten
    // private ist die LiveData "Mutable" damit diese nur hier im ViewModel verändert werden kann
    private var _currentQuestion = MutableLiveData<Question>(questions.random())
    // als public val ist die LiveData nicht Mutable, damit von außen (aus den Fragmenten) nur auf den Wert zugegriffen aber nicht verändert werden kann
    val currentQuestion: LiveData<Question>
        // Da die public val keinen eigenen Wert hält sondern nur den Wert der private var nach außen geben soll, gibt ein Aufruf der public val einfach den Wert in der private var zurück
        get() = _currentQuestion

    // Gleich wie LiveData zu "currentQuestion" oben
    private var _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score

    // Gleich wie LiveData zu "currentQuestion" oben
    private var _isGameOver = MutableLiveData<Boolean>(false)
    val isGameOver: LiveData<Boolean>
        get() = _isGameOver

    // Funktion um neue Frage zu laden
    private fun nextQuestion() {
        // in den Wert der LiveData "value" wird eine neue Frage gespeichert
        _currentQuestion.value = questions.random()
    }

    // Funktion um Antwort zu überprüfen
    fun checkAnswer(answer: Int) {
        if (answer == _currentQuestion.value?.correctAnswer) {
            // Wert innerhalb von score wird um 1 erhöht, wenn Frage richtig ist
            // Da hier LiveData aktualisiert wird, werden alle Observer auf die LiveData "score" benachrichtigt
            _score.value = score.value?.plus(1)

            if (_score.value == 10) {
                // Der Wert der LiveData wird verändert mit Zugriff auf "value"
                _isGameOver.value = true
            } else {
                nextQuestion()
            }

        } else {
            // Der Wert der LiveData wird verändert mit Zugriff auf "value"
            _isGameOver.value = true
        }
    }

    fun restartGame() {
        _isGameOver.value = false
        _score.value = 0
        nextQuestion()
    }

}