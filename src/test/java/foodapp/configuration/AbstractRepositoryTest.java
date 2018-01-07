//package foodapp.configuration;
//
//import com.datastax.driver.core.Cluster;
//import com.datastax.driver.core.Session;
//import org.apache.thrift.transport.TTransportException;
//import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.springframework.context.annotation.Import;
//
//import java.io.IOException;
//import java.util.Properties;
//
//
//@Import(CassandraTestConfig.class)
//
//public abstract class AbstractRepositoryTest {
//
//    @BeforeClass
//    public static void initCassandra() {
//        try {
//            Properties prop = new Properties();
//            prop.load(AbstractRepositoryTest.class.getClassLoader().getResourceAsStream("application-test.properties"));
//            String cassandraHosts = prop.getProperty("cassandra.hosts");
//            String cassandraPort = prop.getProperty("cassandra.port");
//
//            EmbeddedCassandraServerHelper.startEmbeddedCassandra("another-cassandra.yaml", 20000);
//
//            Cluster cluster = Cluster.builder().addContactPoints(cassandraHosts).withPort(Integer.parseInt(cassandraPort)).build();
//            Session session = cluster.connect();
//
//
//            session.execute("create keyspace  \"mykeyspace\" WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};");
//            session.execute("use \"mykeyspace\";");
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Before
//    public void initTest() {
//        try {
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    @AfterClass
//    public static void cleanCassandra() {
//        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
//    }
//
//}
