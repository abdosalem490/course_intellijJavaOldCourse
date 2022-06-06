package com.example.test;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public abstract class HeavenBody
{
    private final double orbitalPeriod;
    private final Set<HeavenBody> satellites;
    private final Key key;
    public enum BodyTypes
    {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenBody(String name, double orbitalPeriod , BodyTypes bodyType) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name , bodyType);
    }



    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public boolean addSatellite(HeavenBody moon)
    {
        return this.satellites.add(moon);
    }

    public Set<HeavenBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof HeavenBody)
        {
            HeavenBody theObject = (HeavenBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode()
    {
        return this.key.hashCode();
    }

    public static Key makeKey(String name , BodyTypes bodyType)
    {
        return new Key(name , bodyType);
    }
    @Override
    public String toString() {
        return this.key.name +" : "+this.key.bodyType+", "+this.orbitalPeriod;
    }
    public static final class Key
    {
        private String name;
        private BodyTypes bodyType;
        private Key(String name , BodyTypes bodyType)
        {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()+57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj)
        {
            Key key = (Key) obj;
            if (this.name.equals(key.getName()))
            {
                return (this.bodyType== key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name+": "+this.bodyType;
        }
    }
}
