package com.example.quiz

object constants {

    val USER_NAME:String ="user_name"
    val TOTAL_QUE :String ="total_que"
    val CORRECT_ANS :String ="correct_ans"

    fun getque() : ArrayList<Question> {
        val quelist = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )
        quelist.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )

        quelist.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        quelist.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        quelist.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        quelist.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        quelist.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        quelist.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        quelist.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_newzealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        quelist.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        quelist.add(que10)
        return quelist
    }

}