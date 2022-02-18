package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//@Disabled
@Autonomous (name = "Candace AutonomousProgram2")

public class autoProgram2 extends LinearOpMode {

    Candace_Nate Bot = new Candace_Nate();

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
            Bot.driveForward(.5, 7);

            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(.5, 4);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(.5, 7);


            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(.5, 4);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(.5, 7);


            telemetry.addLine("Turning Right");
            telemetry.update();
            Bot.rotateRight(.5, 4);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(.5, 7);
            Bot.stopMotor();

            telemetry.addLine("Turning Left");
            telemetry.update();
            Bot.rotateLeft(.5, 4);

            telemetry.addLine("Driving Forward");
            telemetry.update();
            Bot.driveForward(.5, 7);
            Bot.stopMotor();


        }

//..

    }

}