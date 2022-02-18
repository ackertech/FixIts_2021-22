package org.firstinspires.ftc.teamcode.Base.ZArchive;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Base.ZArchive.Arm_Bot;

@Disabled
@TeleOp(name = "ArmBot")

public class ArmBotTeleOp extends OpMode {

    //  boolean elbowMove = false;
    //  boolean shoulderMove = false;

    public Arm_Bot Bot = new Arm_Bot();

    public void init() {

        Bot.initArmBot(hardwareMap);
        Bot.elbowJ.setPosition(Bot.elbowCurrPos);
        //Bot.shoulderJ.setPosition(Bot.shoulderCurrPos);

    }

    public void loop() {

        handControl();
        wristControl();
        elbowControl();
        telemetry.addData("Elbow Current Pos", Bot.elbowCurrPos);

    }

    public void handControl() {

        if (gamepad1.a) {
            Bot.point();
        } else if (gamepad1.b) {
            Bot.openHand();
        } else if (gamepad1.y) {
            Bot.peace();
        } else if (gamepad1.right_bumper) {
            Bot.surferWave();
        } else if (gamepad1.x) {
            Bot.thumbsUp();
        } else {
            Bot.closeHand();
        }
    }


    public void elbowControl() {

        if (gamepad1.dpad_up  && Bot.elbowCurrPos < Bot.elbowMaxPos)
        {
            Bot.elbowCurrPos += Bot.elbowIncrements;
            Bot.elbowJ.setPosition(Bot.elbowCurrPos);
        }
        else {
            Bot.elbowJ.setPosition(Bot.elbowCurrPos);
        }

        if (gamepad1.dpad_down  && Bot.elbowCurrPos > Bot.elbowMinPOs)
        {
            Bot.elbowCurrPos -= Bot.elbowIncrements;
            Bot.elbowJ.setPosition(Bot.elbowCurrPos);
        }
        else {
            Bot.elbowJ.setPosition(Bot.elbowCurrPos);
        }
    }

    public void shoulderControl() {

        if (gamepad1.dpad_left  && Bot.shoulderCurrPos < Bot.shoulderMaxPos)
        {
            Bot.shoulderCurrPos += Bot.shoulderIncrements;
            Bot.shoulderJ.setPosition(Bot.shoulderCurrPos);
        }
        else {
            Bot.shoulderJ.setPosition(Bot.shoulderCurrPos);
        }

        if (gamepad1.dpad_right  && Bot.shoulderCurrPos > Bot.shoulderMinPos)
        {
            Bot.shoulderCurrPos -= Bot.shoulderIncrements;
            Bot.shoulderJ.setPosition(Bot.shoulderCurrPos);
        }
        else {
            Bot.shoulderJ.setPosition(Bot.shoulderCurrPos);
        }
    }

    public void wristControl() {
        if (gamepad1.left_trigger > 0.1) {

            Bot.openWrist();
        }
        else if (gamepad1.right_trigger > 0.1) {

            Bot.halfWrist();
        }
        else {

            Bot.closeWrist();

        }

    }

}
