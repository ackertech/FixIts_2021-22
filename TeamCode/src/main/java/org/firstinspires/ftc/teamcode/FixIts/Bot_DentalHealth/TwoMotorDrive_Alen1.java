package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class TwoMotorDrive_Alen1 {

 //Declaring variables for my motors
 public DcMotor frontLeftMotor;
 public DcMotor frontRightMotor;

   // rewired to run our robot
   public LinearOpMode linearOp = null;
   public void setLinearOp(LinearOpMode linearOp) {  this.linearOp = linearOp; }

   // Common Method for motor run mode
    public final DcMotor.RunMode currentMotorRunMode = DcMotor.RunMode.RUN_USING_ENCODER;
    public static final double TICKS_PER_ROTATION = 538;



   public void setMotorRunModes (DcMotor.RunMode mode) {

       frontLeftMotor.setMode(mode);
       frontRightMotor.setMode(mode);

   }

   public  void stopMotors () {
       frontLeftMotor.setPower(0);
       frontRightMotor.setPower(0);
               
   }

   //Common method for driving forward
    public void driveFroward(double power) {

        double ABSpower = Math.abs(power);
        frontLeftMotor.setPower(ABSpower);
        frontRightMotor.setPower(ABSpower);

    }
        public void driveBackward ( double power){

            double ABSpower = Math.abs(power);
            frontLeftMotor.setPower(-ABSpower);
            frontRightMotor.setPower(-ABSpower);


        }

        public void rotateLeft ( double power){

            double ABSpower = Math.abs(power);
            frontLeftMotor.setPower(ABSpower);
            frontRightMotor.setPower(-ABSpower);

        }

        public void rotateRight ( double power){

            double ABSpower = Math.abs(power);
            frontLeftMotor.setPower(-ABSpower);
            frontRightMotor.setPower(ABSpower);

        }
    }
