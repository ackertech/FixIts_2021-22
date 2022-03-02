package org.firstinspires.ftc.teamcode.Base.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmHand {

    // Define Hand Variables
    public Servo pinkyF = null;
    public Servo middleF = null;
    public Servo indexF = null;
    public Servo thumbF = null;
    public Servo ringF = null;

    //Define Arm Variables
    public Servo elbow = null;
    public Servo wrist = null;

    //Set Positioning for Arm or Hand
    public double elbowMaxPos = 0.5;
    public double elbowMinPOs = 0.18;
    public double elbowCurrPos = 0.18;
    public double elbowIncrements = 0.0005;

    //Hardware Constructors
    public HardwareMap hwBot = null;
    public ArmHand() {}

    //Allows us to leverage telemetry and sleep
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {

        this.linearOp = linearOp;
    }

    //Hardware Initialization
    public void initArmHand(HardwareMap hwMap) {

        hwBot = hwMap;

        //Expansion Hub Port 0
        pinkyF = hwBot.get(Servo.class, "pinky");
        pinkyF.setDirection(Servo.Direction.FORWARD);

        //Expansion Hub Port 1
        ringF = hwBot.get(Servo.class, "ring");
        ringF.setDirection(Servo.Direction.FORWARD);

        //Expansion Hub Port 2
        middleF = hwBot.get(Servo.class, "middle");
        middleF.setDirection(Servo.Direction.FORWARD);

        //Expansion Hub Port 3
        indexF = hwBot.get(Servo.class, "index");
        indexF.setDirection(Servo.Direction.FORWARD);

        //Expansion Hub Port 4
        thumbF = hwBot.get(Servo.class, "thumb");
        thumbF.setDirection(Servo.Direction.REVERSE);

        //Expansion Hub Port 5
        wrist = hwBot.get(Servo.class, "wrist");
        wrist.setDirection(Servo.Direction.FORWARD);

        //Control Hub Port 1
        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection(Servo.Direction.FORWARD);


    }

    /**  ********  WRIST MOVEMENT METHODS *************      **/

    public void closeWrist() { wrist.setPosition(0); }

    public void openWrist() { wrist.setPosition(1); }

    public void halfWrist() { wrist.setPosition(.5); }

    /**  ********  WRIST MOVEMENT METHODS *************      **/

    public void raiseArm() { elbow.setPosition(elbowMaxPos); }

    public void lowerArm() { elbow.setPosition(elbowMinPOs); }


    /**  ********  HAND GESTURES *************      **/

    public void point() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void peace() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void closeHand() {
        thumbF.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void openHand() {
        thumbF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }

    public void thumbsUp() {
        thumbF.setPosition(1);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void solute() {
        thumbF.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void surferWave() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
    }


}
