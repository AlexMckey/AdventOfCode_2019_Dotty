case class Pos(x: Int, y: Int)
{
    //def +(that: Pos) = Pos(x + that.x, y + that.y)
    def +(p:(Int, Int)) = Pos(x + p._1, y + p._2)
    def manhattanDistance(other: Pos = Pos(0,0)): Int =
        (x - other.x).abs + (y - other.y).abs
}

val input = "R8,U5,L5,D3\nU7,R6,D4,L4".split('\n')
val wd = input.map(_.split(',')
    .map(_.splitAt(1))
    .map((d,c) => (d,c.toInt)))
val w1 = wd.head
val w2 = wd.last

val p1 = Pos(1,2)
p1.manhattanDistance()
val p2 = p1 + (2,3)
val dp = (1,0)
val ar = LazyList.fill(5)(dp)
ar.scanLeft(Pos(0,0))((p,d) => p + d).take(7).toList
LazyList.iterate(Pos(0,0),5)(_+(1,0))
LazyList.unfold(Pos(0,0))(p => Some(p+(1,0), p+(1,0))).take(5)
def partPath(part:(String, Int)) = 
    List.fill(part._2)(part._1 match {
        case "L" => (-1,0)
        case "R" => (1,0)
        case "U" => (0,1)
        case "D" => (0,-1)
        case _ => (0,0)
    })
wd.map(_.flatMap(partPath(_).toIterable).scanLeft(Pos(0,0))(_ + _).drop(1))