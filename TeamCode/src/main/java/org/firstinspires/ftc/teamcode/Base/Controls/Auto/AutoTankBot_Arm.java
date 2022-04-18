package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Base.Mechanisms.ArmHand;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@Autonomous(name = "TankBot ASL Hand")

public class AutoTankBot_Arm extends LinearOpMode {

    TankBot Bruno = new TankBot();
    ArmHand Handy = new ArmHand();

    @Override
    public void runOpMode() throws InterruptedException {

        Bruno.initRobot(hardwareMap);
        Handy.initArmHand(hardwareMap);

        Bruno.setLinearOp(this);
        Handy.setLinearOp(this);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){

            telemetry.addLine("Waiting for ASL Gesture");
            telemetry.update();

            Handy.raiseArm();
            sleep(1500);
            Handy.openWrist();
            Handy.signSentence("Hello");
            Handy.closeWrist();
            sleep(1500);
            Handy.lowerArm();

            sleep(2000);

            Handy.raiseArm();
            sleep(1500);
            Handy.openWrist();
            Handy.signSentence("I love robots");
            Handy.closeWrist();
            sleep(1500);
            Handy.lowerArm();

            sleep(2000);

            Handy.raiseArm();
            sleep(1500);
            Handy.openWrist();
            Handy.signSentence("Goodbye");
            Handy.closeWrist();
            sleep(1500);
            Handy.lowerArm();

            requestOpModeStop();

        }

        idle();

    }


}
