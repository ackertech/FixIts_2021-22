package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.TankBot_Connor;
import org.firstinspires.ftc.teamcode.iLab.Bot_Connor.The_Mighty_and_All_Powerful_Hand;

@TeleOp(name = "CandyBox_Olivia")

public class TeleOpCandyBox_Olivia extends OpMode {

    //Variables and Constants
// must have init and loop for code to work

    // connects the code to the robot
    public TankBot_Connor Thomas_The_Tank = new TankBot_Connor();
    public The_Mighty_and_All_Powerful_Hand Hand = new The_Mighty_and_All_Powerful_Hand();

    // Code to initialize robot
    public void init() {
        Thomas_The_Tank.initRobot(hardwareMap);
        Hand.initThe_Mighty_and_All_Powerful_Hand(hardwareMap);

    }
    //once code ends, tells code to restart until driver tells it to stop
    public void loop () {
        raiseHand();
        rotateArm();
        rotateWrist();
        handMovements();


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


    public void rotateWrist(){
        if (gamepad1.left_bumper) {
            Hand.wristLeft(); }
        else if (gamepad1.right_bumper) {
            Hand. wristRight(); }
    }

    public void handMovements() {
        if (gamepad1.back) {
            Hand.openHand(); }

        else if (gamepad1.start) {
            Hand.closeHand(); }
    }


}
