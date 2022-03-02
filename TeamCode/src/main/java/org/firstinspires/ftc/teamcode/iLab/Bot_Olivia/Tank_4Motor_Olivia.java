package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Tank_4Motor_Olivia {


    // Defines the motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;


    //Required code to operate a robot
    public LinearOpMode linearOp = null;

    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }


    // This is a method for setting motor behavior
    public void setMotorRunModes(DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    // Common Method Have Robot Moving
    // The parentheses represent the perimeter/ ability to move of the robot

    public void stopMotors() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }


    //Common Method for Making Robot Drive Forward
    // Same as note in code up above
    public void driveForward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(ABSpower);

    }

    public void driveBackwards (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearRightMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(-ABSpower);
    }

    public void turnLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearRightMotor.setPower(ABSpower);

    }

    public void turnRight (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        rearLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearRightMotor.setPower(-ABSpower);

    }
}
