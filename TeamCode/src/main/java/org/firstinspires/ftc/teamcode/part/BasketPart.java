package org.firstinspires.ftc.teamcode.part;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BasketPart {
    private Servo servoBasket;
    private boolean moved = false;
    private int resolution = 350;
    private int counter = 0;
    public boolean moving_down = false;
    private Telemetry telemetry;

    public BasketPart(HardwareMap hardwareMap, Telemetry telemetry){
        this.servoBasket = hardwareMap.get(Servo.class, "servoBasket");
        this.telemetry = telemetry;
    }


    public void move(){
        if(!this.moved){
            servoBasket.setPosition(0);
            this.moved = true;
            this.counter = 0;
            this.moving_down = false;
        }
        else{
            this.moved = false;
            this.moving_down = true;
        }

    }

    public void update(){
        if(this.moving_down){
            servoBasket.setPosition(0.65 / (double)this.resolution * (double)this.counter);
            if(this.counter == this.resolution) {
                this.counter = 0;
                this.moving_down = false;
            } else {
                this.counter++;
            }
        }
    }

}
