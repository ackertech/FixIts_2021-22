package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Allen3 {
    // Declare variables for the Motors

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;

    // This required as part of FIRST Tech Challenge SDK    Memorize & include
    public LinearOpMode linearOp =null;
    public void setLinearOp(LinearOpMode linearOp) {this.linearOp = linearOp;}
    
    // These are common motor variables from running with encoders (not power)
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;
    public static final double TICK_PER_ROTATION = 538;

    // Common Method to Set Motor Behavior or Rund Modes from the Robot Class
    public void setMotorRunModes (DcMotor.RunMode mode) {

        frontLeftMotor.setMode(mode);
        frontRightMotor.setMode(mode);
    }

    // Common Method to Stop Moving

    public void stopMotor() {


        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);

    }

    // Common Method to Drive Forward

    public void driveForward (double power) {

        double ABSpower= Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);



    }

    // Common Method to Drive Backwards

    public void driveBackward (double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(-ABSpower);
        frontRightMotor.setPower(-ABSpower);

    }

    // Cpmon Method to Turn Left (aka Rotate)

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