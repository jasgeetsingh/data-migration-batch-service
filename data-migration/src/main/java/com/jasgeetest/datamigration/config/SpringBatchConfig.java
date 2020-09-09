package com.jasgeetest.datamigration.config;

import com.jasgeetest.datamigration.model.TrackLog;
import com.jasgeetest.datamigration.repository.TrackLogRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    TrackLogRepository trackLogRepository;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<TrackLog> itemReader,
                   ItemProcessor<TrackLog, TrackLog> itemProcessor,
                   ItemWriter<TrackLog> itemWriter
    ) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<TrackLog, TrackLog>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public ListItemReader<TrackLog> itemReader() {

         System.out.println("Track Logs ----->> "+trackLogRepository.findAll());
        ListItemReader<TrackLog> listItemReader = new ListItemReader(trackLogRepository.findAll());
        return listItemReader;
    }



}
