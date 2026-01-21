package designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {
    private final List<String> users = new ArrayList<>();

    public InMemoryDatabase() {
        for (int i = 0; i <= 200; i++) {
            users.add("User" + i);
        }
    }


    public List<String> getUsers(int limit, int offset) {
        if(offset >= this.users.size()){
            return new ArrayList<>();
        }
        int end = Math.min(offset + limit, this.users.size());
        return this.users.subList(offset, end);
    }
}
