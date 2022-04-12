package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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
    public enum Style {ARCADE1, ARCADE2, TANK}
    public Style driverStyle = Style.ARCADE1;

    //Arm & Elbow Variables
    public enum ArmState {ARM_START, ARM_RAISE, ARM_REST, ARM_RETRACT}
    ArmState armState = ArmState.ARM_START;
    public enum ArmControl {AUTO, MANUAL}
    public ArmControl armControl = ArmControl.MANUAL;

    //Linear Behavior Variables
    public enum LinearState {LINEAR_START, LINEAR_EXTEND, LINEAR_REST, LINEAR_RETRACT}
    LinearState linearState = LinearState.LINEAR_START;
    public enum LinearControl {AUTO, MANUAL}
    public LinearControl linearControl = LinearControl.MANUAL;
    public double horizontalTicks = 4000;
    public double horizontalPower = 0.75;

    //LazySusan Variables
    public enum LazySusanControl {AUTO, MANUAL}
    public LazySusanControl lazySusanControl = LazySusanControl.MANUAL;
    public enum LazySusanEncoder {FORWARD, REVERSE, OFF}
    public LazySusanEncoder lazySusanEncoder = LazySusanEncoder.OFF;
    public double lazySusanTicks = 5000;
    public double lazySusanPower = 0.90;

    //Counting Variables
    public enum CountState {NAPTIME, ONE, TWO, THREE, FOUR, FIVE, DONE}
    public CountState countingState = CountState.NAPTIME;
    public ElapsedTime elmoTimer = new ElapsedTime();

    // Timers

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
    }

    // TeleOp Loop Method.  This start AFTER clicking the Play Button on the Driver Station Phone
    @Override
    public void loop() {

        speedControl();
        driveControl();
        handControl();
        elbowControl();
        linearActuatorControl();
        lazySusanControl();
        telemetryOutput();

    }

    /**************************************
     *  Telemetry Controls
     **************************************/

    public void telemetryOutput() {
        telemetry.addData("Drive Style: ", driverStyle);
        telemetry.addData("Drive Speed: ", speedMultiply);
        telemetry.addData("Arm State: ", armState );
        telemetry.addData("Arm Control: ", armControl );
        telemetry.addData("Arm Position: ", Handy.elbow.getPosition() );
        telemetry.addData("LazySusan Position: ", Liney.lazySusanMotor.getCurrentPosition() );
        telemetry.addData("LazySusan Control: ", lazySusanControl);
        telemetry.addData("LazySusan Encoders: ", lazySusanEncoder);
        telemetry.addData("Hand Gesture: ", handGesture);
        telemetry.addData("Wrist Gesture: ", wristStatus);
        telemetry.addData("Linear State: ", linearState );
        telemetry.addData("Horizontal Position: ", Liney.horizontalMotor.getCurrentPosition() );
        telemetry.update();
    }

    /**************************************
     *  GAMEPAD 1 CONTROLS
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
     *  GAMEPAD 2 CONTROLS
     **************************************/

    /**  ********  Lazy Susan and Linear Actuator  *************      **/

    public void lazySusanControl() {

        if (gamepad2.y) {

            if (lazySusanControl == LazySusanControl.MANUAL) {

                lazySusanControl = LazySusanControl.AUTO;
            }
            else {
                lazySusanControl = LazySusanControl.MANUAL;
            }
        }

        if (lazySusanControl == LazySusanControl.MANUAL) {
            if (gamepad2.right_stick_x > 0.1) {

                Liney.rotateForward(lazySusanPower);
            }
            else if (gamepad2.right_stick_x < -0.1) {

                Liney.rotateReverse(lazySusanPower);
            }
            else {
                Liney.lazySusanMotor.setPower(0);
            }

        }
        else if (lazySusanControl == LazySusanControl.AUTO) {

             if (gamepad2.left_bumper) {
                 lazySusanEncoder = LazySusanEncoder.FORWARD;
                 Liney.lazySusanMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                 Liney.lazySusanMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
             }
             if (gamepad2.right_bumper) {
                 lazySusanEncoder = LazySusanEncoder.REVERSE;
                 Liney.lazySusanMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                 Liney.lazySusanMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
             }

             if (lazySusanEncoder == LazySusanEncoder.FORWARD) {

                if (Math.abs(Liney.lazySusanMotor.getCurrentPosition()) < lazySusanTicks ) {
                    Liney.lazySusanMotor.setPower(lazySusanPower);
                }
                else{
                    Liney.lazySusanMotor.setPower(0);
                }
            }
            else if (lazySusanEncoder == LazySusanEncoder.REVERSE) {

                if (Math.abs(Liney.lazySusanMotor.getCurrentPosition()) < lazySusanTicks ) {
                    Liney.lazySusanMotor.setPower(-lazySusanPower);
                }
                else {
                    Liney.lazySusanMotor.setPower(0);
                }
            }
        }

    }


    public void linearActuatorControl() {

        if (gamepad2.left_stick_button) {

            if (linearControl == LinearControl.MANUAL) {
                linearControl = LinearControl.AUTO;
            }
            else {
                linearControl = LinearControl.MANUAL;
            }

        }

        if (linearControl == LinearControl.MANUAL) {
            if (gamepad2.left_stick_x > 0.1) {
                Liney.moveLinearForward(horizontalPower);
            }
            else if (gamepad2.left_stick_x < -0.1) {
                Liney.moveLinearReverse(horizontalPower);
            }
            else {
                Liney.horizontalMotor.setPower(0);
            }
        }
        else if (linearControl == LinearControl.AUTO) {

            switch (linearState) {
                case LINEAR_START:
                    if (gamepad2.left_trigger > 0.1) {
                        Liney.horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        Liney.horizontalMotor.setPower(horizontalPower);
                        linearState = LinearState.LINEAR_EXTEND;
                    }
                    break;

                case LINEAR_EXTEND:
                    if ( Liney.horizontalMotor.getCurrentPosition() > horizontalTicks ) {
                        Liney.horizontalMotor.setPower(0);
                        linearState = LinearState.LINEAR_RETRACT;
                    }
                    break;

                case LINEAR_REST:
                    if (gamepad2.right_trigger > 0.1) {
                        Liney.horizontalMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                        Liney.horizontalMotor.setPower(-horizontalPower);
                        linearState = LinearState.LINEAR_RETRACT;
                    }
                    break;

                case LINEAR_RETRACT:
                    if ( (Liney.horizontalMotor.getCurrentPosition() > horizontalTicks) ) {
                        Liney.horizontalMotor.setPower(0);
                        linearState = LinearState.LINEAR_START;
                    }
                    break;

                default:
                    linearState = LinearState.LINEAR_START;
            }

        }

    }

    /**  ********  ARM and ELBOW METHODS USING GAMEPAD2 *************      **/

   public void elbowControl() {

       if (gamepad2.dpad_left) {
           armControl = ArmControl.AUTO;
       }
       if (gamepad2.dpad_right) {
           armControl = ArmControl.MANUAL;
       }

       if (armControl == ArmControl.AUTO) {

           switch (armState) {
               case ARM_START:
                   if (gamepad2.dpad_up) {
                       Handy.openHand();
                       Handy.elbow.setPosition(Handy.elbowMaxPos);
                       armState = ArmState.ARM_RAISE;
                   }
                   break;
               case ARM_RAISE:
                   Handy.openHand();
                   Handy.openWrist();
                   armState = ArmState.ARM_REST;

                   break;
               case ARM_REST:
                   if (gamepad2.dpad_down) {
                       Handy.closeWrist();
                       Handy.closeHand();
                       Handy.elbow.setPosition(Handy.elbowMinPOs);
                       armState = ArmState.ARM_RETRACT;
                   }
                   break;
               case ARM_RETRACT:
                   Handy.openWrist();
                   armState = ArmState.ARM_START;

                   break;
               default:
                   armState = ArmState.ARM_START;
           }

       }
       else if (armControl == ArmControl.MANUAL) {

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


   }


    /**  ********  HAND METHODS USING GAMEPAD2 *************      **/

    public void countWithElmo() {

        switch (countingState) {

            case ONE:
                Handy.countOne();
                elmoTimer.reset();
                countingState = CountState.TWO;
                break;

            case TWO:

                if (elmoTimer.seconds() > 2.5) {
                    Handy.closeHand();
                    Handy.countTwo();
                    elmoTimer.reset();
                    countingState = CountState.THREE;
                }
                break;

            case THREE:
                if (elmoTimer.seconds() > 2.5) {
                    Handy.closeHand();
                    Handy.countThree();
                    elmoTimer.reset();
                    countingState = CountState.FOUR;
                }
                break;

            case FOUR:
                if (elmoTimer.seconds() > 2.5) {
                    Handy.closeHand();
                    Handy.countFour();
                    elmoTimer.reset();
                    countingState = CountState.FIVE;
                }
                break;
            case FIVE:
                if (elmoTimer.seconds() > 2.5) {
                    Handy.closeHand();
                    Handy.countFive();
                    countingState = CountState.DONE;
                }
                break;

            case DONE:
                if (elmoTimer.seconds() > 2.5) {
                    Handy.closeHand();
                    countingState = CountState.NAPTIME;
                }
                break;
        }

    }

    public void handControl() {

        if (gamepad2.a) {
            countingState = CountState.ONE;
            countWithElmo();
            handGesture = "Counting with Elmo";
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
          //  Handy.closeWrist();
          //  Handy.closeHand();
            handGesture = "Close Hand";
        }
    }


}
