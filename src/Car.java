import java.awt.*;

public class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model
    public Point coordinates = new Point(0, 0); // Car coordinates
    private int state = 1;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    // getter-function that returns the number of doors a car has
    public int getNrDoors() {
        return nrDoors;
    }

    // getter-function that returns the engine power of the car
    public double getEnginePower() {
        return enginePower;
    }

    // getter-function that returns the current speed of the car
    public double getCurrentSpeed() {
        if (currentSpeed <= 0) return currentSpeed = 0;
        else return Math.min(currentSpeed, enginePower);
    }

    // getter-function that returns the color of the car
    public Color getColor() {
        return color;
    }

    // setter-function to set the color of the car
    public void setColor(Color clr) {
        color = clr;
    }

    // function that starts the engine of the car
    public void startEngine() {
        currentSpeed = 0.1;
    }

    // function that stops the engine of the car
    public void stopEngine() {
        currentSpeed = 0;
    }

    // interface
    // potential changes are expected for these methods
    public void move() {
        switch (state) {
            case 1: //rakt fram
                coordinates.y += (int) currentSpeed;
                break;
            case 2: //går åt höger
                coordinates.x += (int) currentSpeed;
                break;
            case 3: //går ner
                coordinates.y -= (int) currentSpeed;
                break;
            case 4: //går åt vänster
                coordinates.x -= (int) currentSpeed;
                break;
        }
    }

    public void turnLeft() {
        if (state <= 1) {
            state = 4;
        } else {
            state -= 1;
        }
    }

    public void turnRight() {
        if (state >= 4) {
            state = 1;
        } else {
            state += 1;
        }
    }

    public double Zero_to_One(double amount) {
        if (amount <= 0) amount = 0;
        else amount = Math.min(amount, 1);
        System.out.printf("Call from Zero_to_One() function, the amount is %s\n", amount);
        return amount;
    }

    public double speedFactor(){ return 0; }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount) {
        amount = Zero_to_One(amount);
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        amount = Zero_to_One(amount);
        decrementSpeed(amount);
    }
}
