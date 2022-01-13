package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Skynet_Sarah extends Twomotordrive_Sarah{

    public RevBlinkinLedDriver ledLights;
    public HardwareMap hwBot = null;
    public Servo flag = null;

    public Skynet_Sarah () {

    }



    public void initRobot (HardwareMap HwMap) {

        hwBot = HwMap;

        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");

        frontRightMotor = hwBot.dcMotor.get("front_right_motor");

        backLeftMotor = hwBot.dcMotor.get("back_left_motor");

        backRightMotor = hwBot.dcMotor.get("back_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);

        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        backRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        flag = hwBot.get(Servo.class, "flag");

        flag.setDirection(Servo.Direction.FORWARD);




    }

    public void initFlag() {
        flag.setPosition(0.95);
    }
    public void raiseFlag() {
        flag.setPosition(0.57);
    }
    public void lowerFlag() {
        flag.setPosition(0.95);
    }
    public void waveFlagRight() {
        flag.setPosition(0.75);
    }
    public void waveFlagLeft() {
        flag.setPosition(0.35);
    }

    public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {

        ledLights.setPattern(patternName);
    }


}