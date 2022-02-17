package org.firstinspires.ftc.teamcode.Base.Drivetrains;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class AllWheelDrive {


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

    public void driveForward (double power) {

        frontLeftMotor.setPower(Math.abs(power));
        frontRightMotor.setPower(Math.abs(power));
        rearLeftMotor.setPower(Math.abs(power));
        rearRightMotor.setPower(Math.abs(power));

    }

    public void driveBackward (double power) {

        frontLeftMotor.setPower(-Math.abs(power));
        frontRightMotor.setPower(-Math.abs(power));
        rearLeftMotor.setPower(-Math.abs(power));
        rearRightMotor.setPower(-Math.abs(power));
    }

    public void turnLeft (double power) {

        frontLeftMotor.setPower(-Math.abs(power));
        rearLeftMotor.setPower(-Math.abs(power));
        frontRightMotor.setPower(Math.abs(power));
        rearRightMotor.setPower(Math.abs(power));
    }

    public void turnRight (double power) {

        frontLeftMotor.setPower(Math.abs(power));
        rearLeftMotor.setPower(Math.abs(power));
        frontRightMotor.setPower(-Math.abs(power));
        rearRightMotor.setPower(-Math.abs(power));
    }

    public void driveForward (double FL,double FR,double RL,double RR) {

        frontLeftMotor.setPower(Math.abs(FL));
        frontRightMotor.setPower(Math.abs(FR));
        rearLeftMotor.setPower(Math.abs(RL));
        rearRightMotor.setPower(Math.abs(RR));
    }

    public void driveBackward (double FL,double FR,double RL,double RR) {

        frontLeftMotor.setPower(-Math.abs(FL));
        frontRightMotor.setPower(-Math.abs(FR));
        rearLeftMotor.setPower(-Math.abs(RL));
        rearRightMotor.setPower(-Math.abs(RR));

    }

    public void turnLeft (double FL,double FR,double RL,double RR) {

        frontLeftMotor.setPower(-Math.abs(FL));
        frontRightMotor.setPower(Math.abs(FR));
        rearLeftMotor.setPower(-Math.abs(RL));
        rearRightMotor.setPower(Math.abs(RR));

    }

    public void turnRight (double FL,double FR,double RL,double RR) {

        frontLeftMotor.setPower(Math.abs(FL));
        frontRightMotor.setPower(-Math.abs(FR));
        rearLeftMotor.setPower(Math.abs(RL));
        rearRightMotor.setPower(-Math.abs(RR));

    }



}

