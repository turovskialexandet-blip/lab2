import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarsJUnitJupiterTests {
    private final Car volvo240 = new Volvo240();
    private final Car saab95 = new Saab95();
    private final Scania scania = new Scania();

    @Test
    public void initTest(){
        // tests initialization
        System.out.println("___\nTests initialization:");
        System.out.println(volvo240);
        System.out.println(saab95);
        System.out.println(scania);
    }

    @Test
    public void getterTest(){
        // tests getters
        assertEquals(4, volvo240.getNrDoors());
        assertEquals(2, saab95.getNrDoors());
        assertEquals(100, volvo240.getEnginePower());
        assertEquals(125,saab95.getEnginePower());
        assertEquals(Color.red,saab95.getColor());
        assertEquals(Color.black,volvo240.getColor());
        assertFalse(saab95.getCurrentSpeed() >0);
        assertFalse(volvo240.getCurrentSpeed() >0);
        assertTrue(scania.getFlatBedAngle()>=0 && scania.getFlatBedAngle() <=70);
    }

    @Test
    public void setterTest(){
        // tests setters
        Color beforeS = saab95.getColor();
        saab95.setColor(Color.magenta);
        assertNotSame(beforeS, saab95.getColor());

        Color beforeV = volvo240.getColor();
        volvo240.setColor(Color.cyan);
        assertNotSame(beforeV, volvo240.getColor());
    }

    @Test
    public void movement_And_rotationTest(){
        // tests the movement of the cars
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed());

        volvo240.incrementSpeed(10);
        double nowV = volvo240.getCurrentSpeed();
        assertNotSame(0.1, nowV);


        for (int i = 0; i < 2; i++){
            volvo240.turnRight();
            volvo240.move();
            volvo240.turnLeft();
            volvo240.move();
        }
        Point cordVnow = new Point(volvo240.coordinates.x, volvo240.coordinates.y);
        assertNotSame(new Point(0, 0), cordVnow);

        for (int i = 1; i < 3; i++){
            volvo240.decrementSpeed(i);
            volvo240.move();
            assertNotSame(cordVnow, volvo240.coordinates);
        }

        volvo240.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed());
        Point befcord = volvo240.coordinates;
        volvo240.move();
        assertSame(befcord, volvo240.coordinates);

    }

    @Test
    public void gas_And_brake(){
        volvo240.startEngine();
        volvo240.incrementSpeed(30);
        assertTrue(volvo240.getCurrentSpeed()>0.1);

        double beforeVol = volvo240.getCurrentSpeed();
        volvo240.gas(0.5);
        assertTrue(volvo240.getCurrentSpeed() > beforeVol);

        double beforeVol2 = volvo240.getCurrentSpeed();
        volvo240.gas(2);
        assertTrue(volvo240.getCurrentSpeed() > beforeVol2);

        double beforeVol3 = volvo240.getCurrentSpeed();
        volvo240.brake(4);
        assertTrue(volvo240.getCurrentSpeed() < beforeVol3);

        volvo240.brake(0.3);
        System.out.printf("Volvo240s speed after 2nd brake call: %s.\n", volvo240.getCurrentSpeed());
    }

    @Test
    public void testRaiseFlatbedPreventsDriving() {
        Scania scania = new Scania();

        scania.RaiseFlatbed(50);
        scania.startEngine();
        scania.gas(1.0);

        assertEquals(0, scania.getCurrentSpeed());
    }

    @Test
    public void testCanDriveWhenFlatbedIsDown() {
        Scania scania = new Scania();
        scania.startEngine();

        scania.gas(1.0);

        assertTrue(scania.getCurrentSpeed() > 0);
    }

    @Test
    public void testCannotRaiseFlatbedWhileMoving() {
        Scania scania = new Scania();
        scania.startEngine();
        scania.gas(1.0);

        scania.RaiseFlatbed(50);

        assertEquals(0, scania.getFlatBedAngle());
    }

}