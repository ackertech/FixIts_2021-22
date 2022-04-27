package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.util.concurrent.TimeUnit;

//@Disabled
@TeleOp(name = "Thomas_The_TankBot_Drive_Basic_Connor_Beethoven's_Wig")
public class Tank_TeleOp_Connor extends OpMode{

    ElapsedTime timer = new ElapsedTime();
    //TeleOp Driving Behavior Variables
    public double speedMultiply = 0.50;
    public enum Style {
        ONESTICK, TWOSTICK, TANK
    }
    public enum Gamepad2_Style {
        HANDGESTURES, CANDYBOX, COUNTINGWITHELMOMANNUAL, COUNTINGWITHELMOAUTO, CLAW
    }

    public enum ArmControl {AUTO, MANUAL}
    public ArmControl armControl = ArmControl.MANUAL;

    public enum LazySusanControl {AUTO, MANUAL}
    public LazySusanControl lazySusanControl = LazySusanControl.MANUAL;
    public enum LazySusanEncoder {FORWARD, REVERSE, OFF}
    public LazySusanEncoder lazySusanEncoder = LazySusanEncoder.OFF;
    public double lazySusanTicks = 5000;
    public double lazySusanPower = 0.90;

    public double UpAndDownLinearMotorTicks = 900; //will need to change later
    public enum ControlOfUpAndDownLinearMotor {FORWARD, REVERSE}
    public ControlOfUpAndDownLinearMotor controlOfUpAndDownLinearMotor = ControlOfUpAndDownLinearMotor.FORWARD;

    public Style driverStyle = Style.ONESTICK;
    public Gamepad2_Style gamepadTwoStyle = Gamepad2_Style.HANDGESTURES;

    public enum CountState {ONE, TWO, THREE, FOUR, FIVE, ELMOISDONEFORNOW, ELMOGOESNIGHTNIGHT}
    public CountState countingState = CountState.ONE;

    public double leftSidePower;
    public double rightSidePower;


    //GamePad Variables
    double leftStickYVal;
    double leftStickXVal;
    double rightStickYVal;
    double rightStickXVal;
    double currentTime;
    double delayTime = 1.0;


    // Construct the Physical Bot based on the Robot Class
    public TankBot_Connor Thomas_The_Tank = new TankBot_Connor();
    public The_Mighty_and_All_Powerful_Hand Hand = new The_Mighty_and_All_Powerful_Hand();

    //TeleOp Initilize method. This is the Init Button on the Driver Station Phone.
    @Override
    public void init () {

        Thomas_The_Tank.initRobot(hardwareMap);
        Hand.initThe_Mighty_and_All_Powerful_Hand(hardwareMap);
        timer.reset();

    }

    // TeleOp Loop Method. This start After clicking the Play button on the Driver Station Phone

        public void loop() {

        speedControl();
        drivingStyle();
        drive();
        gamepadTwoStyle();
        gamepad2Control();
        telemetryOutput();

    }

    @Override
    public void stop() {
        Hand.closeHand();
        Hand.lowerArm();
    }

