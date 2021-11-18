package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Twomotordrive_Sarah {


    //Declare Variables for the Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) {this.linearOp = linearOp;}


    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
    }
    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

    }

    public void driveForward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);

    }

    public void driveBackward (double power) {
        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
    }

    // JDA - Check Motors Variables Below.  Do you have one of each?
    public void turnLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
    }
    // JDA - Check Motors Variables Below.  Do you have one of each?
    public void turnRight (double power) {
        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
    }

}