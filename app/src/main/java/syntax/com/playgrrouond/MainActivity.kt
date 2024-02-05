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
        setupAllViews()
    }

    private fun setupAllViews() {
        setupAllButtons()
        setupRadioButtons()
        setupSwitches()
    }

    private fun setupAllButtons() {
        binding.buttonGenerateText.setOnClickListener {
            val editTextEntry = binding.editTextText.text
            var result = getString(R.string.textViewOutput)
            if (!editTextEntry.isBlank()) {
                result = getString(R.string.textViewOutput) + "\n${editTextEntry}"
            }
            binding.textViewResult.text = result
        }
        binding.buttonReset.setOnClickListener {
            resetAllViews()
        }
    }

    private fun setupRadioButtons() {
        binding.radioButtonGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId) {
                binding.radioButtonRed.id -> setBackgroundToColor(Color.RED)
                binding.radioButtonGreen.id -> setBackgroundToColor(Color.GREEN)
                binding.radioButtonBlue.id -> setBackgroundToColor(Color.BLUE)
                else -> setBackgroundToColor(Color.TRANSPARENT)
            }
        }
    }

    private fun setupSwitches() {
        binding.switchEditText.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.editTextText.isEnabled = isChecked
        }
        binding.switchRadioButtons.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.radioButtonRed.isEnabled = isChecked
            binding.radioButtonGreen.isEnabled = isChecked
            binding.radioButtonBlue.isEnabled = isChecked
        }
        binding.switchButton.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.buttonGenerateText.isEnabled = isChecked
            binding.buttonReset.isEnabled = isChecked
        }
    }

    private fun resetAllViews() {
        setBackgroundToColor(Color.TRANSPARENT)
        setAllSwitchesTo(true)
        resetTextViews()
        setAllRadioButtonsTo(false)
    }

    private fun setBackgroundToColor(color: Int) {
        binding.root.setBackgroundColor(color)
        binding.linearLayoutEditText.setBackgroundColor(color)
        binding.linearLayoutRadioButtons.setBackgroundColor(color)
        binding.linearLayoutSwitches.setBackgroundColor(color)
        binding.linearLayoutButtons.setBackgroundColor(color)
        binding.linearLayoutTextViewResult.setBackgroundColor(color)
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