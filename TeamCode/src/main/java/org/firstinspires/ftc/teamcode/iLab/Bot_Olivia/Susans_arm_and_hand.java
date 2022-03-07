package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Susans_arm_and_hand {

    //Define Hand Variables
    public Servo nineToes = null;
    public Servo skagzilla = null;
    public Servo claptrap = null;
    public Servo cl4pt = null;
    public Servo rakk = null;

    //Define Arm Variables
    public Servo scythid = null;
    public Servo spiderant = null;

    //Set positioning for Arm or Hand
    public double elbowMaxPos = 0.5;
    public double elbowMinPos = 0.18;
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
    public void initTKBaha(HardwareMap hwMap) {

        hwBot = hwMap;


        //Expansion Hub Port 0
        nineToes = hwBot.get(Servo.class, "nineToes");
        nineToes.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 1
        skagzilla = hwBot.get(Servo.class, "skagzilla");
        skagzilla.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 2
        claptrap = hwBot.get(Servo.class, "claptrap");
        claptrap.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 3
        cl4pt = hwBot.get(Servo.class, "cl4pt");
        cl4pt.setDirection((Servo.Direction.FORWARD));

        //Expansion Hub Port 4
        rakk = hwBot.get(Servo.class, "rakk");
        rakk.setDirection((Servo.Direction.REVERSE));

        //Expansion Hub Port 5
        spiderant = hwBot.get(Servo.class, "spiderant");
        spiderant.setDirection((Servo.Direction.REVERSE));

        //Control Hub Port 1
        scythid = hwBot.get(Servo.class, "scythid");
        scythid.setDirection((Servo.Direction.REVERSE));
    }

    /** *************   WRIST MOVEMENT METHODS ************ **/

    public void bandit() {
        spiderant.setPosition(1);}

    public void openWrist() {
        spiderant.setPosition(1);}

    public void halfWrist() {
        spiderant.setPosition(5);
    }


    /** ******** WRIST MOVEMENT METHODS ************ **/

    public void raiseArm() {
        scythid.setPosition(elbowMaxPos);
    }

    public void lowerArm() {
        scythid.setPosition(elbowMinPos);
    }

    /** ********** HAND GESTURES *********** **/

    public void point() {
        rakk.setPosition(0);
        cl4pt.setPosition(1);
        claptrap.setPosition(0);
        skagzilla.setPosition(0);
        nineToes.setPosition(0);
    }

    public void peace() {
        rakk.setPosition(0);
        cl4pt.setPosition(1);
        claptrap.setPosition(1);
        skagzilla.setPosition(0);
        nineToes.setPosition(0);
    }

    public void love() {
        rakk.setPosition(1);
        cl4pt.setPosition(0);
        claptrap.setPosition(1);
        skagzilla.setPosition(0);
        nineToes.setPosition(1);
    }

    public void thumbsup() {
        rakk.setPosition(1);
        cl4pt.setPosition(0);
        claptrap.setPosition(0);
        skagzilla.setPosition(0);
        nineToes.setPosition(0);
    }

    public void rockon() {
        rakk.setPosition(0);
        cl4pt.setPosition(0);
        claptrap.setPosition(1);
        skagzilla.setPosition(0);
        nineToes.setPosition(1);
    }

    public void close() {
        rakk.setPosition(0);
        cl4pt.setPosition(0);
        claptrap.setPosition(0);
        skagzilla.setPosition(0);
        nineToes.setPosition(0);
    }

    public void open() {
        rakk.setPosition(1);
        cl4pt.setPosition(1);
        claptrap.setPosition(1);
        skagzilla.setPosition(1);
        nineToes.setPosition(1);
    }

    public void aloha() {
        rakk.setPosition(1);
        cl4pt.setPosition(0);
        claptrap.setPosition(0);
        skagzilla.setPosition(0);
        nineToes.setPosition(1);
    }

    public void chinesefinger() {
        rakk.setPosition(0);
        cl4pt.setPosition(0);
        claptrap.setPosition(0);
        skagzilla.setPosition(0);
        nineToes.setPosition(1);
    }
}



