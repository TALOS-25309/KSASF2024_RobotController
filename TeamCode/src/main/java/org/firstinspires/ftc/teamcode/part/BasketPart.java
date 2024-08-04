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
            servoBasket.setPosition(0.65);
            this.moved = false;
        }

    }

}
