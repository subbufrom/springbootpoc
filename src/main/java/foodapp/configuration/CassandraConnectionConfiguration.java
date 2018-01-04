package foodapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "foodapp.repository")
@PropertySource(value = { "classpath:cassandra.properties" })

public class CassandraConnectionConfiguration extends AbstractCassandraConfiguration {
    private static final String KEYSPACE = "cassandra.keyspace";
    private static final String CONTACTPOINTS = "cassandra.contactpoints";
    private static final String PORT = "cassandra.port";

    @Autowired
    private Environment environment;

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(environment.getProperty(CONTACTPOINTS));
        cluster.setPort(Integer.parseInt(environment.getProperty(PORT)));
        return cluster;
    }

    @Override
    protected String getKeyspaceName() {
        return "cassandra";
    }
}
