package syntax.com.playground.ui.article

import androidx.lifecycle.ViewModel
import syntax.com.playground.R
import syntax.com.playground.data.repo.LoremRepository

class ArticleViewModel: ViewModel() {

    private val loremRepository = LoremRepository()

    val canList = loremRepository.loadCans(10000)
    val shipList = loremRepository.loadShips(100000)

    private var _position = 0
    val position: Int
        get() = _position

    private var _imageRef = R.drawable.ship_01
    val imageRef: Int
        get() = _imageRef

    private var _articleDescription = ""
    val articleDescription: String
        get() = _articleDescription

    fun setArticleDescription(text: String) {
        _articleDescription = text
    }

    fun setImageRef(ref: Int) {
        _imageRef = ref
    }

    fun setPosition(position: Int) {
        _position = position
    }
}