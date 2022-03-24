package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Base.Mechanisms.ArmHand;
import org.firstinspires.ftc.teamcode.Base.Mechanisms.LinearMobility;
import org.firstinspires.ftc.teamcode.Base.Robot.TankBot;

//@Disabled
@TeleOp(name = "TankBot Arm-Linear")

public class TankTeleOpWithArmLinear extends OpMode {

    //Driving Behavior Variables
    public double speedMultiply = .75;
    public enum Style {
        ARCADE1, ARCADE2, TANK
    }
    public Style driverStyle = Style.ARCADE1;

    //Arm Behavior Variables
    public enum ArmState {
        ARM_START,
        ARM_RAISE,
        ARM_REST,
        ARM_RETRACT
    }
    ArmState armState = ArmState.ARM_START;

    //Linear Behavior Variables
    public enum LinearState {
        LINEAR_START,
        LINEAR_EXTEND,
        LINEAR_REST,
        LINEAR_RETRACT

    }
    LinearState linearState = LinearState.LINEAR_START;


    public ElapsedTime armTimer = new ElapsedTime();
    public ElapsedTime linearTimer = new ElapsedTime();

    // GamePad Variables
    public double leftSidePower;
    public double rightSidePower;
    double leftStickYVal;
    double leftStickXVal;
    double rightStickXVal;
    double rightStickYVal;

    // Hand Variables
    String handGesture;
    String wristStatus;


    // Construct the Physical Bot and Mechanisms
    public TankBot Bruno = new TankBot();
    public ArmHand Handy = new ArmHand();
    public LinearMobility Liney = new LinearMobility();



    // TeleOp Initialize Method.  This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Bruno.initRobot(hardwareMap);
        Handy.initArmHand(hardwareMap);
        Liney.initLinearMobility(hardwareMap);
        armTimer.reset();
        linearTimer.reset();
    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone
    @Override
    public void loop() {

        speedControl();
        driveControl();
        handControl();
        elbowAutomatedControl();
        elbowManualControl();
        lazySusanControl();
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
        telemetry.addData("Horizontal Position: ", Liney.horizontalMotor.getCurrentPosition() );
        telemetry.addData("Vertical Position: ", Liney.verticalMotor.getCurrentPosition() );
        telemetry.addData("Rotating Position: ", Liney.lazySusanMotor.getCurrentPosition() );
        telemetry.update();
    }

    /**************************************
     *
     *  GAMEPAD 1 CONTROLS
     *
     **************************************/


    /**  ********  DRIVING METHODS USING GAMEPAD 1 *************      **/

    public void driveControl() {

        if (gamepad1.left_bumper) {
            driverStyle = Style.ARCADE1;
        }
        if (gamepad1.right_bumper) {
            driverStyle = Style.ARCADE2;
        }
        if (gamepad1.right_stick_button) {
            driverStyle = Style.TANK;
        }

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

    /**************************************
     *
     *  GAMEPAD 2 CONTROLS
     *
     **************************************/

    /**  ********  Lazy Susan and Linear Actuator  *************      **/

    public void lazySusanControl() {

        if (gamepad2.left_bumper) {
            Liney.rotateForward(.90,10);

        }
        else if (gamepad2.right_bumper) {
            Liney.rotateReverse(.90, 10);
        }

    }

    /**  ********  ARM and ELBOW METHODS USING GAMEPAD2 *************      **/

   public void elbowAutomatedControl() {

       switch (armState) {
           case ARM_START:
               if (gamepad2.dpad_left) {
                   Handy.closeWrist();
                   Handy.closeHand();
                   armState = ArmState.ARM_RAISE;
               }
               break;
           case ARM_RAISE:
               if (Handy.elbow.getPosition() - Handy.elbowMaxPos < 0.05) {
                   Handy.openWrist();
                   armState = ArmState.ARM_REST;
               }
               break;
           case ARM_REST:
               if (gamepad2.dpad_left) {
                   Handy.closeWrist();
                   Handy.closeHand();
                   armState = ArmState.ARM_RETRACT;
               }
               break;
           case ARM_RETRACT:
               if (Handy.elbow.getPosition() - Handy.elbowMinPOs < 0.05) {
                   Handy.closeWrist();
                   armState = ArmState.ARM_START;
               }
               break;
           default:
               armState = ArmState.ARM_START;
       }

   }

    public void elbowManualControl() {

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


    /**  ********  HAND METHODS USING GAMEPAD2 *************      **/

    public void handControl() {

        if (gamepad2.a) {
            Handy.openWrist();
            Handy.point();
            handGesture = "Pointing";
        } else if (gamepad2.b) {
            Handy.openWrist();
            Handy.surferWave();
            handGesture = "Surfer Wave";
        } else if (gamepad2.y) {
            Handy.openWrist();
            Handy.peace();
            handGesture = "Peace Sign";
        } else if (gamepad2.x) {
            Handy.openWrist();
            Handy.thumbsUp();
            handGesture = "Thumbs Up";
        } else {
            Handy.closeWrist();
            Handy.closeHand();
            handGesture = "Close Hand";
        }
    }


}
