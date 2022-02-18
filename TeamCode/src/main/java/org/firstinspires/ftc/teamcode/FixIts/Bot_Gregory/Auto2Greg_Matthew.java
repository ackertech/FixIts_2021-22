package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Auto2Greg_Matthew")

public class Auto2Greg_Matthew extends LinearOpMode {
    Gregory_Matthew Bot = new Gregory_Matthew();

    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.75,7);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.75,1);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.75,1);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.75,1);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.75,1);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(0.75,1);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.75,1);

            telemetry.addLine("Turning Left");
            telemetry.update();
            Bot.rotateLeft(0.75,0.75);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(0.75,1);

            requestOpModeStop();


        }

        idle();

    }


}
