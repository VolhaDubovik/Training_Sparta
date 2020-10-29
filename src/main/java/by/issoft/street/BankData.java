package by.issoft.street;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BankData {

/*    @JsonProperty("Cur_ID") //145
    int cur_ID;
    @JsonProperty("Date") // 2020-10-28T00:00:00
    String date;

    @JsonProperty("Cur_Scale") // 1
    int cur_Scale;*/

    @JsonProperty("Cur_Abbreviation") // USD
    private String abbreviation;
    @JsonProperty("Cur_Name") // Доллар США
    private String currencyName;
    @JsonProperty("Cur_OfficialRate") //2.5534
    private double currencyRate;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public double exchangeBYN(double amountBYN) {
        return amountBYN / currencyRate;
    }


}