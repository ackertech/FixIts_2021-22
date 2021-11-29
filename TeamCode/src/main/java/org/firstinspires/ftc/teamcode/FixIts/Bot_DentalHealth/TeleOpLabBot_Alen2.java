package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "DentalHealth_Alen2", group = "Bot_Dental")
public class TeleOpLabBot_Alen2 extends OpMode {

    public double speedMultiply = 0.50;

    public DentalHealth_Alen2 Bot = new DentalHealth_Alen2();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

        Bot.lowerFlag();

    }

    @Override
    public void loop() {

        drive();
        speedControl();

        flagControl();

    }

    public void drive () {

        if (gamepad1.left_stick_y > 0.1) {
            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -0.1) {
            Bot.driveBackword(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > 0.1) {
            Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
        }
        else if (gamepad1.left_stick_x < -0.1) {
            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
        }
        else {
            Bot.stopMotor();
        }

    }

    public void speedControl() {
        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;
        }
        else if (gamepad1.dpad_down) {
            speedMultiply = 0.5;
        }
        else if (gamepad1.dpad_left) {
            speedMultiply = 0.75;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1.0;
        }
    }
//Control methods for lowering and the raising the flag

    public void flagControl () {

        if (gamepad1.a) {
            Bot.raiseFlag();
        }

        else if (gamepad1.y) {
            Bot.lowerFlag();

        }

        else if (gamepad1.x) {
            Bot.waveFlagLeft();

        }

        else if (gamepad1.b) {
            Bot.waveFlagRight();

        }

        else if (gamepad1.left_bumper) {
            Bot.initFlag();

        }

    }

    public void ledControl () {

        if (gamepad1.left_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_OCEAN_PALETTE);
        } else if (gamepad1.right_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_OCEAN_PALETTE);
        }
    }
}

