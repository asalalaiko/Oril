package by.asalalaiko.repo;

import by.asalalaiko.model.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PairRepository extends JpaRepository<Pair, Integer> {

    List<Pair> getByCurr1(String Curr1);



}
