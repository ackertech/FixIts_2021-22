package org.firstinspires.ftc.teamcode.Base.ZArchive;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm_Bot {

    public Servo pinkyF = null;
    public Servo middleF = null;
    public Servo indexF = null;
    public Servo thumbF = null;
    public Servo ringF = null;

    public Servo shoulderJ = null;
    public Servo elbowJ = null;
    public Servo wristJ = null;

    public HardwareMap hwBot = null;

    public double elbowMaxPos = 0.5;
    public double elbowMinPOs = 0.18;
    public double elbowCurrPos = 0.18;
    public double elbowIncrements = 0.0005;

    public double shoulderMaxPos = 0.5;
    public double shoulderMinPos = 0.25;
    public double shoulderCurrPos = .5;
    public double shoulderIncrements = 0.0005;



    public Arm_Bot() {
    }

    public void initArmBot(HardwareMap hwMap) {

        hwBot = hwMap;

        pinkyF = hwBot.get(Servo.class, "pinkyF");      // port 1
        pinkyF.setDirection(Servo.Direction.FORWARD);

        middleF = hwBot.get(Servo.class, "middleF");    // port 3
        middleF.setDirection(Servo.Direction.FORWARD);

        indexF = hwBot.get(Servo.class, "indexF");      // port 4
        indexF.setDirection(Servo.Direction.FORWARD);                          // all extension hub

        thumbF = hwBot.get(Servo.class, "thumbF");      // port 5
        thumbF.setDirection(Servo.Direction.REVERSE);

        ringF = hwBot.get(Servo.class, "ringF");        // port 2
        ringF.setDirection(Servo.Direction.FORWARD);

        shoulderJ = hwBot.get(Servo.class, "shoulderJ");          //port 1
        shoulderJ.setDirection(Servo.Direction.FORWARD);

        elbowJ = hwBot.get(Servo.class, "elbowJ");                //port 2 control hub
        elbowJ.setDirection(Servo.Direction.FORWARD);

        wristJ = hwBot.get(Servo.class, "wristJ");                //port 3
        wristJ.setDirection(Servo.Direction.FORWARD);

    }

    public void closeWrist() {

        wristJ.setPosition(0);
    }

    public void openWrist() {

        wristJ.setPosition(1);
    }

    public void halfWrist() {

        wristJ.setPosition(.5);
    }

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
