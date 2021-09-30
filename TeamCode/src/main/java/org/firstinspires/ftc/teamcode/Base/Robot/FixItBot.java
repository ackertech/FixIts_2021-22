package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.TwoMotorDrive;

import java.util.concurrent.TimeUnit;

public class FixItBot extends TwoMotorDrive {

    // Hardware Variable
    public HardwareMap hwBot = null;

    // Servo Variables
    public Servo flag = null;
    public Servo arm = null;
    public Servo bucket = null;

    // Led Variables
    public RevBlinkinLedDriver ledLights;
    public RevBlinkinLedDriver.BlinkinPattern ledPattern;
    public RevBlinkinLedDriver.BlinkinPattern patternArray[] = {
            RevBlinkinLedDriver.BlinkinPattern.GREEN,               // 0 index
            RevBlinkinLedDriver.BlinkinPattern.RED,                 // 1 index
            RevBlinkinLedDriver.BlinkinPattern.WHITE,               // 2 index
            RevBlinkinLedDriver.BlinkinPattern.HEARTBEAT_RED  };    // 3 index


    // Timer
    public ElapsedTime currentTime = new ElapsedTime();             //current Time
    public double ledTimer;                                         // LED Timer Stopwatch
    public double ledTimerIncrementer = 4;                          // 4 second incrementer
    public int ledCounter = 0;                                      // Counter for changing lights



    // Robot Physical Constructor
    public FixItBot() {

    }


    // Custom Robot Initiazition Method

    public void initRobot (HardwareMap hwMap) {

        hwBot = hwMap;

        frontLeftMotor =  hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");

        //Sets the direction of the robot's motors
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Define this robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define & Initialize Servos
        flag = hwBot.get(Servo.class, "flag");
        flag.setDirection(Servo.Direction.FORWARD);

        arm = hwBot.get(Servo.class, "arm");
        arm.setDirection(Servo.Direction.FORWARD);

        bucket = hwBot.get(Servo.class, "bucket");
        bucket.setDirection(Servo.Direction.FORWARD);

        //Define & Initialize LEDTester Lights
        ledLights = hwBot.get(RevBlinkinLedDriver.class, "led_strip");
        ledPattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE;   //https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf
        ledLights.setPattern(ledPattern);

        //Timer Reset
        currentTime.reset();

    }


    // **********************   Robot Mechanisms ***************************//

    //Flag Mechanisms using flag servo

    public void raiseFlag() {

        flag.setPosition(0.9);
    }

    public void lowerFlag() {

        flag.setPosition(0.1);

    }

    //Arm Mechanisms using arm servo

    public void raiseArm() {

        arm.setPosition(0.9);
    }

    public void lowerArm() {

        arm.setPosition(0.1);

    }

    //Bucket Mechanisms using arm servo

    public void openBucket() {

        bucket.setPosition(0.9);
    }

    public void closeBucket() {

        bucket.setPosition(0.1);

    }

    public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
                ledLights.setPattern(patternName);

    }

    public void christmasPattern () {

            ledTimer += currentTime.time(TimeUnit.SECONDS);

            if (currentTime.time(TimeUnit.SECONDS) >= (ledTimer + ledTimerIncrementer) ) {
                if (ledCounter % 2 == 0 )
                    ledLights.setPattern(patternArray[0]);
                else
                    ledLights.setPattern(patternArray[1]);
            }
            ledCounter += 1;
    }

}