     public void speedControl () {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.50;}
            else if (gamepad1.dpad_down == true) {
                speedMultiply = 0.60;}
            else if (gamepad1.dpad_left == true) {
                speedMultiply = 0.75;}
            else if (gamepad1.dpad_up == true){
                speedMultiply = 0.25;}
            else if (gamepad1.a == true){
                speedMultiply = 1.00;}
        }

        public void gamepad2Control() {
            switch (gamepadTwoStyle) {
                case HANDGESTURES:
                    lazySusanControl();
                    if (gamepad2.right_bumper && gamepad2.left_bumper) {
                        Hand.wave();
                    }
                    if (gamepad2.dpad_up) {
                        Hand.thumbsUp();
                    }
                    if (gamepad2.dpad_down) {
                        Hand.thumbsDown();
                    }
                    if (gamepad2.dpad_left) {
                        Hand.point();
                    }
                    if (gamepad2.dpad_right) {
                        Hand.peaceSign();
                    }
                    if (gamepad2.left_bumper && gamepad2.right_bumper == false) {
                        Hand.openHand();
                    }
                    if (gamepad2.right_bumper && gamepad2.left_bumper == false) {
                        Hand.closeHand();
                    }
                    if (gamepad2.y) {
                        Hand.smack();
                        speedMultiply = 1.00;
                    }

                    if (gamepad2.left_trigger > 0.1) {
                        Hand.raiseArm();
                    }

                    if (gamepad2.right_trigger > 0.1) {
                        Hand.lowerArm();
                    }

                    if (gamepad2.x) {
                        if (lazySusanControl == lazySusanControl.MANUAL) {
                            lazySusanControl = lazySusanControl.AUTO;
                        } else {
                            lazySusanControl = lazySusanControl.MANUAL;
                        }
                    }
                    break;

                case CANDYBOX:
                    lazySusanControl();


                    break;


                case COUNTINGWITHELMOMANNUAL:
                    lazySusanControl();

                    if (gamepad2.dpad_up) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(0);
                        Hand.ringFinger.setPosition(0);
                        Hand.pinkyFinger.setPosition(0);
                    }

                    else if (gamepad2.dpad_right) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(0);
                        Hand.pinkyFinger.setPosition(0);
                    }

                    else if (gamepad2.dpad_down) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(1);
                        Hand.pinkyFinger.setPosition(0);
                    }

                    else if (gamepad2.dpad_left) {
                        Hand.thumb.setPosition(0);
                        Hand.indexFinger.setPosition(1);
                        Hand.middleFinger.setPosition(1);
                        Hand.ringFinger.setPosition(1);
                        Hand.pinkyFinger.setPosition(1);
                    }

                    else if (gamepad2.left_bumper) {
                        Hand.openHand();
                    }

                    else if (gamepad2.right_bumper) {
                        Hand.closeHand();
                    }

                    if (gamepad2.back) {
                        Hand.wristLeft();
                    }

                    else if (gamepad2.start) {
                        Hand.wristRight();
                    }

                    else if (gamepad2.y) {
                        Hand.wristMiddle();
                    }

                    if (gamepad2.left_trigger > 0.1) {
                        Hand.raiseArm();
                    }

                   else  if (gamepad2.right_trigger > 0.1) {
                        Hand.lowerArm();
                    }



                    break;

                case COUNTINGWITHELMOAUTO:
                    switch (countingState) {
                        case ONE:
                            Hand.thumb.setPosition(0);
                            Hand.indexFinger.setPosition(1);
                            Hand.middleFinger.setPosition(0);
                            Hand.ringFinger.setPosition(0);
                            Hand.pinkyFinger.setPosition(0);
                            timer.reset();
                            countingState = CountState.TWO;
                            break;

                        case TWO:
                            if (timer.seconds() > 2) {
                                Hand.thumb.setPosition(0);
                                Hand.indexFinger.setPosition(1);
                                Hand.middleFinger.setPosition(1);
                                Hand.ringFinger.setPosition(0);
                                Hand.pinkyFinger.setPosition(0);
                                timer.reset();
                                countingState = CountState.THREE;
                            }
                            break;

                        case THREE:
                            if (timer.seconds() > 2) {
                                Hand.thumb.setPosition(0);
                                Hand.indexFinger.setPosition(1);
                                Hand.middleFinger.setPosition(1);
                                Hand.ringFinger.setPosition(1);
                                Hand.pinkyFinger.setPosition(0);
                                timer.reset();
                                countingState = CountState.FOUR;
                            }
                            break;

                        case FOUR:
                            if (timer.seconds() > 2) {
                                Hand.thumb.setPosition(0);
                                Hand.indexFinger.setPosition(1);
                                Hand.middleFinger.setPosition(1);
                                Hand.ringFinger.setPosition(1);
                                Hand.pinkyFinger.setPosition(1);
                                timer.reset();
                                countingState = CountState.FIVE;
                            }
                                break;

                        case FIVE:
                            if (timer.seconds() > 2) {
                                Hand.thumb.setPosition(1);
                                Hand.indexFinger.setPosition(1);
                                Hand.middleFinger.setPosition(1);
                                Hand.ringFinger.setPosition(1);
                                Hand.pinkyFinger.setPosition(1);
                                timer.reset();
                                countingState = CountState.ELMOISDONEFORNOW;
                            }
                            break;

                        case ELMOISDONEFORNOW:
                            if (timer.seconds() > 2) {
                                Hand.closeHand();
                                countingState = CountState.ELMOGOESNIGHTNIGHT;
                            }
                            break;





                    }

                    if (gamepad2.left_trigger > 0.1) {
                        Hand.raiseArm();
                    }

                    else if (gamepad2.right_trigger > 0.1) {
                        Hand.lowerArm();
                    }

                    if (gamepad2.back) {
                        Hand.wristRight();
                    }

                    else if (gamepad2.start) {
                        Hand.wristLeft();
                    }

                    else if (gamepad2.y) {
                        Hand.wristMiddle();
                    }



                        break;

                case CLAW:
                    UpAndDownLinearMotorControl();

                    if (gamepad2.left_trigger > 0.1) {
                        Hand.clawOpen();
                    }

                    else if (gamepad2.right_trigger > 0.1) {
                        Hand.clawClose();
                    }
            }

        }

    public void UpAndDownLinearMotorControl() {

       if (gamepad2.left_bumper) {

           Thomas_The_Tank.upAndDownLinearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
           controlOfUpAndDownLinearMotor = controlOfUpAndDownLinearMotor.REVERSE;

       }

       else if (gamepad2.right_bumper){

           Thomas_The_Tank.upAndDownLinearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
           controlOfUpAndDownLinearMotor = controlOfUpAndDownLinearMotor.FORWARD;


       }

        if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.FORWARD) {
            if ( Math.abs(Thomas_The_Tank.upAndDownLinearMotor.getCurrentPosition()) < 1500) {
                Thomas_The_Tank.upAndDownLinearMotor.setPower(0.4);
            }

            else {Thomas_The_Tank.upAndDownLinearMotor.setPower(0);}
        }

        if (controlOfUpAndDownLinearMotor == controlOfUpAndDownLinearMotor.REVERSE) {
            if (Math.abs(Thomas_The_Tank.upAndDownLinearMotor.getCurrentPosition()) < 1500) {
                Thomas_The_Tank.upAndDownLinearMotor.setPower(-0.4);
            }

            else {Thomas_The_Tank.upAndDownLinearMotor.setPower(0);}
        }
    }



