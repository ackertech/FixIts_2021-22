package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Robot.LabBot_4Motor;

// *****  Autonomous with Encoders & Rotations *********

//@Disabled
@Autonomous(name = "Gregory Acker Auto")

public class Auto_MrAcker extends LinearOpMode {

    Gregory_Matthew2 Bot = new Gregory_Matthew2();

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
            Bot.driveForward(.5,7);

            //We are now at the top left corner of the square

            telemetry.addLine("Turning Right at First Corner");
            telemetry.update();
            Bot.rotateRight(.5,4);

            telemetry.addLine("Driving Forward to Second Corner");
            telemetry.update();
            Bot.driveForward(.5,7);

            //We are at the top right corner of the square

            telemetry.addLine("Turning Right at Second Corner");
            telemetry.update();
            Bot.rotateRight(1,1);

            telemetry.addLine("Driving Forward to Third Corner");
            telemetry.update();
            Bot.driveForward(1,1);

            //We are at the bottom right corner of the square

            telemetry.addLine("Turning Right at Third Corner");
            telemetry.update();
            Bot.rotateRight(1,1);

            telemetry.addLine("Driving Forward to Fourth Corner ");
            telemetry.update();
            Bot.driveForward(1,1);

            //We are at the bottom left corner of the square

            telemetry.addLine("Turning Left at Fourth Corner");
            telemetry.update();
            Bot.rotateLeft(1,1);

            telemetry.addLine("Driving Forward to Finish");
            telemetry.update();
            Bot.driveForward(1,1);

            requestOpModeStop();

        }

        idle();

    }


}
