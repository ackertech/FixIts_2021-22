package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "Hello World Charlie")

public class HelloWorld_Charlie extends OpMode {

    @Override
    public void init() {
        
        telemetry.addData("Hello","World");

    }

    @Override
    public void loop() {

        telemetry.addData("Running","Robot");

    }

}

// push jda