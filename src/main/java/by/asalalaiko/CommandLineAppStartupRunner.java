package by.asalalaiko;

import by.asalalaiko.model.Pair;
import by.asalalaiko.repository.PairRepository;
import by.asalalaiko.service.PairService;
import by.asalalaiko.service.PairServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    public PairRepository pairRepository;
    @Autowired
    public PairServiceImpl pairService;

    @Override
    public void run(String... args) throws Exception {
      while (true) {

//          pairRepository.save(findPair("BTC","USD"));
//          pairRepository.save(findPair("ETH","USD"));
//          pairRepository.save(findPair("XRP","USD"));

          Thread.sleep(15000L);

      }
    }

    @Async
    public  Pair findPair(String Curr1, String Curr2){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        Pair pair = new Pair();
        pair = restTemplate.getForObject("https://cex.io/api/last_price/{Curr1}/{Curr2}", Pair.class, Curr1, Curr2);
        pair.setTimestamp(new Date());
        LOGGER.info("rest OK : " + pair.toString());
        return pair;
    }
}
