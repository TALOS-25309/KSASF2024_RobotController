package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class WheelPart {
    private DcMotor motorFL, motorFR, motorBL, motorBR;

    public WheelPart(HardwareMap hardwareMap){
        motorFL = hardwareMap.get(DcMotor.class, "FrontLeft");
        motorFR = hardwareMap.get(DcMotor.class, "FrontRight");
        motorBL = hardwareMap.get(DcMotor.class, "BackLeft");
        motorBR = hardwareMap.get(DcMotor.class, "BackRight");

    }

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
        motorBL.setPower(wheelSpeed * -direction.label()[2]);
        motorBR.setPower(wheelSpeed * direction.label()[3]);
    }


}
