package scalaz
package syntax

/** Wraps a value `self` and provides methods related to `Empty` */
trait EmptyV[F[_],A] extends SyntaxV[F[A]] {
  ////

  ////
}

trait ToEmptySyntax  {
  implicit def ToEmptyV[F[_],A](v: F[A]) =
    (new EmptySyntax[F] {}).ToEmptyV(v)
  implicit def ToEmptyVFromBin[F[_, _], X, A](v: F[X, A]) =
    (new EmptySyntax[({type f[a] = F[X, a]})#f] {}).ToEmptyV(v)
  implicit def ToEmptyVFromBinT[F[_, _[_], _], G[_], X, A](v: F[X, G, A]) =
    (new EmptySyntax[({type f[a] = F[X, G, a]})#f] {}).ToEmptyV(v)
  implicit def ToEmptyVFromBinTId[F[_, _[_], _], X, A](v: F[X, Id, A]) =
    (new EmptySyntax[({type f[a] = F[X, Id, a]})#f] {}).ToEmptyV(v)

  ////

  ////
}

trait EmptySyntax[F[_]]  {
  implicit def ToEmptyV[A](v: F[A]): EmptyV[F, A] = new EmptyV[F,A] { def self = v }

  ////

  ////
}