import java.awt.*;

public class Scania extends Car{
    private double FlatBedAngle;
    private boolean turboOn;
    // Uppgift 1
    public Scania(){
        super(2, 550, Color.BLUE, "Scania");
        FlatBedAngle = 0;
    }

    public double getFlatBedAngle(){ return FlatBedAngle; }

    public void RaiseFlatbed(double angle){
        if (getCurrentSpeed() == 0) {
            FlatBedAngle = Math.min(angle, 70);
        }
    }

    @Override
    public void startEngine() {
        if (getFlatBedAngle() == 0) currentSpeed = 0.1;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
}
