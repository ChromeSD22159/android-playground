package syntax.com.playground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import syntax.com.playground.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.extras?.getInt(POSITION)
        val imageRef = intent.extras?.getInt(IMAGEREF)
        val description = intent.extras?.getString(DESCRIPTION)

        if (position != null && imageRef != null && description != null) {
            binding.tvPosition.text = position.toString()
            binding.imageView.setImageResource(imageRef)
            binding.tvDetail.text = description

            binding.btShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo ich möchte gerne X mit dir teilen.")

                intent.type = "text/plain"

                val shareChooser = Intent.createChooser(intent, position.toString())
                startActivity(shareChooser)
            }
        }
    }
}