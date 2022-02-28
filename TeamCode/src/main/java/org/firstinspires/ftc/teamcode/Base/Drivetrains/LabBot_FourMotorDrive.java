package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class LabBot_FourMotorDrive {

    // Declared Variables for our Motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

    //Tracking elapsed runtime
    public ElapsedTime runtime = new ElapsedTime();

    // This is just required as part of the FIRST SDK.  Memorize it!!!
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {

        this.linearOp = linearOp;
    }

    // Declared two constants for our motor run modes
   public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    //Common method that can be used in our TeleOp and Autonomous programs
    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    // Movement methods

    // Stops the Motors
    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }

    // Drives Forward
    public void driveForward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(ABSpower);
    }

    // Drives Backwards
    public void driveBackward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(-ABSpower);
    }

    //Rotates Left
    public void rotateLeft (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(ABSpower);

    }

    //Rotates Right
    public void rotateRight (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(-ABSpower);
    }

    //******Drive without Encoder Methods********
    public void driveForward( double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);
        while (frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            driveForward(power);
            linearOp.telemetry.addData("Forward Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.update();
        }
        stopMotors();
    }

    public void driveBackward ( double power, double rotations){

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            driveBackward(power);
            linearOp.telemetry.addData("Backward Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.update();
        }
        stopMotors();
    }

    public void rotateLeft (double power, double rotations) {
        double ticks = Math.abs(rotations) * (-1) * TICKS_PER_ROTATION; //strafing left moves encoder towards positive infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            rotateLeft(power);
            linearOp.telemetry.addData("Turning Left Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.update();
        }
        stopMotors();
    }



    public void rotateRight (double power, double rotations) {
        double ticks = Math.abs(rotations) * TICKS_PER_ROTATION; //strafing right moves encoder towards -infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(currentMotorRunMode);

        while(frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            rotateRight(power);
            linearOp.telemetry.addData("Turning Right Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.update();
        }
        stopMotors();
    }

    //******Drive with Encoder Methods********

    public void driveForward( double power, double rotations, double timeout) {

        double ticks = Math.abs(rotations) * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_USING_ENCODER);
        runtime.reset();

        while (frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive() && runtime.seconds() < timeout) {
            driveForward(power);
            linearOp.telemetry.addData("Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.addData("RunTime: ", runtime);
            linearOp.telemetry.update();
        }
        stopMotors();
    }

    public void driveBackward ( double power, double rotations,double timeout){

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_USING_ENCODER);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive() && runtime.seconds() < timeout) {
            driveBackward(power);
            linearOp.telemetry.addData("Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.addData("RunTime: ", runtime);
            linearOp.telemetry.update();
        }
        stopMotors();
    }

    public void rotateLeft (double power, double rotations,double timeout) {
        double ticks = Math.abs(rotations) * (-1) * TICKS_PER_ROTATION; //strafing left moves encoder towards positive infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_USING_ENCODER);

        while (frontLeftMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive() && runtime.seconds() < timeout) {
            rotateLeft(power);
            linearOp.telemetry.addData("Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.addData("RunTime: ", runtime);
            linearOp.telemetry.update();
        }
        stopMotors();
    }


    public void rotateRight (double power, double rotations,double timeout) {
        double ticks = Math.abs(rotations) * TICKS_PER_ROTATION; //strafing right moves encoder towards -infinity
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_USING_ENCODER);

        while(frontLeftMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive() && runtime.seconds() < timeout) {
            rotateRight(power);
            linearOp.telemetry.addData("Ticks: ", frontLeftMotor.getCurrentPosition());
            linearOp.telemetry.addData("RunTime: ", runtime);
            linearOp.telemetry.update();
        }
        stopMotors();
    }


}
