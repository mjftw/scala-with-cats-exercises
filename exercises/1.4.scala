import cats._
import cats.implicits._

final case class Cat(name: String, age: Int, color: String)

object Main {
  // Implement a Show typeclass instance for Cat
  implicit val showCat: Show[Cat] = Show.show[Cat] { cat =>
    val name = cat.name.show
    val age = cat.age.show
    val color = cat.color.show

    s"$name is a $age year-old $color cat."
  }

  val jiji = Cat("Jiji", 5, "black")

  println(jiji.show)
}
