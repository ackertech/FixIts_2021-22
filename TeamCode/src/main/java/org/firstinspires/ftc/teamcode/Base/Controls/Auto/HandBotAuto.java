package org.firstinspires.ftc.teamcode.Base.Controls.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Base.Robot.HandBot;

@Disabled
@Autonomous (name = "Autonomous HandBot")

public class HandBotAuto extends LinearOpMode {

    HandBot Bot = new HandBot();
    String sentence = "Hello! I am learning sign language";
    String letter = " ";


    @Override

    public void runOpMode() throws InterruptedException {

        Bot.initHandBot(hardwareMap);

        telemetry.addLine("Awaiting Start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()){


            telemetry.addLine("Sentence : " + sentence);
            telemetry.update();

            sleep(2000);

            telemetry.addLine("ASL Spelling Begins");
            telemetry.update();

            for (int i=0; i < sentence.length(); i++) {

                letter = sentence.valueOf(i);
                telemetry.addLine("Letter : " + letter);
                telemetry.update();

                Bot.createWords(letter);
                sleep(2000);
                Bot.closeHand();

            }

            telemetry.addLine("ASL Spelling Ends");
            telemetry.update();


            requestOpModeStop();
        }

        idle();

    }

}
