package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.AllWheelDrive;
import org.firstinspires.ftc.teamcode.Base.Drivetrains.Tank_FourMotorDrive;

public class HammerHead extends AllWheelDrive {

    // Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;


    // Robot Physical Constructor used in TeleOp and Autonomous classes
    public HammerHead() {

    }

    // Custom Method that will initialize the robot hardware in TeleOp and Autonomous

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;

        //Define the name of the motors used in the control hub configuration
        frontLeftMotor =  hwBot.dcMotor.get("frontLeft"); //
        rearLeftMotor =  hwBot.dcMotor.get("rearLeft");
        frontRightMotor = hwBot.dcMotor.get("frontRight");
        rearRightMotor = hwBot.dcMotor.get("rearRight");

        //Sets the direction of the robot's motors based on physical placement
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);

        //Define this robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }


}





