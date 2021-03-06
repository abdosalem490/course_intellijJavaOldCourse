package test2;

import java.util.HashMap;
import java.util.Map;

public final class Location {
   private final int locationID;
    private String description;
    private Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null)
            this.exits = new HashMap<String, Integer>(exits);
        else
            this.exits = new HashMap<>();

        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }


    public String getDescription() {
        return description;
    }


    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

}
