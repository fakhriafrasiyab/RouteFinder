package com.route.finder;

public class GraphShow {
    public static void main(String[] args) {
        GraphWeighted graphWeighted = new GraphWeighted(true);
        City zero = new City("Subotica", "46.099482", "19.670069");
        City one = new City("Kanjiža", "46.062513", "20.051904");
        City two = new City("Senta", "45.928325", "20.086365");
        City three = new City("Kikinda", "45.831178", "20.473791");
        City four = new City("Bečej", "45.614361", "20.047463");

        // Our addEdge method automatically adds Nodes as well.
        // The addNode method is only there for unconnected Nodes,
        // if we wish to add any
        graphWeighted.addEdge(zero, one, 8);
        graphWeighted.addEdge(zero, two, 11);
        graphWeighted.addEdge(one, two, 7);
        graphWeighted.addEdge(two, three, 10);
        graphWeighted.addEdge(two, four, 11);

        graphWeighted.DijkstraShortestPath(zero, four);
    }
}
