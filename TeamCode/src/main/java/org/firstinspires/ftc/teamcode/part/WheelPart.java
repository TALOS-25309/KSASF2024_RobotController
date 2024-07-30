package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.DcMotor;


public class WheelPart {
    private DcMotor motorFL, motorFR, motorBL, motorBR;

    private double wheelSpeed = 0.5;

    public void stop(){
        motorFL.setPower(0);
        motorFR.setPower(0);
        motorBL.setPower(0);
        motorBR.setPower(0);
    }


    public enum Direction {
        MOVE_FW(new int[]{1,1,1,1}),
        MOVE_BW(new int[]{-1,-1,-1,-1}),
        MOVE_L(new int[]{-1,1,1,-1}),
        MOVE_R(new int[]{1,-1,-1,1}),
        ROTATE_L(new int[]{-1,1,-1,1}),
        ROTATE_R(new int[]{1,-1,1,-1})
        ;

        private final int[] label;

        Direction(int[] label) {
            this.label = label;
        }

        public int[] label() {
            return label;
        }
    }


    public void move(Direction direction) {
        motorFL.setPower(wheelSpeed * direction.label()[0]);
        motorFR.setPower(wheelSpeed * direction.label()[1]);
        motorBL.setPower(wheelSpeed * direction.label()[2]);
        motorBR.setPower(wheelSpeed * direction.label()[3]);
    }

//    public void moveForward(){
//        move(Direction.MOVE_FW);
//    }
//
//    public void moveBackward(){
//        motorFL.setPower(wheelSpeed * -1);
//        motorFR.setPower(wheelSpeed * -1);
//        motorBL.setPower(wheelSpeed * -1);
//        motorBR.setPower(wheelSpeed * -1);
//    }
//
//    public void moveLeft(){
//        motorFL.setPower(wheelSpeed * -1);
//        motorFR.setPower(wheelSpeed * 1);
//        motorBL.setPower(wheelSpeed * 1);
//        motorBR.setPower(wheelSpeed * -1);
//    }
//
//    public void moveRight(){
//        motorFL.setPower(wheelSpeed * 1);
//        motorFR.setPower(wheelSpeed * -1);
//        motorBL.setPower(wheelSpeed * -1);
//        motorBR.setPower(wheelSpeed * 1);
//    }


}
