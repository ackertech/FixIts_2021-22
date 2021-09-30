package org.firstinspires.ftc.teamcode.iLab.Bot_ASL_Emma;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ASL_Bot {
    public Servo pinkyF = null;
    public Servo middleF = null;
    public Servo indexF = null;
    public Servo thumbF = null;
    public Servo ringF = null;
    public Servo wrist = null;
    public Servo elbow = null;

    public HardwareMap hwBot = null;

    public ASL_Bot () {

    }

    public void initArmBot(HardwareMap hwMap) {

        hwBot = hwMap;

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

        wrist = hwBot.get(Servo.class, "wrist");
        wrist.setDirection(Servo.Direction.FORWARD);

        elbow = hwBot.get(Servo.class, "elbow");
        elbow.setDirection(Servo.Direction.FORWARD);

    }

    public void indexPoint() {
        thumbF.setPosition(0);
        indexF.setPosition(1);
        middleF.setPosition(0);
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
}
