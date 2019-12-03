import java.io.BufferedReader
import java.io.File
import scala.io.Source

object Sol01 extends App with SolInput {

    val fileName = "Sol01.txt"
    
    val masses = input(fileName).map(_.toInt).toList

    def calcFuel(mass: Int) = 
        mass / 3 - 2

    val res1 = masses.map(calcFuel).sum

    println(s"$res1") //3342351

    def calcAllFuel(mass: Int) = Iterator.iterate(calcFuel(mass))(calcFuel)

    val res2 = masses.map(calcAllFuel(_).takeWhile(_ > 0).sum).sum

    println(s"$res2") //5010664
}