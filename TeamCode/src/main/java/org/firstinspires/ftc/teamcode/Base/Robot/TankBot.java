package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.Tank_FourMotorDrive;
import org.firstinspires.ftc.teamcode.Base.Drivetrains.Tank_TwoMotorDrive;

import java.util.concurrent.TimeUnit;

public class TankBot extends Tank_FourMotorDrive {

    // Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;

    // Robot Physical Constructor used in TeleOp and Autonomous classes
    public TankBot() { }
    public ElapsedTime timer = new ElapsedTime();

    // Custom Method that will initialize the robot hardware in TeleOp and Autonomous

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;

        //Define the name of the motors used in the control hub configuration
        frontLeftMotor =  hwBot.dcMotor.get("front_left_motor"); // Port 0
        rearLeftMotor =  hwBot.dcMotor.get("rear_left_motor");  // Port 1
        frontRightMotor = hwBot.dcMotor.get("front_right_motor"); //Port 2
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor"); // Port 3

        //Sets the direction of the robot's motors based on physical placement
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Define this robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    public void pause (double pauseTime) {
        timer.reset();
        while (timer.milliseconds() < pauseTime) {
            linearOp.telemetry.addData("Timer (ms): ", timer.milliseconds());
            linearOp.telemetry.update();
        }
        timer.reset();
    }


}





