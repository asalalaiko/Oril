package by.asalalaiko;

import by.asalalaiko.model.Pair;
import by.asalalaiko.service.GetServise;
import by.asalalaiko.service.PairService;
import by.asalalaiko.service.impl.JPAPairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;


public class Application extends IOException {

    @Autowired
    private JPAPairService pairService;

      public static void main(String args[]) throws InterruptedException {



        while (true){

            new GetServise().findPair("BTC","USD");

            new GetServise().findPair("ETH","USD");
            new GetServise().findPair("XRP","USD");
            Thread.sleep(15000L);
        }
        
    }
}
