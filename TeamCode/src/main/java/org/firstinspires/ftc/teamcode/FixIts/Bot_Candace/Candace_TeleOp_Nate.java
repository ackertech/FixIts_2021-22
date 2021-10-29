package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@TeleOp(name = "TeleOp:Candace_TeleOp_Nate")
public class Candace_TeleOp_Nate extends OpMode {
public double speedMultiply = 0.50;
public Candace_Nate Bot = new Candace_Nate();

    @Override
    public void init() {
        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop() {

        drive();
        speedControl();

    }

    public void speedControl() {
        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;

        }
        else if (gamepad1.dpad_down) {
            speedMultiply = 0.50;
        }
        else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1.0;
        }
    }
    public void drive() {

        if (gamepad1.left_stick_y > .1) {
            Bot.driveForward(gamepad1.left_stick_y * speedMultiply);
        } else if (gamepad1.left_stick_y < -.1) {
            Bot.driveBackward(gamepad1.left_stick_y * speedMultiply);
        } else if (gamepad1.left_stick_x > .1) {
            Bot.rotateRight(gamepad1.left_stick_x * speedMultiply);
        } else if (gamepad1.left_stick_x < -.1) {
            Bot.rotateLeft(gamepad1.left_stick_x * speedMultiply);
        } else {
            Bot.stopMotor();

        }
    }




}
