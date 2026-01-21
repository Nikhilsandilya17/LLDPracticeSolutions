package designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories;

import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.InMemoryDatabase;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private InMemoryDatabase inMemoryDatabase;

    public UserRepositoryImpl() {
        this.inMemoryDatabase = new InMemoryDatabase();
    }
    @Override
    public List<String> findUsers(int limit, int offset) {
        return inMemoryDatabase.getUsers(limit, offset);
    }
}
