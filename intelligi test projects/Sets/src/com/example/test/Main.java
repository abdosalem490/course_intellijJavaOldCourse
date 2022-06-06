package com.example.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenBody.Key , HeavenBody> solarSystem = new HashMap<>();
    private static Set<HeavenBody> planets = new HashSet<>();
    public static void main(String[] args)
    {
        HeavenBody temp = new Planet("Mercury" , 88);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

         temp = new Planet("Venus" , 225);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

         temp = new Planet("Earth" , 365);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        HeavenBody tempMoon = new Moon("Moon" , 27);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars" , 687);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos" , 1.3);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos" , 0.3);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter" , 4332);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        tempMoon = new Moon("Io" , 1.8);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa" , 3.5);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede" , 7.1);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto" , 16.7);
        solarSystem.put(tempMoon.getKey() , tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn" , 10759);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        temp = new Planet("Uranus" , 30660);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        temp = new Planet("Neptune" , 165);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        temp = new DwarfPlanet("Pluto" , 248);
        solarSystem.put(temp.getKey() , temp);
        planets.add(temp);

        System.out.println("Planets ");
        for (HeavenBody planet : planets)
        {
            System.out.println("\t" + planet.getKey());
        }

        HeavenBody body = solarSystem.get(HeavenBody.makeKey("Mars" , HeavenBody.BodyTypes.PLANET));
        System.out.println("Moons of "+body.getKey());
        for (HeavenBody jupitarMoon : body.getSatellites())
        {
            System.out.println("\t"+jupitarMoon.getKey());
        }

        Set<HeavenBody> moons = new HashSet<>();
        for (HeavenBody planet : planets)
        {
            moons.addAll(planet.getSatellites());
        }
        System.out.println("All moons ");
        for (HeavenBody moon : moons)
        {
            System.out.println("\t"+moon.getKey());
        }
        HeavenBody pluto = new Planet("Pluto" , 842 );
        planets.add(pluto);

        for (HeavenBody planet : planets)
        {
         //   System.out.println(planet.getKey() + " : " +planet.getOrbitalPeriod());
            System.out.println(planet);
        }
        HeavenBody earth1 = new Planet("Earth" , 365);
        HeavenBody earth2 = new Planet("Earth",365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));

        solarSystem.put(pluto.getKey() , pluto);
        System.out.println(solarSystem.get(HeavenBody.makeKey("Pluto" , HeavenBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenBody.makeKey("Pluto" , HeavenBody.BodyTypes.DWARF_PLANET)));

        System.out.println();
        System.out.println("the solar system contains");
        for (HeavenBody heavenBody : solarSystem.values())
        {
            System.out.println(heavenBody);
        }
    }
}
