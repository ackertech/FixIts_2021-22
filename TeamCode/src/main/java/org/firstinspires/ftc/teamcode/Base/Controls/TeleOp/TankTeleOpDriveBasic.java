package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

@Disabled
@TeleOp(name = "TankBot Basic")

public class TankTeleOpDriveBasic extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedMultiply = .75;


    // GamePad Variables
    double leftStickYVal;
    double leftStickXVal;


    // Construct the Physical Bot based on the Robot Class
    public TankBot Bruno = new TankBot();


    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init() {
        Bruno.initRobot(hardwareMap);
    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {

        speedControl();
        driveControl();
        telemetryOutput();

    }


    /**  ********  DRIVING METHODS USING GAMEPAD 1 *************      **/

    public void speedControl () {
        if (gamepad1.dpad_right) {
            speedMultiply = 0.25; }
        else if (gamepad1.dpad_down) {
            speedMultiply = 0.50; }
        else if (gamepad1.dpad_left) {
            speedMultiply = 0.75; }
        else if (gamepad1.dpad_up) {
            speedMultiply = 1.00; }
    }

    public void driveControl() {

        leftStickYVal = gamepad1.left_stick_y;
        leftStickYVal = Range.clip(leftStickYVal, -1, 1);

        leftStickXVal = gamepad1.left_stick_x;
        leftStickXVal = Range.clip(leftStickXVal, -1, 1);

        if (leftStickYVal < -0.1) {
            Bruno.tankDriveForward(speedMultiply*leftStickYVal); }
        else if (leftStickYVal > 0.1) {
            Bruno.tankDriveBackward(speedMultiply*leftStickYVal); }
        else if (leftStickXVal > 0.1) {
            Bruno.tankTurnRight(speedMultiply*leftStickXVal); }
        else if (leftStickXVal < -0.1) {
            Bruno.tankTurnLeft(speedMultiply*leftStickXVal); }
        else {
            Bruno.stopMotors(); }

    }


    public void telemetryOutput() {
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Bruno.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Bruno.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor Power: ", Bruno.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power: ", Bruno.rearRightMotor.getPower());
        telemetry.update();

    }


}
