package syntax.com.playground.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import syntax.com.playground.R
import syntax.com.playground.databinding.ActivityMainBinding
import syntax.com.playground.helpers.PGConstant
import syntax.com.playground.ui.meal.MealViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        handleOnBackPressed()
        setupObservers()
    }

    private fun setupBottomNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomNAvigationView.setupWithNavController(navHost.navController)
    }

    private fun handleOnBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                binding.fragmentContainerView.findNavController().navigateUp()
                binding.toolbar.title = PGConstant.EMPTY_STRING.strValue
            }
        }
        onBackPressedDispatcher.addCallback(callback)
    }

    private fun setupObservers() {
        viewModel.actionBarTitle.observe(this) {
            binding.toolbar.title = it
        }
    }
}