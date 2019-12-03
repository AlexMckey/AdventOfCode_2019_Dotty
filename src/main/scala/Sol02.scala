object Sol02 extends App with SolInput {

    val fileName = "Sol02.txt"
    
    val program = input(fileName)
        .next
        .split(',')
        .map(_.toInt)
        .zipWithIndex
        .map(_.swap)
        .toMap
        .withDefaultValue(99)

    def binOp(memory: Map[Int, Int], address: Int, op: (Int, Int) => Int) = {
        memory.updated(memory(address+3), op(memory(memory(address+1)), memory(memory(address+2))))
    }

    def computer(program: Map[Int, Int]) = Iterator.iterate((0, program, false))
    { (ip, memory, isHalt) => 
        memory(ip) match {
            case 1 => (ip+4, binOp(memory, ip, _+_), false)
            case 2 => (ip+4, binOp(memory, ip, _*_), false)
            case 99 => (ip+1, memory, true)
        }
    }

    def runProgram(program: Map[Int, Int], noun: Int, verb: Int) = {
        var memory = program + (1 -> noun) + (2 -> verb)
        computer(memory)
        .dropWhile(!_._3)
        .next._2(0)
    }

    val res1 = runProgram(program, 12, 2)
    
    println(res1) //5434663

    val (noun, verb) = scala.util.Random.shuffle(
            (1 to 99)
            .flatMap(n => 
                (1 to 99)
                .map(v => (n,v))))
        .find((n,v) => runProgram(program,n,v) == 19690720)
        .getOrElse((0,0))

    val res2 = noun * 100 + verb
    println(res2) //4559
}