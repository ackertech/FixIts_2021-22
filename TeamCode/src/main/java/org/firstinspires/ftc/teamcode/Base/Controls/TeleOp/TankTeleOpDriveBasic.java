package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "TankBot Basic")

public class TankTeleOpDriveBasic extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedMultiply = .75;


    // GamePad Variables
    double leftStickYVal;
    double leftStickXVal;



    // Construct the Physical Bot based on the Robot Class
    public TankBot Bot = new TankBot();


    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Bot.initRobot(hardwareMap);

    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {

        speedControl();
        drive();
        telemetryOutput();

    }


    /**  ********  DRIVING METHODS USING GAMEPAD 1 *************      **/

    public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.25; }
        else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.50; }
        else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75; }
        else if (gamepad1.dpad_up == true) {
            speedMultiply = 1.00; }
    }

    public void drive() {

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);

        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);

        if (leftStickYVal < -0.1) {
            Bot.tankDriveForward(speedMultiply*leftStickYVal); }
        else if (leftStickYVal > 0.1) {
            Bot.tankDriveBackward(speedMultiply*leftStickYVal); }
        else if (leftStickXVal > 0.1) {
            Bot.tankTurnRight(speedMultiply*leftStickXVal); }
        else if (leftStickXVal < -0.1) {
            Bot.tankTurnLeft(speedMultiply*leftStickXVal); }
        else {
            Bot.stopMotors(); }

    }


    public void telemetryOutput() {
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Bot.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Bot.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor Power: ", Bot.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power: ", Bot.rearRightMotor.getPower());
        telemetry.update();

    }


}
