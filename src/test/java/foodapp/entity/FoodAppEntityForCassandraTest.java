package foodapp.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FoodAppEntityForCassandraTest {

    @InjectMocks
    FoodAppEntityForCassandra cassandra;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void EntityTest() throws Exception {
        String expectedString = "{\"id\":\"1\",\"name\":\"testfood\",\"type\":\"veg\",\"price\":12}";
        FoodAppEntityForCassandra cassandra = new FoodAppEntityForCassandra();
        cassandra.setId("1");
        cassandra.setName("testfood");
        cassandra.setType("veg");
        cassandra.setPrice(12l);
        String testString = objectMapper.writeValueAsString(cassandra);
        assertEquals(expectedString, testString);
    }
}
