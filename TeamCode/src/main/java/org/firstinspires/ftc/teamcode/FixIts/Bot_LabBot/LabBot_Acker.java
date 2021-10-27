package org.firstinspires.ftc.teamcode.FixIts.Bot_LabBot;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LabBot_Acker extends TwoMotorDrive_Acker {

    public HardwareMap hwBot = null;

    public LabBot_Acker () {

    }

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);





    }


}
