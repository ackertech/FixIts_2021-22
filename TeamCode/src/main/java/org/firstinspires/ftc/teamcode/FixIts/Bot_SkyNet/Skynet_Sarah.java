package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Skynet_Sarah extends Twomotordrive_Sarah{

    public HardwareMap hwBot = null;

    public Skynet_Sarah () {

    }

    public void initRobot (HardwareMap HwMap) {

        hwBot = HwMap;

        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");

        frontRightMotor = hwBot.dcMotor.get("front_left_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
}
