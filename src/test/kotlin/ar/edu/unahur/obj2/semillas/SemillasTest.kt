package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.describeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
    describe("Pruebas sobre diferentes plantas"){
        val quinoa1 = Quinoa(0.4,2010, 0.2)
        val quinoa2 = Quinoa(1.8,2006,0.9)
        val sojeroFeliz = SojaTrans(1.0, 2022)
        val pepi = Peperina(1.0,2020)
        val menti = Menta(1.0,2020)
        it("verificar si las plantas dan semillas"){
            quinoa1.daSemillas().shouldBeTrue()
            quinoa2.daSemillas().shouldBeTrue()
            sojeroFeliz.daSemillas().shouldBeFalse()
        }
        it("Comparar espacio ocupado entre menta y peperina"){
            pepi.espacio().shouldBe(4.0)
            menti.espacio().shouldBe(2.0)
        }
    }
    describe("Creación de parcela, y plantas de soja") {
        val parcela1 = Parcela(20.0, 1.0, 10)
        val ssj1 = Soja(1.1,2018)
        val ssj2 = Soja(1.12, 2019)
        val ssj3 = Soja(1.17, 2020)
        val ssj4 = Soja(1.23, 2021)
        //Plantamos Soja
        //parcela1.plantar(ssj1)
        //parcela1.plantar(ssj2)
        //parcela1.plantar(ssj3)
        //parcela1.plantar(ssj4)

        it("Comprobación de superficie y cantidad maxima de plantas "){
            parcela1.superficie().shouldBe(20.0)
            parcela1.maxPlantas().shouldBe(4)
            //parcela1.plantas.size.shouldBe(4)
            //parcela1.tieneComplicaciones().shouldBeFalse()
        }


}})