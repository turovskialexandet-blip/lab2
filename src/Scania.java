import java.awt.*;

public class Scania extends Car{
    private double FlatBedAngle;
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
}
