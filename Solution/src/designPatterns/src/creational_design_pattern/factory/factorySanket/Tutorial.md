Do not use new keyword too much
lets say we have a linked list class
what we will do is linkedlIst = new LinkedList();
lets say we want to creeate a LRU cache
lruCache = Diuble linkedList , then a new HashMap and in DLL we will do new Node()
so there is lot of object creation going on
problme is you should not do the object cration whenever u wnt wherever u want
because
now if we keep on doing new here and there

class LRUCache{
    private linkedList li;
LRUCache(){
li = new DoublyLinkedList(); 
//and similarly we will do for maps and all the things
}
}
problem is we are clearly violating DIP
because LRUCache is directly depending on concrete class DoublyLinkedList
THis linkedlist can be a interface(single, doubly  or any other)
but the moment we do new DoubltLinkedList
this violated DIP
we cannot do new on abstract class nor u can do on interface
so lets say we have LRU cache written like this
now if later we have optimised linked list(we made changes to lined list)
now if LRUcache uses opimisedLInked list
we loose flexibility
we need to do li = new OptimisedLinkedList();
violating DIP leads to tight coupling

now as we see we have isue of DIP
so hwo to solve DIP is using dependecy inhection

so what we will do is
class LRUCache{
    private linkedList li;
LRUCache(linkedList li){
this.li = li;
//and similarly we will do for maps and all the things
}
}

now this class is only depending on abstrctions not on concrete implementations
now what happened with this dependency injection, when yhou will be creating  a ne wLRU cache object
at that point of time u cna decide whether u want to pass doubly linked list or singly linked list or optimised linked list
so now deplayed the execution/need of new keyword
creation of object should not be bothered in the class 

in client code we will be doign new LRUCache(new DoublyLinkedList())


now lets do one thing
consider a usecase
we will try to have sutioation, at any point of time
when uses gives any iput
we will be doing
if(){
new LRUCache(new DoublyLinkedList())
}else if(){
new LRUCache(new SinglyLinkedList())
}
there will be a lot of logic


lets try to see this more formally



lets make our problem statement complex

abstract class Coffee{
    Milk milk;
Sugar sugar;
CoffeeType coffeeType;
    abstract void prepare();
}
Milk is also a interface
couMilk, almond MIlknm, goat milk

so now when we actually do new Lattee(new OatMilkn(), new Robusta(), new WhiteSugar())

