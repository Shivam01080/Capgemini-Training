package com.main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gal.algo.WordCounter;
import com.gal.algo.FileProvider;
@Configuration
public class BeanConfig {
    @Bean
    public String dirToSearch(){
        return "C:\\Users\\HP\\eclipse-workspace\\Capg\\src\\Capg";
    }
    @Bean
    public FileProvider fileProvider(){
        return new FileProvider(dirToSearch(),".java");
    }
    @Bean
    public WordCounter wordCounter(){
        WordCounter wc = new WordCounter();
        wc.setWordToSearch("System");
        wc.setFileProvider(fileProvider());
        return wc;
    }
}