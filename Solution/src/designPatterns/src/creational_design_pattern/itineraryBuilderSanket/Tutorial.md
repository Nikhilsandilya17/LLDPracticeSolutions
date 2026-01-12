because the object was created using default constructor till the time we dont manually call all the
the relevant setters this object is invalid as it does not go through any validations.
Lets say we had a newbie working with codebase and they did not all together call this setter
so we had a invalid object floating around in the system which can cause issues later.
Ex: a DBConnection class without url,username,password set.

Problem: what if object is immutable

Sol2
What if we put all the validation checks in the constructor call that means we make a custom constructor where
we have all the validations inplace(apart from getter setter). So that if any validation fails we will not allow object
creation

if you have all the validation in constructir itself then we should have all the parameters in the constructor itself.
User(String firstName,String lastName, String email, String phoneNumber)
if(firstName == null or firstName.lenght == 0){
throw
}
//more validations

Problem solved : nobody will be able to create an invalid object
Problem faced: ther are so many parameters that you have passed to ur construtir
1. now we need to remember the order of parameters while creating object
2. adding new params is also a headache(low maintainability)
3. Client code(the code which will be user object) will become less readable
4. you have to manualy pass null which are not require always during object creation

Sol3:
as we are passing null, we can make multiple constructors with different parameters
- not every language supports constructor overloading 
- also how many we should make
- now cnsidering firstName, lastName, email firstName, lastName, password and all of them are strings. so we will not be able to create 2 separate constructoes
as all of them are strigns - so constructor overloading is not going to be a solution

Sol4
so to solve this problem we can wrap all the values which we are passign to constuctor in a DS
we need a DS where we can pass values in any order
HashMap in java, unordered_map in cpp, dict in python

so lets pass mapper to User Object
user(mapper)
and immediately our problem is solved as we can access mapper.name, mapper.email
if somehow, someone creates this key value pair based DS object for us, we can leverage it and make a very clean class

Q.who will create this mapper object?
instead of calling this as mapper lets give it better name builder
now lets create a builder class
Responsibility of builder class 
- this will contain all the properties of user class
- it will create a temporary obecjt before we create our final user
- we need to pass the builder objecvt to our user constructor
- which means we need to have bulder object before the creation of user object
- this builder is not going to use a bloated constructor for object creation
- instead we are going to use setter based validations in the builder class
- now bcz our builder setter have the validation, user constructor does not need to have any validation
- in the vbuilder class what we can have is (pct name, pvt age, pvt email)
- now we can have setter methods for each of these properties with return type as builder
Builder(){
- //normal defalt constructor
- }
void setAge(x){
- if(this.x<0){
- return;
- }
- this.age = x;
}

let see how a objct creation is going to look like
b = bew Builder()
b.setFirstName("Sanket");
b.setAge("25);
u = new User(b);

lets make it slightly more fancy otherwise its correct till now
now lets say in builder class apart from all the setters it has one more function
User build(){
    return new User(this);
this is basiucally the current builder object
as user requires a builde robject in constructor
}

u = b.build()
currently user constructor is public, so someone can call it with a null
instead of having return typr of setters as void
what if we have it Builder
ex: Builder setAge(x)
so now as the return type is builder we can chain the setter calls

Builder setAge(x){
if(this.x<0){
}

return this; //returning curent object of builder


so now object constrcution can lokk something like
b = new Builder();
b.age(10).firstName("Sanket").lastNmae("singh").build() // this is fucntion chaining
and this line can direclty return a new user objcet as build function is returning user object
u = new Builder().age(10).firstName("Sanket").lastNmae("singh").build()

if we want to technically ensure the user constructor should not be availbale for everybody to crate
we make it private

but the momemnt u make it private, your builder will not be able to access it
but there is a concept called as static clss
we can try to make builder class as a part of user class


class User
..
..

static class Builder{

..
}

}

- now as builder is static class inside user class
- it can access all the private members of user class including private constructor
- and as we have made builder as static i dont need to make a user object to call builder class
- i can just say
new User.Builder();
once i have that builde robject, i can do
- User user  = new User.Builder().age(10).firstName("Sanket").lastNmae("singh").build()
- calling constrcutor of builder and using build we call user constructor
- 


