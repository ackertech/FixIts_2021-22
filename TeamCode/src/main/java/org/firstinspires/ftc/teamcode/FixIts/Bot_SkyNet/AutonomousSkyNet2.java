package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;




@Autonomous(name = "Skynet Auto 2")

public class AutonomousSkyNet2 extends LinearOpMode {

    //Specify the robot class to construct
    Skynet_Sarah Bot = new Skynet_Sarah();

    //We are adding in the code that is personal to the robot here
    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);


        //waiting for drive to press start on drive control system
        waitForStart();


        while (opModeIsActive()) {

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1, 1);

            telemetry.addLine("Turning Right at First Corner");
            telemetry.update();
            Bot.turnRight(1, 1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1, 1);

            telemetry.addLine("Turning Right at Second Corner");
            telemetry.update();
            Bot.turnRight(1, 1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1, 1);

            telemetry.addLine("Turning Left at Third Corner");
            telemetry.update();
            Bot.turnLeft(1, 1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(1, 1);

            Bot.stopMotors();


        }
    }
}