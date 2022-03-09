package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Mechanisms.ASLHand;
import org.firstinspires.ftc.teamcode.Base.Mechanisms.ArmHand;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "TankBot ASL")

public class TankTeleOpWithArmASL extends TankTeleOpWithArm {

    //TeleOp Driving Behavior Variables
    String ASLWord = "Hello";

    // Construct the Physical Bot based on the Robot Class
    public ASLHand ASL = new ASLHand();

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone

    @Override
    public void loop() {

        speedControl();
        driveControl();
        drive();
        handControl();
        wristControl();
        elbowControl();
        lazySusanControl();
        signASL();
        telemetryOutput();

    }
    @Override
    public void telemetryOutput() {
        telemetry.addData("Drive Mode: ", driverStyle);
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Bruno.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Bruno.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor Power: ", Bruno.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power: ", Bruno.rearRightMotor.getPower());
        telemetry.addData("Elbow Position: ", Handy.elbowCurrPos );
        telemetry.addData("LazySusan Position: ", Bruno.lazySusanCurrPos );
        telemetry.addData("Hand Gesture: ", handGesture);
        telemetry.addData("Wrist Status: ", wristStatus);
        telemetry.addData("ASL Sentence: ", ASLWord);
        telemetry.update();

    }


    /**  ********  ASL METHODS USING GAMEPAD 2 *************      **/

    public void signASL() {
        if (gamepad2.dpad_up) {
            Handy.raiseArm();
            Bruno.pause(1000);
            Handy.openWrist();
            ASLWord = "I Love MBCA";
            ASL.signSentence(ASLWord);
            Handy.closeWrist();
            Bruno.pause(1000);
            Handy.lowerArm();
        }
        else if (gamepad2.dpad_down) {
            Handy.raiseArm();
            Bruno.pause(1000);
            Handy.openWrist();
            ASLWord = "I Love Robots";
            ASL.signSentence(ASLWord);
            Handy.closeWrist();
            Bruno.pause(1000);
            Handy.lowerArm();
        }
        else if (gamepad2.dpad_right) {
            Handy.raiseArm();
            Bruno.pause(1000);
            Handy.openWrist();
            ASLWord = "Hello";
            ASL.signSentence(ASLWord);
            Handy.closeWrist();
            Bruno.pause(1000);
            Handy.lowerArm();
        }
        else if (gamepad2.dpad_left) {
            Handy.raiseArm();
            Bruno.pause(1000);
            Handy.openWrist();
            ASLWord = "Goodbye";
            ASL.signSentence(ASLWord);
            Handy.closeWrist();
            Bruno.pause(1000);
            Handy.lowerArm();

        }

    }




}
