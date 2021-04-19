import cats._
import cats.instances._
import cats.instances.int._
import cats.instances.double._
import cats.instances.option._
import cats.syntax.semigroup._ // for |+|

object Main {
  // 2.5 Exercise 1
  def add[A: Monoid](items: List[A]): A =
    items.foldLeft(Monoid[A].empty)(_ |+| _)

  // 2.5 Exercise 2
  def addOption[A: Monoid](items: List[Option[A]]): Option[A] =
    items.foldLeft[Option[A]](Some(Monoid[A].empty))((a, b) => a |+| b)

  case class Order(totalCost: Double, quantity: Double)

  // 2.5 Exercise 3
  implicit val orderMonoid = new Monoid[Order] {
    def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)

    def empty = Order(0, 0)
  }

  // See some output
  println(add(List(Order(10.1, 3), Order(4.2, 3.14))))
}
