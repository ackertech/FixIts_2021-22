package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Base.Robot.LabBot;

@Disabled
@Autonomous (name = "LabBot:Auto")

public class LabBotAuto extends LinearOpMode {

    // Specific which robot class to construct (aka physically use and implement).
    LabBot Bot = new LabBot();

    // We are choosing to add our own code instead of the code in superclass.
    @Override

    public void runOpMode() throws InterruptedException {

        // Initialize our robot hardware based om the robot class we chose.
        Bot.initRobot(hardwareMap);

        //Provide drive feedback and status to the Drive Control system.
        telemetry.addLine("Awaiting Start");
        telemetry.update();

        // Waiting for drive to press Start on Drive Control system.
        waitForStart();

        // Do the below while the TeleOp Op mode is active (drive has not pressed Stop)
        while (opModeIsActive()){

            /*  Robot will try to drive a square
                1. Update status for drive
                2. then drive or turn for X seconds
            */

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);
            Bot.driveForward(1);

            // Stay in the loop until drive presses Stop
            requestOpModeStop();

        }

        idle();

        }

}
