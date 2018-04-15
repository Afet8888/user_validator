package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.model.Human;
import az.itstep.azjava.testapp.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/family/human")
public class HumanController {

    private HumanService humanService;

    @GetMapping
    public List<Human> getAll() {
        return humanService.getAll();
    }

    @PostMapping
    public Human save(@RequestBody Human human) {
        return humanService.save(human);
    }

    @PutMapping
    public Human update(@RequestBody Human human) {
        return humanService.update(human);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        humanService.delete(id);
    }

    @GetMapping("/{id}")
    public Human getById(@PathVariable Integer id) {
        return humanService.getById(id).orElse(null);
    }

    @Autowired
    public void setHumanService(HumanService humanService) {
        this.humanService = humanService;
    }
}
