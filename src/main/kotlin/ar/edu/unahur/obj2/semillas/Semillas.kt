package ar.edu.unahur.obj2.semillas

class Menta(var altura: Double, val anioSemilla: Int) {
    fun toleranciaSol(): Int {
        return 7
    }

    fun espacio(): Double {
        return altura + 1
    }

    fun daSemillas(): Boolean {
        return altura > 0.4 || esFuerte()
    }

    fun esFuerte(): Boolean {
        return toleranciaSol() > 9
    }

}

class Soja(var altura: Double, val anioSemilla: Int) {

    fun toleranciaSol(): Int {
        if (altura < 0.5) {return 6}
        else if (altura in 0.5..1.0) {return 8}
        else {return 12}
    }

    fun espacio(): Double {
        return altura / 2
    }

    fun daSemillas(): Boolean {
        return esFuerte() || anioSemilla > 2007 && altura in 0.75..0.9
    }

    fun esFuerte(): Boolean {
        return toleranciaSol() > 9
    }
}


class Quinoa(var altura: Double, val anioSemilla: Int, var espacio: Double) {
    fun toleranciaSol(): Int {
        if (espacio < 0.3) {return 10}
        else {return 7}
    }

    fun espacio(): Double {
        return altura / 2
    }

    fun daSemillas(): Boolean {
        return esFuerte() || anioSemilla in 2001..2008
    }

    fun esFuerte(): Boolean {
        return toleranciaSol() > 9
    }
}
