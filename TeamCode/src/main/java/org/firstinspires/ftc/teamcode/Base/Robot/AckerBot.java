package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Base.Drivetrains.MecanumDrive;

import java.util.concurrent.TimeUnit;


public class AckerBot extends MecanumDrive {

    //Robot Hardware Constructors

    public HardwareMap hwBot  =  null;

    // Led Variables
    public RevBlinkinLedDriver ledLights;
    public RevBlinkinLedDriver.BlinkinPattern ledPattern;
    public RevBlinkinLedDriver.BlinkinPattern patternArray[] = {
            RevBlinkinLedDriver.BlinkinPattern.GREEN,                             //0 index
            RevBlinkinLedDriver.BlinkinPattern.RED,                               //1 index
            RevBlinkinLedDriver.BlinkinPattern.WHITE,                            //2 index
            RevBlinkinLedDriver.BlinkinPattern.HEARTBEAT_RED,                    //3 index
            RevBlinkinLedDriver.BlinkinPattern.LIGHT_CHASE_RED,                  //4 index
            RevBlinkinLedDriver.BlinkinPattern.TWINKLES_FOREST_PALETTE,          //5 index
            RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_PARTY_PALETTE,       //6 index
            RevBlinkinLedDriver.BlinkinPattern.RAINBOW_PARTY_PALETTE,           //7 index
            RevBlinkinLedDriver.BlinkinPattern.SINELON_FOREST_PALETTE,           //8 index

    };


    // LED Timer
    public ElapsedTime currentTime = new ElapsedTime();
    public int ledTimer;
    public int ledTimerIncrementer  = 4;
    public int ledCounter = 0;

    // TeleOp timer
    public ElapsedTime timer = new ElapsedTime();
    double waitTime = 2.0;

    //AckerBot specific hardware
    public DcMotor launcher;
    public DcMotor camLift;
    public Servo camPivot;
    public Servo trapDoor;

    //FTC SDK Requirement
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode Op) {
        linearOp = Op;
    }


    //LabBot Constructor

    public AckerBot() {

    }


    public void initRobot(HardwareMap hwMap) {

        hwBot = hwMap;

        // Define Motors for Robot
        frontLeftMotor = hwBot.dcMotor.get("front_left_motor");
        frontRightMotor = hwBot.dcMotor.get("front_right_motor");
        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");


        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotor.Direction.REVERSE);



        //Initialize Motor Run Mode for Robot
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //Define & Initialize Candy Launcher Motors

        launcher = hwBot.dcMotor.get("launcher");
        launcher.setDirection(DcMotor.Direction.REVERSE);
        launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        camLift = hwBot.dcMotor.get("cam_lift");
        camLift.setDirection(DcMotor.Direction.FORWARD);
        camLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Define & Initialize Candy Launcher Servos

        trapDoor = hwBot.get(Servo.class, "trap_door");
        trapDoor.setDirection(Servo.Direction.REVERSE);
        closeTrapDoor();

        camPivot= hwBot.get(Servo.class, "cam_pivot");
        camPivot.setDirection(Servo.Direction.FORWARD);
        camCenter();

        //Define & Initialize LEDTester Lights

        ledLights = hwBot.get(RevBlinkinLedDriver.class, "led_strip");
        ledPattern = RevBlinkinLedDriver.BlinkinPattern.RAINBOW_PARTY_PALETTE;   //https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf
        ledLights.setPattern(ledPattern);


        //Timer Reset
        currentTime.reset();

        //
        ledCounter = 0 ;


    }


    // LED Control Methods

    public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
        ledLights.setPattern(patternName);

    }

    // Candy Launcher Methods

    public void stopLauncher () {
        launcher.setPower(0);
        launcher.setPower(0);

    }

    public void runLauncher (double power) {
        double ABSpower = Math.abs(power);
        launcher.setPower(ABSpower);
        launcher.setPower(ABSpower);

    }

    public void openTrapDoor () {
        trapDoor.setPosition(.6);

    }

    public void closeTrapDoor () {
        trapDoor.setPosition(.7);
    }


    // FPV Camera Control Methods

    public void camLeft () {
        camPivot.setPosition(.1);

    }

    public void camRight () {
        camPivot.setPosition(.9);
    }

    public void camCenter () {
        camPivot.setPosition(.5);
    }

    public void camLiftDown () {
        camLift.setPower(-1.0);
    }

    public void camLiftUp () {
        camLift.setPower(1.0);
    }

    public void camLiftStop () {

        camLift.setPower(0.0);
    }

    /**
    Hand Control Methods

    public void handWaveHand(){
        handOpenHand();
        timer.reset();
        if (timer.time() < waitTime-1) {}
        handCloseHand();
        timer.reset();
        if (timer.time() < waitTime-1) {}
        handOpenHand();
        timer.reset();
        if (timer.time() < waitTime-1) {}
        handCloseHand();
        timer.reset();
        if (timer.time() < waitTime-1) {}
        handOpenHand();
        timer.reset();
        if (timer.time() < waitTime-1) {}
        handCloseHand();
    }

    public void handCount(){
        handNumberOne();
        timer.reset();
        if (timer.time() < waitTime) {}
        handNumberTwo();
        timer.reset();
        if (timer.time() < waitTime) {}
        handNumberThree();
        timer.reset();
        if (timer.time() < waitTime) {}
        handNumberFour();
        timer.reset();
        if (timer.time() < waitTime) {}
        handNumberFive();
        timer.reset();
        if (timer.time() < waitTime+2) {}
        handCloseHand();
    }


    public void handMakeFist(){
        pinkyF.setPosition(0.2);
        indexF.setPosition(0.2);
        middleF.setPosition(0.2);
        ringF.setPosition(0.2);
        thumbF.setPosition(0.2);
    }

    public void handOpenHand(){
        pinkyF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        thumbF.setPosition(1);
    }

    public void handCloseHand(){
        pinkyF.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        thumbF.setPosition(0);
    }

    public void handHangOut(){
        pinkyF.setPosition(0.1);
        indexF.setPosition(1);
        middleF.setPosition(0.1);
        ringF.setPosition(1);
        thumbF.setPosition(0.1);
    }

    public void handThumbsUp(){
        pinkyF.setPosition(0.1);
        indexF.setPosition(0.1);
        middleF.setPosition(0.1);
        ringF.setPosition(0.1);
        thumbF.setPosition(1);
    }

    public void handNumberOne(){
        pinkyF.setPosition(0.0);
        indexF.setPosition(1);
        middleF.setPosition(0.0);
        ringF.setPosition(0.0);
        thumbF.setPosition(0);
    }

    public void handNumberTwo(){
        pinkyF.setPosition(0.0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0.0);
        thumbF.setPosition(0);
    }

    public void handNumberThree(){
        pinkyF.setPosition(0.0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        thumbF.setPosition(0);
    }

    public void handNumberFour(){
        pinkyF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        thumbF.setPosition(0);
    }

    public void handNumberFive(){
        pinkyF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        thumbF.setPosition(1);
    }

**/

}
