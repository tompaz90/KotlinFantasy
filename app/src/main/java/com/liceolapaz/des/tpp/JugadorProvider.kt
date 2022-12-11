package com.liceolapaz.des.tpp



class JugadorProvider {
    companion object{
        val jugadorList = listOf<Jugador>(
            Jugador(
                1,
                "Messi",
                9999999.99,
                "999999$",
                9999),
            Jugador(
                2,
                "CR7",
                8888888.88,
                "Delantero (DL)",
                9998,
            )
        )
    }
}