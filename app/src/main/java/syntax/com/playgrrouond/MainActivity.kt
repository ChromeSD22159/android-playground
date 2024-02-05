package syntax.com.playgrrouond

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.core.view.allViews
import androidx.core.view.iterator
import syntax.com.playgrrouond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resetAllViews()
        setupAllViews()
        disableAllViews()
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
                else -> setBackgroundToColor(Color.WHITE)
            }
        }
    }

    private fun setupSwitches() {
        binding.switchEditText.setOnCheckedChangeListener { _, isChecked ->
            binding.editTextText.isEnabled = isChecked
            if(!isChecked) {
                resetTextViews()
            }
        }
        binding.switchRadioButtons.setOnCheckedChangeListener { _, isChecked ->
            setRadioButtonsIsEnabledTo(isChecked)
            if (!isChecked) {
                resetRadioButtons()
                setBackgroundToColor(Color.WHITE)
            }
        }
        binding.switchButton.setOnCheckedChangeListener { _, isChecked ->
            binding.buttonGenerateText.isEnabled = isChecked
            binding.buttonReset.isEnabled = isChecked
        }
    }

    private fun resetAllViews() {
        setAllSwitchesTo(false)
        setRadioButtonsIsEnabledTo(false)
        setButtonsIsEnabledTo(false)
        resetTextViews()
        resetRadioButtons()
        setBackgroundToColor(Color.TRANSPARENT)
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

    private fun resetRadioButtons() {
        binding.radioButtonRed.isChecked = false
        binding.radioButtonGreen.isChecked = false
        binding.radioButtonBlue.isChecked = false
    }

    private fun setRadioButtonsIsEnabledTo(isEnabled: Boolean) {
        binding.radioButtonRed.isEnabled = isEnabled
        binding.radioButtonGreen.isEnabled = isEnabled
        binding.radioButtonBlue.isEnabled = isEnabled
    }

    private fun resetTextViews() {
        binding.editTextText.isEnabled = false
        binding.editTextText.text.clear()
        binding.textViewResult.text = getString(R.string.textViewOutput)
    }

    private fun setButtonsIsEnabledTo(isEnabled: Boolean) {
        binding.buttonGenerateText.isEnabled = isEnabled
        binding.buttonReset.isEnabled = isEnabled
    }

    private fun disableAllViews() {
        binding.switchEditText.isChecked = false
        binding.switchRadioButtons.isChecked = false
        binding.switchButton.isChecked = false
    }
}