# Advanced Methods, Exception Handling, JUnit Testing, and Maven

Topics include:
* Advanced methods,
* Exception handling,
* Maven and JUnit.

## Use of Class Attributes Shadowed by Method Parameters

Method parameters are visible **only** within the method's scope. If a class attribute and a method parameter share the same name, the method parameter is chosen.

**If you must access the class attribute, you must use the `this` keyword**.

## Using `this` Keyword

```java
public class Welcome1 {
    priavte int numberToPrint = 10;

    public Welcome1(){
        // empty constructor
    }

    private void printNumber(int numberToPrint) {
        System.out.println("Method parameter: "+numberToPrint);
        System.out.println("Class attribute: "+this.numberToPrint);
    }

    public static void main(String[] args) {
        new Welcome1().printNumber(5);
    }
}
```

## Method Overloading

Method overloading occurs when methods of the same name are declared in the same class (these must have different sets of parameters).

The compiler selects the appropriate method to call by examining their **signatures** (the method's name and the number of, types, and order of its parameters). Method overloading can be used to create several methods with the same name that perform the same or similar tasks, but on different types, or different numbers of arguments.

Overloaded methods can have different return types if the methods have different parameter lists, however, methods cannot be distinguished by their return type.

**Declaring overloaded methods with identical perameter lists will result in a compilation error**!

## Method Overloading Example

```java
public class Example {

    private static void printName(String first, String last) {
        System.out.println(first+" "+last);
    }

    private static void printName(String name) {
        System.out.println(name);
    }

    private static void printName(char[] first, String last) {
        System.out.println(new String(first)+" "+last);
    }

    public static void main(String[] args) {
        printName("John", "Dunbar");
        printName("John Dunbar");
        char[] first = {'J', 'o', 'h', 'n'};
        printName(first, "Dunbar");
    }
}
```

## Brief Introduction to Concurrency in Java

Complex applications may use **multithreading** to speed up performance or user experience (for example, with a GUI). Calling methods from multiple threads may have undesired and unexpected side effects.

Primitive variables that are declared `final` can be shared safely across threads. In addition to this, using the keyword `synchronized` will 'lock' the method execution and force it to wait until the execution completes.

READ Ch.23 Deitel, H., 2018. Java How to Program, Early Objects.

```java
class Print{
    synchronized void printNumb(int n) {
        for(int i = 1; i <= 5; i++) {
            System.out.println(n*i);
            try {
                Thread.sleep(400);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
```

```java
public class Run {
    public static void main(String[] args) {
        final Print obj = new Print();

        Thread t1 = new Thread() {
            pubic void run() {
                obj.printNumb(5);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                obj.printNumb(100);
            }
        };

        t1.start();
        t2.start();
    }
}
```

## Recursion

A recursive method returns a call to itself until a base case is reached. Common mistakes like omiting the base case, or writing the recursion step incorrectly can cause infinite recursion, eventually leading to a **stack overflow**.

Recursive programs may result in exponential method calls, and can be re-written using loops.

**Use recursive methods only if the problem is naturally recursive, or if there are performance benefits.

```java
// Fig. 18.5: FibonacciCalculator.java
// Recursive fibonacci method.
import java.math.BigInteger;

public class FibonacciCalculator {
    private static BigInteger TWO = BigInteger.valueOf(2);

    // recursive declaration of method fibonacci
    public static BigInteger fibonacci(BigInteger number) { // base cases
        if(number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            return number;
        } else { // recursive step
            return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
        }
    }

    public static void main(String[] args) {
        // displays the fibonacci values from 0-40
        for(int counter = 0; counter <= 40; counter++) {
            System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
        }
    }
}
```

## Exception Handling

An exception is an event which occurs during the execution of a program that disrupts the normal flow of the program's instructions.

An **Exception Handler** is a block of code that can handle the exception.

Java allows us to separate exception handling code from the normal code to improve readability!

Exceptions are propagated across the stack until an exception handler is found, so the developer can choose at what level exceptions should be handled.

**Each organisation will have its own house style on how to write and handle exceptions**.

## Using `throw` Keyword

```java
public class Adult {
    protected int age;

    public Adult(){
        // empty constructor
    }

    public void setAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException("Must be over 18");
        }
        this.age = age;
    }
}
```

## `throws` vs `throw` Keyword

**`throws` declares exceptions that can be thrown by the method. Multiple exception declarations are separated by `,`**.

```java
import java.io.IOException;
import java.io.FileNotFoundException;

public class Adult {
    protected int age;

    public Adult(){
        // empty constructor
    }

    public void setAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException("Must be over 18");
        }
        this.age = age;
    }

    public void accessMedicalRecord(String path) throws IOException {
        if(path == null) {
            throw new FileNotFoundException("The medical record could not be accessed");
        }
    }
}
```

## Checked vs Unchecked Exceptions

Checked exceptions are all subclasses of `Exception` except the `RuntimeException` subclass.

Unchecked exceptions are typically the result of a programming problem: many programmers argue against catching unchecked errors as these cannot be predicted and if they happen, they point towards a bad code design that should be fixed to prevent the error.

**Checked exceptions must be declared by using the `throws` keyword, otherwise the compiler will return an error**.

## Using `try` and `catch` Keyword

```java
import java.io.IOException;

public class AdultTest {
    public static void main(String[] args) {

        int age = Integer.parseInt(args[0]);

        try{
            Adult patient = new Adult();
            patient.setAge(age);
            patient.accessMedicalRecords(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Unchecked exception caught:");
            System.out.println(ex);
        }
        catch (IOException ex) {
            System.out.println("Checked exception caught:");
            System.out.println(ex);
        }
    }
}
```

## Using the `finally` Keyword

The `finally` block is often used as a place to release resources acquired in the try block (for example, database connections, opened files).

The `finally` block is guaranteed to execute unless the `try` block or `catch` block call `System.exit()` which stops the Java interpreter.

**Avoid placing in a `finally` block code that can `throw` an exception**. If such code **is** required, enclose the code in a `try` ... `catch`.

```java
import java.io.IOException;

public class AdultTest {
    public static void main(String[] args) {

        int age = Integer.parseInt(args[0]);

        try{
            Adult patient = new Adult();
            patient.setAge(age);
            patient.accessMedicalRecords(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Unchecked exception caught:");
            System.out.println(ex);
        }
        finally {
            System.out.println("Prints in any case");
        }
    }
}
```

## Apache Maven

Source: https://maven.apache.org/

Maven is a project management software that will make the developer's life much easier.

### What Will Maven Help You with?

* Builds,
* Documentation,
* Reporting,
* Dependencies,
* Source code management (SCM),
* Releases,
* Distribution.

### Using Maven in Codio

Open the terminal and type:

1. `mvn -version` to check if you have it already installed.
2. `pwd` tells you the fully qualified path to your current directory.
3. `mvn archetype:generate` Maven will then recommend an archetype for you to choose from.
4. You confirm the archetype you wish to use by entering the same number as the option.
5. After this, Maven will prompt you to choose a version: you usually want to choose the latest version.
6. Define a value for 'groupId: this must be unique. For example, `org.test`.
7. Define a value for 'artifactId'. For exampple, `lecture6`
8. Define a value for 'version' 1.0-SNAPSHOT. You do not have to declare this.
9. Define a value for 'package' of the groupId. This can be the same as the groupId, so for example, `org.test`.
10. It will ask you to confirm all the details by typing `Y`.

Inspect the `pom.xml` file 'Project Object Model'.

* Ensure that the `properties` tags have the `<maven.compiler.target>` and `<maven.compiler.source>` set to at least 1.8 or above.

To run an application:

1. Ensure you `cd` into the project directory. This is wherever the `pom.xml` is.
2. `mvn compile`.
3. You will need to add the following code to the `maven-jar-plugin` plugin (note that the `mainClass` configuration is dependent on the groupId and the name of the main Java file): 
```
<archive>
    <manifest>
        <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
        <addDefaultSpecificationEntries>true</addDefaultSpecificationEntries>
        <addClasspath>true</addClasspath>
        <mainClass>org.test.App</mainClass>
    </manifest>
</archive>
```
4. `mvn package` turns the file into a `.jar` file. This is saved to a new folder in the project directory called 'target'.
5. You can run the `.jar` file by entering the 'target' directory and typing: `java -jar <jar file name>.jar`. For example, `java -jar lecture6-1.0-SNAPSHOT.jar`.

You can add additional dependencies from: https://mvnrepository.com

## JUnit Testing

Automated testing helps you ensure that the code is running as expected even after you make changes later.

Unit tests focus on the individual code components (units), not on the external environment, end to end system testing, etc.

We can use assert statements to check if methods return expected outcomes. Testing can get complex and multiple tests may be needed to test a single method.

```java
package org.test;

import static org.junit.Assert.*;
import org.junit.Test;

/**
* Unit test for simple App
*/
public class AppTest {
    /**
    * Test 1
    */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
```

Modified App.java

```java
package org.test;

/**
* Hello world!
*/
public class App {
    public int calculateSum(int a, int b) {
        return a+b;
    }

    public void printSum(int a) {
        System.out.println("The sum is: "+a);
    }

    public static void main(String[] args) {
        App app = new App();
        app.printSum(app.calculateSum(1,2));
    }
}
```

Example tests

```java
package org.test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
* Unit test for simple App.
*/
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
    * Test printing
    */
    @Test
    public void testPrinting() {
        System.setOut(new PrintStream(outContent));
        App obj = new App();
        obj.printSum(3);

        assertEquals("The sum is: 4", outContent.toString().trim()); // will fail the test as 4 != 3
        System.setOut(originalOut);
    }

    /**
    * Test addition
    */
    @Test
    public void addNumbers() {
        App obj = new App();
        assertEquals(2, obj.calculateSum(1,1));
        assertEquals(-2, obj.calculateSum(-1,-1));
        assertEquals(0, obj.calculateSum(0,0));
    }
}
```

### Maven Output

In the terminal, you can run `mvn clean test` which will run the test cases in your test file.