package by.asalalaiko.service;

import by.asalalaiko.model.Pair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PairService  {


    void create(Pair pair);

    List<Pair> readAll();

    List<Pair> findByCurr1(String curr1);

    List<Pair> findByCurr1(String curr1, Pageable pageable);

}
