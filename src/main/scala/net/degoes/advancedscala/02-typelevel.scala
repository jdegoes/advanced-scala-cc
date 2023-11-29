/**
 * TYPE-LEVEL PROGRAMMING
 * 
 * Type-level programming allows us to do computation using the type system, often with
 * the goal of increasing the type-safety of our applications, so we can prevent 
 * broader classes of runtime errors.
 * 
 * Scala 3 includes both old tools (refined types, givens, etc.) and new tools (like 
 * match types, singleton types) to help us do type-level programming. 
 */
package net.degoes.advancedscala

import scala.reflect.ClassTag

object vectors:
  import scala.compiletime.ops.int.* // Note: +, -, *, /, %, etc. are all defined in this package.

  /**
    * EXERCISE 1
    * 
    * Add a `++` operator to the `Vector` type, which appends two vectors together, and 
    * tracks the size of the resulting vector at compile-time by using compile-time 
    * operations.
    * 
    * EXERCISE 2
    * 
    * Add an append (`:+`) operator to the `Vector` type, which appends a single element
    * to the end of a vector, and tracks the size of the resulting vector at compile-time
    * by using compile-time operations.
    */
  final class Vector[N <: Int & Singleton, A] private (private val values: Array[A])

  object Vector:
    def empty[A: ClassTag]: Vector[0, A] = new Vector(Array.empty[A])

    def apply[A: ClassTag](a1: A): Vector[1, A] = new Vector(Array(a1))

    def apply[A: ClassTag](a1: A, a2: A): Vector[2, A] = new Vector(Array(a1, a2))

    def apply[A: ClassTag](a1: A, a2: A, a3: A): Vector[3, A] = new Vector(Array(a1, a2, a3))

/**
  * HLISTS
  * 
  * An HList ("heterogeneous list") is a classic type-level structure that can be 
  * implemented in several ways in Scala. Scala 3 no longer needs a separately-
  * implemented HList, because tuples have become Scala 3's own native version of 
  * an HList.
  * 
  * In this section, you will explore classic ways to construct an HList.
  */
object hlist:
  enum HList:
    case Empty
    case ::[+H, +T <: HList](head: H, tail: T)

    def :: [H](h: H): H :: this.type = HList.::(h, this)

  type Empty = HList.Empty.type
  final val Empty: Empty = HList.Empty
  type ::[+H, +T <: HList] = HList.::[H, T]

  /**
    * EXERCISE 1
    * 
    * Using givens, define a type class `Length` that computes the index at which 
    * a given type can be found. It should be a compile-time error if that type 
    * of value does not appear in the HList.
    */
  sealed trait IndexOf[H <: HList, T]:
    def apply(hlist: H): Int

  object IndexOf

  /**
    * EXERCISE 2
    * 
    * Create a type class `At` that can retrieve a value at a specific index in an
    * HList. It should be a compile-time error if the index is out of bounds.
    */
  sealed trait At[H <: HList, I <: Int & Singleton]:
    type Out

    def apply(hlist: H, idx: I): Out
  object At: 
    type Aux[H <: HList, I <: Int & Singleton, O] = At[H, I] { type Out = O }

  extension [H <: HList](hlist: H)
    def at[I <: Int & Singleton](idx: I)(using at: At[H, I]): at.Out = at(hlist, idx)


object matrices:
  import vectors.*
  import scala.compiletime.ops.int.* // Note: +, -, *, /, %, etc. are all defined in this package.

  /**
    * EXERCISE
    * 
    * Design a `matrix` type all of whose operations are checked for the right 
    * size of matrices and vectors at compile-time.
    */
  final case class Matrix[N <: Int & Singleton, M <: Int & Singleton, A](values: Vector[N, Vector[M, A]])