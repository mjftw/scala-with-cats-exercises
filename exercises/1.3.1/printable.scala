trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    def format(input: String) = input
  }

  implicit val intPrintable = new Printable[Int] {
    def format(input: Int) = input.toString
  }
}

object Printable {
  def format[A](input: A)(implicit p: Printable[A]): String =
    p.format(input)

  def print[A](input: A)(implicit p: Printable[A]): Unit =
    println(format(input))
}

// Eval object in repl to test
object Test {
  // Must import as implicit instances are resolved at the call site
  import PrintableInstances._

  val myString = "How many roads must a man walk down?"
  val myInt = 42

  Printable.print(myString)
  Printable.print(myInt)
}
