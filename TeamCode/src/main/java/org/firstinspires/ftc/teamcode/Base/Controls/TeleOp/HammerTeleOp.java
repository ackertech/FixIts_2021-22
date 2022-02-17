package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Base.Robot.HammerHead;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "Hammer Drive")

public class HammerTeleOp extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedMultiply = .50;
    public String driveStyle = "arcade1Stick";

    public double leftSidePower;
    public double rightSidePower;

    // Construct the Physical Bot based on the Robot Class
    public HammerHead Bot = new HammerHead();


    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {

        speedControl();
        driveControl();
        drive();

    }

    // The control methods for driving the  Robot during TeleOp

    public void drive() {

        switch (driveStyle) {

            case "arcade1Stick":
                telemetry.addData("Drive Mode: ", driveStyle);
                telemetry.update();

                if (gamepad1.left_stick_y < -0.1) {
                    Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y > 0.1) {
                    Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_x > 0.1) {
                    Bot.turnRight(speedMultiply * gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.1) {
                    Bot.turnLeft(speedMultiply * gamepad1.left_stick_x);
                } else {
                    Bot.stopMotors();
                }

            case "arcade2Stick":
                telemetry.addData("Drive Mode: ", driveStyle);
                telemetry.update();

                if (gamepad1.left_stick_y < -0.1) {
                    Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y > 0.1) {
                    Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
                } else {
                    Bot.stopMotors();
                }
                if (gamepad1.right_stick_x > 0.1) {
                    Bot.turnRight(speedMultiply * gamepad1.right_stick_x);
                } else if (gamepad1.right_stick_x < -0.1) {
                    Bot.turnLeft(speedMultiply * gamepad1.right_stick_x);
                } else {
                    Bot.stopMotors();
                }


        }
    }

    // Set Drive Mode

    public void driveControl () {

            if (gamepad1.left_bumper) { driveStyle = "arcade1Stick"; }
            if (gamepad1.right_bumper) { driveStyle = "arcade2Stick"; }

    }

     // Control methods for changing speed
     public void speedControl () {

            if (gamepad1.dpad_right) {
                speedMultiply = 0.25;
            } else if (gamepad1.dpad_down) {
                speedMultiply = 0.50;
            } else if (gamepad1.dpad_left) {
                speedMultiply = 0.75;
            } else if (gamepad1.dpad_up) {
                speedMultiply = 1.00;
            }
    }

}
