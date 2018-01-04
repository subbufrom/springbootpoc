package foodapp.service;

import foodapp.entity.FoodAppEntityForElasticSearch;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.io.File;

import static org.junit.Assert.*;


public class FoodAppServiceTest {

    private static Node node;
    private static Client client;

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Autowired
    private FoodAppService foodAppService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void setUp() throws Exception {
        File tmpDir = File.createTempFile("elastic", Long.toString(System.nanoTime()));
        System.out.println("Temp directory: " + tmpDir.getAbsolutePath());
        Settings.Builder elasticsearchSettings =
                Settings.settingsBuilder()
                        .put("http.enabled", "false") // 1
                        .put("index.number_of_shards", "1")
                        .put("path.data", new File(tmpDir, "data").getAbsolutePath()) // 2
                        .put("path.logs", new File(tmpDir, "logs").getAbsolutePath()) // 2
                        .put("path.work", new File(tmpDir, "work").getAbsolutePath()) // 2
                        .put("path.home", tmpDir); // 3

        node = nodeBuilder().local(true).settings(elasticsearchSettings.build()).node();


        }
    public Client getClient() {
        return node.client();

//        startupEmbeddedNode
//
//        elasticsearchTemplate.deleteIndex(FoodAppEntityForElasticSearch.class);
//        elasticsearchTemplate.createIndex(FoodAppEntityForElasticSearch.class);
//        elasticsearchTemplate.putMapping(FoodAppEntityForElasticSearch.class);
//        elasticsearchTemplate.refresh(FoodAppEntityForElasticSearch.class);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {


    }

    @Test
    public void saveElastic() {

        FoodAppEntityForElasticSearch foodAppEntityForElasticSearch = new FoodAppEntityForElasticSearch("1","testsamosa","testtype",20);
        foodAppService.saveElastic(foodAppEntityForElasticSearch);
    }

    @Test
    public void searchAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findInRange() {
    }

    @Test
    public void delete() {
    }
}