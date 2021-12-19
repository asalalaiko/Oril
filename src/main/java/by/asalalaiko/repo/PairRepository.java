package by.asalalaiko.repo;

import by.asalalaiko.model.Pair;

import java.util.Collection;

public interface PairRepository {

    Collection<Pair> getByCurr1(String Curr1);

    Pair addPair(Pair pair);


}
