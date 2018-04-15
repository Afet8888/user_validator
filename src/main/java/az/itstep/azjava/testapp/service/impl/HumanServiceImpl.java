package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.HumanDao;
import az.itstep.azjava.testapp.model.Human;
import az.itstep.azjava.testapp.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HumanServiceImpl implements HumanService {

    private HumanDao humanDao;

    @Override
    public Human save(Human human) {
        if(Objects.nonNull(human)
                && Objects.isNull(human.getId())) {
            return humanDao.save(human);
        }
        throw new RuntimeException("");
    }

    @Override
    public Human update(Human human) {
        if(Objects.nonNull(human)
                && Objects.nonNull(human.getId())) {
            return humanDao.save(human);
        }
        throw new RuntimeException("");
    }

    @Override
    public List<Human> getAll() {
        return (List<Human>) humanDao.findAll();
    }

    @Override
    public Optional<Human> getById(Integer id) {
        return humanDao.findById(id);
    }

    @Override
    public void delete(Integer id) {
        humanDao.deleteById(id);
    }

    @Autowired
    public void setHumanDao(HumanDao humanDao) {
        this.humanDao = humanDao;
    }
}
