package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Dental Auto Encoders")

public class Autonomous2DentalHealth_Alen2 extends AutonomousDentalHealth_Alen2{

    //Specify the robot class to construct
    DentalHealth_Alen2 Bot = new DentalHealth_Alen2();

    //We are adding in the code that is personal to the robot here
    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);
        Bot.setLinearOp(this);

        telemetry.addLine("Awaiting start");
        telemetry.update();

        //waiting for drive to press start on drive control system
        waitForStart();


        while (opModeIsActive()) {

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(.5,2.5);

            //This puts us in the top left corner of the square

            telemetry.addLine("Turning Right at the first corner");
            telemetry.update();
            Bot.rotateRight(.5,1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(.5,2);

            //This puts us in the top right corner of the square

            telemetry.addLine("Turning Right at the first corner");
            telemetry.update();
            Bot.rotateRight(.5,1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(.5,2);

            //This puts us in the bottom left corner of the square

            telemetry.addLine("Turning Right at the first corner");
            telemetry.update();
            Bot.rotateRight(.5,1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(.5,2);

            //This puts us in the bottom left corner of the square

            telemetry.addLine("Turning Left at the first corner");
            telemetry.update();
            Bot.rotateLeft(.5,1);

            telemetry.addLine("Driving Forward in Square");
            telemetry.update();
            Bot.driveForward(.5,3);

        }

        idle();

    }
}
