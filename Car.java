/* 
 * Name: Angie Alvarez
 * Date: 03/9/2026
 * Program: Assessment: Car Data Analyzer
 */

public class Car {

    private String Car_ID;
    private String Brand;
    private String Model;
    private int Year;
    private String Fuel_Type;
    private String Color;
    private double Mileage_kmpl;

    //default constructor; used to set strings and initialize array list

    public Car(String car_ID, String brand, String model, int year, String fuel_Type, String color, double mileage_kmpl) {
        this.Car_ID = car_ID;
        this.Brand = brand;
        this.Model = model;
        this.Year = year;
        this.Fuel_Type = fuel_Type;
        this.Color = color;
        this.Mileage_kmpl = mileage_kmpl;
    }

    // all setters and getters

    public String getCar_ID() {
        return Car_ID;
    }

    public void setCar_ID(String car_ID) {
        this.Car_ID = car_ID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        this.Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    public String getFuel_Type() {
        return Fuel_Type;
    }

    public void setFuel_Type(String fuel_Type) {
        this.Fuel_Type = fuel_Type;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public double getMileage_kmpl() {
        return Mileage_kmpl;
    }

    public void setMileage_kmpl(double mileage_kmpl) {
        this.Mileage_kmpl = mileage_kmpl;
    }

    //toString method
    @Override
    public String toString() {
        return "Car{" +
                "Car_ID='" + Car_ID + '\'' +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Year=" + Year + '\'' +
                ", Fuel_Type='" + Fuel_Type + '\'' +
                ", Color='" + Color + '\'' +
                ", Mileage_kmpl=" + Mileage_kmpl +
                '}';
    }

} // end class
