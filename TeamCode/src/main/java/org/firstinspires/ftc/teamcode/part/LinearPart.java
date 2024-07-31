package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LinearPart {
    private Servo servoLinearL, servoLinearR;

    public LinearPart(HardwareMap hardwareMap){
        servoLinearL = hardwareMap.get(Servo.class, "LinearL");
        servoLinearR = hardwareMap.get(Servo.class, "LinearR");
        servoLinearL.setDirection(Servo.Direction.FORWARD);
        servoLinearR.setDirection(Servo.Direction.REVERSE);
    }

    public enum Direction {
        FW(1),
        BW(-1)
        ;

        private final int label;
        Direction(int label) {
            this.label = label;
        }
        public int label() {
            return label;
        }
    }

    double final_pos = 0;
    double last_pos = 0;
    double linearSpeed = 0.1; // 실제 조종 후 수정 필요


    public void set_pos(Direction direction){
        if(direction == Direction.FW){
            this.final_pos=0.45;
        }
        else{
            this.final_pos=0.35;
        }
        this.servoLinearL.setPosition(final_pos+0.025);
        this.servoLinearR.setPosition(final_pos-0.25);

    }


    // 오른쪽 왼쪽 서보가 다르게 작동되야함
    public void move(Direction direction){
        this.final_pos = this.last_pos + direction.label() * this.linearSpeed;
        if(0<this.final_pos && this.final_pos<1){
            this.servoLinearL.setPosition(final_pos);
            this.servoLinearR.setPosition(final_pos);

            this.last_pos = this.final_pos;
        }
    }


}
