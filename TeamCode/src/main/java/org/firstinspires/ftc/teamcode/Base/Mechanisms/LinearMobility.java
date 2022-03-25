package org.firstinspires.ftc.teamcode.Base.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LinearMobility {

    public DcMotor horizontalMotor;
    public DcMotor verticalMotor;
    public DcMotor lazySusanMotor;

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
        lazySusanMotor = hwBot.dcMotor.get("rotatingMotor");

        horizontalMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        verticalMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        lazySusanMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lazySusanMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lazySusanMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        horizontalMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        verticalMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lazySusanMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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
        lazySusanMotor.setPower(Math.abs(power));
    }

    public void rotateReverse (double power) {
        lazySusanMotor.setPower(-Math.abs(power));
    }


    /**  Overloaded Autonomous Methods using Encoders  **/

    public void autoMoveLinearForward (double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (horizontalMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive()) {
            moveLinearForward(power);
        }
        horizontalMotor.setPower(0);
    }

    public void autoMoveLinearReverse( double power, double rotations) {

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        horizontalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (horizontalMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            moveLinearReverse(power);
        }
        horizontalMotor.setPower(0);
    }

    public void autoMoveLinearUp( double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (verticalMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive())  {
            moveLinearUp(power);
        }
        verticalMotor.setPower(0);
    }

    public void autoMoveLinearDown( double power, double rotations) {

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        verticalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        verticalMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (verticalMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            moveLinearDown(power);
        }
        verticalMotor.setPower(0);
    }

    public void autoRotateForward( double power, double rotations) {

        double ticks = rotations * TICKS_PER_ROTATION;
        lazySusanMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lazySusanMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (lazySusanMotor.getCurrentPosition() < ticks && linearOp.opModeIsActive() ) {
            rotateForward(power);
        }
        lazySusanMotor.setPower(0);
    }

    public void autoRotateReverse( double power, double rotations) {

        double ticks = rotations * (-1) * TICKS_PER_ROTATION;
        lazySusanMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lazySusanMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (lazySusanMotor.getCurrentPosition() > ticks && linearOp.opModeIsActive()) {
            rotateReverse(power);
        }
        lazySusanMotor.setPower(0);
    }


}
