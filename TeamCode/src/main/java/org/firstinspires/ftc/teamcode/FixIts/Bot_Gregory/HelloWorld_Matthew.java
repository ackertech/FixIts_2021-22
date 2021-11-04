package org.firstinspires.ftc.teamcode.FixIts.Bot_Gregory;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "Hello World Matthew")

public class HelloWorld_Matthew extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hello","World");

    }

    @Override
    public void loop() {

        telemetry.addData("Running","Robot");

    }

}