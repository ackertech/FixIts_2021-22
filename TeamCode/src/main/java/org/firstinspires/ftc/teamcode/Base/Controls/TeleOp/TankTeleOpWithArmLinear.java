package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Mechanisms.ArmHand;
import org.firstinspires.ftc.teamcode.Base.Mechanisms.LinearMobility;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "TankBot Linear Arm")

public class TankTeleOpWithArmLinear extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedMultiply = .75;
    public enum Style {
        ARCADE1, ARCADE2, TANK
    }
    public Style driverStyle = Style.ARCADE1;
    public double leftSidePower;
    public double rightSidePower;

    // GamePad Variables
    double leftStickYVal;
    double leftStickXVal;
    double rightStickXVal;
    double rightStickYVal;

    // Hand Variables
    String handGesture;
    String wristStatus;

    //Linear Actuator Variables
    public double horizontalMax = 3;
    public double horizontalMin = 0.25;
    public double verticalMax = 3;
    public double verticalMin = 0.25;
    public double rotateMax = 3;
    public double rotateMin = 0.25;
    public double linearPower = 0.60;

    // Construct the Physical Bot based on the Robot Class
    public TankBot Bruno = new TankBot();
    public ArmHand Handy = new ArmHand();
    public LinearMobility Box = new LinearMobility();

    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Bruno.initRobot(hardwareMap);
        Handy.initArmHand(hardwareMap);
        Box.initLinearMobility(hardwareMap);

    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone
    @Override
    public void loop() {

        speedControl();
        driveControl();
        drive();
        handControl();
        wristControl();
        elbowControl();
        lazySusanControl();
        linearControl();
        telemetryOutput();

    }

    public void telemetryOutput() {
        telemetry.addData("Drive Mode: ", driverStyle);
        telemetry.addData("Speed: ", speedMultiply);
        telemetry.addData("Front Left Motor Power: ", Bruno.frontLeftMotor.getPower());
        telemetry.addData("Rear Left Motor Power: ", Bruno.rearLeftMotor.getPower());
        telemetry.addData("Front Right Motor Power: ", Bruno.frontRightMotor.getPower());
        telemetry.addData("Rear Right Motor Power: ", Bruno.rearRightMotor.getPower());
        telemetry.addData("Elbow Position: ", Handy.elbowCurrPos );
        telemetry.addData("LazySusan Position: ", Bruno.lazySusanCurrPos );
        telemetry.addData("Hand Gesture: ", handGesture);
        telemetry.addData("Wrist Status: ", wristStatus);
        telemetry.addData("Horizontal Position: ", Box.horizontalMotor.getCurrentPosition() );
        telemetry.addData("Vertical Position: ", Box.verticalMotor.getCurrentPosition() );
        telemetry.addData("Rotating Position: ", Box.rotatingMotor.getCurrentPosition() );
        telemetry.update();

    }


    /**  ********  DRIVING METHODS USING GAMEPAD 1 *************      **/

    public void drive() {

        switch (driverStyle) {

            case ARCADE1:

                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Bruno.tankDriveForward(speedMultiply*leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    Bruno.tankDriveBackward(speedMultiply*leftStickYVal);
                } else if (leftStickXVal > 0.1) {
                    Bruno.tankTurnRight(speedMultiply*leftStickXVal);
                } else if (leftStickXVal < -0.1) {
                    Bruno.tankTurnLeft(speedMultiply*leftStickXVal);
                } else {
                    Bruno.stopMotors();
                }
                break;

            case ARCADE2:

                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);
                rightStickXVal = gamepad1.right_stick_x;
                rightStickXVal = Range.clip(rightStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Bruno.tankDriveForward(speedMultiply*leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    Bruno.tankDriveBackward(speedMultiply*leftStickYVal);
                } else {
                    Bruno.stopMotors();
                }
                if (rightStickXVal > 0.1) {
                    Bruno.tankTurnRight(speedMultiply*rightStickXVal);
                } else if (rightStickXVal < -0.1) {
                    Bruno.tankTurnLeft(speedMultiply*rightStickXVal);
                } else {
                    Bruno.stopMotors();
                }
                break;

            case TANK:

                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);

                leftSidePower = speedMultiply * leftStickYVal * (-1);
                rightSidePower = speedMultiply * rightStickYVal * (-1);
                Bruno.tankDrive(leftSidePower,rightSidePower);
                break;
        }
    }


    public void driveControl () {
            if (gamepad1.left_bumper) {
                driverStyle = Style.ARCADE1;
            }
            if (gamepad1.right_bumper) {
                driverStyle = Style.ARCADE2;
            }
            if (gamepad1.right_stick_button) {
                driverStyle = Style.TANK;
            }
            if (gamepad1.right_stick_button) {  }
    }


     public void speedControl () {
            if (gamepad1.dpad_right) {
                speedMultiply = 0.25;
            } else if (gamepad1.dpad_down) {
                speedMultiply = 0.50;
            } else if (gamepad1.dpad_left) {
                speedMultiply = 0.75;
            } else if (gamepad1.dpad_up) {
                speedMultiply = 1.00;
            }
    }

    /**  ********  Linear Actuator  *************      **/

    public void linearControl() {
        if (gamepad1.a) {
            Box.moveLinearForward(linearPower, horizontalMax);
        }
        else if (gamepad1.b) {
            Box.moveLinearReverse(linearPower, horizontalMin);
        }
        else if (gamepad1.x) {
            Box.moveLinearUp(linearPower, verticalMax);
        }
        else if (gamepad1.y) {
            Box.moveLinearDown(linearPower, verticalMin);
        }
    }


    /**  ********  ARM METHODS USING GAMEPAD2 *************      **/

    public void elbowControl() {

        if (gamepad2.dpad_up  && Handy.elbowCurrPos < Handy.elbowMaxPos) {
            Handy.elbowCurrPos += Handy.elbowIncrements;
            Handy.elbow.setPosition(Handy.elbowCurrPos);
        }
        else {
            Handy.elbow.setPosition(Handy.elbowCurrPos);
        }

        if (gamepad2.dpad_down  && Handy.elbowCurrPos > Handy.elbowMinPOs) {
            Handy.elbowCurrPos -= Handy.elbowIncrements;
            Handy.elbow.setPosition(Handy.elbowCurrPos);

        }
        else {
            Handy.elbow.setPosition(Handy.elbowCurrPos);
        }
    }

    public void lazySusanControl() {

        if (gamepad2.dpad_left  && Bruno.lazySusanCurrPos < Bruno.lazySusanMaxPos) {
            Bruno.lazySusanCurrPos += Bruno.lazySusanIncrements;
            Bruno.lazySusan.setPosition(Bruno.lazySusanCurrPos);
        }
        else {
            Bruno.lazySusan.setPosition(Bruno.lazySusanCurrPos);
        }

        if (gamepad2.dpad_right  && Bruno.lazySusanCurrPos > Bruno.lazySusanMinPos) {
            Bruno.lazySusanCurrPos -= Bruno.lazySusanIncrements;
            Bruno.lazySusan.setPosition(Bruno.lazySusanCurrPos);
        }
        else {
            Bruno.lazySusan.setPosition(Bruno.lazySusanCurrPos);
        }
    }



    /**  ********  HAND METHODS USING GAMEPAD2 *************      **/

    public void handControl() {

        if (gamepad2.a) {
            Handy.point();
            handGesture = "Pointing";
        } else if (gamepad2.b) {
            Handy.surferWave();
            handGesture = "Surfer Wave";
        } else if (gamepad2.y) {
            Handy.peace();
            handGesture = "Peace Sign";
        } else if (gamepad2.x) {
            Handy.thumbsUp();
            handGesture = "Thumbs Up";
        } else if (gamepad2.left_bumper) {
            Handy.openHand();
            handGesture = "Open Hand";
        } else if (gamepad2.right_bumper) {
            Handy.closeHand();
            handGesture = "Close Hand";
        } else {
            Handy.closeHand();
            handGesture = "Close Hand";
        }
    }

    public void wristControl() {
        if (gamepad2.left_trigger > 0.1) {
            Handy.openWrist();
            wristStatus = "Open Wrist";
        }
        else if (gamepad2.right_trigger > 0.1) {
            Handy.halfWrist();
            wristStatus = "Half Wrist";
        }
        else {
            Handy.closeWrist();
            wristStatus = "Close Wrist";
        }

    }


}
