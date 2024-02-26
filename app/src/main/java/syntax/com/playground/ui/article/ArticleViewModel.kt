package syntax.com.playground.ui.article

import androidx.lifecycle.ViewModel
import syntax.com.playground.data.Repository

class ArticleViewModel: ViewModel() {

    private val repository = Repository()

    val canList = repository.loadCans(10000)
    val shipList = repository.loadShips(100000)
}