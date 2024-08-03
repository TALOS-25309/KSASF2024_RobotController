package org.firstinspires.ftc.teamcode.part;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LinearArmPart {
    private Servo servoLinearL, servoLinearR;
    public boolean expanded = true;

    public LinearArmPart(HardwareMap hardwareMap){
        servoLinearL = hardwareMap.get(Servo.class, "LinearL");
        servoLinearR = hardwareMap.get(Servo.class, "LinearR");
        servoLinearL.setDirection(Servo.Direction.FORWARD);
        servoLinearR.setDirection(Servo.Direction.REVERSE);

    }

    public enum Direction {
        FW(-1),
        BW(1)
        ;

        private final int label;
        Direction(int label) {
            this.label = label;
        }
        public int label() {
            return label;
        }
    }




    public void set_pos(Direction direction){
        if(direction == Direction.FW){
            this.final_pos=0.2;
            this.expanded = true;
        }
        else{
            this.final_pos=0.1;
            this.expanded = false;
        }
        this.servoLinearL.setPosition(final_pos+0.275);
        this.servoLinearR.setPosition(final_pos);

    }



    double final_pos = 0.1;
    double last_pos = 0.1;
    double linearSpeed = 0.002; // 실제 조종 후 수정 필요
    // 오른쪽 왼쪽 서보가 다르게 작동되야함
    public void move(Direction direction){
        this.final_pos = this.last_pos + direction.label() * this.linearSpeed;
        if(0.1<=this.final_pos && this.final_pos<=0.2){
            this.servoLinearL.setPosition(final_pos+0.275);
            this.servoLinearR.setPosition(final_pos);

            this.last_pos = this.final_pos;
        }
    }


}
