package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.TankBot_Connor;
import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.Tank_TeleOp_Connor;
import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.The_Mighty_and_All_Powerful_Hand;

@TeleOp(name = "CandyBox_Olivia")

public class TeleOpCandyBox_Olivia extends OpMode {

    //Variables and Constants
// says that, at aany time, GroverState has to be in this position
    public enum GroverState {ONE, TWO, THREE,FOUR, FIVE, GROVERDREAMSACK, GROVEROVER};
    public GroverState groveringState = GroverState.ONE;

    public ElapsedTime GroverWatch = new ElapsedTime();

    // connects the code to the robot
    public TankBot_Connor Thomas_The_Tank = new TankBot_Connor();
    public The_Mighty_and_All_Powerful_Hand Hand = new The_Mighty_and_All_Powerful_Hand();

    // must have init and loop for code to work
    // Code to initialize robot
    public void init() {
        Thomas_The_Tank.initRobot(hardwareMap);
        Hand.initThe_Mighty_and_All_Powerful_Hand(hardwareMap);

    }
    //once code ends, tells code to restart until driver tells it to stop
    public void loop () {
        raiseHand();
        rotateArm();
        handMovements();
        wristControl();
        CountingWithGroverAuto();


    }

    public void raiseHand() {
        if (gamepad1.dpad_up) {
            Hand.raiseArm(); }
        else if (gamepad1.dpad_down) {
            Hand.lowerArm(); }
    }


    public void rotateArm(){
            if (gamepad1.dpad_left) {
                Thomas_The_Tank.lazySusanLeft(0.5); }
            else if (gamepad1.dpad_right) {
                Thomas_The_Tank.lazySusanRight(0.5); }
            else {
                Thomas_The_Tank.lazySusanStop(); }
    }


    public void handMovements() {
        if (gamepad1.back) {
            Hand.openHand(); }

        else if (gamepad1.start) {
            Hand.closeHand(); }
    }

    public void wristControl() {
        if (gamepad1.left_bumper && Hand.wristCurrPos < Hand.wristMaxPos) {
            Hand.wristCurrPos += Hand.wristIncrements;
            Hand.wrist.setPosition(Hand.wristCurrPos);
        }

        else {
            Hand.wrist.setPosition(Hand.wristCurrPos);
        }

        if (gamepad1.right_bumper && Hand.wristCurrPos > Hand.wristMinPos) {
            Hand.wristCurrPos -= Hand.wristIncrements;
            Hand.wrist.setPosition(Hand.wristCurrPos);
        }

        else {
            Hand.wrist.setPosition(Hand.wristCurrPos);
        }
    }

    public void CountingWithGroverAuto() {
        if (gamepad1.b) {
            groveringState = GroverState.ONE;

            switch (groveringState) {
                case ONE:
                    Hand.thumb.setPosition(0);
                    Hand.indexFinger.setPosition(1);
                    Hand.middleFinger.setPosition(0);
                    Hand.ringFinger.setPosition(0);
                    Hand. pinkyFinger.setPosition(0);
                    GroverWatch.reset();
                    groveringState = GroverState.TWO;
                    break;

                case TWO:
                    if (GroverWatch.seconds()>2) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(0);
                        Hand. pinkyFinger.setPosition(0);
                        GroverWatch.reset();
                        groveringState = GroverState.THREE;
                     }
                    break;
                case THREE:
                    if (GroverWatch.seconds()>2) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(1);
                        Hand. pinkyFinger.setPosition(0);
                        GroverWatch.reset();
                        groveringState = GroverState.FOUR;
                    }
                    break;
                case FOUR:
                    if (GroverWatch.seconds()>2) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(1);
                        Hand. pinkyFinger.setPosition(1);
                        GroverWatch.reset();
                        groveringState = GroverState.FIVE;
                    }
                    break;
                case FIVE:
                    if (GroverWatch.seconds()>2) {
                        Hand.thumb.setPosition(1);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(1);
                        Hand. pinkyFinger.setPosition(1);
                        GroverWatch.reset();
                        groveringState = GroverState.GROVEROVER;
                    }
                    break;
                case GROVERDREAMSACK:
                    if (GroverWatch.seconds () > 2) {
                        Hand.closeHand();
                        groveringState = GroverState.GROVERDREAMSACK;
                    }
                    break;
            }
        }
    }





}
