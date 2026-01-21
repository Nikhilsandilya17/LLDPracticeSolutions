package designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.iterators;

import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.Iterator;
import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories.UserRepository;
import designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories.UserRepositoryImpl;

import java.util.List;

public class UserIterator implements Iterator<List<String>> {

    private final UserRepository userRepository;
    private final int limit;
    private int offset = 0;
    private List<String> current;

    public UserIterator(int limit) {
        this.userRepository = new UserRepositoryImpl();
        this.limit = limit;
        this.current = userRepository.findUsers(limit, offset);
    }

    @Override
    public boolean hasNext() {
        return !current.isEmpty();
    }

    @Override
    public List<String> next() {
        List<String> result = current;
        this.offset += limit;
        this.current = userRepository.findUsers(limit, offset);
        return result;
    }
}
