package org.firstinspires.ftc.teamcode.iLab.Bot_Jetsam_Camden.Control;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.iLab.Bot_Jetsam_Camden.Robot.Jetsam_Bot_Camden;

@Disabled
@TeleOp(name = "Jetsam:Camden:FirstDrive")
public class TelOp extends OpMode {

    public Jetsam_Bot_Camden Bot = new Jetsam_Bot_Camden();

    double speedMultiply = 1;

    public void init() {

        Bot.initJetsam(hardwareMap);
    }

    public void loop() {

        flagControl();
        drive();
        slowDrive();
       // ledControl();
        candyLaunch();
        launcherStop();
        thumbsUp();
        roadRage();
        surferWave();
        highFive();
        wave();
        fist();
    }

    public void stop() {


    }

    public void slowDrive() {

        if (gamepad1.dpad_down) {
            speedMultiply = 0.5;
        } else if (gamepad1.dpad_up) {
            speedMultiply = 1;
        }
    }

    public void drive() {

        if (gamepad1.left_stick_y > .1) {

            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y < -.1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x > .1) {

            Bot.turnRight(speedMultiply * gamepad1.left_stick_x);
        } else if (gamepad1.left_stick_x < -.1) {

            Bot.turnLeft(speedMultiply * gamepad1.left_stick_x);
        } else {

            Bot.stopMotors();
        }
    }

    public void flagControl() {

        if (gamepad1.right_bumper) {
            Bot.raiseFlag();
        }
        if (gamepad1.left_bumper) {
            Bot.lowerFlag();
        }


    }
/**
    public void ledControl() {

        if (gamepad1.a) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.CONFETTI);
        } else if (gamepad1.b) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.STROBE_GOLD);
        } else if (gamepad1.y) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE);
        }

    }
**/
    public void candyLaunch() {

        if (gamepad1.right_stick_button) {
            Bot.Launcher.setPower(1);
        }

    }

    public void launcherStop() {

        if (gamepad1.left_stick_button) {
            Bot.Launcher.setPower(0);
        }

    }





    public void thumbsUp() {

        if (gamepad2.b) {
            Bot.pinkyF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.ringF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.thumbF.setPosition(1);
        }

        else {
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.pinkyF.setPosition(0);
        }
    }


    public void roadRage() {        //ONLY USE WHEN NECESSARY

        if (gamepad2.left_stick_button)

        {
            Bot.pinkyF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.ringF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(1);
        }

        else {
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.pinkyF.setPosition(0);
        }

    }


    public void surferWave() {

        if (gamepad2.y)
        {
            Bot.middleF.setPosition(0);
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(1);
            Bot.pinkyF.setPosition(1);
        }

        else {
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.pinkyF.setPosition(0);
        }
    }

    public void highFive() {

        if (gamepad2.x)
        {
            Bot.pinkyF.setPosition(1);
            Bot.thumbF.setPosition(1);
            Bot.indexF.setPosition(1);
            Bot.ringF.setPosition(1);
            Bot.middleF.setPosition(1);
        }

        else {
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.pinkyF.setPosition(0);
        }
    }

     public void wave() {

        if (gamepad2.right_stick_button)
        {
            highFive();
            fist();
            highFive();
            fist();
            highFive();
            fist();
        }
        else {
            Bot.ringF.setPosition(0);
            Bot.thumbF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.pinkyF.setPosition(0);
        }
    } 

    public void fist() {

        if (gamepad2.right_bumper) {

            Bot.pinkyF.setPosition(0);
            Bot.middleF.setPosition(0);
            Bot.ringF.setPosition(0);
            Bot.indexF.setPosition(0);
            Bot.thumbF.setPosition(0);
        }

            else {
                Bot.ringF.setPosition(0);
                Bot.thumbF.setPosition(0);
                Bot.indexF.setPosition(0);
                Bot.middleF.setPosition(0);
                Bot.pinkyF.setPosition(0);
            }
    }


    }

