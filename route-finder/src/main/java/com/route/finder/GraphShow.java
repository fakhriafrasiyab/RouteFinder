package com.route.finder;

public class GraphShow {
    public static void main(String[] args) {
        Graph graph = new Graph(true);
        City zero = new City("Subotica", "46.099482", "19.670069");
        City one = new City("Kanjiža", "46.062513", "20.051904");
        City two = new City("Senta", "45.928325", "20.086365");
        City three = new City("Sombor", "45.770616", "19.116589");
        City four = new City("Bačka Topola", "45.812892", "19.630098");
        City five = new City("Ada", "45.796703", "20.133137");
        City six = new City("Kikinda", "45.831178", "20.473791");
        City seven = new City("Vrbas", "45.568624", "19.652300");
        City eight = new City("Bečej", "45.614361", "20.047463");
        City nine = new City("Zrenjanin", "45.379652", "20.395340");
        City ten = new City("Bačka Palanka", "45.252139", "19.397028");
        City eleven = new City("Novi Sad", "45.254284", "19.842461");
        City twelve = new City("Ruma", "45.007928", "19.816085");
        City thirteen = new City("Pančevo", "44.878964", "20.657296");
        City fourteen = new City("Sremska Mitrovica", "44.979736", "19.610388");
        City fifteen = new City("Vršac", "45.122362", "21.297521");

        graph.addEdge(zero, one, 40.1);//two directional
        graph.addEdge(one, zero, 40.1);
        graph.addEdge(zero, four, 41.1);//two directional
        graph.addEdge(four, zero, 41.1);
        graph.addEdge(three, zero, 56.9);//one directional
        graph.addEdge(three, four, 47.4);//two directional
        graph.addEdge(four, three, 47.4);
        graph.addEdge(four, eleven, 73.6);//one directional
        graph.addEdge(four, seven, 30.9);//one directional
        graph.addEdge(seven, ten, 47.8);//one directional
        graph.addEdge(one, two, 22.8);//two directional
        graph.addEdge(two, one, 22.8);
        graph.addEdge(two, five, 17.8);//two directional
        graph.addEdge(five, two, 17.8);
        graph.addEdge(five, nine, 71.9);//two directional
        graph.addEdge(nine, five, 71.9);
        graph.addEdge(six, five, 30.4);//two directional
        graph.addEdge(five, six, 30.4);
        graph.addEdge(eight, zero, 95);//one directional
        graph.addEdge(nine, eleven, 50.1);//two directional
        graph.addEdge(eleven, nine, 50.1);
        graph.addEdge(eleven, ten, 40);//two directional
        graph.addEdge(ten, eleven, 40);
        graph.addEdge(ten, three, 76.6);//one directional
        graph.addEdge(eleven, fourteen, 53.4);//two directional
        graph.addEdge(fourteen, eleven, 53.4);
        graph.addEdge(fourteen, twelve, 23.9);//two directional
        graph.addEdge(twelve, fourteen, 24);
        graph.addEdge(ten, eleven, 33.8);//one directional
        graph.addEdge(ten, nine, 82.9);//one directional
        graph.addEdge(eight, eleven, 48.8);//one directional
        graph.addEdge(five, eight, 23.6);//one directional
        graph.addEdge(nine, thirteen, 78.2);//two directional
        graph.addEdge(thirteen, nine, 78.2);
        graph.addEdge(thirteen, fifteen, 65.7);//two directional
        graph.addEdge(five, thirteen, 65.7);

        graph.DijkstraShortestPath(zero, twelve);
    }
}
