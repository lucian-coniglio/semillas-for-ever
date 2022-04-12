package ar.edu.unahur.obj2.semillas


open class Planta (open var altura: Double, open val anioSemilla: Int){
    open fun toleranciaSol(): Int {
        return 7
    }
    open fun espacio(): Double {
        return 0.5
    }
    open fun daSemillas(): Boolean {
        return true
    }
    open fun esFuerte(): Boolean {
        return this.toleranciaSol() > 9
    }
}
open class Menta(altura: Double, anioSemilla: Int) : Planta(altura,anioSemilla) {
    override fun espacio(): Double {
        return altura + 1
    }
    override fun daSemillas(): Boolean {
        return altura > 0.4 || esFuerte()
    }
}

open class Soja( altura: Double,  anioSemilla: Int) : Planta(altura, anioSemilla){

    override fun toleranciaSol(): Int {
        var tolerancia = 12
        if (altura in 0.5..1.0) {tolerancia =8}
        else if (altura < 0.5) {tolerancia = 6}
        return tolerancia
    }

    override fun espacio(): Double { return altura / 2 }

    override fun daSemillas(): Boolean {
        return esFuerte() || anioSemilla > 2007 && altura in 0.75..0.9
    }

}

class Quinoa(altura: Double, anioSemilla: Int, var espacio: Double) : Planta(altura, anioSemilla){
    override fun toleranciaSol(): Int {
        if (espacio < 0.3) {return 10}
        else {return 7}
    }

    override fun espacio(): Double {
        return altura / 2
    }

    override fun daSemillas(): Boolean {
        return esFuerte() || anioSemilla in 2001..2008
    }

}

class SojaTrans(altura: Double, anioSemilla: Int) : Soja(altura, anioSemilla) {
    override fun daSemillas(): Boolean {return false}
}

class Peperina(altura: Double, anioSemilla: Int) : Menta(altura, anioSemilla) {
    override fun espacio(): Double {return (altura +1) *2}
}

class Parcela(val ancho: Double, val largo: Double, val horasSol: Int,) {
    var plantas = mutableListOf<Planta>()

    fun superficie(): Double {
        return ancho * largo
    }

    fun maxPlantas(): Double {
        // Creo que aca deberia ser tipo entero, porque a mi entender no se puede plantas media planta. hay que revisarlo
        if (ancho <= largo) {return superficie() / 3 + largo} else {return superficie() / 5}
    }

    fun tieneComplicaciones() = plantas.any() {p-> p.toleranciaSol() < horasSol}

    fun plantar(planta: Planta): Unit {
        plantas.add(planta)
        //if plantas.size > this.maxPlantas() //throw exception: Se superó la capacidad maxima de la parcela
        //if planta.toleranciaSol() - horasSol >= 2 //throw Exception: La parcela recibe más luz que la tolerancia de la planta

    }
}


