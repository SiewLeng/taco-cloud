package tacos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class Config {

    @Bean
    public AbstractDataSource getDatasource() {
    	AbstractDataSource datasource = new DriverManagerDataSource("jdbc:h2:mem:tacocloud", "sa", "");
        return datasource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(AbstractDataSource dataSource) {
        return new JdbcTemplate(dataSource);
        //return jdbcTemplate;
    }

}
