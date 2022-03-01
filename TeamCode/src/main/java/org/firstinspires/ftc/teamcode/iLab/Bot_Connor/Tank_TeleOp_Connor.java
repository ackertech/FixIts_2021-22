package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

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

        public void drive() {

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);

        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);

        if (leftStickYVal < -0.1) {
            Thomas_The_Tank.driveForward(speedMultiply*leftStickYVal); }
        else if (leftStickYVal > -0.1) {
            Thomas_The_Tank.driveForward(speedMultiply*leftStickYVal); }
        else if (leftStickXVal > 0.1) {
            Thomas_The_Tank.driveForward(speedMultiply*leftStickXVal); }
        else if (leftStickXVal < -0.1) {
            Thomas_The_Tank.driveForward(speedMultiply*leftStickXVal); }
        else {
            Thomas_The_Tank.stopMotors(); }
        }


        public void telemetryOutput() {
        telemetry.addLine("Thomas The Tank Control Panel");
        telemetry.addLine("May The Force Be With You");
        telemetry.addLine("Semper Paratus");
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Thomas_The_Tank.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Thomas_The_Tank.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor The Power of The Dark Side: ", Thomas_The_Tank.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power Of Pop Tarts: ", Thomas_The_Tank.frontRightMotor.getPower());
        telemetry.update();
    }

        }



