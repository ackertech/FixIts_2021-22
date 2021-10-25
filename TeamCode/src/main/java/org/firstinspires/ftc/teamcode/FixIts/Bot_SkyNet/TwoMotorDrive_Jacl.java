package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Jacl {

    //Declaring variables for my motors
    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    // Required to run our robot
    public LinearOpMode LinearOP = null;

    public void setLinearOP(LinearOpMode LinearOp) {
        this.LinearOP = LinearOp;
    }

    //Common Method for Motor Run mode
    public final DcMotor.RunMode CurrentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;

    public void setMotorRunModes(DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);

    }

    public void stopMotors () {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
    }

    public void driveForward(double power) {

        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);
    }


    public void driveBackward(double power) {

        double ABSpower = Math.abs(power);

        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }

    public void rotateLeft(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(ABSpower);
    }

    public void rotateRight(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(-ABSpower);
    }
}
