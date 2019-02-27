package com.jay.app.web.rest;

import java.util.HashSet;
import java.util.Objects;

public class ConnectedCities {
    private String city1;
    private String city2;

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public boolean checkCitiesConnected(String origin, String dest){
        if(!origin.equalsIgnoreCase(dest)
            &&(origin.equalsIgnoreCase(this.getCity1())||origin.equalsIgnoreCase(this.getCity2()))
            && (dest.equalsIgnoreCase(this.getCity1())||dest.equalsIgnoreCase(this.getCity2()))){
            return true;
        }else{return false;}
    }

    public ConnectedCities(String cities) {
        String[] citiesArr = cities.split(",");
        this.city1 = citiesArr[0].trim();
        this.city2 = citiesArr[1].trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectedCities that = (ConnectedCities) o;
//        return (city1.equals(that.city1) || city1.equals(that.city2)) &&
//            (city2.equals(that.city2) || city2.equals(that.city1));
        return (this.getCity1().equalsIgnoreCase(that.getCity1())||this.getCity1().equalsIgnoreCase(that.getCity2()))&&
            (this.getCity2().equalsIgnoreCase(that.getCity1())||this.getCity2().equalsIgnoreCase(that.getCity2()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(city1, city2);
    }

    @Override
    public String toString() {
        return "ConnectedCities{" +
            "city1='" + city1 + '\'' +
            ", city2='" + city2 + '\'' +
            '}';
    }
}

