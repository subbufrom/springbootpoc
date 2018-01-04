package foodapp;

import foodapp.entity.FoodAppEntityForCassandra;
import foodapp.entity.FoodAppEntityForElasticSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodApplicationTests {

//	@Test
//	public void contextLoads() {
//	}

	@Test
    public void sampleTest() {

        FoodAppEntityForCassandra foodAppEntityForCassandra = new FoodAppEntityForCassandra();
        foodAppEntityForCassandra.setId("1");
        foodAppEntityForCassandra.setName("testname");
        foodAppEntityForCassandra.setPrice(200l);
        foodAppEntityForCassandra.setType("veg");
        FoodAppEntityForElasticSearch foodAppEntityForElasticSearch = new FoodAppEntityForElasticSearch();
        foodAppEntityForElasticSearch.setId("1");
        foodAppEntityForElasticSearch.setName("testname");
        foodAppEntityForElasticSearch.setPrice(200);
        foodAppEntityForElasticSearch.setType("veg");

    }

}
