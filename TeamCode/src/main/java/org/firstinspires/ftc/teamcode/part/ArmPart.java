package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmPart {
    private Servo servoHand, servoArm;
    private Arm arm;
    private Hand hand;

    public ArmPart(HardwareMap hardwareMap){
        servoHand = hardwareMap.get(Servo.class, "servoHand");
        servoArm = hardwareMap.get(Servo.class, "servoArm");
        this.hand = new Hand();
        this.arm = new Arm();
    }

    // 집게손
    public class Hand{
        private boolean opened = false;

        public void open(){
            servoHand.setPosition(0.6);
            this.opened = true;
        }

        public void close(){
            servoHand.setPosition(0.1);
            this.opened = false;
        }

    }

    // 손목
    public class Arm{
        private boolean raised = false;

        public void init(){
            lower();
        }


        public void raise(){
            servoArm.setPosition(0.1);
            this.raised = true;
        }

        public void lower(){
            servoArm.setPosition(0.6);
            this.raised = false;
        }
    }





    public void move_hand(){
        if(hand.opened){
            hand.close();
        }
        else{
            hand.open();
        }
    }

    public void move_arm(){
        if(arm.raised){
            arm.lower();
        }
        else{
            arm.raise();
        }
    }
}
