package az.itstep.azjava.testapp.service;

import az.itstep.azjava.testapp.model.Human;

import java.util.List;
import java.util.Optional;

public interface HumanService {
    Human save(Human human);
    Human update(Human human);
    List<Human> getAll();
    Optional<Human> getById(Integer id);
    void delete(Integer id);
}
