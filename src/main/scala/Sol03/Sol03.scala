case class Pos(x: Int, y: Int)
{
    def +(p:(Int, Int)) = Pos(x + p._1, y + p._2)
    def manhattanDistance(other: Pos = Pos(0,0)): Int =
        (x - other.x).abs + (y - other.y).abs
}

object Sol03 extends App with SolInput {

    val fileName = "Sol03/Sol03.txt"
    
    val wires = input(fileName)
        .map(_.split(','))
        .toList
    
    def partPath(part: String) = {
        val (dir, cnt) = part.splitAt(1)
        LazyList.fill(cnt.toInt)(dir match {
                case "L" => (-1,0)
                case "R" => (1,0)
                case "U" => (0,1)
                case "D" => (0,-1)
                case _ => (0,0)
            })
    }

    val wirePoints = wires.map(
        _.flatMap(partPath)        
        .scanLeft(Pos(0,0))(_+_)
        .drop(1))

    val w1pts = wirePoints.head
    val w2pts = wirePoints.last

    val intersectPoints = w1pts.intersect(w2pts)
    val res1 = intersectPoints.map(_.manhattanDistance()).min
    println(res1) //1064

    val res2 = intersectPoints.map(p => 2 + w1pts.indexOf(p) + w2pts.indexOf(p)).min
    println(res2) //25676
}