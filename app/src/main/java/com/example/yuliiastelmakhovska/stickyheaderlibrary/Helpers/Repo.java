package com.example.yuliiastelmakhovska.stickyheaderlibrary.Helpers;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Person;
import com.example.yuliiastelmakhovska.stickyheaderlibrary.Models.Trip;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Repo {

    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>(45);
        people.add(new Person("George",
                              "Washington"));
        people.add(new Person("John",
                              "Adams"));
        people.add(new Person("Thomas",
                              "Jefferson"));
        people.add(new Person("James",
                              "Madison"));
        people.add(new Person("James",
                              "Monroe"));
        people.add(new Person("John Quincy",
                              "Adams"));
        people.add(new Person("Andrew",
                              "Jackson"));
        people.add(new Person("Martin",
                              "Van Buren"));
        people.add(new Person("William",
                              "Harrison"));
        people.add(new Person("John",
                              "Tyler"));
        people.add(new Person("Zachary",
                              "Taylor"));
        people.add(new Person("Millard",
                              "Fillmore"));
        people.add(new Person("Franklin",
                              "Pierce"));
        people.add(new Person("James",
                              "Buchanan"));
        people.add(new Person("Abraham",
                              "Lincoln"));
        people.add(new Person("Andrew",
                              "Johnson"));
        people.add(new Person("Ulysses",
                              "Grant"));
        people.add(new Person("Rutherford",
                              "Hayes"));
        people.add(new Person("James",
                              "Garfield"));
        people.add(new Person("Chester",
                              "Arthur"));
        people.add(new Person("Grover",
                              "Cleveland"));
        people.add(new Person("Benjamin",
                              "Harrison"));
        people.add(new Person("William",
                              "McKinley"));
        people.add(new Person("Theodore",
                              "Roosevelt"));
        people.add(new Person("William",
                              "Taft"));
        people.add(new Person("Woodrow",
                              "Wilson"));
        people.add(new Person("Warren",
                              "Harding"));
        people.add(new Person("Calvin",
                              "Coolidge"));
        people.add(new Person("Calvin",
                "Coolidge"));
        people.add(new Person("Herbert",
                              "Hoover"));
        people.add(new Person("Harry",
                              "Truman"));
        people.add(new Person("Dwight",
                              "Eisenhower"));
        people.add(new Person("John",
                              "Kennedy"));
        people.add(new Person("Lyndon",
                              "Johnson"));
        people.add(new Person("Richard",
                              "Nixon"));
        people.add(new Person("Gerald",
                              "Ford"));
        people.add(new Person("Jimmy",
                              "Carter"));
        people.add(new Person("Ronald",
                              "Reagan"));
        people.add(new Person("George H.W.",
                              "Bush"));
        people.add(new Person("Bill",
                              "Clinton"));
        people.add(new Person("George W.",
                              "Bush"));
        people.add(new Person("Barack",
                              "Obama"));
        people.add(new Person("Donald",
                              "Trump"));

        return people;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Trip> getTrips() {
        //return null;
        List <Trip> trips = new ArrayList<>();
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.RED));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00,Color.BLACK));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLUE));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.YELLOW));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.YELLOW));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.GREEN));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.RED));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.GREEN));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.CYAN));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.RED));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00,Color.BLACK));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLUE));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.YELLOW));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.YELLOW));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.GREEN));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.RED));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.GREEN));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.CYAN));

        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.RED));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00,Color.BLACK));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLUE));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.YELLOW));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.YELLOW));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.GREEN));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.RED));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.GREEN));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.CYAN));

        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.RED));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLUE));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.BLACK));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00,Color.BLACK));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLUE));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.YELLOW));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.YELLOW));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.GREEN));
        trips.add(new Trip(5,new Date(1220227200L * 1000),"England",5000.00,Color.BLACK));
        trips.add(new Trip(1,new Date(1220832000L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(2,new Date(1220227200L * 1000),"France",5500.00, Color.RED));
        trips.add(new Trip(1,new Date(1221436800L * 1000),"Germany",2000.00, Color.GREEN));
        trips.add(new Trip(1,new Date(1220227200L * 1000),"USA",2000.00, Color.BLACK));
        trips.add(new Trip(3,new Date(1220832000L * 1000),"Argentina",4000.00, Color.CYAN));


        return trips;
    }
}
