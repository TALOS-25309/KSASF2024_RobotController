package org.firstinspires.ftc.teamcode.mainop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.part.ArmPart;
import org.firstinspires.ftc.teamcode.part.LinearArmPart;
import org.firstinspires.ftc.teamcode.part.LinearBasketPart;
import org.firstinspires.ftc.teamcode.part.WheelPart;
import org.firstinspires.ftc.teamcode.part.BasketPart;

@TeleOp(name = "KSASF", group = "")
public class TeleOpMain extends OpMode{


    private WheelPart wheelPart;
    private ArmPart armPart;
    private LinearArmPart linearArmPart;
    private LinearBasketPart linearBasketPart;
    private BasketPart basketPart;


    public void init(){
        this.armPart = new ArmPart(hardwareMap);
        this.wheelPart = new WheelPart(hardwareMap);
        this.linearArmPart = new LinearArmPart(hardwareMap);
        this.linearBasketPart = new LinearBasketPart(hardwareMap);
        this.basketPart = new BasketPart(hardwareMap);
    }

    boolean last_circle = false;
    boolean last_square = false;

    public void start(){

    }

    public void loop(){

        if(gamepad1.dpad_up){
            // 직진
            this.wheelPart.move(WheelPart.Direction.MOVE_FW);
        }
        else if(gamepad1.dpad_down){
            // 후진
            this.wheelPart.move(WheelPart.Direction.MOVE_BW);
        }
        else if(gamepad1.dpad_left){
            // 왼쪽 이동
            this.wheelPart.move(WheelPart.Direction.MOVE_L);
        }
        else if(gamepad1.dpad_right){
            // 오른쪽 이동
            this.wheelPart.move(WheelPart.Direction.MOVE_R);
        }
        else if(gamepad1.left_bumper){
            // 왼쪽 회전
            this.wheelPart.move(WheelPart.Direction.ROTATE_L);
        }
        else if(gamepad1.right_bumper){
            // 오른쪽 회전
            this.wheelPart.move(WheelPart.Direction.ROTATE_R);
        }
        else{
            this.wheelPart.stop();
        }



        // 수평 리니어 + 집게
        if(gamepad1.square){
            if(!last_square){
                if(this.linearArmPart.expanded){
                    this.linearArmPart.set_pos(LinearArmPart.Direction.BW);
                    Thread.sleep(500);
                    this.armPart.hand.close();
                    Thread.sleep(500);
                    this.armPart.arm.raise();
                }
                else{
                    linearArmPart.set_pos(LinearArmPart.Direction.FW);
                    Thread.sleep(500);
                    this.armPart.hand.open();
                    Thread.sleep(500);
                    this.armPart.arm.lower();
                }
            }
            last_square = true;
        }
        else{
            last_square = false;
        }




        // 수직 리니어 + 바구니
        if(gamepad1.circle) {
            if(!last_circle){
                this.linearBasketPart.to_expand = !this.linearBasketPart.to_expand;
                this.basketPart.move();
                if(this.armPart.arm.raised){
                    this.armPart.hand.open();
                    this.armPart.arm.lower();
                }

            }
            last_circle = true;
        }
        else{
            last_circle = false;
        }

        this.linearBasketPart.move();

    }

}
