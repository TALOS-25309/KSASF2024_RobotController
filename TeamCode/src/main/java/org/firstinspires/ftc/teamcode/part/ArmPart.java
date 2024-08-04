package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmPart {
    private Servo servoHand, servoArm;
    public Arm arm;
    public Hand hand;

    public ArmPart(HardwareMap hardwareMap){
        servoHand = hardwareMap.get(Servo.class, "servoHand");
        servoArm = hardwareMap.get(Servo.class, "servoArm");
        this.hand = new Hand();
        this.arm = new Arm();
    }

    // 집게손
    public class Hand{
        private boolean opened = true;

        public void move(){
            if(this.opened){
                servoHand.setPosition(0.35);
                this.opened = false;
            }else{
                servoHand.setPosition(0.6);
                this.opened = true;
            }
        }

    }

    // 손목
    public class Arm{
        public boolean raised = false;

        public void move(){
            if(this.raised){
                servoArm.setPosition(0);
                this.raised = false;
            }else{
                servoArm.setPosition(1);
                this.raised = true;
            }
        }
    }


    // 함께 움직임
    public void move_together(){

        try {
            this.hand.move();
            Thread.sleep(500);
            this.arm.move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
