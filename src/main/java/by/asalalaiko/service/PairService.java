package by.asalalaiko.service;

import by.asalalaiko.model.Pair;

import java.util.List;

public interface PairService {

    void savePair(Pair pair);

    List<Pair> getPairs();

    List<Pair> findByCurr1(String curr1);


}
