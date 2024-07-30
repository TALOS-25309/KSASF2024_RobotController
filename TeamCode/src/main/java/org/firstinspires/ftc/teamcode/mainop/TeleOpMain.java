package org.firstinspires.ftc.teamcode.mainop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.part.WheelPart;

public class TeleOpMain {
    private Gamepad gamepad;
    private WheelPart wheelPart;

    void start(){

    }

    void loop(){
        if(gamepad.dpad_up){
            // 직진
            wheelPart.move(WheelPart.Direction.MOVE_FW);
        }
        else if(gamepad.dpad_down){
            // 후진
            wheelPart.move(WheelPart.Direction.MOVE_BW);
        }
        else if(gamepad.dpad_left){
            // 왼쪽 이동
            wheelPart.move(WheelPart.Direction.MOVE_L);
        }
        else if(gamepad.dpad_right){
            // 오른쪽 이동
            wheelPart.move(WheelPart.Direction.MOVE_R);
        }
        else if(gamepad.x){
            // 왼쪽 회전
            wheelPart.move(WheelPart.Direction.ROTATE_L);
        }
        else if(gamepad.b){
            // 오른쪽 회전
            wheelPart.move(WheelPart.Direction.ROTATE_R);
        }
    }

}
