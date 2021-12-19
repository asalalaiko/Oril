package by.asalalaiko.service.impl;

import by.asalalaiko.model.Pair;
import by.asalalaiko.repo.PairRepository;
import by.asalalaiko.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component
public class JPAPairService implements PairService {

    @Autowired
    private PairRepository pairRepository;

    @Override
    public void savePair(Pair pair) {
      pairRepository.save(pair);
    }

    @Override
    public List<Pair> getPairs() {
        return pairRepository.findAll();
    }

    @Override
    public List<Pair> findByCurr1(String curr1) {
        return pairRepository.getByCurr1(curr1);
    }
}
