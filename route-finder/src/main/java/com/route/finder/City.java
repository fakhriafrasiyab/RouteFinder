package com.route.finder;

import java.util.LinkedList;

public class City {
    private String name;
    private String latitude;
    private String longitude;
    private boolean visited;
    LinkedList<EdgeWeighted> edges;

    City(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        visited = false;
        edges = new LinkedList<>();
    }

    boolean isVisited() {
        return visited;
    }

    void visit() {
        visited = true;
    }

    public String getName() {
        return name;
    }

}

