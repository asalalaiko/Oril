package by.asalalaiko;

import by.asalalaiko.service.GetServise;

import java.io.IOException;


public class Application extends IOException {

    public static void main(String args[]) throws InterruptedException {

        while (true){
            new GetServise().findPair("BTC","USD");
            new GetServise().findPair("ETH","USD");
            new GetServise().findPair("XRP","USD");
            Thread.sleep(15000L);
        }







//        RestTemplate restTemplate = new RestTemplate();
//
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
////Add the Jackson Message converter
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//// Note: here we are making this converter to process any kind of response,
//// not only application/*json, which is the default behaviour
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);
//
//
//
//        Pair pair =  restTemplate.getForObject("https://cex.io/api/ticker/BTC/USD",Pair.class);
//        System.out.println(pair.toString());
//
//        LastPrice lp = restTemplate.getForObject("https://cex.io/api/last_price/BTC/USD", LastPrice.class);
//        System.out.println(lp.toString());






    }
}
