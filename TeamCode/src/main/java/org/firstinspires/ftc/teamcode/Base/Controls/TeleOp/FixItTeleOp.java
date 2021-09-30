package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Base.Robot.FixItBot;

@Disabled
@TeleOp(name = "TeleOp:FixIts", group = "FixIt")

public class FixItTeleOp extends OpMode {

    //TeleOp Variables
    public double speedMultiply = 1;

    // Construct the Physical Bot based on the Robot Class
    public FixItBot Bot = new FixItBot();


    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init()    {

        Bot.initRobot(hardwareMap);
        Bot.lowerFlag();
    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone

    public void loop () {

        drive();
        flagControl();
        ledControl();
        speedControl();
        Bot.christmasPattern();

    }



    // The control methods for driving the  Robot during TeleOp

    public void drive(){

        if (gamepad1.left_stick_y > .1) {

            Bot.driveForward( speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_y < -.1) {

            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > .1) {

            Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
        }
        else if (gamepad1.left_stick_x < -.1) {

            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
        }
        else {

            Bot.stopMotors();
        }
    }


    //Control Methods for lowering and rasing the flag

    public void flagControl () {

        if (gamepad1.a) {
            Bot.raiseFlag();
        }
        else if (gamepad1.b)  {
            Bot.lowerFlag();
        }

    }

    // Control methods for changing the LED Lights
    //SHORT_RED, SHORT_BLUE, SHORT_WHITE, COLOR_WAVES_LAVA_PALETTE, COLOR_WAVES_OCEAN_PALETTE, STROBE_RED, STROBE_BLUE, STROBE_WHITE

    public void ledControl () {

        if (gamepad1.left_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE);
        } else if (gamepad1.right_trigger > 0.1) {
            Bot.setLedPattern(RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE);
        }
    }

    // Control methods for changing speed
    public void speedControl() {

        if (gamepad1.dpad_down) {
            speedMultiply = 0.5;
        }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1;
        }
    }








}
