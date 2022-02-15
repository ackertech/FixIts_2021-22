package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Candace_Nate extends FourMotorDrive{
    // Servo Vars
    public Servo flag = null;
    public HardwareMap hwBot = null;
    //LED vars
    public RevBlinkinLedDriver ledlights;
    public RevBlinkinLedDriver.BlinkinPattern ledpattern;


    //public Candace_Nate() {}




        public void initRobot (HardwareMap hwMap){
            hwBot = hwMap;
            leftMotor1 = hwBot.dcMotor.get("left_motor1");
            //1
            rightMotor1 = hwBot.dcMotor.get("right_motor1");
            //0
            leftMotor2 = hwBot.dcMotor.get("left_motor2");
            //3
            rightMotor2 = hwBot.dcMotor.get("right_motor2");
            //2

            leftMotor1.setDirection(DcMotor.Direction.FORWARD);
            leftMotor2.setDirection(DcMotor.Direction.FORWARD);
            rightMotor1.setDirection(DcMotor.Direction.REVERSE);
            rightMotor2.setDirection(DcMotor.Direction.REVERSE);

            setMotorRunModes(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            setMotorRunModes(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            leftMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            flag = hwBot.get(Servo.class, "flag");
            flag.setDirection(Servo.Direction.FORWARD);

            ledlights = hwBot.get(RevBlinkinLedDriver.class, "led strip");
            ledpattern = RevBlinkinLedDriver.BlinkinPattern.COLOR_WAVES_RAINBOW_PALETTE;
            ledlights.setPattern(ledpattern);
        }
        public void raiseFlag () {
            flag.setPosition(0.9);
        }
        public void lowerFlag () {
            flag.setPosition(0.1);
        }
        public void waveFlagRight () {
            // flag.setPosition(0.9);
            flag.setPosition(0.5);
        }
        public void waveFlagLeft () {
            flag.setPosition(0.9);
            // flag.setPosition(0.5);
        }
        public void initFlag () {
            flag.setPosition(0.5);
        }
        public void setLedpattern (RevBlinkinLedDriver.BlinkinPattern patternName) {
        ledlights.setPattern(patternName);
        }

}

//jda