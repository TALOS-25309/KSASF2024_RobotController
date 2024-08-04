package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BasketPart {
    private Servo servoBasket;
    private boolean moved = false;

    public BasketPart(HardwareMap hardwareMap){
        servoBasket = hardwareMap.get(Servo.class, "servoBasket");
    }


    public void move(){
        if(!this.moved){
            servoBasket.setPosition(0);
            this.moved = true;
        }
        else{
            try {
                int total_time = 700;
                int resolution = 700;
                for (int i = 0; i < resolution; i++) {
                    servoBasket.setPosition(0.65 / (double)resolution * (double)i);
                    Thread.sleep(total_time / resolution);
                }
                this.moved = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
