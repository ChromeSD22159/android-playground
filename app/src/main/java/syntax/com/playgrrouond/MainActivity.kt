package syntax.com.playgrrouond

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import syntax.com.playgrrouond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resetAllViews()
        setupAllButtons()
    }

    private fun setupAllButtons() {
        binding.buttonGenerateText.setOnClickListener {
            val editTextEntry = binding.editTextText.text
            binding.textViewResult.text = getString(R.string.textViewOutput) + "\n${editTextEntry}"
        }
        binding.buttonReset.setOnClickListener {
            resetAllViews()
        }
    }

    private fun resetAllViews() {
        setAllBackgroundColorToWhite()
        setAllSwitchesTo(true)
        resetTextViews()
        setAllRadioButtonsTo(false)
    }

    private fun setAllBackgroundColorToWhite() {
        binding.root.setBackgroundColor(Color.WHITE)
        binding.linearLayoutEditText.setBackgroundColor(Color.WHITE)
        binding.linearLayoutRadioButtons.setBackgroundColor(Color.WHITE)
        binding.linearLayoutSwitches.setBackgroundColor(Color.WHITE)
        binding.linearLayoutButtons.setBackgroundColor(Color.WHITE)
        binding.linearLayoutTextViewResult.setBackgroundColor(Color.WHITE)
    }

    private fun setAllSwitchesTo(isChecked: Boolean) {
        binding.switchEditText.isChecked = isChecked
        binding.switchRadioButtons.isChecked = isChecked
        binding.switchButton.isChecked = isChecked
    }

    private fun setAllRadioButtonsTo(isChecked: Boolean) {
        binding.radioButtonRed.isChecked = isChecked
        binding.radioButtonGreen.isChecked = isChecked
        binding.radioButtonBlue.isChecked = isChecked
    }

    private fun resetTextViews() {
        binding.editTextText.setText("")
        binding.textViewResult.text = getString(R.string.textViewOutput)
    }
}