package org.firstinspires.ftc.teamcode.FixIts.Bot_Johntavious;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp(name="Hello World Grant")

public class HelloWorld_Grant extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hello", "World");

    }

    @Override
    public void loop() {

        telemetry.addData("Running","Robot");

    }

}
