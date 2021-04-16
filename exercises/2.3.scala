trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) =
    monoid
}

object BooleanMoniodInstances {
  implicit val booleanOrMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x || y
    def empty: Boolean = false
  }

  implicit val booleanAndMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x && y
    def empty: Boolean = true
  }

  implicit val booleanExorMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = x ^ y
    def empty: Boolean = false
  }

  implicit val booleanExnorMonoid = new Monoid[Boolean] {
    def combine(x: Boolean, y: Boolean): Boolean = !(x ^ y)
    def empty: Boolean = true
  }
}
