package com.main;
import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.gal.algo.WordCounter;
public class MainBeans {

    public static void main(String[] args) throws Exception{
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(BeanConfig.class);
        WordCounter wc = context.getBean(WordCounter.class);
        Map<String,Integer> result = wc.createMapResult();
        for(String file : result.keySet()){
            System.out.println(file + " -> " + result.get(file));
        }
        context.close();
    }
}