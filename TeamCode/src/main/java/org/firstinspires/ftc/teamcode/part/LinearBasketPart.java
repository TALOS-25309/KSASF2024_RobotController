package org.firstinspires.ftc.teamcode.part;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearBasketPart {
    private DcMotor dcLinear;
    private boolean expanded = false;

    public LinearBasketPart(HardwareMap hardwareMap){
        dcLinear = hardwareMap.get(DcMotor.class, "dcLinear");
        dcLinear.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcLinear.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    public enum Direction {
        UP(-1),
        DOWN(1),
        STOP(0)
        ;

        private final int label;
        Direction(int label) {
            this.label = label;
        }
        public int label() {
            return label;
        }
    }

    // private
    private double power = 1;
    public void move(Direction direction){
        dcLinear.setPower(direction.label());
    }
}
