import java.awt.*;

public class Scania extends Car{
    private double FlatBedAngle;
    private final Saab95 turbo;
    // Uppgift 1
    public Scania(){
        super(2, 550, Color.BLUE, "Scania", "truck");
        FlatBedAngle = 0;
        turbo = new Saab95();
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

    @Override
    public double speedFactor(){
        return turbo.speedFactor();
    }

    public void setTurboOn(){
        turbo.setTurboOn();
    }

    public void setTurboOff(){
        turbo.setTurboOff();
    }
}
