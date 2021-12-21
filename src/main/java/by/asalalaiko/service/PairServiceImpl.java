package by.asalalaiko.service;

import by.asalalaiko.model.Pair;
import by.asalalaiko.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional(readOnly = true)
public class PairServiceImpl implements PairService{

    @Autowired
    private PairRepository pairRepository;

    @Override
    public void create(Pair pair) {
        pairRepository.save(pair);
    }

    @Override
    public List<Pair> readAll() {
        return pairRepository.findAll();
    }

    @Override
    public  List<Pair> findByCurr1(String curr1) {
        return pairRepository.getByCurr1(curr1);
    }

    @Override
    public List<Pair> findByCurr1(String curr1, Pageable pageable) {
        return pairRepository.getByCurr1(curr1, pageable);
    }
}
