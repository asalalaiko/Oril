package by.asalalaiko.service;

import by.asalalaiko.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptocurrencyReportService {

    @Autowired
    private PairRepository pairRepository;
}
