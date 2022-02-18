package org.firstinspires.ftc.teamcode.Base.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class ASLHand extends ArmHand {

    public ElapsedTime timer = new ElapsedTime();
    public double waitTime = 2.0;
    String letter = " ";

    //Allows us to leverage telemetry and sleep
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {

        this.linearOp = linearOp;
    }

    public ASLHand() { }

    /**  ********  ASL LOGIC *************      **/

    public void signSentence(String word) {

        linearOp.telemetry.addData("Word: ", word);
        linearOp.telemetry.update();
        linearOp.sleep(1000);

        for (int i=0; i < word.length(); i++) {

            linearOp.telemetry.addData("Letter: ", letter);
            linearOp.telemetry.update();
            letter = word.valueOf(i);
            createWords(letter);
            linearOp.sleep(1000);
            closeHand();
            linearOp.sleep(1000);

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

    /**  ********  ASL LETTERS *************      **/

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
