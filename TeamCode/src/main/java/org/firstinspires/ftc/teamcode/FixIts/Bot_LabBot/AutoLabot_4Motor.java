package org.firstinspires.ftc.teamcode.FixIts.Bot_LabBot;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled
@Autonomous(name = "LabBot:Auto 4Motor")

public class AutoLabot_4Motor extends LinearOpMode {

    LabBot_4Motor Bot = new LabBot_4Motor();

    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initRobot(hardwareMap);


        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){



            requestOpModeStop();
        }

        idle();

    }


}
