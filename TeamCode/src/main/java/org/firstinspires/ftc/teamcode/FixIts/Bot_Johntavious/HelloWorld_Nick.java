package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp(name= "HelloWorld_Nick")

public class HelloWorld_Nick extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hello","World");

    }

    @Override
    public void loop() {

      telemetry.addData("Running","Robot");

    }
// force push
}

