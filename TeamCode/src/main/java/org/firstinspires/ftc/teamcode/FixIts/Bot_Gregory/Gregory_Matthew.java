package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.TwoMotorDrive;
import org.firstinspires.ftc.teamcode.Base.Robot.LabBot;

public class Gregory_Matthew extends TwoMotorDrive_Matthew {

    public HardwareMap hwBot = null;

    public Servo flag = null;

    public RevBlinkinLedDriver ledLights;
    public RevBlinkinLedDriver.BlinkinPattern ledPattern;

    public Gregory_Matthew () {

    }

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");

        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        flag = hwBot.get(Servo.class,"flag");
        flag.setDirection(Servo.Direction.FORWARD);

        ledLights = hwBot.get(RevBlinkinLedDriver.class, "led_strip");
        ledPattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE;
        ledLights.setPattern(ledPattern);
    }
    public void raiseFlag() {
        flag.setPosition(0.5);
    }
    public void lowerFlag() {
        flag.setPosition(0.9);
    }

    public void initFlag() {
        flag.setPosition(0.2);
    }
    public void waveFlagRight() {
        flag.setPosition(0.399);
    }
    public void waveFlagLeft() {
        flag.setPosition(0.711);
    }

    public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
        ledLights.setPattern(patternName);
    }
}



