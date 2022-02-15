package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Twomotordrive_Sarah {


    //Declare Variables for the Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;



    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) {this.linearOp = linearOp;}


    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        backLeftMotor.setMode(mode);
        backRightMotor.setMode(mode);

    }
    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

    }

    public void driveForward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
        backLeftMotor.setPower(ABSpower);
        backRightMotor.setPower(ABSpower);

    }

    public void driveBackward (double power) {
        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
        backRightMotor.setPower(-ABSpower);
        backLeftMotor.setPower(-ABSpower);
    }

    // JDA - Check Motors Variables Below.  Do you have one of each?
    public void turnLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
        backLeftMotor.setPower(-ABSpower);
        backRightMotor.setPower(ABSpower);
    }
    // JDA - Check Motors Variables Below.  Do you have one of each?
    public void turnRight (double power) {
        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
        backLeftMotor.setPower(ABSpower);
        backRightMotor.setPower(-ABSpower);
    }

}