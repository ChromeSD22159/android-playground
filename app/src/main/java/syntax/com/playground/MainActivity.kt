package syntax.com.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import syntax.com.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shipList = DataSource().loadShips()
        binding.recyclerView.adapter = ShipAdapter(this, shipList)
    }
}