package repositories

import data.Country


object MedalTableRepository {

    private val countries = mutableListOf<Country>()

    init {
        countries.add(
            Country(
                15L,
                1,
                "Estados Unidos",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/2560px-Flag_of_the_United_States.svg.png",
                35,
                30,
                25
            )
        )

        countries.add(
            Country(
                8L,
                2,
                "China",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1024px-Flag_of_the_People%27s_Republic_of_China.svg.png",
                32,
                28,
                22
            )
        )

        countries.add(
            Country(
                78L,
                3,
                "Argentina",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png",
                28,
                24,
                20
            )
        )

        countries.add(
            Country(
                16L,
                4,
                "Alemania",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/640px-Flag_of_Germany.svg.png",
                24,
                20,
                18
            )
        )

        countries.add(
            Country(
                55L,
                5,
                "Japón",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png",
                22,
                18,
                16
            )
        )

        countries.add(
            Country(
                60L,
                6,
                "Reino Unido",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Flag_of_the_United_Kingdom_%281-2%29.svg/1200px-Flag_of_the_United_Kingdom_%281-2%29.svg.png",
                20,
                17,
                15
            )
        )

        countries.add(
            Country(
                10L,
                7,
                "Francia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg/1200px-Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg.png",
                18,
                15,
                14
            )
        )

        countries.add(
            Country(
                66L,
                8,
                "Australia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png",
                15,
                14,
                12
            )
        )

        countries.add(
            Country(
                1L,
                9,
                "Italia",
                "https://upload.wikimedia.org/wikipedia/commons/0/03/Flag_of_Italy.svg",
                14,
                12,
                10
            )
        )

        countries.add(
            Country(
                123L,
                10,
                "Canadá",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/800px-Flag_of_Canada_%28Pantone%29.svg.png",
                12,
                10,
                8
            )
        )
    }


    fun get(): List<Country> {

        return countries.sortedBy { it.goldMedals }.reversed()
    }
}