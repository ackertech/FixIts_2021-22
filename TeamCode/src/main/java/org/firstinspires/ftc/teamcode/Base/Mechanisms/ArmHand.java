package org.firstinspires.ftc.teamcode.Base.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

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
    public double elbowMinPOs = 0.8;
    public double elbowHalfPos = 0.7;
    public double elbowCurrPos = 0.8;
    public double elbowIncrements = 0.0005;

    //ASL Gestures
    public String letter = "Hello";
    public ElapsedTime ASLtimer = new ElapsedTime();
    public double ASLpause = 2;


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
        wrist.setDirection(Servo.Direction.REVERSE);

        //Control Hub Port 1
        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection(Servo.Direction.REVERSE);

        closeHand();

    }

    /**  ********  WRIST MOVEMENT METHODS *************      **/

    public void closeWrist() {

        wrist.setPosition(0);
    }

    public void openWrist() {

        wrist.setPosition(1);
    }

    public void halfWrist() {

        wrist.setPosition(.5);
    }

    /**  ********  WRIST MOVEMENT METHODS *************      **/

    public void raiseArm() {
        closeHand();
        elbow.setPosition(elbowMaxPos);
        elbowCurrPos = elbowMaxPos;
    }

    public void lowerArm() {
        closeHand();
        elbow.setPosition(elbowMinPOs);
        elbowCurrPos = elbowMinPOs;
    }


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

    public void countOne() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }
    public void countTwo() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }
    public void countThree() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(0);
    }
    public void countFour() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }
    public void countFive() {
        thumbF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }

    public void letterA () {
        thumbF.setPosition(.5);
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }
    public void letterB () {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }

    public void letterC () {
        thumbF.setPosition(.5);
        indexF.setPosition(.5);
        middleF.setPosition(.5);
        ringF.setPosition(.5);
        pinkyF.setPosition(.5);
    }
    public void letterD () {
        thumbF.setPosition(.75);
        indexF.setPosition(1);
        middleF.setPosition(.3);
        ringF.setPosition(.3);
        pinkyF.setPosition(.3);
    }

    public void letterE () {
        thumbF.setPosition(.75);
        indexF.setPosition(.3);
        middleF.setPosition(.3);
        ringF.setPosition(.3);
        pinkyF.setPosition(.3);
    }

    public void letterF () {
        thumbF.setPosition(.6);
        indexF.setPosition(.7);
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(1);
    }

    public void letterG () {
        thumbF.setPosition(.55);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void letterH () {
        thumbF.setPosition(.6);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void letterI () {
        thumbF.setPosition(.3);
        indexF.setPosition(.3);
        middleF.setPosition(.3);
        ringF.setPosition(.3);
        pinkyF.setPosition(1);
    }
    public void letterJ () {
        thumbF.setPosition(.3);
        indexF.setPosition(.3);
        middleF.setPosition(.3);
        ringF.setPosition(.3);
        pinkyF.setPosition(1);
        wrist.setPosition(1);
    }
    public void letterK () {
        thumbF.setPosition(.5);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        wrist.setPosition(.5);
    }

    public void letterL () {
        thumbF.setPosition(1);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }

    public void letterM () {
        thumbF.setPosition(.1);
        indexF.setPosition(.5);
        middleF.setPosition(.5);
        ringF.setPosition(.5);
        pinkyF.setPosition(.5);
    }

    public void letterN () {
        thumbF.setPosition(.2);
        indexF.setPosition(.5);
        middleF.setPosition(.5);
        ringF.setPosition(.5);
        pinkyF.setPosition(.5);
    }
    public void letterO () {
        thumbF.setPosition(.5);
        indexF.setPosition(.5);
        middleF.setPosition(.5);
        ringF.setPosition(.5);
        pinkyF.setPosition(.5);
    }
    public void letterP () {
        thumbF.setPosition(.5);
        indexF.setPosition(1);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        wrist.setPosition(1);
    }
    public void letterQ () {
        thumbF.setPosition(.5);
        indexF.setPosition(1);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        wrist.setPosition(1);
    }
    public void letterR () {
        thumbF.setPosition(.3);
        indexF.setPosition(.95);
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
    }
    public void letterS () {
        indexF.setPosition(0);
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        thumbF.setPosition(.3);
    }
    public void letterT () {
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        thumbF.setPosition(.4);
        indexF.setPosition(0);
    }
    public void letterU () {
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        thumbF.setPosition(.2);
        indexF.setPosition(1);
    }
    public void letterV () {
        middleF.setPosition(1);
        ringF.setPosition(0);
        pinkyF.setPosition(0);
        thumbF.setPosition(.2);
        indexF.setPosition(1);
    }
    public void letterW () {
        middleF.setPosition(1);
        ringF.setPosition(1);
        pinkyF.setPosition(0);
        thumbF.setPosition(.2);
        indexF.setPosition(1);
    }
    public void letterX () {
        middleF.setPosition(.5);
        ringF.setPosition(.5);
        pinkyF.setPosition(.5);
        thumbF.setPosition(.3);
        indexF.setPosition(.7);
    }
    public void letterY () {
        middleF.setPosition(0);
        ringF.setPosition(0);
        pinkyF.setPosition(1);
        thumbF.setPosition(.5);
        indexF.setPosition(0);
    }

    public void signSentence(String word) {

        for (int i=0; i < word.length(); i++) {
            letter = word.valueOf(i);
            ASLtimer.reset();
            while (ASLtimer.seconds() < ASLpause) {
                createWords(letter);
            }
            closeHand();
        }

    }


    public void createWords(String letter) {

        if (letter.toUpperCase() == "A") {
            letterA();
        }
        else if (letter.toUpperCase() == "B") {
            letterB();
        }
        else if (letter.toUpperCase() == "C") {
            letterC();
        }
        else if (letter.toUpperCase() == "D") {
            letterD();
        }
        else if (letter.toUpperCase() == "E") {
            letterE();
        }
        else if (letter.toUpperCase() == "F") {
            letterF();
        }
        else if (letter.toUpperCase() == "G") {
            letterG();
        }
        else if (letter.toUpperCase() == "H") {
            letterH();
        }
        else if (letter.toUpperCase() == "I") {
            letterI();
        }
        else if (letter.toUpperCase() == "J") {
            letterJ();
        }
        else if (letter.toUpperCase() == "K") {
            letterK();
        }
        else if (letter.toUpperCase() == "L") {
            letterL();
        }
        else if (letter.toUpperCase() == "M") {
            letterM();
        }
        else if (letter.toUpperCase() == "N") {
            letterN();
        }
        else if (letter.toUpperCase() == "O") {
            letterO();
        }
        else if (letter.toUpperCase() == "P") {
            letterP();
        }
        else if (letter.toUpperCase() == "Q") {
            letterQ();
        }
        else if (letter.toUpperCase() == "R") {
            letterR();
        }
        else if (letter.toUpperCase() == "S") {
            letterS();
        }
        else if (letter.toUpperCase() == "T") {
            letterT();
        }
        else if (letter.toUpperCase() == "U") {
            letterU();
        }
        else if (letter.toUpperCase() == "V") {
            letterV();
        }
        else if (letter.toUpperCase() == "W") {
            letterW();
        }
        else if (letter.toUpperCase() == "X") {
            letterX();
        }
        else if (letter.toUpperCase() == "Y") {
            letterY();
        }
        else {
            closeHand();
        }


    }
}
