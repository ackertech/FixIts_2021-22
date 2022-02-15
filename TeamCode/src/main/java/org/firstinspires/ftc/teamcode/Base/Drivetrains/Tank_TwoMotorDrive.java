package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class Tank_TwoMotorDrive {

    // Declare Variables for the Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    // This is required as part of FIRST Tech Challenge SDK   Memorize & include.
    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }


    // Common Method to Set the Motor Behavior or Run Modes from the Robot Class
    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);

    }

    // Common Method to Stop Moving

    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

    }

    // Common Method to Drive Forward

    public void driveForward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
;

    }

    // Common Method to Drive Backwards

    public void driveBackward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }

    // Common Method to Turn Left (aka Rotate)

    public void rotateLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
    }

    // Common Method to Turn Right (aka Rotate)

    public void rotateRight (double power) {
        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }




}

