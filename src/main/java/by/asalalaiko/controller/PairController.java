package by.asalalaiko.controller;

import by.asalalaiko.model.Pair;
import by.asalalaiko.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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


        Pair pair = pairService.getByCurr1Min(currencyname);

        return pair != null
                ? new ResponseEntity(pair, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    ///cryptocurrencies/maxprice?name=[currency_name]
    @GetMapping(value = "/cryptocurrencies/maxprice")
    public ResponseEntity<List<Pair>> maxprice(@RequestParam(value = "name") String currencyname) {

        Pair pair = pairService.getByCurr1Max(currencyname);

        return pair != null
                ? new ResponseEntity(pair, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

///cryptocurrencies/csv
    @GetMapping(value = "/cryptocurrencies/csv")
        public void fooAsCSV(HttpServletResponse response) {
        response.setContentType("text/csv; charset=utf-8");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);



    }

}