package syntax.com.playground.ui.article

import androidx.lifecycle.ViewModel
import syntax.com.playground.data.LoremRepository

class ArticleViewModel: ViewModel() {

    private val loremRepository = LoremRepository()

    val canList = loremRepository.loadCans(10000)
    val shipList = loremRepository.loadShips(100000)
}