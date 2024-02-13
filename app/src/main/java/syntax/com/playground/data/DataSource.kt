package syntax.com.playground.data

import syntax.com.playground.data.model.Article
import syntax.com.playground.R
import kotlin.random.Random

class DataSource {

    fun loadArticels(count: Int = 100): List<Article> {
        var randomsArticles = mutableListOf<Article>()
        val allCans = listOfAllCans()
        val allShips = listOfAllShips()
        for (index in 0..count) {
            randomsArticles.add(allCans[(0..allCans.size -1).random()])
            randomsArticles.add(allShips[(0..allShips.size -1).random()])
        }
        return randomsArticles.shuffled()
    }

    private fun listOfAllShips(): List<Article> {
        return listOf(
            Article(R.drawable.ship_01, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_02, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_03, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_04, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_05, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_06, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_07, generateRandomIpsumWords(), true),
            Article(R.drawable.ship_08, generateRandomIpsumWords(), true)
        )
    }

    private fun listOfAllCans(): List<Article> {
        return listOf(
            Article(R.drawable.can1, generateRandomIpsumWords(), false),
            Article(R.drawable.can2, generateRandomIpsumWords(), false),
            Article(R.drawable.can3, generateRandomIpsumWords(), false),
            Article(R.drawable.can4, generateRandomIpsumWords(), false),
            Article(R.drawable.can5, generateRandomIpsumWords(), false),
            Article(R.drawable.can6, generateRandomIpsumWords(), false)
        )
    }
    
    private fun generateRandomIpsumWords(): String {
        return generateLoremIpsum((23..42).random())
    }

   private fun generateLoremIpsum(wordCount: Int): String {
        val loremIpsumWords = arrayOf(
            "lorem", "ipsum", "dolor", "sit", "amet", "consectetur",
            "adipiscing", "elit", "sed", "do", "eiusmod", "tempor",
            "incididunt", "ut", "labore", "et", "dolore", "magna",
            "aliqua", "ut", "enim", "ad", "minim", "veniam"
        )

        return (1..wordCount)
            .map { loremIpsumWords[Random.nextInt(loremIpsumWords.size)] }
            .joinToString(" ")
            .plus(".")
    }
}