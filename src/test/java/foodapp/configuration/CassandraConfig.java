//package foodapp.configuration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
//import org.springframework.data.cassandra.config.SchemaAction;
//import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//
//@Configuration
//@EnableCassandraRepositories("foodapp.repository")
//public class CassandraConfig extends AbstractCassandraConfiguration {
//
//    @Value("${cassandra.hosts}")
//    String cassandraHosts;
//    @Value("${cassandra.port}")
//    String cassandraPort;
//    @Value("${cassandra.keyspace}")
//    String cassandraKeySpace;
//
//    @Override
//    public String getKeyspaceName() {
//        return cassandraKeySpace;
//    }
//
//    @Bean
//    public CassandraClusterFactoryBean cluster() {
//        CassandraClusterFactoryBean cluster =
//                new CassandraClusterFactoryBean();
//        cluster.setContactPoints(cassandraHosts);
//        cluster.setPort(Integer.parseInt(cassandraPort));
//        return cluster;
//    }
//
//
//    @Override
//    public SchemaAction getSchemaAction() {
//        return SchemaAction.CREATE_IF_NOT_EXISTS;
//    }
//    @Override
//    public String[] getEntityBasePackages() {
//        return new String[]{
//                "foodapp.entity"};
//    }
//}
