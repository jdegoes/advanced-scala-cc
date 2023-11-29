/**
 * GIVENS
 *
 * Many languages have _type inference_, which allows the compiler to deduce the
 * type of an expression from the expression itself. Scala has type inference,
 * but it also has _value inference_, more properly termed _term inference_,
 * which allows the compiler to deduce the value of an expression from its type.
 *
 * In Scala 3, term inference is exposed and leveraged with the keywords `given`
 * and `using`. A `given` value is a recipe for constructing a class of values,
 * and a `using` clause is a way of requesting that Scala construct such a
 * value, given the recipes that have been made available to the compiler
 * through `given`.
 *
 * Givens supercede implicits in Scala 2.x, but mostly, are just a different
 * (and slightly cleaned up)
 */
package net.degoes.advancedscala

object basics:
  given Int = 42

  /**
   * EXERCISE 1A
   *
   * Create a given string. This will tell the Scala compiler how to build a
   * string (namely, the one you specify) whenever a string is required with
   * `using`.
   */

  trait Printer:
    def print(s: String): Unit

  /**
   * EXERCISE 1B
   *
   * Create a `using` clause in this method that requests a `Printer` and uses
   * it to print the string "Hello, world!".
   */
  def usingPrinter(): Unit = ???

  /**
   * EXERCISE 2A
   *
   * Create a given `Printer` that prints to the console. Now when any code
   * requires a `Printer` with `using`, the Scala compiler will automatically
   * provide the console printer.
   */
  given Printer = ???

  trait Reader:
    def read(): String

  /**
   * EXERCISE 2B
   *
   * Create a `using` clause in this method that requests a `Reader` and uses it
   * to read a string from the console.
   */
  def usingReader(): String = ???

  /**
   * EXERCISE 3
   *
   * Create a "named" given by using the syntax `given <name>: <type> = `.
   */
  given foo: Reader = ???

/**
 * TYPECLASSES
 *
 * Givens can be used for several different things, but one of the most common
 * ways to use them is to emulate type classes. Type classes are an alternative
 * to OOP abstraction, which are compatible with parametric polymorphism (rather
 * than subtype polymorphism), and which provide additional benefits, including
 * being able to abstract over third-party data types and abstract over
 * construction.
 */
object typeclasses:
  trait Show[A]:
    extension (a: A) def show: String

  object Show:
    given Show[Int]    = _.toString
    given Show[String] = identity(_)

  def example(using Show[String]) = "foo".show

  /**
   * EXERCISE 1
   *
   * The components of a type class are:
   *
   *   1. The type class itself, which is a trait with a type parameter, and
   *      methods that define the core capabilities of the type class. 2. A set
   *      of "given" values, which are instances of the type class for specific
   *      types.
   *
   * Using the type class, whether in polymorphic or mono-morphic code, requires
   * a `using` clause, which requests a given instance of the type class for a
   * specific type.
   *
   * In this exercise, you will define a type class that can serialize a data
   * type T into a Map[String, String].
   *
   * Add a `serialize` method to the `PropSerialize` type class, which converts
   * a value of type `T` into a `Map[String, String]`.
   */
  trait PropSerialize[-A]

  /**
   * EXERCISE 2
   *
   * Add given instances of `PropSerialize` for `Int`, `String`, `Boolean`,
   * `Map[String, String]`.
   *
   * BONUS: Define one for `Map[String, A]` whenever `A` is `PropSerialize`.
   */
  object PropSerialize

  /**
   * EXERCISE 3
   *
   * Use the `PropSerialize` type class to serialize different types into maps,
   * and combine the maps together.
   */
  def propSerializeExample() = ???
