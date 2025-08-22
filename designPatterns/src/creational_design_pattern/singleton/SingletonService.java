package creational_design_pattern.singleton;

public class SingletonService {
    /*
    Approach 1:
     */
//    private static SingletonService instance;
//
//    private SingletonService(){}
//
//    public static SingletonService getInstance(){
//        if(instance == null){
//            return instance = new SingletonService();
//        }
//        return instance;
//    }
//
//    public void display(){
//        System.out.println("Singleton Service is running");
//    }

    /*
    Approach 2: Thread Safe Singleton
     */
    //    private static SingletonService instance;
//
//    private SingletonService(){}
//
//    public static synchronized SingletonService getInstance(){
//        if(instance == null){
//            return instance = new SingletonService();
//        }
//        return instance;
//    }
//
//    public void display(){
//        System.out.println("Singleton Service is running");
//    }

    /*
    Approach 3: Double-checked locking
     */
    private static volatile SingletonService instance;

    private SingletonService() {
    }

    public static SingletonService getInstance() {
        if (instance == null) {
            synchronized (SingletonService.class){
                if(instance==null){
                    instance = new SingletonService();
                }
            }
            return instance = new SingletonService();
        }
        return instance;
    }

    public void display() {
        System.out.println("Singleton Service is running");
    }

}
