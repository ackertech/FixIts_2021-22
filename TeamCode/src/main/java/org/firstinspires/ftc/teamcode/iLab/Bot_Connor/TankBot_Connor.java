package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TankBot_Connor extends Tank_FourMotorDrive_Connor{
    //define Mechinism Varibles
    public Servo lazySusan;
    //Set Lazy Susan movement values
    public double lazySusanMaxPos = 0.5;
    public double lazySusanMinPos = 0.25;
    public double lazySusanCurrPos = 0.5;
    public double lazySusanIncrements = 0.0005;

    //Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;

    //Robot Physical Constructor used in TeleOp and Autonomous
    public TankBot_Connor () { }

    // Custom Method that will initilize the robot hardware in TeleOp and Autonomous
    public void initRobot (HardwareMap hwMap) {
        hwBot = hwMap;

        //Define the name of the motors used in the control hub configuation
        frontLeftMotor = hwBot.dcMotor.get("frontLeftMotor"); //Port 0
        frontRightMotor = hwBot.dcMotor.get("frontRightMotor");// Port 1
        rearLeftMotor = hwBot.dcMotor.get("rearLeftMotor");// Port 2
        rearRightMotor = hwBot.dcMotor.get("rearRightMotor");// Port 3

        //Sets the direction of the robot's motors based on physical placement
        frontLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotor.Direction.FORWARD);


        //Define this robot run modes
        setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Define this robot's braking modes
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        /**  ********  Tankbot_Connor Mechanisms ************     **/

        //Control Hub Port 0
        lazySusan = hwBot.get(Servo.class, "lazy_susan");
         lazySusan.setDirection(Servo.Direction.FORWARD);



    }

}
