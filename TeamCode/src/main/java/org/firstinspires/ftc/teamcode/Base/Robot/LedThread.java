package org.firstinspires.ftc.teamcode.Base.Robot;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class LedThread extends Thread {


    //Threading Variables & Constructor
    public LinearOpMode linearOp = null;


    public LedThread() {}

    public AckerBot Bot = new AckerBot();


    public void setLinearOp(LinearOpMode linearOp) {

        this.linearOp = linearOp;
    }


    @Override
    public void run() {
        linearOp.telemetry.addData("Thread Status:","Starting Thread");
        linearOp.telemetry.update();

        try {

            while (!isInterrupted() && linearOp.opModeIsActive()) {

                Bot.ledLights.setPattern(Bot.patternArray[0]);
                linearOp.telemetry.addData("Thread Status:","Pattern 0");
                linearOp.telemetry.update();
               // wait(2000);

                Bot.ledLights.setPattern(Bot.patternArray[1]);
                linearOp.telemetry.addData("Thread Status:","Pattern 1");
                linearOp.telemetry.update();
                //wait(2000);

                Bot.ledLights.setPattern(Bot.patternArray[2]);
                linearOp.telemetry.addData("Thread Status:","Pattern 2");
                linearOp.telemetry.update();
                //wait(2000);

            }
        }
        //catch (InterruptedException e) {}
        catch (Exception e) {
            linearOp.telemetry.addData("Thread Status:", "Interrupted Thread");
            linearOp.telemetry.update();
        }

    }


}
