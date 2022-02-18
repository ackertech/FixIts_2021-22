package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Robot.LabBot_4Motor;

@Disabled
@Autonomous(name = "LabBot:4M:Square:Power")

public class AutoLabot_4Motor extends LinearOpMode {

    LabBot_4Motor Bot = new LabBot_4Motor();

    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            telemetry.addLine("Driving Forward from Start");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            //We are now at the top left corner of the square

            telemetry.addLine("Turning Right at First Corner");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward to Second Corner");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            //We are at the top right corner of the square

            telemetry.addLine("Turning Right at Second Corner");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward to Third Corner");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            //We are at the bottom right corner of the square

            telemetry.addLine("Turning Right at Third Corner");
            telemetry.update();
            Bot.rotateRight(0.5);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward to Fourth Corner ");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            //We are at the bottom left corner of the square

            telemetry.addLine("Turning Left at Fourth Corner");
            telemetry.update();
            Bot.rotateLeft(-0.5);
            sleep(1000);
            Bot.stopMotors();

            telemetry.addLine("Driving Forward to Finish");
            telemetry.update();
            Bot.driveForward(1);
            sleep(2000);
            Bot.stopMotors();

            requestOpModeStop();

        }

        idle();

    }


}
