public class Flatbed {
    private double FlatBedAngle = 0;
    private double currentSpeed = new Vehicle().getCurrentSpeed(); //vad exakt gör detta?
    private boolean RampLowered = false;

    public double getFlatBedAngle(){ return FlatBedAngle; }

    public boolean getRampLowered(){ return RampLowered; }

    public void RaiseFlatbed(double angle){
        if (currentSpeed == 0) {
            FlatBedAngle = Math.min(FlatBedAngle + angle, 70);
        }
    }

    public void LowerFlatbed(double angle){
        if (currentSpeed == 0) {
            FlatBedAngle = Math.min(FlatBedAngle - angle, 70);
        }
    }

    public void RaiseRamp(){ RampLowered = false; }
    public void LoweredRamp(){ RampLowered = true; }
}
