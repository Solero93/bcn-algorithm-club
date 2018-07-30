package com.bcnalgorithmclub.graphs.maxflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parking {

    public static void main(String[] args) {

        Parking p = new Parking();

        String[] case0 = new String[]{
                "C....XP",
                "C....XP",
                "C....XP"};
        System.out.println(p.minTime(case0) == -1);

        String[] case1 = new String[]{
                "C.....P",
                "C.....P",
                "C.....P"};
        System.out.println(p.minTime(case1) == 6);

        String[] case2 = new String[]{
                "C.X.....",
                "..X..X..",
                "..X..X..",
                ".....X.P"};
        System.out.println(p.minTime(case2) == 16);

        String[] case3 = new String[]{
                "XXXXXXXXXXX",
                "X......XPPX",
                "XC...P.XPPX",
                "X......X..X",
                "X....C....X",
                "XXXXXXXXXXX"};
        System.out.println(p.minTime(case3) == 5);

        String[] case4 = new String[]{
                ".C.",
                "...",
                "C.C",
                "X.X",
                "PPP"};
        System.out.println(p.minTime(case4) == 4);

        String[] case5 = new String[]{
                "CCCCC",
                ".....",
                "PXPXP"};
        System.out.println(p.minTime(case5) == -1);

        String[] case6 = new String[]{
                "..X..",
                "C.X.P",
                "..X.."};

        System.out.println(p.minTime(case6) == -1);
    }

    private final char PARKING ='P';
    private final char CAR = 'C';
    private final char WALL = 'X';

    class Location
    {
        public int i;
        public int j;

        public Location(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    private int minTime(String[] park) {
        //TODO implementation
        ArrayList<Location> cars = new ArrayList<>();
        ArrayList<Location> parkings = new ArrayList<>();
        int numberOfCars = 0;
        int numberOfParking = 0;
        char[][] array = new char[park.length][park[0].length()];
        for (int row = 0; row < park.length; row++) {
            for (int column = 0; column < park[0].length(); column++) {
                if (park[row].charAt(column) == CAR){
                    numberOfCars++;
                    cars.add(new Location(row, column));
                }
                else if (park[row].charAt(column) == PARKING){
                    numberOfParking++;
                    parkings.add(new Location(row, column));
                }

                array[row][column] = park[row].charAt(column);
            }
        }

        if (numberOfCars > numberOfParking)
            return -1;
        int[][] distanceCarToParking = new int[numberOfCars][numberOfParking];
        Set<Integer> availableDistances = new HashSet();
        for (int i = 0; i < numberOfCars; i++) {
            distanceCarToParking[i] = calculateDistanceCarToParking(cars.get(i), array, parkings, availableDistances);
        }

        int minMaxFlow = Integer.MAX_VALUE;
        for(int distance : availableDistances)
        {
            int[][] matrix = buildMatrix(numberOfCars, numberOfParking, distance, distanceCarToParking );

            MaximumFlow maximumFlow = new MaximumFlow();
            int maxFlow = maximumFlow.fordFulkerson(matrix, 0, matrix[0].length - 1);
            if (maxFlow == numberOfCars && distance < minMaxFlow) {
                minMaxFlow = distance;
            }

        }

        if( minMaxFlow == Integer.MAX_VALUE){
            minMaxFlow = -1;
        }
        //System.out.println("Min Max distance: " + minMaxFlow);
        return minMaxFlow;
    }

    private int[][] buildMatrix(int numberOfCars, int numberOfParking, int distance, int[][] distanceCarToParking) {
        int size = 2 + numberOfCars + numberOfParking;
        int[][] matrix = new int[size][size];

        for (int i = 1; i <= numberOfCars; i++) {
            matrix[0][i] = 1;

            for (int j = 0; j < numberOfParking; j++) {
                if(distanceCarToParking[i-1][j] <=distance) {
                    matrix[i][j + numberOfCars + 1] = 1;
                }
            }
        }

        for (int i = 1; i <= numberOfParking; i++) {
            matrix[numberOfCars + i][size-1] = 1;
        }
        return matrix;
    }


    private int[] calculateDistanceCarToParking(Location car, char[][] parkingMap, ArrayList<Location> parkings, Set<Integer> availableDistances)  {
        int[][] distances = new int[parkingMap.length][parkingMap[0].length];
        ArrayList<Location> vertices = new ArrayList<>();
        ArrayList<Location> neighbours;
        int[] parkingDistances = new int[parkings.size()];

        for (int i = 0; i < parkingMap.length; i++) {
            for (int j = 0; j < parkingMap[0].length; j++) {
                distances[i][j] = Integer.MAX_VALUE;
                if (parkingMap[i][j] != WALL)
                    vertices.add(new Location(i, j));
            }
        }
        distances[car.i][car.j] = 0;

        while(!vertices.isEmpty()) {

            Location minDistanceVertex = findMinDistanceVertex(distances, vertices);

            if (minDistanceVertex == null){
                break;
            }

            vertices.remove(minDistanceVertex);

            neighbours = findNeighbours(minDistanceVertex, parkingMap);
            for(Location neighbour : neighbours)
            {
                int alt = distances[minDistanceVertex.i][minDistanceVertex.j] + 1;
                if(alt < distances[neighbour.i][neighbour.j])
                {
                    distances[neighbour.i][neighbour.j] = alt;
                }
            }
        }
        int i = 0;
        for(Location parking : parkings)
        {
            parkingDistances[i] = distances[parking.i][parking.j];
            if (parkingDistances[i] != Integer.MAX_VALUE) {
                availableDistances.add(parkingDistances[i]);
            }
            i++;
        }
        return parkingDistances;
    }

    private Location findMinDistanceVertex(int[][] distances, ArrayList<Location> vertices )
    {
        int minDistance = Integer.MAX_VALUE;
        Location minDistanceLocation = null;

        for (Location vertex : vertices) {
            if (distances[vertex.i][vertex.j] < minDistance){
                minDistance = distances[vertex.i][vertex.j];
                minDistanceLocation = vertex;
            }
        }
        return minDistanceLocation;
    }

    private ArrayList<Location> findNeighbours(Location minDistanceVertex, char[][] parkingMap) {
        ArrayList<Location> neighbours = new ArrayList<>();

        int top = 0;
        int bottom = parkingMap.length;
        int left = 0;
        int right = parkingMap[0].length;

        int row = minDistanceVertex.i;
        int column = minDistanceVertex.j;

        if (row - 1 >= top && parkingMap[row - 1][column] != WALL)
        {
            neighbours.add(new Location(row -1, column));
        }

        if (column - 1 >= left && parkingMap[row][column - 1] != WALL)
        {
            neighbours.add(new Location(row, column - 1));
        }

        if (row + 1 < bottom && parkingMap[row + 1][column] != WALL)
        {
            neighbours.add(new Location(row + 1, column));
        }

        if (column + 1 < right && parkingMap[row][column + 1] != WALL)
        {
            neighbours.add(new Location(row, column + 1));
        }

        return neighbours;
    }

}
