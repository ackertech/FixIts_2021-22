package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Base.Robot.LabBot_4Motor;

//@Disabled
@TeleOp(name = "LabBot 4Motor")
public class TeleOpLabBot_4Motor extends OpMode {

    public double speedMultiply = 0.50;
    public boolean tankDrive = true;

    public LabBot_4Motor Bot = new LabBot_4Motor();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop () {

        drive();
        speedControl();
        driveControl();

    }

    public void drive() {

        if (!tankDrive) {

            if (gamepad1.left_stick_y < -0.1) {
                Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
            } else if (gamepad1.left_stick_y > 0.1) {
                Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
            } else if (gamepad1.left_stick_x > 0.1) {
                Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
            } else if (gamepad1.left_stick_x < -0.1) {
                Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
            } else {
                Bot.stopMotors();
            }
        }
        else {

            if (gamepad1.left_stick_y < -0.1) {
                Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
            } else if (gamepad1.left_stick_y > 0.1) {
                Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
            } else if (gamepad1.right_stick_x > 0.1) {
                Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);
            } else if (gamepad1.right_stick_x < -0.1) {
                Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);
            } else {
                Bot.stopMotors();
            }

        }
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
            speedMultiply = 1.00;
        }

    }

    public void driveControl () {

        if (gamepad1.left_bumper) {
            tankDrive = true;
        }
        if (gamepad1.right_bumper) {
            tankDrive = false;
        }
    }


}
