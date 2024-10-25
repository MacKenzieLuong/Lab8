package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    } /**
     * this gets size of the list
     * @return
     */
    public int getCount(){
        return cities.size();
    }
    /**
     * this adds a city object to the list
     *the second phase, you can add the
     city * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * This returns  lithest of cities
     * @return
     * Return the  list
     */
    public List<City> getCities() {
        List<City> list = cities;
        return list;
    }
    /**
     * This deletes a city to the list if the city exists
     * @param city
     * This is a candidate city to delete
     */
    public Boolean hasCity(City city) {
        if (cities.contains(city)) {
            return Boolean.TRUE;
        } else{
            return Boolean.FALSE;

        }
    }

    /**
     * This deletes a city to the list if the city exists
     * @param city
     * This is a candidate city to delete
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else{
            throw new IllegalArgumentException();

        }
    }
    /**
     * This returns the number of cities in a list of cities
     * @return
     * Return number of cities in list
     */
    public int countCities(){
        return cities.size();
    }



}
