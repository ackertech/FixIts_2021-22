package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class FourMotorDrive {

    //Declaring variables for my motors
    public DcMotor leftMotor1;
    public DcMotor rightMotor1;
    public DcMotor rightMotor2;
    public DcMotor leftMotor2;

    //Required to run our robot
    public LinearOpMode linearOp = null;

    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }

    //Common Method for Motor Run mode
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double Ticks_Per_Rotation = 538;

    public void setMotorRunModes (DcMotor.RunMode mode){

        leftMotor1.setMode(mode);
        rightMotor1.setMode(mode);
        leftMotor2.setMode(mode);
        rightMotor2.setMode(mode);
    }
    public void stopMotor() {
        leftMotor1.setPower(0);
        rightMotor1.setPower(0);
        leftMotor2.setPower(0);
        rightMotor2.setPower(0);

    }


    public void driveForward(double power) {

        double ABSPower = Math.abs(power);
        leftMotor1.setPower(ABSPower);
        rightMotor1.setPower(ABSPower);
        leftMotor2.setPower(ABSPower);
        rightMotor2.setPower(ABSPower);

    }
    public void driveBackward(double power){

        double ABSPower=Math.abs(power);

        leftMotor1.setPower(-ABSPower);
        rightMotor1.setPower(-ABSPower);
        leftMotor2.setPower(-ABSPower);
        rightMotor2.setPower(-ABSPower);
    }

    public void rotateLeft(double power){

        double ABSPower=Math.abs(power);
        leftMotor1.setPower(ABSPower);
        leftMotor2.setPower(ABSPower);
        rightMotor2.setPower(-ABSPower);
        rightMotor1.setPower(-ABSPower);

    }

    public void rotateRight(double power){
        double ABSPower=Math.abs(power);
        leftMotor1.setPower(-ABSPower);
        leftMotor2.setPower(-ABSPower);
        rightMotor2.setPower(ABSPower);
        rightMotor1.setPower(ABSPower);
    }

}
