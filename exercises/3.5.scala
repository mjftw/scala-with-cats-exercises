import cats.instances._

sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  implicit val treeFunctor = new Functor[Tree] {
    def map[A, B](tree: Tree[A])(func: A => B): Tree[B] = tree match {
      case Leaf(value)         => Leaf(func(value))
      case Branch(left, right) => Branch(map(left)(func), map(right)(func))
    }
  }
}

// Some test code
object Test {
  val tree: Tree[Int] = Branch(Branch(Leaf(2), Leaf(1)), Leaf(4))
  val newTree = tree.map(_ * 10)

  println(newTree)
}
