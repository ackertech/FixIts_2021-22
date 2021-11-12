package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.TwoMotorDrive;
import org.firstinspires.ftc.teamcode.Base.Robot.LabBot;

public class Gregory_Matthew extends TwoMotorDrive {

    public HardwareMap hwBot = null;

    public Servo flag = null;

    public Gregory_Matthew () {

    }

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");

        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        flag = hwBot.get(Servo.class,"flag");
        flag.setDirection(Servo.Direction.FORWARD);
    }
    public void raiseFlag() {
        flag.setPosition(0.9);
    }
    public void lowerFlag() {
        flag.setPosition(0.1);
    }

    public void initFlag() {
        flag.setPosition(0.1);
    }
    public void waveFlagRight() {
        flag.setPosition(0.25);
    }
    public void waveFlagLeft() {
        flag.setPosition(0.75);
    }
}



