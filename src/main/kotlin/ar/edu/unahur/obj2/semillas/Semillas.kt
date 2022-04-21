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
    fun parcelaIdeal(unaParcela: Parcela): Boolean{
        return unaParcela.superficie() > 6
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
    fun parcelaIdeal(unaParcela: Parcela): Boolean {
        return unaParcela.horasSol == toleranciaSol()
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
    fun parcelaIdeal(unaParcela: Parcela): Boolean {
        return unaParcela.plantas.all {this.altura < 1.5}
    }
}

class SojaTrans(altura: Double, anioSemilla: Int) : Soja(altura, anioSemilla) {
    override fun daSemillas(): Boolean {return false}
    override fun parcelaIdeal(unaParcela: Parcela): Boolean {
        return unaParcela.plantas.count() == 1
    }
}

class Peperina(altura: Double, anioSemilla: Int) : Menta(altura, anioSemilla) {
    override fun espacio(): Double {return (altura +1) *2}
}

class Parcela(val ancho: Double, val largo: Double, val horasSol: Int,) {
    var plantas: Iterable<Planta>()

    fun superficie(): Double {
        return ancho * largo
    }

    fun maxPlantas(): Double {
        if (ancho <= largo) {return superficie() / 3 + largo} else {return superficie() / 5}
    }


    fun tieneComplicaciones(): Boolean { return plantas.any{this.toleranciaSol() < horasSol}}

}

