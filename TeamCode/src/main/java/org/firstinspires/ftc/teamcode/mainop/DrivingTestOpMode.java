package org.firstinspires.ftc.teamcode.mainop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.part.ArmPart;
import org.firstinspires.ftc.teamcode.part.LinearArmPart;
import org.firstinspires.ftc.teamcode.part.LinearBasketPart;
import org.firstinspires.ftc.teamcode.part.WheelPart;

@TeleOp(name = "Driving Test", group = "")
public class DrivingTestOpMode extends OpMode{
    private DcMotor motorFL, motorFR, motorBL, motorBR;

    public void init(){
        motorFL = hardwareMap.get(DcMotor.class, "FrontLeft");
        motorFR = hardwareMap.get(DcMotor.class, "FrontRight");
        motorBL = hardwareMap.get(DcMotor.class, "BackLeft");
        motorBR = hardwareMap.get(DcMotor.class, "BackRight");
    }

    public void start(){

    }

    public void loop(){
        double leftStickX = gamepad1.left_stick_x;
        double leftStickY = gamepad1.left_stick_y;
        double rightStickX = gamepad1.right_stick_x;
        double rightStickY = gamepad1.right_stick_y;

        // -45 degree rotation
        double left_x = leftStickX * Math.cos(Math.PI/4) - leftStickY * Math.sin(Math.PI/4);
        double left_y = leftStickX * Math.sin(Math.PI/4) + leftStickY * Math.cos(Math.PI/4);
        double right_x = rightStickX * Math.cos(Math.PI/4) - rightStickY * Math.sin(Math.PI/4);
        double right_y = rightStickX * Math.sin(Math.PI/4) + rightStickY * Math.cos(Math.PI/4);

        motorFR.setPower(-right_y);
        motorBL.setPower(left_y);
        motorFL.setPower(left_x);
        motorBR.setPower(right_x);
    }
}
