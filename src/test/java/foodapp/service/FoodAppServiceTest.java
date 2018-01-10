package foodapp.service;

import foodapp.entity.FoodAppEntityForCassandra;
import foodapp.entity.FoodAppEntityForElasticSearch;
import foodapp.repository.CassandraRepository;
import foodapp.repository.ElasticSearchRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class FoodAppServiceTest {

    @InjectMocks
    private FoodAppService foodAppService;

    @Mock
    CassandraRepository cassandraRepository;

    @Mock
    ElasticSearchRepository elasticsearchRepository;

    MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(foodAppService).build();
        }

    @Test
    public void saveTest() throws IOException {
        FoodAppEntityForCassandra foodAppEntityForCassandra = new FoodAppEntityForCassandra();
        FoodAppEntityForElasticSearch foodAppEntityForElasticSearch = new FoodAppEntityForElasticSearch();
        when(elasticsearchRepository.save(any(FoodAppEntityForElasticSearch.class))).thenReturn(foodAppEntityForElasticSearch);
        when(cassandraRepository.save(any(FoodAppEntityForCassandra.class))).thenReturn(foodAppEntityForCassandra);
        foodAppService.save(foodAppEntityForCassandra);
    }

    @Test
    public void searchAllTest() {
        foodAppService.searchAll();
    }

    @Test
    public void findById() {
        String id = "1";
        foodAppService.findById(id);
    }

    @Test
    public void findInRange() {
        int from = 1;
        int to = 10;
        foodAppService.findInRange(from,to);
    }

    @Test
    public void delete() {
        String id = "1";
        foodAppService.delete(id);
    }
}
