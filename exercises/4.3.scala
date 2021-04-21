object Id {
  // The Id Monad is actually just the value it contains
  type Id[A] = A

  def pure[A](a: A): Id[A] = a

  // Without the container, map and flatMap are identical
  def map[A, B](ia: Id[A])(f: A => B): Id[B] = f(ia)

  def flatMap[A, B](ia: Id[A])(f: A => Id[B]): Id[B] = f(ia)
}
