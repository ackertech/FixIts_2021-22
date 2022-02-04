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
        Bot.rotateRight(1);
        sleep(2000);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(1000);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.rotateRight(1);
        sleep(2000);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(1000);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.rotateRight(1);
        sleep(2000);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(1000);
        Bot.stopMotor();

        telemetry.addLine("Driving Forward");
        telemetry.update();
        Bot.rotateRight(1);
        sleep(2000);
        Bot.stopMotor();

        telemetry.addLine("Turning Right");
        telemetry.update();
        Bot.rotateRight(0.5);
        sleep(1000);
        Bot.stopMotor();

        // Stay in the loop until drive presses stop
        requestOpModeStop();

    }

    idle();

    }
}


