package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Johntavius_Grant extends TwoMotorDrive_Grant{

    public HardwareMap hwBot = null;

    public Johntavius_Grant () {

    }

    public void initRobot (HardwareMap hwMap) {

     hwBot = hwMap;
     frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
     frontRightMotor = hwBot.dcMotor.get("front_right_motor");

     frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
     frontRightMotor.setDirection(DcMotor.Direction.REVERSE);

     setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
     setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

     frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
     frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }



}
