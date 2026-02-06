import java.awt.*;

public class Car extends Vehicle {
    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car
    private final String modelName; // The car model
    private final String CarVariant; // car variants: passenger car, truck, buss
    private final Motor_vehicle parent = new Motor_vehicle();

    public Car(int nrDoors, double enginePower, Color color, String modelName, String CarVariant) {
        this.nrDoors = nrDoors;
        parent.setEnginePower(enginePower);
        this.color = color;
        this.modelName = modelName;
        this.CarVariant = CarVariant.toLowerCase(); // Added lowercase for them to make it easier with conditions
        parent.stopEngine();
    }

    // getter-function that returns the number of doors a car has
    public int getNrDoors() {
        return nrDoors;
    }

    // getter-function that returns the color of the car
    public Color getColor() {
        return color;
    }

    // setter-function to set the color of the car
    public void setColor(Color clr) {
        color = clr;
    }

    public void incrementSpeed(double amount) { parent.incrementSpeed(amount); }

    public void decrementSpeed(double amount) { parent.decrementSpeed(amount); }

    public void gas(double amount) { parent.gas(amount); }

    public void brake(double amount) { parent.brake(amount); }

    public double getEnginePower() { return parent.getEnginePower(); }

    public void startEngine() { parent.startEngine(); }

    public void stopEngine() { parent.stopEngine(); }
}
