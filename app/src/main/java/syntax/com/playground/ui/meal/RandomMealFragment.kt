package syntax.com.playground.ui.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import syntax.com.playground.data.model.meal.Meal
import syntax.com.playground.databinding.FragmentRandomMealBinding

class RandomMealFragment: Fragment() {

    private lateinit var vb: FragmentRandomMealBinding
    private val viewModel: MealViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vb = FragmentRandomMealBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Verberge die Komplexität in Funktionen.
         * Funktionen sollten einen aussagekräftigen Namen haben.
         * An dieser Stelle können wir den Vorgang im Quelltext nachvollziehen. Das heißt
         * den Ablauf, Schritt für Schritt ablesen.
         * Wenn wir an den konkreten Detail interesse haben, schauen wir uns die
         * konkrete Implementierung der jeweilingen Funktion an.
         *
         * An dieser Stelle ist das aber erst noch nicht relevant.
         * Also Merke: VERBERGE die Komplexität!!!!!
         *
         * Weiter sind Kommentare NICHT zu-Empfehlen. Der Code soll
         * selbst erklärend sein!!!!
         */
        addObservers()
        addClickListeners()
    }

    private fun addClickListeners() {
        vb.btNext.setOnClickListener {
            viewModel.laodRandomMeal()
        }
    }

    private fun addObservers() {
        viewModel.randomMeal.observe(viewLifecycleOwner) { mealObj: Meal ->
            vb.tvMealTitle.text = mealObj.name
            vb.tvCountry.text = mealObj.area
            vb.tvCategory.text = mealObj.category
            vb.ivRandomMealImage.load(mealObj.image)
        }
    }
}