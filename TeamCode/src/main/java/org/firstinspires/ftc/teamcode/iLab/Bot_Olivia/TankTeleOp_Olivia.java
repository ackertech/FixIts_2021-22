package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "TankBot_Olivia")

public class TankTeleOp_Olivia extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedMultiply = 0.75;

    //GamePad Variables
    double leftStickYVal;
    double leftStickXVal;


    // Construct the Physical Bot based on the Robot Class
    //Saying use the blueprint that we just created and physically construct it
    public TankBot_Olivia Bot = new TankBot_Olivia();
    public Susans_arm_and_hand Handy = new Susans_arm_and_hand();


    //TeleOp Initialize Method. This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Bot.initRobot(hardwareMap);
        Handy.initArmHand(hardwareMap);

    }

    //TeleOp loop Method/ This starts AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {
        speedControl();
        drive();
        telemetryOutput();
        handControl();
        armControl();



    }


    /**
     * ************* DRIVING METHODS USING GAMEPAD1 ********************
     **/

    public void speedControl() {
        if (gamepad1.dpad_right == true) {
            speedMultiply = 0.25;
        } else if (gamepad1.dpad_down == true) {
            speedMultiply = 0.50;
        } else if (gamepad1.dpad_left == true) {
            speedMultiply = 0.75;
        } else if (gamepad1.dpad_up == true) {
            speedMultiply = 1.00;
        }
    }

        public void drive () {
            leftStickYVal = gamepad1.left_stick_y;
            leftStickYVal = Range.clip(leftStickYVal, -1, 1);
            leftStickXVal = gamepad1.left_stick_x;
            leftStickXVal = Range.clip(leftStickXVal, -1, 1);

            if (leftStickYVal < -0.1) {
                Bot.driveForward(speedMultiply * leftStickYVal);
            } else if (leftStickYVal > 0.1) {
                Bot.driveBackwards(speedMultiply * leftStickYVal);
            } else if (leftStickXVal > 0.1) {
                Bot.turnRight(speedMultiply * leftStickXVal);
            } else if (leftStickXVal < -0.1) {
                Bot.turnLeft(speedMultiply * leftStickXVal);
            } else {
                Bot.stopMotors();
            }

        }
        public void armControl(){
        if (gamepad2.x) {
            Handy.raiseArm();}
            if (gamepad2.y) {
                Handy.lowerArm();
        }


        }

        public void handControl(){
        if (gamepad2.a) {
            Handy.openWrist();
            Handy.point();
        } else if (gamepad2.b) {
            Handy.aloha();
        }
        else if (gamepad2.dpad_up) {
            Handy.open(); }
        else if (gamepad2.dpad_down){
            Handy.close(); }
        // do for rest of actions
        }

        //bob = telemetry output
        public void telemetryOutput() {
            telemetry.addLine("I Still See All -Connor");
            telemetry.addData("Speed: ", speedMultiply);
            telemetry.addData("Front Left Motor Power: ", Bot.frontLeftMotor.getPower());
            telemetry.addData("Rear Left Motor Power: ", Bot.rearLeftMotor.getPower());
            telemetry.addData("Front Right Motor Power: ", Bot.frontRightMotor.getPower());
            telemetry.addData("Rear Right Motor Power: ", Bot.rearRightMotor.getPower());
            telemetry.addData("Elbow Position: ", Handy.elbow.getPosition());
            telemetry.addData("Elbow Min Position: ", Handy.elbowMinPos);
            telemetry.addData("Elbow Max Position: ", Handy.elbowMaxPos);

            telemetry.update();



        }
    }






