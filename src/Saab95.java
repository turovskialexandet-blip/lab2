import java.awt.*;

public class Saab95 extends Car{

    private final Motor_vehicle parent = new Motor_vehicle();
    
    public Saab95(){
        super(2, 125, Color.red, "Saab95", "passenger car");
        setTurboOff();
    }

    public void setTurboOn(){ parent.setTurboOn(); }

    public void setTurboOff(){ parent.setTurboOff(); }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(parent.getTurbo()) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
