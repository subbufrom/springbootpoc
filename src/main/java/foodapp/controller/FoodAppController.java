package foodapp.controller;

import foodapp.entity.FoodAppEntityForCassandra;
import foodapp.entity.FoodAppEntityForElasticSearch;
import foodapp.service.FoodAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class FoodAppController {

    @Autowired
    private FoodAppService foodAppService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void saveAll(@Valid @RequestBody FoodAppEntityForCassandra cassandradata) throws IOException {
        foodAppService.save(cassandradata);
    }

    @GetMapping("/search/all")
    public List<FoodAppEntityForElasticSearch> searchAll() {
        return foodAppService.searchAll();
    }

    @GetMapping("/search/{id}")
    public FoodAppEntityForElasticSearch findById(@PathVariable String id) {
        return foodAppService.findById(id);
    }

    @GetMapping("/search/{from}/{to}")
    public List<FoodAppEntityForElasticSearch> findByRange(@PathVariable int from, @PathVariable int to) {
        return foodAppService.findInRange(from, to);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public void update(@RequestBody FoodAppEntityForCassandra payload) throws IOException {
        saveAll(payload);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id) {
        foodAppService.delete(id);
    }
}
