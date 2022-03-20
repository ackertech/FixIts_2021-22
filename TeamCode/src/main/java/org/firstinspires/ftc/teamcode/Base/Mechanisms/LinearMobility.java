package org.firstinspires.ftc.teamcode.Base.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearMobility {

    public DcMotor horizontalMotor;
    public DcMotor verticalMotor;
    public DcMotor rotatingMotor;

    public HardwareMap hwBot = null;

    public static final double TICKS_PER_ROTATION = 538;

    //Allows us to leverage telemetry and sleep
    public LinearOpMode linearOp = null;
    public void setLinearOp (LinearOpMode linearOpModeOp) {
        this.linearOp = linearOp;
    }

    public LinearMobility() {};

    public void initLinearMobility(HardwareMap hwMap) {

        hwBot = hwMap;

        horizontalMotor = hwBot.dcMotor.get("horizontalMotor");
        verticalMotor = hwBot.dcMotor.get("verticalMotor");
        rotatingMotor = hwBot.dcMotor.get("rotatingMotor");

        horizontalMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        verticalMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rotatingMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotatingMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rotatingMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        horizontalMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        verticalMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotatingMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    public void moveLinearForward (double power) {
        horizontalMotor.setPower(Math.abs(power));
    }

    public void moveLinearReverse (double power) {
        horizontalMotor.setPower(-Math.abs(power));
    }

    public void moveLinearUp (double power) {
        verticalMotor.setPower(Math.abs(power));
    }

    public void moveLinearDown (double power) {
        verticalMotor.setPower(-Math.abs(power));
    }

    public void rotateForward (double power) {
        rotatingMotor.setPower(Math.abs(power));
    }

    public void rotateReverse (double power) {
        rotatingMotor.setPower(-Math.abs(power));
    }

    /**  Overloaded Methods using Encoders  **/

    public void moveLinearForward (double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (horizontalMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            moveLinearForward(power);
        }
        horizontalMotor.setPower(0);
    }

    public void moveLinearReverse( double power, double rotations) {

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (horizontalMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            moveLinearReverse(power);
        }
        horizontalMotor.setPower(0);
    }



    public void moveLinearUp( double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (verticalMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            moveLinearUp(power);
        }
        verticalMotor.setPower(0);
    }

    public void moveLinearDown( double power, double rotations) {

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (verticalMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            moveLinearDown(power);
        }
        verticalMotor.setPower(0);
    }




}
