package syntax.com.playground

class DataSource {

    private val someText = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups."
    fun loadArticels(): List<Article> {
        return listOf(
            Article(R.drawable.ship_01, someText, true),
            Article(R.drawable.ship_02, someText, true),
            Article(R.drawable.ship_03, someText, true),
            Article(R.drawable.ship_04, someText, true),
            Article(R.drawable.ship_05, someText, true),
            Article(R.drawable.ship_06, someText, true),
            Article(R.drawable.ship_07, someText, true),
            Article(R.drawable.ship_08, someText, true),
            Article(R.drawable.can1, someText, false),
            Article(R.drawable.can2, someText, false),
            Article(R.drawable.can3, someText, false),
            Article(R.drawable.can4, someText, false),
            Article(R.drawable.can5, someText, false),
            Article(R.drawable.can6, someText, false),
            Article(R.drawable.ship_01, someText, true),
            Article(R.drawable.ship_02, someText, true),
            Article(R.drawable.ship_03, someText, true),
            Article(R.drawable.ship_04, someText, true),
            Article(R.drawable.ship_05, someText, true),
            Article(R.drawable.ship_06, someText, true),
            Article(R.drawable.ship_07, someText, true),
            Article(R.drawable.ship_08, someText, true),
            Article(R.drawable.can1, someText, false),
            Article(R.drawable.can2, someText, false),
            Article(R.drawable.can3, someText, false),
            Article(R.drawable.can4, someText, false),
            Article(R.drawable.can5, someText, false),
            Article(R.drawable.can6, someText, false),
            Article(R.drawable.ship_01, someText, true),
            Article(R.drawable.ship_02, someText, true),
            Article(R.drawable.ship_03, someText, true),
            Article(R.drawable.ship_04, someText, true),
            Article(R.drawable.ship_05, someText, true),
            Article(R.drawable.ship_06, someText, true),
            Article(R.drawable.ship_07, someText, true),
            Article(R.drawable.ship_08, someText, true),
            Article(R.drawable.can1, someText, false),
            Article(R.drawable.can2, someText, false),
            Article(R.drawable.can3, someText, false),
            Article(R.drawable.can4, someText, false),
            Article(R.drawable.can5, someText, false),
            Article(R.drawable.can6, someText, false)
        )
    }
}