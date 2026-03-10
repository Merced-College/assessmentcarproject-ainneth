/*
* Name: Angie Alvare
* Date: 03/9/2026
* Program: Assessment: Car Data Analyzer (Main.java)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Car> loadCars = new ArrayList<>();

    public static void main(String[] args) {
        readCarDataFromCSV("Car_Data.csv");
        insertionSortByBrand();
        printTotalCarsLoaded();
        printFirst2000Cars();
        printFirst10CarsAfterSorting();
        searchBrand();
    }

    //Step 2 - Load CSV

    public static void readCarDataFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0; 
            int carCount = 0; // Counter for cars loaded
            // To keep track of line numbers for error reporting
            
            while ((line = br.readLine()) != null && carCount < 2000) {
                lineNum++;

                if(lineNum <= 1) {
                    continue; // Skip header line
                }

                String[] data = line.split(",");
                if (data.length == 7) {
                    String car_ID = data[0];
                    String brand = data[1];
                    String model = data[2];
                    int year = Integer.parseInt(data[3]);
                    String fuel_Type = data[4];
                    String color = data[5];
                    double mileage_kmpl = Double.parseDouble(data[6]);

                    loadCars.add(new Car(car_ID, brand, model, year, fuel_Type, color, mileage_kmpl));
                    carCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }//end readCarDataFromCSV
    }

    //print total cars loaded
    public static void printTotalCarsLoaded() {
        System.out.println("Total cars loaded: " + loadCars.size());
    }

    // Print first 2000 car
    public static void printFirst2000Cars() {
        int count = Math.min(2000, loadCars.size());
        for (int i = 0; i < count; i++) {
            System.out.println(loadCars.get(i));
        }
    }
    public static void insertionSortByBrand() {
        for (int i = 1; i < loadCars.size(); i++) {
            Car variable = loadCars.get(i);
            int j = i - 1;

            // Move elements of loadCars[0..i-1], that are greater than the brand, to one position ahead
            // of their current position
            while (j >= 0 && loadCars.get(j).getBrand().compareToIgnoreCase(variable.getBrand()) > 0) {
                loadCars.set(j + 1, loadCars.get(j));
                j = j - 1;
            }
            loadCars.set(j + 1, variable);
        }
    }
    //first 10 cars after sorting
    public static void printFirst10CarsAfterSorting() {
    System.out.println( "Top 10 cars after sorting:");
    for(int i = 0; i < 10 && i < loadCars.size(); i++) {
        System.out.println(loadCars.get(i));
    }
}

    //ze menu
    static void searchBrand(){
        try(Scanner scnr = new Scanner(System.in)){
            while(true){
              System.out.print("Enter the brand to search (or 'quit' to exit): ");
             String brandToSearch = scnr.nextLine();

             if (brandToSearch.equalsIgnoreCase("quit")) {
                break;
            }

            boolean found = false;

            for (Car car : loadCars) {
                if (car.getBrand().equalsIgnoreCase(brandToSearch)) {
                    System.out.println(car);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No cars found for brand: " + brandToSearch);
            }
        }
    }
    }
}