public void lazySusanControl() {
        if (gamepad2.x) {
            if (lazySusanControl == lazySusanControl.MANUAL) {
                lazySusanControl = lazySusanControl.AUTO;
            }

            else  {
                lazySusanControl = lazySusanControl.MANUAL;
            }
        }

        if (lazySusanControl == lazySusanControl.MANUAL) {
            if (gamepad2.right_stick_x > 0.1) {
                Thomas_The_Tank.lazySusanLeft(lazySusanPower);
            }

            else if (gamepad2.right_stick_x < -0.1) {
                Thomas_The_Tank.lazySusanRight(lazySusanPower);
            }

            else{
                Thomas_The_Tank.lazySusanStop();
            }
        }

        else if (lazySusanControl == lazySusanControl.AUTO) {
            if (gamepad2.left_bumper) {
                lazySusanEncoder = lazySusanEncoder.FORWARD;
                Thomas_The_Tank.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Thomas_The_Tank.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (gamepad2.right_bumper) {
                lazySusanEncoder = lazySusanEncoder.REVERSE;
                Thomas_The_Tank.lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                Thomas_The_Tank.lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }

            if (lazySusanEncoder == lazySusanEncoder.FORWARD) {
                if (Math.abs(Thomas_The_Tank.lazy_Susan.getCurrentPosition()) < lazySusanTicks ){
                 Thomas_The_Tank.lazy_Susan.setPower(lazySusanPower);
                }
                else {
                    Thomas_The_Tank.lazy_Susan.setPower(0);
                }
            }

            else if (lazySusanEncoder == lazySusanEncoder.REVERSE) {
                if (Math.abs(Thomas_The_Tank.lazy_Susan.getCurrentPosition()) < lazySusanTicks ) {
                    Thomas_The_Tank.lazy_Susan.setPower(-lazySusanPower);
                }
                else {
                    Thomas_The_Tank.lazy_Susan.setPower(0);
                }
            }

        }
}



        public void drive() {

        switch (driverStyle) {
            case ONESTICK:


                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Thomas_The_Tank.driveForward(speedMultiply * leftStickYVal);
                } else if (leftStickYVal > 0.1) {
                    Thomas_The_Tank.driveBackwards(speedMultiply * leftStickYVal);
                } else if (leftStickXVal > 0.1) {
                    Thomas_The_Tank.rotateRight(speedMultiply * leftStickXVal);
                } else if (leftStickXVal < -0.1) {
                    Thomas_The_Tank.rotateLeft(speedMultiply * leftStickXVal);
                } else {
                    Thomas_The_Tank.stopMotors();
                }
                break;

            case TWOSTICK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);
                leftStickXVal = gamepad1.left_stick_x;
                leftStickXVal = Range.clip(leftStickXVal, -1, 1);
                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);
                rightStickXVal = gamepad1.right_stick_x;
                rightStickXVal = Range.clip(rightStickXVal, -1, 1);

                if (leftStickYVal < -0.1) {
                    Thomas_The_Tank.driveForward(speedMultiply*leftStickYVal);
                }
                else if (leftStickYVal > 0.1){
                    Thomas_The_Tank.driveBackwards(speedMultiply*leftStickYVal);
                }

                else if (rightStickXVal > 0.1) {
                    Thomas_The_Tank.rotateRight(speedMultiply*rightStickXVal);
                }

                else if (rightStickXVal < -0.1) {
                    Thomas_The_Tank.rotateLeft(speedMultiply*rightStickXVal);
                }
                else {
                    Thomas_The_Tank.stopMotors();
                }
                break;


            case TANK:
                leftStickYVal = gamepad1.left_stick_y;
                leftStickYVal = Range.clip(leftStickYVal, -1, 1);

                rightStickYVal = gamepad1.right_stick_y;
                rightStickYVal = Range.clip(rightStickYVal, -1, 1);

                leftSidePower = speedMultiply * leftStickYVal * (-1);
                rightSidePower = speedMultiply * rightStickYVal * (-1);
                Thomas_The_Tank.tankDrive(leftSidePower, rightSidePower);
                break;



            }
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
        telemetry.addData("UpAndDownLinearMotorTicksMeasurement", Thomas_The_Tank.upAndDownLinearMotor.getCurrentPosition());
        if (driverStyle == Style.ONESTICK) {
            telemetry.addLine("OneStick Drive");
        }
        else if (driverStyle == Style.TANK) {
            telemetry.addLine("Tank Drive");
        }
        else if (driverStyle == Style.TWOSTICK) {
            telemetry.addLine(" TwoStick Drive");
            }
        if (gamepadTwoStyle == Gamepad2_Style.HANDGESTURES) {
            telemetry.addLine("Hand Gestures Mode");
        }
        else if (gamepadTwoStyle == Gamepad2_Style.CANDYBOX) {
            telemetry.addLine("CandyBox Mode");
        }

        if (lazySusanEncoder == lazySusanEncoder.FORWARD) {
            telemetry.addLine("Lazy Susan Encoder is FORWARD");
        }

        else if (lazySusanEncoder == lazySusanEncoder.REVERSE) {
            telemetry.addLine("Lazy Susan Encoder is REVERSE");
        }

        if (lazySusanControl == lazySusanControl.MANUAL) {
            telemetry.addLine("Lazy Susan Control MANUAL");
        }

        else if (lazySusanControl == lazySusanControl.AUTO) {
            telemetry.addLine("Lazy Susan Control AUTOMATIC");
        }

        if (gamepadTwoStyle == Gamepad2_Style.COUNTINGWITHELMOMANNUAL) {
            telemetry.addLine("You Are Now Counting With Elmo Manually");
        }
        else if (gamepadTwoStyle == Gamepad2_Style.COUNTINGWITHELMOAUTO) {
            telemetry.addLine("You Are Now Counting With Elmo Automaticly");
        }
        telemetry.update();
    }
    public void drivingStyle () {

        if (gamepad1.x) {
            driverStyle = Style.ONESTICK;

        }
        if (gamepad1.b)
        { driverStyle = Style.TANK;

        }

        if (gamepad1.y)
        { driverStyle = Style.TWOSTICK;}


    }

    public void gamepadTwoStyle() {
        if (gamepad2.b) {
            gamepadTwoStyle = Gamepad2_Style.HANDGESTURES; }
        if (gamepad2.a) {
            gamepadTwoStyle = Gamepad2_Style.CANDYBOX; }
        if (gamepad2.left_stick_button) {
            gamepadTwoStyle = Gamepad2_Style.COUNTINGWITHELMOMANNUAL;
        }
        if (gamepad2.right_stick_button) {
            countingState = CountState.ONE;
            gamepadTwoStyle = Gamepad2_Style.COUNTINGWITHELMOAUTO;
        }
        if (gamepad1.back) {
            gamepadTwoStyle = Gamepad2_Style.CLAW;
        }
    }

        }

//hi

