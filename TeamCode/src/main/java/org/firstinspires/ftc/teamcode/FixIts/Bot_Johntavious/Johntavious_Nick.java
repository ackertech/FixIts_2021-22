package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Johntavious_Nick extends TwoMotorDrive_Nick {

   public HardwareMap hwBot = null;
   // define variable
   public Servo flag = null;


   public Johntavious_Nick () {

   }

   public void initRobot (HardwareMap hwMap) {

      hwBot = hwMap;
      frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
      frontRightMotor = hwBot.dcMotor.get("front_right_motor");

      frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
      frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

      setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

      frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

      //initialize
      flag = hwBot.get(Servo.class, "flag");
      flag.setDirection(Servo.Direction.FORWARD);

   }


   // movement

   public void raiseFlag() {

      flag.setPosition(0.9);
   }

   public void lowerFlag() {

      flag.setPosition(0.1);
   }

   public void initFlag() {

      flag.setPosition(0.5);
   }

   public void waveFlagRight(){

      flag.setPosition(0.3);

   }

   public void waveFlagLeft(){

      flag.setPosition(0.7);

   }

}
