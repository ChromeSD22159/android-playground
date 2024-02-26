package syntax.com.playground.data

import syntax.com.playground.data.model.Chapter
import kotlin.random.Random

class Repository {

    fun getChapterList(count: Int = 100, isRandom: Boolean = true): List<Chapter> {
        return if (isRandom) generateChapterList(count) else { hardCodedChapterList }
    }

    private val hardCodedChapterList: List<Chapter> = listOf(
        Chapter(0, "lorem"),
        Chapter(1, "lorem ipsum"),
        Chapter(2, "lorem ipsum dolor"),
        Chapter(3, "lorem ipsum dolor amet"),
        Chapter(4, "lorem ipsum dolor amet consectetur"),
        Chapter(5, "lorem ipsum dolor amet consectetur adipiscing"),
        Chapter(6, "lorem ipsum dolor amet consectetur adipiscing elit"),
        Chapter(7, "lorem ipsum dolor amet consectetur adipiscing elit sed"),
        Chapter(8, "lorem ipsum dolor amet consectetur adipiscing elit sed do"),
        Chapter(9, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod"),
        Chapter(10, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor"),
        Chapter(11, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt"),
        Chapter(12, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut"),
        Chapter(13, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore"),
        Chapter(14, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et"),
        Chapter(15, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore"),
        Chapter(16, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna"),
        Chapter(17, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"),
        Chapter(18, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut"),
        Chapter(19, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim"),
        Chapter(20, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad"),
        Chapter(21, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim"),
        Chapter(22, "lorem ipsum dolor amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad minim veniam")
    )

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
}