package cassandra.controller;

import cassandra.entity.FoodEntityCassandra;
import cassandra.entity.FoodEntityElastic;
import cassandra.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public void saveAll(@RequestBody String payload) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FoodEntityCassandra foodEntityCassandra = objectMapper.readValue(payload,FoodEntityCassandra.class);
        FoodEntityElastic foodEntityElastic = objectMapper.readValue(payload,FoodEntityElastic.class);
        userService.save(foodEntityCassandra);
        userService.saveElastic(foodEntityElastic);
    }

    @GetMapping("/search/all")
    public List<FoodEntityElastic> searchAll() {
        System.out.println(userService.searchAll());
        return   userService.searchAll();
    }

    @GetMapping("/search/{id}")
    public FoodEntityElastic findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("/search/{from}/{to}")
    public List<FoodEntityElastic> findByRange(@PathVariable int from, int to) {
        return userService.findrange(from, to);
    }
}
