package com.zpi.main;

import java.util.List;

public class Quotations {

    private String currency;
    private String code;
    private List<Rate> rates;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(code).append("\n");
        for(Rate r : rates){
            stringBuilder.append(r.getMid()).append("\n");
        }

        return stringBuilder.toString();
    }

}
