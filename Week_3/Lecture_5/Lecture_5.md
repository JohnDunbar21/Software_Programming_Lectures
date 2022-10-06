# Java Objects and Classes

Topics include:
* Objects,
* Concept of classes,
* Constructors,
* Instance variables,
* Methods,
* Enumerables.

## Instance Variables, Setter Methods, and Getter Methods

Each class you create in Java becomes a new type that can be used to declare variables and create objects.

You can declare new classes as needed: this is one reason Java is known as an extensible language.

By convention, we use Camel-Case (CamelCaps) to name our methods, variables, and classes.

Inspect the code below:

```java
// Fig. 3.1: Account.java
// Account class that contains a name instance variable
// and methods to set and get its value.

public class Account {
    private String name; // instance variable

    // Setter method used to set the instance variable
    public void setName(String name) {
        this.name = name; // stores the method variable into the instance variable
    }

    // Getter method used to retrieve the instance variable
    public String getName() {
        return name; // returns the value of the instance variable
    }
}
```

A few things to note are:
* A getter method will never take any method input as it is just retrieving existing data,
* A setter method will never return a value since it is setting an instance variable.

## Instance Variables

An object will always have attributes that are implemented as instance variables. **Instance variables are properties that make the object what it is (such as shape, weight, colour, etc...)**.

A class normally contains one or more methods that can manipulate the instance variables of that class: these are called **getters** and **setters**.

Each instance of an object has its own copy of each of the class's instance variables. This is what makes objects so useful! You can essentially make a blueprint that represents an abstraction of a physical entity.

There are different levels of access for instance variables: `public`, `protected`, and `private`. When an instance variable is `public`, it can be freely altered without the need for getters and setters. If an instance is `private`, it can only be modified by the getters and setters, and can only be retrieved by doing so. We will discuss `protected` instance variables in a later lecture.

Inspect the code below:

```java
// Fig. 3.2: AccountTest.java
// Creating and manipulating an Account object.
import java.util.Scanner;

public class AccountTest extends Account {
    public static void main(String[] args) {

        // Create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        // Create an Account object and assign it to myAccount
        Account myAccount = new Account();

        // Take user input to assign a name value
        String userName = input.nextLine();

        // Set the name value of the object instance
        myAccount.setName(userName);

        // Display the name value of the object instance
        System.out.printf("Account holder: %s%n%n", myAccount.getName());
    }
}
```

**DISCLAIMER: I modified the code given in the lecture to `extends` the Account object. This is because we are creating an object inside of another object, therefore they need to be in separate files. As such, in order to manipulate them, we must have the current file inherit the Account object**.

Please note, setter methods can be referred to as **mutator methods**, and getter methods can be called **accessor methods** or **query methods**.

## Instantiating an Object

A class instance is created using the `new` keyword. This can be seen in the above code samples, but in abstract terms it looks like:

`<ClassName> classInstanceName = new <ClassName>();`

Similarly, if you want to create an instance of a class with pre-defined instance variables, you will require a **constructor**. A constructor is a class method that contains a set of parameters that are assigned to the instance variables.

Inspect the code below:

```java
// Fig. 3.5: Account.java
// Account class with a constructor that initialises the name instance variable.

public class Account {
    private String name; // instance variable

    // Constructor method setting the default value of the instance variable
    public Account(String Name) {
        this.name = name;
    }

    // Setter method used to set the instance variable
    public void setName(String name) {
        this.name = name; // stores the method variable into the instance variable
    }

    // Getter method used to retrieve the instance variable
    public String getName() {
        return name; // returns the value of the instance variable
    }
}
```

Please note, the constructor's name must be the same as the class name.

If you do not create a constructor, the JVM will provide a default one at runtime that has no parameters and the class's instance variables are initialised to their default values.

**You can have multiple constructors consecutively, and the JVM will judge which one to use based on the parameters passed into the object's initialisation values**.

Inspect the code below:

```java
// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.

public class Time2 {
    private int hour; // 0-23
    private int minute; // 0-59
    private int second; // 0-59

    // Time2 no-argument constructor:
    // Initialises each instance variable to zero
    public Time2() {
        this(0, 0, 0);
    }

    // Time2 constructor:
    // Hour supplied, Minute and Second defaulted to 0
    public Time2(int hour) {
        this(hour, 0, 0);
    }

    // Time2 constructor:
    // Hour and Minute supplied, Second defaulted to 0
    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }

    // Time2 constructor:
    // Hour, Minute, and Second supplied
    public Time2(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Hour must be 0-23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("Minute must be 0-59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("Second must be 0-59");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // Time2 constructor:
    // Another Time2 object supplied
    public Time2(Time2 time) {
        // invoke constructor with three arguments
        this(time.hour, time.minute, time.second);
    }
}
```

**A constructor that calls another constructor in this way is called a delegating constructor**. This makes the class easier to maintain and modify.

