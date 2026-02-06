import java.awt.*;

public class Scania extends Car{
    private final Motor_vehicle turbo;
    private final Flatbed flatbed;
    private final Saab95 speedFactor;
    // Uppgift 1
    public Scania(){
        super(2, 550, Color.BLUE, "Scania", "truck");
        turbo = new Motor_vehicle();
        flatbed = new Flatbed();
        speedFactor = new Saab95();
    }

    public double getFlatBedAngle() { return flatbed.getFlatBedAngle(); }

    public void RaiseFlatbed(double angle) { flatbed.RaiseFlatbed(angle); }
    public void LowerFlatbed(double angle) { flatbed.LowerFlatbed(angle); }

    @Override
    public void startEngine() {
        if (getFlatBedAngle() == 0) currentSpeed = 0.1;
    }

    @Override
    public double speedFactor(){
        return speedFactor.speedFactor();
    }

    public void setTurboOn() { turbo.setTurboOn(); }

    public void setTurboOff() { turbo.setTurboOff(); }
}
