package by.asalalaiko.service;

import by.asalalaiko.model.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GetServise {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetServise.class);


    @Async
    public void findPair(String Curr1, String Curr2) throws InterruptedException {


        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);


        Pair lp = restTemplate.getForObject("https://cex.io/api/last_price/{Curr1}/{Curr2}", Pair.class, Curr1, Curr2);
        lp.setTimestamp(new Date());
        LOGGER.info("rest OK : " + lp.toString());


        }



}

