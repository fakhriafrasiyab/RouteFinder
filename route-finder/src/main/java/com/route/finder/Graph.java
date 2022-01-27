package com.route.finder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<City> cities;
    private boolean directed;

    Graph(boolean directed) {
        this.directed = directed;
        cities = new HashSet<>();
    }

    public void addEdge(City source, City destination, double distance) {
        cities.add(source);
        cities.add(destination);
        addEdgeHelper(source, destination, distance);
        if (!directed && source != destination) {
            addEdgeHelper(destination, source, distance);
        }
    }

    //this function is to check there is no duplicate edges
    private void addEdgeHelper(City source, City destination, double distance) {
        for (Edge edge : source.edges) {
            if (edge.source == source && edge.destination == destination) {
                edge.distance = distance;
                return;
            }
        }
        // If it hasn't been added already, add the edge
        source.edges.add(new Edge(source, destination, distance));
    }

    public void DijkstraShortestPath(City source, City destination) {
        // We keep track of which path gives us the shortest path for each node
        // by keeping track how we arrived at a particular node, we effectively
        // keep a "pointer" to the parent node of each node, and we follow that
        // path to the start
        HashMap<City, City> changedAt = new HashMap<>();
        changedAt.put(source, null);

        HashMap<City, Double> shortestPathMap = new HashMap<>();

        for (City city : cities) {
            if (city == source)
                shortestPathMap.put(source, 0.0);
            else shortestPathMap.put(city, Double.POSITIVE_INFINITY);
        }

        for (Edge edge : source.edges) {
            shortestPathMap.put(edge.destination, edge.distance);
            changedAt.put(edge.destination, source);
        }

        source.visit();

        while (true) {
            City currentCity = closestReachableUnvisited(shortestPathMap);
            // if we can't get the closest city it means they are not connected
            if (currentCity == null) {
                System.out.println("There isn't a path between " + source.getName() + " and " + destination.getName());
                return;
            }

            // If the closest non-visited city is our destination, we want to print the route
            if (currentCity == destination) {
                System.out.println("The path with the smallest distance between "
                        + source.getName() + " and " + destination.getName() + " is:");

                City child = destination;
                String path = destination.getName();
                while (true) {
                    City parent = changedAt.get(child);
                    if (parent == null) {
                        break;
                    }

                    // Since our changedAt map keeps track of child -> parent relations
                    // in order to print the path we need to add the parent before the child and
                    // it's descendants
                    path = parent.getName() + " " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("The path costs: " + shortestPathMap.get(destination));
                return;
            }
            currentCity.visit();

            // Now we go through all the unvisited nodes our current node has an edge to
            // and check whether its shortest path value is better when going through our
            // current node than whatever we had before
            for (Edge edge : currentCity.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentCity) + edge.distance < shortestPathMap.get(edge.destination)) {
                    shortestPathMap.put(edge.destination,
                            shortestPathMap.get(currentCity) + edge.distance);
                    changedAt.put(edge.destination, currentCity);
                }
            }
        }
    }

    private City closestReachableUnvisited(HashMap<City, Double> shortestRouteMap) {
        double shortestDistance = Double.POSITIVE_INFINITY;
        City closestCity = null;
        for (City city : cities) {
            if (city.isVisited())
                continue;

            double currentDistance = shortestRouteMap.get(city);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestCity = city;
            }
        }
        return closestCity;
    }
}
