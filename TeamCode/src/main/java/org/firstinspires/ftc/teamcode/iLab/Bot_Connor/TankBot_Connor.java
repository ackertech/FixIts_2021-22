package org.firstinspires.ftc.teamcode.iLab.Bot_Connor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TankBot_Connor extends Tank_FourMotorDrive_Connor{
    //define Mechinism Varibles
    //Set Lazy Susan movement values

    public DcMotor sidewaysLinearMotor;
    public DcMotor upAndDownLinearMotor;
    public DcMotor lazy_Susan;

    public static final double TICKS_PER_ROTATION_5203 = 751.8;
    public static final double TICKS_PER_ROTATION_5202 = 384.5;

    //Hardware Mapping Variable used by robot controller
    public HardwareMap hwBot = null;

    //Robot Physical Constructor used in TeleOp and Autonomous
    public TankBot_Connor () { }

    // Custom Method that will initilize the robot hardware in TeleOp and Autonomous
    public void initRobot (HardwareMap hwMap) {
        hwBot = hwMap;

        //Define the name of the motors used in the control hub configuation
        frontLeftMotor = hwBot.dcMotor.get("frontLeftMotor"); //Port 0
        frontRightMotor = hwBot.dcMotor.get("frontRightMotor");// Port 2
        rearLeftMotor = hwBot.dcMotor.get("rearLeftMotor");// Port 1
        rearRightMotor = hwBot.dcMotor.get("rearRightMotor");// Port 3

        //Sets the direction of the robot's motors based on physical placement
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotor.Direction.REVERSE);
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

        //Expansion Hub Port 2
        lazy_Susan = hwBot.dcMotor.get("lazySusan");
         lazy_Susan.setDirection(DcMotor.Direction.FORWARD);
         lazy_Susan.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

         lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
         lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        /** Linear Actuatiors*********    **/

        sidewaysLinearMotor = hwBot.dcMotor.get("sidewaysLinearMotor"); //Expantion Hub Port 0
        upAndDownLinearMotor = hwBot.dcMotor.get("upAndDownLinearMotor"); //Expantion Hub Port 1

        sidewaysLinearMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        upAndDownLinearMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        sidewaysLinearMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        upAndDownLinearMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        sidewaysLinearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        sidewaysLinearMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        upAndDownLinearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        upAndDownLinearMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void lazySusanLeft (double power) {
        lazy_Susan.setPower(Math.abs(power));
    }

    public void lazySusanRight (double power) {
        lazy_Susan.setPower(-Math.abs(power));
    }

    public void lazySusanStop(){
        lazy_Susan.setPower(0);
    }

    public                  void lazySusanLeft( double                 power, double                 rotations){
        double ticks = rotations * TICKS_PER_ROTATION_5203;
        lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (lazy_Susan.getCurrentPosition() < ticks) {
            lazySusanLeft(power); }

        lazySusanStop();
    }

    public void lazySusanRight(double                  power, double                  rotations) {
        double ticks = rotations * (-1) * TICKS_PER_ROTATION_5203;
        lazy_Susan.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lazy_Susan.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        while (lazy_Susan.getCurrentPosition() > ticks) {
            lazySusanRight(power);
        }
        lazySusanStop();
    }

    public void stopSidewaysLinearMotor(){
        sidewaysLinearMotor.setPower(0);
    }

    public void stopUpAndDownLinearMotor(){
        upAndDownLinearMotor.setPower(0);
    }

    public void sidewaysLinearMotorLeft(){
        sidewaysLinearMotor.setPower(-100);
    }

    public void sidewaysLinearMotorRight() {
        sidewaysLinearMotor.setPower(100);
    }

    public void upAndDownLinearMotorUp(){
        upAndDownLinearMotor.setPower(100);
    }

    public void upAndDownLinearMotorDown(){
        upAndDownLinearMotor.setPower(-100);
    }

}
