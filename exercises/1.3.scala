/* === Library === */

trait Printable[A] {
  def format(value: A): String
}

object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String =
      p.format(a)

    def print(implicit p: Printable[A]): Unit =
      println(format)
  }
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

/* === Application === */
final case class Cat(name: String, age: Int, color: String)

object Main {
  // Exercise 1.3.1 - Use the typeclasses
  // Must import as implicit instances are resolved at the call site
  import PrintableInstances._

  val myString = "How many roads must a man walk down?"
  val myInt = 42

  // Uses typeclass instances previously defined
  Printable.print(myString)
  Printable.print(myInt)

  // Exercise 1.3.2 - Call Printable on our cat

  // Create a typeclass instance for our own type
  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)

      s"${name} is a ${age} years-old ${color} cat."
    }
  }

  val paws = Cat("Paws", 5, "turtleshell")

  Printable.print(paws)

  // Exercise 1.3.3 - We have now given Cat(...) the extension methods format and print
  import PrintableSyntax._

  Cat("Lucky", 3, "dog pretending to be a").print
}
