package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Johntavious_Nick", group = "Bot_Johntavious")

public class TeleOpJohntavious_Nick extends OpMode {

    public double speedMultiply = 0.50;

    public Johntavious_Nick Bot = new Johntavious_Nick();

    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    @Override
    public void loop () {

        drive();
        speedControl();

    }

    public void drive () {

       if (gamepad1.left_stick_y > 0.1) {

           Bot.driveForward(speedMultiply * gamepad1.left_stick_y);

       }

       else if (gamepad1.left_stick_y < - 0.1) {

           Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);
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

    public void speedControl () {

       if (gamepad1.dpad_right) {
           speedMultiply = 0.25;
       }

       else if (gamepad1.dpad_down) {
           speedMultiply = 0.50;
       }

       else if (gamepad1.dpad_left) {
           speedMultiply = 0.50;
       }

       else if (gamepad1.dpad_up) {
           speedMultiply = 1.0;

       }


    }

}

