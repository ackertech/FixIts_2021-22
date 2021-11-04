package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Grant {
    //Declaring variables for my motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    // Required to run our robot
    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp){this.linearOp = linearOp;}

    //Common Method for motor Run mode
    public final DcMotor .RunMode currentMotorRunMode = DcMotor .RunMode .RUN_WITHOUT_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);

    }

    // Stops the Motors
    public void stopMotor () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
    }

    // Drives Forward
    public void driveForward(double power) {

       double ABSpower = Math.abs(power);
       frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);

    }

    // Drives Backward
    public void driveBackward(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }


    // Rotates Left
    public void rotateLeft(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);

    }


    // Rotates Right
    public void rotateRight(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }
















}
