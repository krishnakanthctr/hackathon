package com.orders.config;


import com.orders.dto.OrderDto;
import com.orders.processor.OrderItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    /*@Value("${datasource.driver}")
    private String databaseDriver;
    @Value("${datasource.url}")
    private String databaseUrl;
    @Value("${datasource.username}")
    private String databaseUsername;
    @Value("${datasource.password}")
    private String databasePassword;*/

    /*@Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseDriver);
        dataSource.setUrl(databaseUrl);
        dataSource.setUsername(databaseUsername);
        dataSource.setPassword(databasePassword);

        return dataSource;
    }*/

    @Bean
    public JdbcCursorItemReader<OrderDto> reader(){
        JdbcCursorItemReader<OrderDto> reader = new JdbcCursorItemReader<OrderDto>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT oid, orderStatus FROM hackathon.order");
        reader.setRowMapper(new OrderRowMapper());

        return reader;
    }

    public class OrderRowMapper implements RowMapper<OrderDto> {

        @Override
        public OrderDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderDto order = new OrderDto();
            order.setOid(rs.getLong("oid"));
            order.setOrderForm(rs.getString("orderFrom"));
            order.setOrderStatus(rs.getString("orderStatus"));
            return order;
        }

    }

    @Bean
    public OrderItemProcessor processor(){
        return new OrderItemProcessor();
    }

    @Bean
    public FlatFileItemWriter<OrderDto> writer(){
        FlatFileItemWriter<OrderDto> writer = new FlatFileItemWriter<OrderDto>();
        writer.setResource(new ClassPathResource("orders.csv"));
        writer.setLineAggregator(new DelimitedLineAggregator<OrderDto>() {{
            setDelimiter(",");
            setFieldExtractor(new BeanWrapperFieldExtractor<OrderDto>() {{
                setNames(new String[] { "oid", "orderStatus" });
            }});
        }});

        return writer;
    }



    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<OrderDto, OrderDto> chunk(10)
                .reader(this.reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job exportUserJob() {
        return jobBuilderFactory.get("exportUserJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
