package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Johntavious_Nick extends TwoMotorDrive_Nick {

   public HardwareMap hwBot = null;

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

   }

}
