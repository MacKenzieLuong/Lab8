package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    /**
     * get empty list check if city is there
     *add city
     * Check if city has new city
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
// This line checks if the city is in the list. As the list is empty is should return false
        assertEquals(Boolean.FALSE, list.hasCity(city));
//We now add the city
        list.addCity(city);
// hasCity should return true now
        assertEquals(Boolean.TRUE, list.hasCity(city));
    }

    /**
     * add city
     * check number is one
     * delete city
     * check if number goes down
     */
    @Test
    void testDeleteCities() {
        list = MockCityList();
        City extraCity = new City("Vancouver", "British Columbia");
        list.addCity(extraCity);
        assertEquals(1, list.getCities().size());
        list.delete(extraCity);
        assertEquals(0, list.getCities().size());
        assertFalse(list.getCities().contains(extraCity));
    }






    }
