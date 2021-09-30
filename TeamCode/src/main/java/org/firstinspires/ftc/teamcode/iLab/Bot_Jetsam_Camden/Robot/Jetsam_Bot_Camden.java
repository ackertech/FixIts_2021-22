package org.firstinspires.ftc.teamcode.iLab.Bot_Jetsam_Camden.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.iLab.Bot_Jetsam_Camden.DriveTrain.DualMotorDrive1;

public class Jetsam_Bot_Camden extends DualMotorDrive1 {

    //hardware variable

    public Servo pinkyF = null;
    public Servo middleF = null;
    public Servo indexF = null;
    public Servo thumbF = null;
    public Servo ringF = null;

    public HardwareMap hwBot = null;

    public Servo flag = null;

    public DcMotor Launcher = null;

   // public RevBlinkinLedDriver ledLights;
   //   public RevBlinkinLedDriver.BlinkinPattern ledPattern;

    public Jetsam_Bot_Camden() {

    }

    public void initJetsam(HardwareMap hwMap) {

        hwBot = hwMap;

        Launcher = hwBot.dcMotor.get("launcher");


        pinkyF = hwBot.get(Servo.class, "pinkyF");
        pinkyF.setDirection(Servo.Direction.FORWARD);

        middleF = hwBot.get(Servo.class, "middleF");
        middleF.setDirection(Servo.Direction.FORWARD);

        indexF = hwBot.get(Servo.class, "indexF");
        indexF.setDirection(Servo.Direction.FORWARD);

        thumbF = hwBot.get(Servo.class, "thumbF");
        thumbF.setDirection(Servo.Direction.FORWARD);

        ringF = hwBot.get(Servo.class, "ringF");
        ringF.setDirection(Servo.Direction.FORWARD);


        rearLeftMotor = hwBot.dcMotor.get("rear_left_motor");
        rearRightMotor = hwBot.dcMotor.get("rear_right_motor");

        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.REVERSE);

        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        //servo init
        flag = hwBot.get(Servo.class, "flag");
        flag.setDirection(Servo.Direction.FORWARD);

     //   ledLights = hwBot.get(RevBlinkinLedDriver.class, "led_strip");

    //    ledPattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_LAVA_PALETTE;
     //   ledLights.setPattern((ledPattern));

    }

    //servo methods
    public void raiseFlag() {
        flag.setPosition(0.8);
    }

    public void lowerFlag() {
        flag.setPosition(0.3);
    }

   // public void setLedPattern (RevBlinkinLedDriver.BlinkinPattern patternName){
   //         ledLights.setPattern(patternName);

    }




