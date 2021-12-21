package by.asalalaiko.controller;

import by.asalalaiko.model.Pair;
import by.asalalaiko.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PairController {

    @Autowired
    public PairService pairService;


    @GetMapping(value = "/cryptocurrencies/all")
    public ResponseEntity<List<Pair>> read() {
        final List<Pair> pairs = pairService.readAll();

        return pairs != null &&  !pairs.isEmpty()
                ? new ResponseEntity<>(pairs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    ///cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size]
    @GetMapping(value = "/cryptocurrencies")
    public ResponseEntity<List<Pair>> page(@RequestParam(value = "name") String currencyname,
                                           @RequestParam(value = "page") Optional<Integer> page,
                                           @RequestParam(value = "size") Optional<Integer> size) {

        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), Sort.by("lprice"));
        List<Pair> pairs = pairService.findByCurr1(currencyname, pageable);

        return pairs != null &&  !pairs.isEmpty()
                ? new ResponseEntity<>(pairs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    ///cryptocurrencies/minprice?name=[currency_name]
    @GetMapping(value = "/cryptocurrencies/minprice")
    public ResponseEntity<List<Pair>> minprice(@RequestParam(value = "name") String currencyname) {
         List<Pair> pairs = pairService.findByCurr1(currencyname);
        final Optional<Pair> pair = pairs.stream()
                .min(Comparator.comparing(Pair::getLprice));

        return pair != null &&  !pairs.isEmpty()
                ? new ResponseEntity(pair, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    ///cryptocurrencies/maxprice?name=[currency_name]
    @GetMapping(value = "/cryptocurrencies/maxprice")
    public ResponseEntity<List<Pair>> maxprice(@RequestParam(value = "name") String currencyname) {
        List<Pair> pairs = pairService.findByCurr1(currencyname);
        final Optional<Pair> pair = pairs.stream()
                .max(Comparator.comparing(Pair::getLprice));

        return pair != null &&  !pairs.isEmpty()
                ? new ResponseEntity(pair, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }



}