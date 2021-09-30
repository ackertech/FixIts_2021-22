package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class TwoMotorDrive {

    // Declare Variables for the Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    // This is required as part of FIRST Tech Challenge SDK   Memorize & include.
    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp) {
        this.linearOp = linearOp;
    }

    // These are common motor variables from running with encoders (not power)
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

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


    //******Common Methods to drive with Encoder Methods********

    /*

    public void driveForward( double speed, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);
        while (frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            driveForward(speed);
        }
        stopMotors();
    }

    public void driveBackward ( double speed, double rotations){

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            driveBackward(-speed);
        }
        stopMotors();
    }

    public void rotateLeft (double speed, double rotations) {
        double ticks = Math.abs(rotations) * (-1) * TICKS_PER_ROTATION; //strafing left moves encoder towards positive infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            rotateLeft(speed);
        }
        stopMotors();
    }


    public void rotateRight (double speed, double rotations) {
        double ticks = Math.abs(rotations) * TICKS_PER_ROTATION; //strafing right moves encoder towards -infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while(frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            rotateRight(speed);
        }
        stopMotors();
    }

    */

}

