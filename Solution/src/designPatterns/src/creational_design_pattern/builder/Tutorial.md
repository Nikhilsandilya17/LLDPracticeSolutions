

# Tutorial: Evolution of Object Creation and The Builder Pattern

## Problem Statement

We want to create a `User` class with multiple attributes like `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `age`, etc.

We also need to add a bunch of validations as well that might include a combination of 2 or more than 2 attributes.
**Ex:** `firstName` and `lastName` should not be same, `email` must be of specific format.

### Initial Class Structure

```java
class User {
    String firstName;
    String lastName;
    String email;
    String password;
}

```

For now, all the properties have visibility **public**.

```java
User user = new User();

```

But with public visibility, anybody outside the class can change values like `u.firstname = ""` (this is now possible, but we don't want empty `firstname` - that's our validation). If we keep things public, we can't enforce validations.

The moment these are **private properties**, now no one can modify these props outside the class, but the problem is people won't be able to access these props outside the class.

---

## Solution 1: Getters and Setters

Introduce getter and setter methods (now we can have our validations in setter methods).

```java
setFirstName(String x) {
    if(x == null || x.length == 0) {
        throw new Exception("Invalid First Name");
    }
}

```

### Problem with Solution 1

When we do this: `user.setFirstName("nikhil")`
As we are able to call a setter on a user object, this means the user object has already been created.

1. Through `User user = new User();` — at time **t1**.
2. Then `user.setFirstName("nikhil")` — at time **t2**.

So between time **t1** and **t2**, the user is **invalid** object as `new user()` is called with the default constructor, which means empty `firstName`, empty `lastName`, empty `email`, `password`. So the user is an invalid object.

Because the object was created using the default constructor, till the time we don't manually call all the relevant setters, this object is invalid as it does not go through any validations and
the firstName, lastName etc fields remain empty.
Let's say we had a newbie working with the codebase and they did not altogether call this setter; so we had an invalid object floating around in the system which can cause issues later.
**Ex:** A `DBConnection` class without `url`, `username`, `password` set.

**Another Problem:** What if the object is immutable? - in that case as well setter wont work

---

## Solution 2: Constructor Validation

What if we put all the validation checks in the constructor call? That means we make a custom constructor where we have all the validations in place (apart from getter/setter). So that if any validation fails, we will not allow object creation.

If you have all the validation in the constructor itself, then we should have all the parameters in the constructor itself.

```java
User(String firstName, String lastName, String email, String phoneNumber) {
    if(firstName == null || firstName.length == 0) {
        throw ...
    }
    // more validations
}

```

### Problem Solved

Nobody will be able to create an invalid object.

### Problems Faced

There are so many parameters that you have passed to your constructor:

1. Now we need to remember the **order of parameters** while creating the object.
2. Adding **new params** is also a headache (low maintainability).
3. **Client code** (the code which will use the user object) will become less readable.
4. You have to manually pass `null` for parameters which are not required always during object creation.

---

## Solution 3: Constructor Overloading

As we are passing `null`, we can make multiple constructors with different parameters.

**Issues:**

* Not every language supports constructor overloading.
* Also, how many should we make?
* Now considering `firstName`, `lastName`, `email` vs `firstName`, `lastName`, `password` — all of them are strings. So we will not be able to create 2 separate constructors as all of them are strings. So constructor overloading is not going to be a solution.

---

## Solution 4: Data Structure Wrapper

So to solve this problem, we can wrap all the values which we are passing to the constructor in a Data Structure (DS). We need a DS where we can pass values in any order.

* `HashMap` in Java
* `unordered_map` in C++
* `dict` in Python

So let's pass a mapper to the User Object:

```java
user(mapper)

```

And immediately our problem is solved as we can access `mapper.name`, `mapper.email`.
If somehow, someone creates this key-value pair based DS object for us, we can leverage it and make a very clean class.

---

## The Builder Pattern

**Q. Who will create this mapper object?**
Instead of calling this as mapper, let's give it a better name: **Builder**. Now let's create a Builder class.

### Responsibility of Builder Class

* This will contain all the properties of the user class.
* It will create a temporary object before we create our final user.
* We need to pass the builder object to our user constructor.
* Which means we need to have a builder object **before** the creation of the user object.
* This builder is not going to use a bloated constructor for object creation.
* Instead, we are going to use **setter based validations** in the builder class.
* Now because our builder setters have the validation, the user constructor does not need to have any validation.

In the Builder class, what we can have is: `pvt name`, `pvt age`, `pvt email`.
Now we can have setter methods for each of these properties.

```java
Builder() {
    // normal default constructor
}

void setAge(x) {
    if(this.x < 0) {
        return;
    }
    this.age = x;
}

```

Let's see how object creation is going to look like:

```java
b = new Builder();
b.setFirstName("Sanket");
b.setAge(25);
u = new User(b);

```

### Refinement: The build() method

Let's make it slightly more fancy otherwise it's correct till now. Now let's say in the Builder class, apart from all the setters, it has one more function:

```java
User build() {
    return new User(this);
    // this is basically the current builder object
    // as user requires a builder object in constructor
}

```

Usage:
`u = b.build()`

### Refinement: Method Chaining

Currently, the user constructor is public, so someone can call it with a `null`.
Instead of having the return type of setters as `void`, what if we have it as `Builder`?

**Ex:** `Builder setAge(x)`
So now as the return type is Builder, we can **chain** the setter calls.

```java
Builder setAge(x) {
    if(this.x < 0) {
        // handle error
    }
    return this; // returning current object of builder
}

```

So now object construction can look something like:

```java
b = new Builder();
b.age(10).firstName("Sanket").lastName("singh").build() // this is function chaining

```

And this line can directly return a new user object as the `build` function is returning a user object:

```java
u = new Builder().age(10).firstName("Sanket").lastName("singh").build()

```

---

## Final Optimization: Static Inner Class

If we want to technically ensure the user constructor should not be available for everybody to create, we make it **private**.

But the moment you make it private, your builder will not be able to access it.
But there is a concept called as **static class**. We can try to make the Builder class as a part of the User class.

```java
class User {
    // properties...
    
    private User(Builder b) {
        // construct user...
    }

    static class Builder {
        // builder implementation...
    }
}

```

* Now as `Builder` is a static class inside the `User` class.
* It can access all the private members of the User class including the private constructor.
* And as we have made Builder as static, I don't need to make a User object to call the Builder class.

I can just say:

```java
new User.Builder();

```

Once I have that builder object, I can do:

```java
User user = new User.Builder()
                .age(10)
                .firstName("Sanket")
                .lastName("singh")
                .build();

```

Calling the constructor of Builder, and using build we call the user constructor.