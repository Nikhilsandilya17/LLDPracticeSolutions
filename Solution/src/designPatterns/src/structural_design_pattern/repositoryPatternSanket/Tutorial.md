lets say we hae InMemory Database class
public class InMemoryDatabase {
    private List<String> users = new ArrayList<>();
    public void seeder(){ - seeder functions are functions which inserts data 
        for(int i=0;i<=2000;i++){
            users.add("User"+i);
        }
    }

public List<String> getUsers() {
        return users;
    }
}

Lets introduce a new Class 
public class BasicDemo{
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        db.seeder();
        List<String> allUsers = db.getUsers();
        // now lets say we want to get users one by one
        for(String user: allUsers){
            System.out.println(user);
        }
    }
}

repositories are those which are responsible for intetracitng to db
from your logical layers u never interact wth db
directly , bcz incase db changes then due to cthat change our business logic layer will also change


lets say prevously we were at mysql and now we are moving to mongodb
so now if we have direct interaction with db in business logic layer then we need to change that also
we need to remove all the queries of mysql
and this violates SRP - as buiness layer already has the logic to change but due to db change also business layer is changing
and OCP - as we are modifying existing code to accomodate new db

so to avoid that we have a layer called repository layer
which will have all the db interaction logic
and our business logic layer will interact with repository layer only
is service going to inherit the repository
no, as service is not a repository , repository is not a service
so definitely there need to be some kind of composition
order mgmt sercie HAS_A repositry 
now if u have a composition and u havve a has-a reltionship
are we going to have a copostion of concrete repo class
i mean
class OMS{
private final MySQLOrderRepository repo;
}
no, this violates DIP - one concrete class should not depend on another concrete class
instead we will have repositoryu interfcae
there will be concreter repo classes which will implement this interface

clss OMS{
private finl Repository repo;
}

MySqlRepo implements Repository