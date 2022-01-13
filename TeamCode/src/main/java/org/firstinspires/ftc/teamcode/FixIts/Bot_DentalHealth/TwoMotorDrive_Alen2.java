package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Alen2 {

    //Declaring variables for the motors

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;


    // Required to run our robot
    public LinearOpMode linearOp = null;

    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }

    //Common Method for Motor Run mode
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);

    }

    public void stopMotor() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
    }

    public void driveForward(double power) {




        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(ABSpower);
    }

    public void driveBackword(double power) {



        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(-ABSpower);


    }

    public void rotateRight(double power) {


        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(ABSpower);
    }

    public void rotateLeft(double power) {


        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(-ABSpower);

    }
}