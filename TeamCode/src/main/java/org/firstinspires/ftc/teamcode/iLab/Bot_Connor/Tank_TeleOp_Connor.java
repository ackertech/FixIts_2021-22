package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp(name = "Thomas_The_TankBot_Drive_Basic_Connor_Beethoven's_Wig")
public class Tank_TeleOp_Connor extends OpMode{

    //TeleOp Driving Behavior Variables
    public double speedMultiply = 0.50;

    //GamePad Variables
    double leftStickYVal;
    double leftStickXVal;

    // Construct the Physical Bot based on the Robot Class
    public TankBot_Connor Thomas_The_Tank = new TankBot_Connor();

    //TeleOp Initilize method. This is the Init Button on the Driver Station Phone.
    @Override
    public void init () {

        Thomas_The_Tank.initRobot(hardwareMap);


    }

    // TeleOp Loop Method. This start After clicking the Play button on the Driver Station Phone

        public void loop() {


        }

     public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.25;}
            else if (gamepad1.dpad_down == true) {
                speedMultiply = 0.50;}
            else if (gamepad1.dpad_left == true) {
                speedMultiply = 0.75;}
            else if (gamepad1.dpad_up == true){
                speedMultiply = 0.10;}
            else if (gamepad1.a == true){
                speedMultiply = 1.00;}
        }

        }



