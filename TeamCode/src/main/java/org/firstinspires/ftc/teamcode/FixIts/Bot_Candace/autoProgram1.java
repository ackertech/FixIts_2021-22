package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//@Disabled
@Autonomous (name = "Candace AutonomousProgram")

public class autoProgram1 extends LinearOpMode {

    Candace_Nate Bot = new Candace_Nate();

    @Override

    public void runOpMode() throws InterruptedException {
        Bot.initRobot(hardwareMap);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();


    while (opModeIsActive()) {
        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(1500);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(500);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(800);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(500);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(800);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(500);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(800);
        Bot.stopMotor();

        telemetry.addLine("Turning Left");
        telemetry.update();
        Bot.rotateLeft(0.5);
        sleep(500);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(1);
        sleep(800);
        Bot.stopMotor();


    }

//..

}

}
