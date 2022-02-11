package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth.DentalHealth_Alen2;

@Autonomous (name = "Skynet Auto")

public class AutonomousSkyNet extends LinearOpMode {

    //Specify the robot class to construct
    Skynet_Sarah Bot = new Skynet_Sarah();

    //We are adding in the code that is personal to the robot here
    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);

        telemetry.addLine("Awaiting start");
        telemetry.update();

        //waiting for drive to press start on drive control system
        waitForStart();



    while(opModeIsActive()) {


        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(850);
        Bot.stopMotors();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(650);
        Bot.stopMotors();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.turnRight(1);
        sleep(1000);
        Bot.stopMotors();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(650);
        Bot.stopMotors();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.turnRight(0.5);
        sleep(1000);
        Bot.stopMotors();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(650);
        Bot.stopMotors();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.turnRight(1);
        sleep(1000);
        Bot.stopMotors();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(1000);
        Bot.stopMotors();

        telemetry.addLine("Turning Left");
        telemetry.update();
        Bot.turnLeft(1);
        sleep(1000);
        Bot.stopMotors();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveBackward(1);
        sleep(850);
        Bot.stopMotors();

        // Stay in the loop until drive says stop
        requestOpModeStop();

    }

    idle();

    }
}


