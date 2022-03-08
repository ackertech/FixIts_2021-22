package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Susans_arm_and_hand {

    //Define Hand Variables
    public Servo pinkyF = null;
    public Servo ringF = null;
    public Servo middleF = null;
    public Servo indexF = null;
    public Servo thumb = null;

    //Define Arm Variables
    public Servo elbow = null;
    public Servo wrist = null;

    //Set positioning for Arm or Hand
    public double elbowMaxPos = 0.5;
    public double elbowMinPos = 0.8;
    public double elbowCurrPos = 0.18;
    public double elbowIncrements = 0.0005;

    //Hardware Constructors
    public HardwareMap hwBot =  null;
    public Susans_arm_and_hand() {}

    //Allows us to leverage telemetry sleep
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {
        this.linearOp = linearOp;
    }
    //Hardware Initialization
    public void initArmHand(HardwareMap hwMap) {

        hwBot = hwMap;


        //Expansion Hub Port 0
        pinkyF = hwBot.get(Servo.class, "pinkyF");
        pinkyF.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 1
        ringF = hwBot.get(Servo.class, "ringF");
        ringF.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 2
        middleF = hwBot.get(Servo.class, "middleF");
       middleF.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 3
        indexF = hwBot.get(Servo.class, "indexF");
        indexF.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 4
        thumb = hwBot.get(Servo.class, "thumb");
        thumb.setDirection((Servo.Direction.REVERSE));

        //Expansion Hub Port 5
        wrist = hwBot.get(Servo.class, "wrist");
        wrist.setDirection((Servo.Direction.REVERSE));

        //Control Hub Port 1
        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection((Servo.Direction.REVERSE));

        close();
    }

    /** *************   WRIST MOVEMENT METHODS ************ **/

    public void closeWrist() {
        wrist.setPosition(1);}

    public void openWrist() {
        wrist.setPosition(1);}

    public void halfWrist() {
        wrist.setPosition(5);
    }


    /** ******** WRIST MOVEMENT METHODS ************ **/

    public void raiseArm() {
        elbow.setPosition(elbowMaxPos);
    }

    public void lowerArm() {
        close();
        elbow.setPosition(elbowMinPos);
    }

    /** ********** HAND GESTURES *********** **/

    public void point() {
        thumb.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void peace() {
        thumb.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void love() {
       thumb.setPosition(1);
        indexF.setPosition(0);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
    }

    public void thumbsup() {
        thumb.setPosition(1);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void rockon() {
        thumb.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
    }

    public void close() {
        thumb.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void open() {
        thumb.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }

    public void aloha() {
        thumb.setPosition(1);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
    }

    public void chinesefinger() {
        thumb.setPosition(0);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
    }
}



