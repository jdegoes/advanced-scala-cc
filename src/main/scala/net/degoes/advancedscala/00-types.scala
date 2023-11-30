/**
 * TYPES
 *
 * What is a type? What are some of the basic ways of constructing types? What
 * are the possible ways that types can relate to one another?
 *
 * In this section, you will learn the answer to all these questions and more,
 * as you peel back the superficial layer that most developers understand, and
 * start to gain insight into the hidden workings of type systems.
 */
package net.degoes.advancedscala.types

import net.degoes.advancedscala.types.dependent.Message.GetTemp

/**
 * VALUES
 *
 * A 'value' is information (0's and 1's) that exists at runtime (that is, when
 * your program is actually running), and which is stored in memory. Values are
 * the fundamental currency of computation: programs spend their whole lives
 * producing and consuming them, in an effort to accomplish work that is useful
 * to humans.
 *
 * In Scala, a value is anything that can be stored into a `val`, in a statement
 * such as 'val _ = ???'.
 *
 * A related concept is that of the 'expression'. An expression is a recipe for
 * producing a value. Expressions (such as 2 + 2) must be executed in order to
 * produce a value. The execution of recipes involves the step-by-step following
 * of their individual instructions (for example, adding 2 to the number 2).
 */
object values:
  val x = 42

  val xs = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  /**
   * EXERCISE 1
   *
   * Experiment with describing different values. Both literals (constant
   * primitives), and values produced thorough complex expressions.
   */
  lazy val y = xs.map(_ + x).sum

  /**
   * EXERCISE 2
   *
   * What are some constructs in Scala that can NOT be stored into a `val`
   * variable? HINT: Think about all the elements in this Scala source code file
   * that are NOT values.
   */
  lazy val z = ??? 

/**
 * SETS
 *
 * Sets are important in mathematics. Moreover, they can also be used both
 * formally and informally to help give meaning to many concepts in computer
 * science.
 *
 * Fundamentally, a set is an unordered collection of elements, containing no
 * duplicate elements. Sets may be finite or infinite.
 *
 * A set is fundamentally a mathematical thing. But we can explore some
 * properties of sets by using Scala's own 'Set' collection type.
 */
object set_theory:
  /**
   * EXERCISE 1
   *
   * Make a set of booleans using many different expressions to produce
   * booleans.
   */
  lazy val s1: Set[Boolean] = Set(true || false, false && false, !true, !false)

  /**
   * EXERCISE 2
   *
   * What are possible values for the size you constructed? What are impossible
   * values? Explain why the variation.
   */
  assert(s1.size == 2)

  /**
   * EXERCISE 3
   *
   * Union two sets together. Ensure that each set has some unique items, but
   * that both sets have some shared items.
   */
  val s2: Set[Int] = Set(1, 2, 3) union Set(3, 4, 5)

  /**
   * EXERCISE 4
   *
   * What is the size of the set you constructed? Can you explain this size?
   */
  assert(s2.size == 5)

  /**
   * EXERCISE 5
   *
   * Intersect two sets together. Ensure that each set has some unique items,
   * but that both sets have some shared items.
   */
  val s3: Set[Int] = Set(1, 2, 3) intersect Set(3, 4, 5)

  /**
   * EXERCISE 6
   *
   * What is the size of the set you constructed? Can you explain this size?
   */
  assert(s3.size == 1)

  /**
   * EXERCISE 7
   *
   * Subtract one set from another. Ensure that each set has some unique items,
   * but that both sets have some shared items.
   */
  val s4: Set[Int] = Set(1, 2, 3) diff Set(2, 3)

  /**
   * EXERCISE 8
   *
   * What is the size of the set you constructed? Can you explain this size?
   */
  assert(s4.size == 1)

  /**
   * EXERCISE 9
   *
   * One set may be a superset or subset of another set, or they may not be
   * related at all. Implement subsetOf and supersetOf, which determine if one
   * set is a subset or superset of another set.
   */
  def subsetOf[A](s1: Set[A], s2: Set[A]): Boolean   = s1.forall(s2.contains(_))
  def supersetOf[A](s1: Set[A], s2: Set[A]): Boolean = subsetOf(s2, s1)

  /**
   * EXERCISE 10
   *
   * What set is a subset of all other sets? The answer may surprise you.
   */
  val s5: Set[Int] = Set()

  /**
   * EXERCISE 11
   *
   * What set is a superset of all other sets? Can you express this set in
   * Scala?
   */
  lazy val s6: Set[Any] = ???

