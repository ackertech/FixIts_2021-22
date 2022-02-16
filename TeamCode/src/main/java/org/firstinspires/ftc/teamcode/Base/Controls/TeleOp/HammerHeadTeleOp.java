package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Robot.HammerHead;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "HammerHead Drive")

public class HammerHeadTeleOp extends OpMode {

    //TeleOp Variables
    public double speedMultiply = 1;
    public boolean tankDrive = false;
    public boolean arcadeDrive = true;

    //Motor Drive and Power Variables
    double leftStickYVal;
    double leftStickXVal;
    double rightStickXVal;
    double rightStickYVal;

    double frontLeftSpeed;
    double frontRightSpeed;
    double rearLeftSpeed;
    double rearRightSpeed;

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

        leftStickYVal = gamepad1.left_stick_y;
        leftStickXVal = gamepad1.left_stick_x;
        rightStickYVal = gamepad1.right_stick_y;
        rightStickXVal = gamepad1.right_stick_x;

        frontLeftSpeed = leftStickYVal + leftStickXVal + rightStickXVal;
        frontRightSpeed = leftStickYVal - leftStickXVal - rightStickXVal;
        rearLeftSpeed = leftStickYVal - leftStickXVal + rightStickXVal;
        rearRightSpeed = leftStickYVal + leftStickXVal - rightStickXVal;


        if (arcadeDrive) {

            if (gamepad1.left_stick_y < -0.1) {
                Bot.driveForward(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else if (gamepad1.left_stick_y > 0.1) {
                Bot.driveBackward(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else if (gamepad1.left_stick_x > 0.1) {
                Bot.turnRight(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else if (gamepad1.left_stick_x < -0.1) {
                Bot.turnLeft(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else {
                Bot.stopMotors();
            }
        }
        else if (tankDrive) {

            if (gamepad1.left_stick_y < -0.1) {
                Bot.driveForward(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else if (gamepad1.left_stick_y > 0.1) {
                Bot.driveBackward(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            }
            else {
                Bot.stopMotors();
            }

            if (gamepad1.right_stick_x > 0.1) {
                Bot.turnRight(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            } else if (gamepad1.right_stick_x < -0.1) {
                Bot.turnLeft(frontLeftSpeed,frontRightSpeed,rearLeftSpeed,rearRightSpeed);
            }
            else {
                Bot.stopMotors();
            }

        }
    }

    // Set Drive Mode

    public void driveControl () {

        if (gamepad1.left_bumper) {
            tankDrive = true;
            arcadeDrive = false;
        }
        if (gamepad1.right_bumper) {
            tankDrive = false;
            arcadeDrive = true;
        }
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
