package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Robot.LabBot_4Motor;

// *****  Autonomous with Internal Encoders *********

@Disabled
@Autonomous(name = "LabBot:4M:Square:With Enc")

public class AutoLabot_4Motor_With extends LinearOpMode {

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
            Bot.driveForward(1,1,4);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1,1,4);

            //We are now at the top left corner of the square

            telemetry.addLine("Turning Right at First Corner");
            telemetry.update();
            Bot.rotateRight(1,1,4);

            telemetry.addLine("Driving Forward to Second Corner");
            telemetry.update();
            Bot.driveForward(1,1,4);

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
