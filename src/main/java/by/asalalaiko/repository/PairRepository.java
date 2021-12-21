package by.asalalaiko.repository;

import by.asalalaiko.model.Pair;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PairRepository extends JpaRepository<Pair, Integer>   {

    List<Pair> getByCurr1(String Curr1);

    List<Pair> getByCurr1(String Curr1, Pageable pageable);

}
