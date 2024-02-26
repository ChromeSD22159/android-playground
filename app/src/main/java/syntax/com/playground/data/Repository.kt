package syntax.com.playground.data

import syntax.com.playground.data.model.Chapter
import kotlin.random.Random

class Repository {

    private fun generateRandomIpsumWords(): String {
        return generateLoremIpsum((3..15).random())
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

    private fun generateChapterList(count: Int = 100): List<Chapter> {
        val chapterList = mutableListOf<Chapter>()

        for (index in 0..count) {
            chapterList.add(Chapter(index, generateRandomIpsumWords()))
        }
        return chapterList
    }

    fun getChapterList(count: Int = 100): List<Chapter> {
        return generateChapterList(count)
    }
}