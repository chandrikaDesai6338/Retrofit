package com.a20112981.retrofit;

import java.util.List;

public class PlanetsModel {
    public List<Planets> results;

    public List<Planets> getResults() {
        return results;
    }




}
class Planets{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String terrain;
}
