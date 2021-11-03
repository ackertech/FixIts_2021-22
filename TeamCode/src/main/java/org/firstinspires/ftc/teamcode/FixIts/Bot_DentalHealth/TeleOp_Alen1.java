package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;
//@Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;


@TeleOp( name = "TeleOp:DentalHealth_Alen1" , group = "Bot_Dental")
public class TeleOp_Alen1 extends OpMode {

    //TeleOp Variables
    public double speedMultiply = 0.50;          // Start at 50% speed

    // Specific which robot class to construct (aka physically use and implement)
    public DentalHealth_Alen1 Bot = new DentalHealth_Alen1();

    // TeleOp init method. This is the init button on the driver station phone
    @Override
    public void init() {

        Bot.Brushing_Teeth(hardwareMap);

    }

    @Override
    public void loop() {

        drive();
        speedscontrol();


    }

    public void drive() {
        if (gamepad1.left_stick_y > 0.1)
            Bot.driveFroward(speedMultiply * gamepad1.left_stick_y);

        else if (gamepad1.left_stick_y < -0.1)
            Bot.driveBackward(speedMultiply * gamepad1.left_stick_y);

        else if (gamepad1.left_stick_x < 0.1)
            Bot.rotateLeft(speedMultiply * gamepad1.left_stick_x);

        else if (gamepad1.left_stick_x < -0.1)
            Bot.rotateRight(speedMultiply * gamepad1.left_stick_x);


        else {
            Bot.stopMotors();

        }


    }

    public void speedscontrol() {

        if (gamepad1.dpad_right == true) {
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











