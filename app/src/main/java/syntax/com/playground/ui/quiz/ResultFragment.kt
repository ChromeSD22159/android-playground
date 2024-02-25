package syntax.com.playground.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import syntax.com.playground.R
import syntax.com.playground.databinding.FragmentResultBinding

class ResultFragment: Fragment() {

    private lateinit var binding: FragmentResultBinding

    private val quizViewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Beobachtet auch die Score LiveData aus dem ViewModel
        quizViewModel.score.observe(viewLifecycleOwner) {
            if (it != 10) {
                binding.tvTitle.text = "Du hast leider verloren!"
                binding.tvResultScore.text = "Dein Ergebnis: $it"
            }
        }

        // Setzt im ViewModel alle Werte zurück
        binding.btRestart.setOnClickListener {
            quizViewModel.restartGame()
        }

        // Wenn Game läuft (isGameOver == false) wird zurück zum Quizfragment navigiert
        quizViewModel.isGameOver.observe(viewLifecycleOwner) {
            if (!it) {
                findNavController().navigate(R.id.quizFragment)
            }
        }

    }
}