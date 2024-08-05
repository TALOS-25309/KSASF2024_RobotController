package org.firstinspires.ftc.teamcode.part;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearBasketPart {
    public DcMotor dcLinear;
    public boolean to_expand = false;

    public LinearBasketPart(HardwareMap hardwareMap){
        dcLinear = hardwareMap.get(DcMotor.class, "dcLinear");
        dcLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcLinear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dcLinear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


    public enum Direction {
        UP(-1700),
        DOWN(-50),
        ;

        private final int label;
        Direction(int label) {
            this.label = label;
        }
        public int label() {
            return label;
        }
    }

    public void move(){

        if(this.to_expand){
            if(this.dcLinear.getCurrentPosition() > Direction.UP.label()){
                this.dcLinear.setPower(-0.6);
            }
            else{
                this.dcLinear.setPower(0);
            }
        }

        else{
            if(this.dcLinear.getCurrentPosition() < Direction.DOWN.label()){
                this.dcLinear.setPower(0.6);
            }
            else{
                this.dcLinear.setPower(0);
            }
        }
    }
}
