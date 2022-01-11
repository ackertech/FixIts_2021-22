package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FourMotorDrive {

    //Declaring variables for my motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearRightMotor;
    public DcMotor rearLeftMotor;

    //Required to run our robot
    public LinearOpMode linearOp = null;

    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }

    //Common Method for Motor Run mode
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double Ticks_Per_Rotation = 538;

    public void setMotorRunModes (DcMotor.RunMode mode){

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }
    public void stopMotor() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

    }


    public void driveForward(double power) {

        double ABSPower = Math.abs(power);
        frontLeftMotor.setPower(ABSPower);
        frontRightMotor.setPower(ABSPower);
        rearLeftMotor.setPower(ABSPower);
        rearRightMotor.setPower(ABSPower);

    }
    public void driveBackward(double power){

        double ABSPower=Math.abs(power);

        frontLeftMotor.setPower(-ABSPower);
        frontRightMotor.setPower(-ABSPower);
        rearLeftMotor.setPower(-ABSPower);
        rearRightMotor.setPower(-ABSPower);
    }

    public void rotateLeft(double power){

        double ABSPower=Math.abs(power);
        frontLeftMotor.setPower(ABSPower);
        rearLeftMotor.setPower(ABSPower);
        rearRightMotor.setPower(-ABSPower);
        frontRightMotor.setPower(-ABSPower);

    }

    public void rotateRight(double power){
        double ABSPower=Math.abs(power);
        frontLeftMotor.setPower(-ABSPower);
        rearLeftMotor.setPower(-ABSPower);
        rearRightMotor.setPower(ABSPower);
        frontRightMotor.setPower(ABSPower);
    }

}
