package foodapp.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FoodAppEntityForElasticSearchTest {

    @InjectMocks
    FoodAppEntityForElasticSearch elasticSearch;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void EntityTest() throws Exception {
        String expectedString = "{\"id\":\"1\",\"name\":\"testfood\",\"type\":\"veg\",\"price\":12}";
        FoodAppEntityForElasticSearch elasticSearch = new FoodAppEntityForElasticSearch("1","testfood","veg",20);
        elasticSearch.setId("1");
        elasticSearch.setName("testfood");
        elasticSearch.setType("veg");
        elasticSearch.setPrice(12);
        String testString = objectMapper.writeValueAsString(elasticSearch);
        assertEquals(expectedString, testString);
    }
}