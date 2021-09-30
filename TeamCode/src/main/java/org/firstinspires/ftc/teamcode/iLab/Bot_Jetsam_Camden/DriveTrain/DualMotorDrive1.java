package org.firstinspires.ftc.teamcode.iLab.Bot_Jetsam_Camden.DriveTrain;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class DualMotorDrive1 {

    //variables

    public DcMotor rearLeftMotor;
    public DcMotor rearRightMotor;

//linear Op

    public LinearOpMode linearOp = null;
    public void setLinearOp(LinearOpMode linearOp){
        this.linearOp = linearOp;

    }


    //methods

    public void setMotorRunModes (DcMotor.RunMode mode){

        rearLeftMotor.setMode(mode);
        rearRightMotor.setMode(mode);
    }

    public void stopMotors ()   {

        rearLeftMotor.setPower(0);
        rearRightMotor.setPower(0);
    }

    public void driveBackward (double power) {
        double ABSpower = Math.abs(power);

        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(ABSpower);
    }

    public void driveForward (double power) {
        double ABSpower = Math.abs(power);

        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(-ABSpower);
    }

    public void turnRight (double power) {
        double ABSpower = Math.abs(power);

        rearLeftMotor.setPower(ABSpower);
        rearRightMotor.setPower(-ABSpower);
    }

    public void turnLeft (double power) {
        double ABSpower = Math.abs(power);

        rearLeftMotor.setPower(-ABSpower);
        rearRightMotor.setPower(ABSpower);
    }


}
