def calcFuel(mass: Int) = 
  mass / 3 - 2
val l = List(14, 1969, 100756)
l.map(calcFuel).toList
def calcAllFuel(mass: Int) = Iterator.iterate(calcFuel(mass))(calcFuel)
l.map(calcAllFuel(_).takeWhile(_ > 0).sum)