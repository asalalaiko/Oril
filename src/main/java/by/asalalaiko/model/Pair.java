package by.asalalaiko.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pair {

    private Integer id;
    private Date timestamp;
    private String curr1;
    private String curr2;
    private String lprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurr1() {
        return curr1;
    }

    public void setCurr1(String curr1) {
        this.curr1 = curr1;
    }

    public String getCurr2() {
        return curr2;
    }

    public void setCurr2(String curr2) {
        this.curr2 = curr2;
    }

    public String getLprice() {
        return lprice;
    }

    public void setLprice(String lprice) {
        this.lprice = lprice;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "curr1='" + curr1 + '\'' +
                ", curr2='" + curr2 + '\'' +
                ", lprice='" + lprice + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
