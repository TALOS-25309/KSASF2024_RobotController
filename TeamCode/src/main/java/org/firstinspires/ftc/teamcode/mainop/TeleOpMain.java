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

    boolean last_left_bumper = false;
    boolean last_circle = false;
    boolean last_triangle = false;
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
        else if(gamepad1.left_stick_x < 0){
            // 왼쪽 회전
            this.wheelPart.move(WheelPart.Direction.ROTATE_L);
        }
        else if(gamepad1.left_stick_x > 0){
            // 오른쪽 회전
            this.wheelPart.move(WheelPart.Direction.ROTATE_R);
        }
        else{
            this.wheelPart.stop();
        }



        // 집게손 + 손목 움직임

        if(gamepad1.left_bumper){
            // 닫힘 <--> 열림
            if(!last_left_bumper){
                this.armPart.move_together();
            }
            last_left_bumper = true;
        }
        else{
            last_left_bumper = false;
        }


        // 수평 리니어 움직임 - 불연속적
        if(gamepad1.triangle) {
            if(!last_triangle){
                if(this.linearArmPart.expanded){
                    this.linearArmPart.set_pos(LinearArmPart.Direction.BW);
                }else{
                    this.linearArmPart.set_pos(LinearArmPart.Direction.FW);
                }
            }
            last_triangle = true;
        }
        else{
            last_triangle = false;
        }




        // 수직 리니어 움직임
        if(gamepad1.circle) {
            if(!last_circle){
                this.linearBasketPart.to_expand = !this.linearBasketPart.to_expand;
            }
            last_circle = true;
        }
        else{
            last_circle = false;
        }

        this.linearBasketPart.move();

        telemetry.addData("Basket To Expand", this.linearBasketPart.to_expand);
        telemetry.addData("Current Pos", this.linearBasketPart.dcLinear.getCurrentPosition());
        telemetry.addLine();




        // 바구니 움직임
        if(gamepad1.square){
            if(!last_square){
                this.basketPart.move();
                if(this.armPart.arm.raised){
                    this.armPart.arm.move();
                }
            }
            last_square = true;
        }
        else{
            last_square = false;
        }

    }

}
