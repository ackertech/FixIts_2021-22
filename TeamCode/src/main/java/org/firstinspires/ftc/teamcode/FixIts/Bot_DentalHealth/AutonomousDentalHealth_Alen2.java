package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "LabBot_Alen2")

public class AutonomousDentalHealth_Alen2 extends LinearOpMode {

    //Specify the robot class to construct
    DentalHealth_Alen2 Bot = new DentalHealth_Alen2();

    //We are adding in the code that is personal to the robot here
    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);

        telemetry.addLine("Awaiting start");
        telemetry.update();

        //waiting for drive to press start on drive control system
        waitForStart();



    while(

    opModeIsActive())

    {


        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(850);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(850);
        Bot.stopMotor();

        //We are now at the top left corner of the square

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(650);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(850);
        Bot.stopMotor();

        //We are at the top right corner of the square

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(650);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(850);
        Bot.stopMotor();

        //We are at the bottom right corner of the square

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(750);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(950);
        Bot.stopMotor();

        //We are at the bottom left corner of the square

        telemetry.addLine("Turning Left");
        telemetry.update();
        Bot.rotateLeft(-0.5);
        sleep(640);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.driveForward(-1);
        sleep(850);
        Bot.stopMotor();

        // Stay in the loop until drive says stop
        requestOpModeStop();

    }

    idle();

    }
}