/**
 * TYPES
 *
 * In a structural type system, a type may be thought of as a set of values.
 * This "set" does not exist at runtime, but rather, it is a concept that exists
 * only at compile time. In a nominal type system, a type may be thought of as
 * an identity, derived from the name of the type, which, together with a
 * constructor, defines a set of values.
 *
 * In either case, it can be quite useful to imagine types as being sets of
 * values.
 */
object types:
  /**
   * EXERCISE 1
   *
   * If Boolean defines a set of values, what are these values?
   */
  val bool: Set[Boolean] = Set(true, false)

  /**
   * EXERCISE 2
   *
   * If Unit defines a set of values, what are these values?
   */
  val unitValue = ()
  val unit: Set[Unit] = Set(unitValue)

  /**
   * EXERCISE 3
   *
   * If Nothing defines a set of values, what are these values?
   */
  val nothing: Set[Nothing] = Set.empty[Nothing]

  /**
   * EXERCISE 4
   *
   * The name for the mathematical set that contains ALL types is called `*`. We
   * can't form this type in Scala, but you can list a few examples of types
   * that are contained inside this mathematical set.
   *
   * Do so below.
   */
  type `*` = Int :+: String :+: Boolean :+: Unit :+: Nothing

  type :+:[A, B]

  /**
   * EXERCISE 5
   *
   * The type ascription operator `:` can be read as, "is a member of the set
   * of". Interpret this operator in a variety of contexts below.
   */
  val x: Int = ???

  /**
   * EXERCISE 6
   *
   * The statement that some variable value is a member of some set forms a
   * proposition. Propositions may be true or false. When the compiler emits a
   * type error, it is because the compiler could not prove a proposition to be
   * true, which indicates that your program might be unsound. If the compiler
   * does not emit a type error, then it has proven that the proposition is
   * true, and your program is sound (assuming the compiler is correct).
   */
  def cond[A, B](f: A => B, a: A): B = ???

/**
 * BASIC TYPING
 *
 * Scala has a (primarily) nominal type system, which means that types are
 * defined by their name, and not by their structure. Scala is also
 * object-oriented, which means that it supports subtyping.
 *
 * In this set of exercises, you will explore some of this richness.
 */
