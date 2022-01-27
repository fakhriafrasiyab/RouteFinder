package com.route.finder;

public class GraphShow {
    public static void main(String[] args) {
        GraphWeighted graphWeighted = new GraphWeighted(true);
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
        City fiveteen = new City("Vršac", "45.122362", "21.297521");

        graphWeighted.addEdge(zero, one, 40.1);//two directional
        graphWeighted.addEdge(one, zero, 40.1);
        graphWeighted.addEdge(zero, four, 41.1);//two directional
        graphWeighted.addEdge(four, zero, 41.1);
        graphWeighted.addEdge(three, zero, 56.9);//one directional
        graphWeighted.addEdge(three, four, 47.4);//two directional
        graphWeighted.addEdge(four, three, 47.4);
        graphWeighted.addEdge(four, eleven, 73.6);//one directional
        graphWeighted.addEdge(four, seven, 30.9);//one directional
        graphWeighted.addEdge(seven, ten, 47.8);//one directional
        graphWeighted.addEdge(one, two, 22.8);//two directional
        graphWeighted.addEdge(two, one, 22.8);
        graphWeighted.addEdge(two, five, 17.8);//two directional
        graphWeighted.addEdge(five, two, 17.8);
        graphWeighted.addEdge(five, nine, 71.9);//two directional
        graphWeighted.addEdge(nine, five, 71.9);
        graphWeighted.addEdge(six, five, 30.4);//two directional
        graphWeighted.addEdge(five, six, 30.4);
        graphWeighted.addEdge(eight, zero, 95);//one directional
        graphWeighted.addEdge(nine, eleven, 50.1);//two directional
        graphWeighted.addEdge(eleven, nine, 50.1);
        graphWeighted.addEdge(eleven, ten, 40);//two directional
        graphWeighted.addEdge(ten, eleven, 40);
        graphWeighted.addEdge(ten, three, 76.6);//one directional
        graphWeighted.addEdge(eleven, fourteen, 53.4);//two directional
        graphWeighted.addEdge(fourteen, eleven, 53.4);
        graphWeighted.addEdge(fourteen, twelve, 23.9);//two directional
        graphWeighted.addEdge(twelve, fourteen, 24);
        graphWeighted.addEdge(ten, eleven, 33.8);//one directional
        graphWeighted.addEdge(ten, nine, 82.9);//one directional
        graphWeighted.addEdge(eight, eleven, 48.8);//one directional
        graphWeighted.addEdge(five, eight, 23.6);//one directional
        graphWeighted.addEdge(nine, thirteen, 78.2);//two directional
        graphWeighted.addEdge(thirteen, nine, 78.2);
        graphWeighted.addEdge(thirteen, fiveteen, 65.7);//two directional
        graphWeighted.addEdge(five, thirteen, 65.7);

        graphWeighted.DijkstraShortestPath(zero, twelve);
    }
}
