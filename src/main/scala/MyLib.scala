val SolutionDir = """D:\YandexDisk\DevsExercises\AdventOfCode\2019_Dotty\src\main\scala\"""

trait SolInput {
  def input(filename: String): Iterator[String] = {
    scala.io.Source.fromFile(SolutionDir+filename).getLines
  }
}