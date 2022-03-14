package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class Tank_FourMotorDrive {


    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;


    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }


    public void setMotorRunModes (DcMotor.RunMode mode) {               //sets the mode/behavior for the motor

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);

    }

    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }




    public void tankDriveForward (double power) {

        frontLeftMotor.setPower(Math.abs(power));
        frontRightMotor.setPower(Math.abs(power));
        rearLeftMotor.setPower(Math.abs(power));
        rearRightMotor.setPower(Math.abs(power));

    }

    public void tankDriveBackward (double power) {

        frontLeftMotor.setPower(-Math.abs(power));
        frontRightMotor.setPower(-Math.abs(power));
        rearLeftMotor.setPower(-Math.abs(power));
        rearRightMotor.setPower(-Math.abs(power));
    }

    public void tankTurnLeft (double power) {

        frontLeftMotor.setPower(-Math.abs(power));
        rearLeftMotor.setPower(-Math.abs(power));
        frontRightMotor.setPower(Math.abs(power));
        rearRightMotor.setPower(Math.abs(power));
    }

    public void tankTurnRight (double power) {

        frontLeftMotor.setPower(Math.abs(power));
        rearLeftMotor.setPower(Math.abs(power));
        frontRightMotor.setPower(-Math.abs(power));
        rearRightMotor.setPower(-Math.abs(power));
    }

    public void tankDrive (double leftPower, double rightPower) {

        frontLeftMotor.setPower(leftPower);
        rearLeftMotor.setPower(leftPower);

        frontRightMotor.setPower(rightPower);
        rearRightMotor.setPower(rightPower);
    }


}

