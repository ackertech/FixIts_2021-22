package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

public class DentalHealth_Alen1 extends TwoMotorDrive_Alen1 {

   public HardwareMap hwDentalHealth = null;

public DentalHealth_Alen1 () {

    }

    public void Brushing_Teeth (HardwareMap hwMap) {

    hwDentalHealth = hwMap;

    frontLeftMotor = hwDentalHealth.dcMotor.get("front_left_motor");
    frontRightMotor = hwDentalHealth.dcMotor.get("front_right_motor");

    frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
    frontRightMotor.setDirection(DcMotor.Direction.FORWARD);

    setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    



    }

}
