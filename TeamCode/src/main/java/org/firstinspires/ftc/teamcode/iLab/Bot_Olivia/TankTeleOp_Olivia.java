package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

//@Disabled
@TeleOp(name = "TankBot_Olivia")

public class TankTeleOp_Olivia extends OpMode {

    //TeleOp Driving Behavior Variables
    public double speedSlowerDowner = 0.75;

    //GamePad Variables
    double leftStickYVal;
    double leftStickXVal;


    // Construct the Physical Bot based on the Robot Class
    //Saying use the blueprint that we just created and physically construct it
    public TankBot_Olivia Kenny_Yamamoto = new TankBot_Olivia();
    public Susans_arm_and_hand Handy = new Susans_arm_and_hand();


    //TeleOp Initialize Method. This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Kenny_Yamamoto.initRobot(hardwareMap);
        Handy.initTKBaha(hardwareMap);

    }

    //TeleOp loop Method/ This starts AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {
        ellie();
        drive();
        scooter();
        handControl();



    }


    /**
     * ************* DRIVING METHODS USING GAMEPAD1 ********************
     **/

    public void ellie() {
        if (gamepad1.dpad_right == true) {
            speedSlowerDowner = 0.25;
        } else if (gamepad1.dpad_down == true) {
            speedSlowerDowner = 0.50;
        } else if (gamepad1.dpad_left == true) {
            speedSlowerDowner = 0.75;
        } else if (gamepad1.dpad_up == true) {
            speedSlowerDowner = 1.00;
        }
    }

        public void drive () {
            leftStickYVal = gamepad1.left_stick_y;
            leftStickYVal = Range.clip(leftStickYVal, -1, 1);
            leftStickXVal = gamepad1.left_stick_x;
            leftStickXVal = Range.clip(leftStickXVal, -1, 1);

            if (leftStickYVal < -0.1) {
                Kenny_Yamamoto.driveForward(speedSlowerDowner * leftStickYVal);
            } else if (leftStickYVal > 0.1) {
                Kenny_Yamamoto.driveBackwards(speedSlowerDowner * leftStickYVal);
            } else if (leftStickXVal > 0.1) {
                Kenny_Yamamoto.turnRight(speedSlowerDowner * leftStickXVal);
            } else if (leftStickXVal < -0.1) {
                Kenny_Yamamoto.turnLeft(speedSlowerDowner * leftStickXVal);
            } else {
                Kenny_Yamamoto.stopMotors();
            }

        }
        public void handControl(){
        if (gamepad2.a) {
            Handy.openWrist();
            Handy.point();
        } else if (gamepad2.b) {
            Handy.aloha();
        }
        // do for rest of actions
        }

        //bob = telemetry output
        public void scooter() {
           telemetry.addLine("I See Everything -Connor");
            telemetry.addData("Moxxi: ", speedSlowerDowner);
            telemetry.addData("Mordecai: ", Kenny_Yamamoto.frontLeftMotor.getPower());
            telemetry.addData("Lilith: ", Kenny_Yamamoto.rearLeftMotor.getPower());
            telemetry.addData("Brick: ", Kenny_Yamamoto.frontRightMotor.getPower());
            telemetry.addData("Roland: ", Kenny_Yamamoto.rearRightMotor.getPower());
            telemetry.update();


        }
    }






