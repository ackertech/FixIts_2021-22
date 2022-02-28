package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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


    //TeleOp Initialize Method. This is the Init Button on the Driver Station Phone
    @Override
    public void init() {

        Kenny_Yamamoto.initRobot(hardwareMap);

    }

    //TeleOp loop Method/ This starts AFTER clicking the Play Button on the Driver Station Phone

    public void loop() {

    }



    /** ************** DRIVING METHODS USING GAMEPAD1 ******************** **/

    public void speedControl () {
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
    }