object basic:
  /**
   * EXERCISE 1
   *
   * Excluding columns and rows where they are defined, what is the only
   * difference between the following two types?
   */
  trait Type1
  trait Type2

  /**
   * EXERCISE 2
   *
   * Using summon and `=:=`, or a generic function, try to prove that Scala does
   * not see the types `Type1` and `Type2` as being equal.
   */
  summon[Email =:= String]

  /**
   * EXERCISE 3
   *
   * Which declaration keywords introduce a new type into Scala's type system?
   */
  val keywords = Set("trait", "class", "enum")

  type Email = String 

  /**
   * EXERCISE 4
   *
   * The keyword `extends` is used to create a subtype of an existing type. This
   * can be thought of as a set-theoretic operation, where the subtype is a
   * subset of the supertype.
   *
   * Create a sensible relationship between the following types by using
   * `extends`.
   */
  trait Anything
  trait Animal extends Anything
  trait Dog extends Animal 
  trait Cat extends Animal 
  trait Schnauzer extends Dog 
  trait Persian extends Cat 

  trait PetStore {
    def buy(): Animal
  }

  /**
   * EXERCISE 5
   *
   * Functions are "covariant" in their return types, which means that if a
   * function is declared to return a type `A`, then it may return a subtype of
   * `A` instead.
   *
   * Why is this "sound" to do?
   *
   * Create a type of pet store that only allows you to buy dogs, but have it
   * implement the `PetStore` interface.
   */
  object DogStore extends PetStore {
    override def buy(): Schnauzer = new Schnauzer {}
  }

  trait DogHotel {
    def checkin: Dog => Unit
  }

  /**
   * EXERCISE 6
   *
   * Functions are "contravariant" in their input types, which means that if a
   * function is declared to accept a type `A`, then it may accept a supertype
   * of `A` instead.
   *
   * Why is this "sound" to do?
   *
   * Unlike return values, this relationship weirdly does not apply to methods
   * (even though it could apply to methods).
   */
  object AnimalHotel extends DogHotel {
    override def checkin: Animal => Unit = 
      a => println(s"Checked in: ${a}")
  }


  /**
   * EXERCISE 7
   *
   * Using `summon` and `<:<`, prove that the type `Foo` is a subtype of itself.
   * Note: This is true for any type!
   */
  trait Foo
  summon[Foo <:< Foo]

  /**
   * EXERCISE 8
   *
   * Find at least one more supertype of `Reddish`.
   */
  trait Color
  trait Reddish extends Color
  summon[Reddish <:< Reddish]
  summon[Reddish <:< Color]
  summon[Reddish <:< Any]

  /**
   * EXERCISE 9
   *
   * The `Any` type is a supertype of all types. It is the top of the type
   * hierarchy. Use `summon` and `<:<` to prove that `Any` is a supertype of
   * several types.
   */
  summon[Int <:< Any]
  summon[(Int => String) <:< Any]

  /**
   * EXERCISE 10
   *
   * The `Nothing` type is a subtype of all types. It is the bottom of the type
   * hierarchy. Use `summon` and `<:<` to prove that `Nothing` is a subtype of
   * several types.
   *
   * Try to think about what it means to have a type that is the subtype of all
   * other types. Could we create a value of type `Nothing`? Why or why not?
   */
  val x: Nothing = ??? 
  summon[Nothing <:< Nothing]

  trait Wrapper[+A]

  // Invariant type parameter:
  //  If A <: B, then Wrapper[A] is NOT related to Wrapper[B]

  // Covariant type parameter:
  //  If A <: B, then Wrapper[A] <: Wrapper[B]

  // Contravariant type parameter:
  //  If A <: B, then Wrapper[A] >: Wrapper[B]

  type StringFunction[A] = Function1[A, String]

  def map[A](list: List[A], f: StringFunction[A]): List[String] = 
    list.map(f)

  val animalToString: StringFunction[Animal] = _.toString()

  map[Schnauzer](List(new Schnauzer {}), animalToString)

  def acceptWrapper(wrapper: Wrapper[Animal]) = ???

  def acceptList(animals: List[Animal]) = ???

  val dogWrapper: Wrapper[Dog] = new Wrapper[Dog]{}

  val dogList: List[Dog] = List(new Schnauzer {})

  acceptList(dogList)

  acceptWrapper(dogWrapper)
    

/**
 * STRUCTURAL TYPING
 *
 * Although Scala's type system is primarily nominal, it also supports a limited
 * form of structural typing, which allows you to define types in terms of their
 * structure, rather than their name.
 */
object structural:
  type S1 = { def foo: Int }
  type S2 = { def foo: Int; def bar: String }

  /**
   * EXERCISE 1
   *
   * Using `summon` and `=:=`, prove that `S1` and `S2` are equal.
   */
  summon[S2 <:< S1]

  /**
   * EXERCISE 2
   *
   * Make the class `A` a subtype of S1. What happens if you try the `extends`
   * keyword?
   */
  class A {
    def foo: Int = 42
  }

  val s1: S1 = new A{}

  /**
   * EXERCISE 3
   *
   * The refinement of some type `A` by a refinement `R` is a type that is a
   * subtype of `A`, but which has additional structure as defined by structural
   * type `R`.
   *
   * Using the syntax `type B = A { R }`, create a `ShoddyHouseBuilder` type
   * that refines `HouseBuilder` by requiring that the `Walls` and `Foundations`
   * be made of `Straw`.
   */
  trait Straw; trait Wood; trait Cement; trait Steel
  trait HouseBuilder {
    type Walls <: Any
    type Foundations <: Any
  }
  type ShoddyHouseBuilder = 
    HouseBuilder {
      type Walls = Straw
      type Foundations = Straw
    }

  type SomewhatShoddyHouseBuilder[W] = 
    HouseBuilder {
      type Walls = W
      type Foundations = Straw
    }

  /**
   * EXERCISE 4
   *
   * Test that, indeed, ShoddyHouseBuilder is a subtype of HouseBuilder.
   */
  val shoddyHouseBuilder: ShoddyHouseBuilder = ???
  val houseBuilder: HouseBuilder             = shoddyHouseBuilder

/**
 * TYPE OPERATORS
 *
 * Type operators define new types from existing types.
 *
 * In this section, you will explore built-in type operators in Scala.
 */
