package by.asalalaiko.model;

import by.asalalaiko.repository.PairRepository;
import by.asalalaiko.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;

public class CryptocurrencyReport {

    private String name;
    private Double minPrice;
    private Double maxPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public CryptocurrencyReport(String name, Double minPrice, Double maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
}
