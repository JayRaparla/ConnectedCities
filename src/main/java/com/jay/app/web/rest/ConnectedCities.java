package com.jay.app.web.rest;

import java.util.Objects;

public class ConnectedCities {
    String city1;
    String city2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConnectedCities that = (ConnectedCities) o;
        return (city1.equals(that.city1) || city1.equals(that.city2)) &&
            (city2.equals(that.city2) || city2.equals(that.city1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(city1, city2);
    }
}

