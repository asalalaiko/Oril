package by.asalalaiko;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application  {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);





    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
//        @Override
//        public void run(String... args) throws Exception {
////            try {
////                Pair pair = new Pair();
////                pair.setCurr1("qqq1");
////                pair.setCurr2("qqq2");
////                pair.setLprice("111");
////                pairService.create(pair);
////            } catch(Exception e){
////                LOGGER.error("Not RUN", e);
////            }
//
//        }




    }


