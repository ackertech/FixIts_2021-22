package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp(name = "SkyNet_Sarah", group = "Bot_SkyNet")
public class TeleOpSkyNet_Sarah extends OpMode {

    public double speedMultiply = 0.50;

    public Skynet_Sarah Bot = new Skynet_Sarah();

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
        ledControl();

    }


    public void drive() {

        if (gamepad1.left_stick_y < -.1) {
            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y > 0.1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > 0.1) {

            Bot.turnLeft(speedMultiply * gamepad1.left_stick_x);
        }
        else if (gamepad1.left_stick_x < -0.1) {

            Bot.turnRight(speedMultiply * gamepad1.right_stick_x);

        } else {

            Bot.stopMotors();
        }


    }

    public void speedControl() {

        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.75;

        } else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_up == true) {
            speedMultiply = 0.75;
        }
    }

    public void flagControl () {
        if (gamepad1.y) {
            Bot.raiseFlag();
        }
        else if (gamepad1.a)  {
            Bot.lowerFlag();
        }
        else if (gamepad1.x) {
            Bot.waveFlagLeft();
        }
        else if (gamepad1.b) {
            Bot.waveFlagRight();
        }

    }


 public void ledControl () {

        if (gamepad1.left_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE);
        }
        else if (gamepad1.right_trigger < 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE);
        }
 }


}
