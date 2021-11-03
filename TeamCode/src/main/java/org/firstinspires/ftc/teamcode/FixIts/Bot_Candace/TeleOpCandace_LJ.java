package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Base.Robot.LabBot;

@TeleOp(name = "TeleOp:TeleOpCandace_LJ", group = "Bot_Candace")
public class TeleOpCandace_LJ extends OpMode {
    public double speedMultiply = 0.50;

    public Candace_LJ Bot = new Candace_LJ();

    @Override
    public void init() {
        Bot.initRobot(hardwareMap);
    }
    @Override
    public void loop() {
        drive();
        speedControl();


    }

    public void drive() {

        if (gamepad1.left_stick_y > .1) {
            Bot.driveForward(gamepad1.left_stick_y * speedMultiply);
        } else if (gamepad1.left_stick_y < -.1) {
            Bot.driveFBackward(gamepad1.left_stick_y * speedMultiply);
        } else if (gamepad1.left_stick_x > .1) {
            Bot.rotateRight(gamepad1.left_stick_x * speedMultiply);
        } else if (gamepad1.left_stick_x < -.1) {
            Bot.rotateLeft(gamepad1.left_stick_x * speedMultiply);
        } else {
            Bot.stopMotor();

        }
    }
    public void speedControl(){
        if(gamepad1.dpad_right) {
            speedMultiply = 0.25;
        }
        else if (gamepad1.dpad_down){
            speedMultiply=0.50;
        }
        else if (gamepad1.dpad_left){
            speedMultiply=0.75;
        }
        else if (gamepad1.dpad_up){
            speedMultiply=1.00;
        }
    }
}



