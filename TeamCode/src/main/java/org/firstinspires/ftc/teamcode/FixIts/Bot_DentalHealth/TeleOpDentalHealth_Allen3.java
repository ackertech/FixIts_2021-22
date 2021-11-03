package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp:DentalHealth_Allen3", group = "Bot_Dental")
public class TeleOpDentalHealth_Allen3 extends OpMode {

    public double speedMultiply = 0.50;

    public DentalHealth_Allen3 Bot = new DentalHealth_Allen3();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop() {
        drive();
        speedControl();
    }

    public void drive() {

        if (gamepad1.left_stick_y > 0.1) {

            Bot.driveForward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_y < -0.1) {
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x > 0.1) {
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        } else if (gamepad1.left_stick_x < -0.1) {
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
        } else {
            Bot.stopMotor();
        }
    }

    public void speedControl() {

        if (gamepad1.dpad_right) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.50;
        } else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_up == true) {
            speedMultiply = 1.0;
        }
    }
}