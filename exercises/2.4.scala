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

object SetMonoidInstances {
  implicit val setUnionMonoid = new Monoid[Set] {
    def combine(x: Set, y: Set): Set = x ++ y
    def empty: A = Set()
  }
  implicit val setIntersectMonoid = new Semigroup[Set] {
    def combine(x: Set, y: Set): Set = x intersect y
  }
}
