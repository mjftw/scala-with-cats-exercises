import cats.Eq // Equality case class
import cats.syntax.eq._ // for ===
import cats.instances.option._ // for Eq

final case class Cat(name: String, age: Int, color: String)

object Main {
  implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (catA, catB) =>
    catA.name == catB.name &&
    catA.age == catB.age &&
    catA.color == catB.color
  }

  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  println(cat1 === cat2)

  println(Option(cat1) === Option(cat2))
}
