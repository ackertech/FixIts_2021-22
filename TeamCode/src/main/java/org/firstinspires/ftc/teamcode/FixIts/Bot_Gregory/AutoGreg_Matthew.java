package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//@Disabled

@Autonomous (name = "AutoGreg_Matthew")

public class AutoGreg_Matthew extends LinearOpMode {

    Gregory_Matthew Bot = new Gregory_Matthew();

    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(2);
            sleep(800);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(1);
            sleep(800);
            Bot.stopMotors();

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(500);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(2);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(500);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(2);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(500);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(2);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Turning Left");
            telemetry.update();
            Bot.rotateLeft(0.5);
            sleep(50);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(2);
            sleep(1000);
            Bot.stopMotors();

            requestOpModeStop();

        }

        idle();

    }

}