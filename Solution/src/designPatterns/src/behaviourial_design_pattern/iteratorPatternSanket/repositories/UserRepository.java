package designPatterns.src.behaviourial_design_pattern.iteratorPatternSanket.repositories;

import java.util.List;

public interface UserRepository {
    List<String> findUsers(int limit, int offset);

}
