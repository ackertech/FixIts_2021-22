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
        Bot.initFlag();
    }

    @Override
    public void loop() {

        drive();
        speedControl();
        flagControl();
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
        if (gamepad1.left_stick_y > 0.1) {
            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -0.1) {
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > 0.1) {
            Bot.rotateRight(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x < -0.1) {
            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_y);
        }
        else {
            Bot.stopMotor();
        }
    }
    public void flagControl() {
        if (gamepad1.y) {
            Bot.raiseFlag();
        }
        else if (gamepad1.a) {
            Bot.lowerFlag();
        }
        else if (gamepad1.b) {
            Bot.waveFlagLeft();
        }
        else if (gamepad1.x) {
            Bot.waveFlagRight();
        }
    }



}
