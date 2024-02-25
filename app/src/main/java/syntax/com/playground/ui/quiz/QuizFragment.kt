package syntax.com.playground.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import syntax.com.playground.R
import syntax.com.playground.databinding.FragmentQuizBinding

class QuizFragment: Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(layoutInflater)
        return binding.root
    }

    // Das Fragment kümmert sich jetzt nur noch um User-Interkationen und darum unsere Daten anzuzeigen
    // Es enthält keine eigene Logik mehr
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Beobachten der public val "currentQuestion" im ViewModel
        // Verändert sich der Inhalt dieser LiveData wird der Code innerhalb der Lambda-Funktion ausgeführt
        quizViewModel.currentQuestion.observe(viewLifecycleOwner) {
            binding.tvQuestion.text = it.question
            binding.tvOptionOne.text = it.optionOne
            binding.tvOptionTwo.text = it.optionTwo
        }

        // Beobachten der public val "score" im ViewModel
        // Verändert sich der Inhalt dieser LiveData wird der Code innerhalb der Lambda-Funktion ausgeführt
        quizViewModel.score.observe(viewLifecycleOwner) {
            binding.tvScore.text = "Score: $it"
        }

        // Wenn Spiel vorbei (isGameOver == true) wird zum ResultFragment navigiert
        quizViewModel.isGameOver.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.resultFragment)
            }
        }

        // ClickListener um Antwort zu überprüfen
        binding.btOptionOne.setOnClickListener {
            quizViewModel.checkAnswer(1)
        }

        // ClickListener um Antwort zu überprüfen
        binding.btOptionTwo.setOnClickListener {
            quizViewModel.checkAnswer(2)
        }

    }


}