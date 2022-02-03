package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Nick {

    //Declaring variables for my motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;

    //Required to run our robot
    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) { this.linearOp = linearOp; }

    //Common Method for Motor Run mode
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        backLeftMotor.setMode(mode);
        backRightMotor.setMode(mode);

    }

    public void stopMotor() {
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

    public void driveBackward (double power){

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
        backLeftMotor.setPower(-ABSpower);
        backRightMotor.setPower(-ABSpower);

    }

    public void rotateLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
        backLeftMotor.setPower(-ABSpower);
        backRightMotor.setPower(ABSpower);

    }

    public void rotateRight (double power) {
        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
        backLeftMotor.setPower(ABSpower);
        backRightMotor.setPower(-ABSpower);
    }
}



