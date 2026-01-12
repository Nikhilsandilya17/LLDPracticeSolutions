
Problem statement: To get rid of multiple times object creation of 'SIMILAR' type
Example1:
Lets consider we have Chessboard and a piece Pawn, now to create a pawn we need to do lot of initializations
16 times for each pawn,
Code snippet
Pawn pawn1 = new Pawn()
Pawn pawn2 = new Pawn()
Pawn pawn3 = new Pawn()
...
Pawn pawn16 = new Pawn()
and so on
Example 2:
Email class
class Email{
String subject;
String body;
String recipient;
}
Now basically body has a HTML template which can vary
so now to get body we need to perforam fileIO operations which is costly, so if we are creating email object multiple times
for multiple users its going to be costly
Email email1 = new Email() fileIO operation to get body
Email email2 = new Email() fileIO operation to get body
Email email3 = new Email() fileIO operation to get body


Solution:
1. Naive solution
we can create a copy of objects in driver class using default constructor in actual class and then use setters to set the values
from the originlal object to this copy object
By this atleast we are avoiding fileIO operations multiple times
-> Now in this problems are if we are using setters multiple times then what are we vioalating
1. DRY principle: we are duplicating code ( To resolve this we can create a private method)
2. OCP: if we add a new field in Email class then we need to modify this method
3. SRP: driver class has too many responsibilities

2. To use copy constructor
Here we can make a copy constructor in the actual class which takes the same class object as argument
and then copies all the values from the original object to this new object
Now in driver class we can create a new object using this copy constructor
Email email1 = new Email() fileIO operation to get body
Email email2 = new Email(email1) Using copy constructor
Problems:
1. If we have a child class inheriting this Email class then we need to check the type of object
 and then call the respective copy constructor
2. If we have a another child class then we need to modify the driver class(adding a extra if else) - OCP violation
and SRP is violated as driver class has too many responsibilities

3. To use prototype design pattern
Here we can create a Prototype interface which has a method copy()
Now the actual class will implement this interface and provide the implementation for copy method
Now in the copy method we can call the copy constructor and return the new object
Now in driver class we can call the copy method to get the copy of the object
Email email1 = new Email() fileIO operation to get body
Email email2 = email1.copy() Using copy method
Now if we have a child class then we can override the copy method in the child class
and call the respective copy constructor
Now in driver class we dont need to check the type of object and call the respective copy constructor
Now driver class has only one responsibility to create a copy of the object
Now if we have a new child class then we dont need to modify the driver class - OCP is satisfied
SRP is also satisfied as driver class has only one responsibility
DRY is also satisfied as we are not duplicating code
Now the object in itself will decide which copy constructor to call
This is how prototype design pattern works



