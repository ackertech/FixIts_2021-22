package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Gregory_Charlie extends TwoMotorDrive_Charlie {

    public HardwareMap hwBot = null;

    public Gregory_Charlie() {
    }

    public void initRobot(HardwareMap hwMap) {

        hwBot = hwMap;
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

}

// push jda2