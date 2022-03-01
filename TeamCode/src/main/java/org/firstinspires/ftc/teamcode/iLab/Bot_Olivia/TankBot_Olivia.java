package org.firstinspires.ftc.teamcode.iLab.Bot_Olivia;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TankBot_Olivia  extends Tank_4Motor_Olivia {

    //Define Mechanism Variables
    public Servo susan;

    //Set Lazy Susan movement values
    public double susanMaxPos = 0.5;
    public double susanMinPos = 0.25;
    public double susanCurrPos = 0.5;
    public double susanIncrements = 0.0005;

    //Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;

    //Robot Physical Constructor used in TeleOp and Autonomous classes
    public TankBot_Olivia() { }

    // Custom Method that will initialize the robot hardware in TeleOp and Autonomous
    public void initRobot (HardwareMap hwMap) {
        hwBot = hwMap;

        //Define the name of the motors used in control hub configuration
        frontLeftMotor = hwBot.dcMotor.get("frontleftmotor"); //port 0
        rearLeftMotor = hwBot.dcMotor.get("rearleftmotor"); //port 1
        frontRightMotor = hwBot.dcMotor.get("frontrightmotor"); //port 2
        rearRightMotor = hwBot.dcMotor.get("rearrightmotor"); //port 3

        //Sets the direction of the robot's motors based on physical placement
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        //Define robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        /**  ********************    TankBot_Olivia Mechanisms ******************** **/

        //Control Hub Port 0
        susan = hwBot.get(Servo.class, "susan");
        susan.setDirection(Servo.Direction.FORWARD);





    }


}