object operators:
  /**
   * EXERCISE 1
   *
   * The intersection of two types `A` and `B` is a type that is a subtype of
   * both `A` and `B`. It corresponds roughly to set intersection.
   *
   * Explore the meaning of the intersection operator by creating a value whose
   * type is the intersection of two other types.
   */
  trait A {
    def a() = println("a")
  }
  trait B {
    def b() = println("b")
  }
  type C = A & B
  val c: A & B = new A with B {}

  summon[(A & B) =:= (B & A)]

  /**
   * EXERCISE 2
   *
   * The intersection of any type `A` with `Any` is `A`. The reason for this is
   * that `A` already extends `Any` (because all types extend `Any`), and so the
   * intersection of `A` with `Any` is `A` itself.
   *
   * Using `summon` and `=:=`, prove that `A & Any` is equal to `A`.
   */
  def proof1[A] = summon[A =:= A & Any]

  /**
   * EXERCISE 3
   *
   * The union of two types `A` and `B` is a type that is a subtype of either
   * `A` or `B`. It corresponds roughly to set union.
   *
   * Explore the meaning of the union operator by creating a value whose type is
   * the union of two other types.
   */
  object A extends A
  object B extends B
  def either(): A | B = B

  /**
   * EXERCISE 4
   *
   * The union of any type `A` with `Nothing` is `A`. The reason for this is
   * that `Nothing` is uninhabited (there are no values of type `Nothing`), and
   * so the union of `A` with `Nothing` is `A` itself.
   *
   * Using `summon` and `=:=`, prove that `A | Nothing` is equal to `A`.
   */
  def proof2[A] = summon[A =:= A]

/**
 * PATH-DEPENDENT TYPES
 *
 * Scala supports a unique feature called "path-dependent types", which allows
 * you to define types that are dependent on the value of a term.
 *
 * Path-dependent types can be useful to increase type-safety, as well as for
 * purposes of modularization (though they are seldom employed for this
 * purpose).
 */
object dependent:
  trait Cement; trait Straw; trait Wood; trait Steel
  object Cement extends Cement; object Straw extends Straw; object Wood extends Wood; object Steel extends Steel
  trait Builder {
    type Walls
    type Foundations

    def build(): (Walls, Foundations)
  }

  val builder: Builder = new Builder {
    type Walls = String
    type Foundations = String 

    def build() = ("Walls", "Foundations")
  }

  val (walls: builder.Walls, foundations: builder.Foundations) = 
    builder.build()

  object SturdyBuilder extends Builder {
    type Walls       = Cement
    type Foundations = Cement

    def build(): (Walls, Foundations) = (Cement, Cement)
  }
  object ShoddyBuilder extends Builder {
    type Walls       = Straw | Wood
    type Foundations = Straw | Wood

    def build(): (Walls, Foundations) = (Straw, Straw)
  }

  /**
   * EXERCISE 1
   *
   * Test to see if Scala thinks that `l.Walls` is the same type as `r.Walls`.
   * Can you explain this answer?
   */
  def test1(l: Builder, r: Builder) = 
    summon[l.Walls =:= l.Walls]

  /**
   * EXERCISE 2
   *
   * Test to see if `ShoddyBuilder.Walls` is the same type as
   * `SturdyBuilder.Walls`. Can you explain this answer?
   */
  summon[ShoddyBuilder.Walls =:= ShoddyBuilder.Walls]

  /**
   * EXERCISE 3
   *
   * Test to see if `ShoddyBuilder.Walls` is the same type as `ref.Walls`, where
   * `ref1` is a reference to `ShoddyBuilder`. Can you explain this answer?
   */
  val ref1 = SturdyBuilder
  summon[SturdyBuilder.Walls =:= ref1.Walls]

  /**
   * EXERCISE 3
   *
   * Give an explicit type to `ref2` of `Builder`. What happens, and how can you
   * explain this? How can you fix this?
   */
  val ref2: SturdyBuilder.type = SturdyBuilder
  summon[SturdyBuilder.Walls =:= ref2.Walls]

  case class Time(now: Long)
  case class Temp(temp: Double)

  /**
   * EXERCISE 4
   *
   * Sketch out an actor system, where each input message is typed, and
   * generates an output message, whose type depends on the input message.
   */
  sealed trait Message {
    type Out 
  }
  object Message {
    object GetTime extends Message {
      type Out = Time 
    }
    object GetTemp extends Message {
      type Out = Temp
    }
  }
  trait Actor {
    def send(message: Message): message.Out = ???
  }
  def testActor(actor: Actor) = 
    val time: Time = actor.send(Message.GetTime)
    val temp: Temp = actor.send(Message.GetTemp)
