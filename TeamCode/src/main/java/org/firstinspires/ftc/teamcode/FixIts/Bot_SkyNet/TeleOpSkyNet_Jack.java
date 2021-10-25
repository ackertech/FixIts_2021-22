package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOP:SkyNet_Jack")
public class TeleOpSkyNet_Jack extends OpMode {

    public double speedMultiply = 0.50;

    public SkyNet_Jack Bot = new SkyNet_Jack();

    @Override
    public void init() {

        Bot.startRobot(hardwareMap);

    }
    @Override
    public void loop () {

        drive();
        speedControl();
    }

    public void drive () {

        if (gamepad1.left_stick_y > 0.1) {
            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -0.1) {
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > 0.1) {
            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x < -0.1) {
            Bot.rotateRight(speedMultiply * gamepad1.left_stick_y);
        }
        else {
            Bot.stopMotors();
        }
    }


    public void speedControl () {

        if(gamepad1.dpad_right == true) {
            speedMultiply = 0.25;

        }
        else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.50;

        }
        else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75;

        }

        else if (gamepad1.dpad_up == true) {
            speedMultiply = 1.00;

        }



    }





}
