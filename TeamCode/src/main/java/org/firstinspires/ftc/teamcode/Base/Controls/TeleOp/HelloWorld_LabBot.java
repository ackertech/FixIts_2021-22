package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name="Hello World Acker")

public class HelloWorld_LabBot extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hello"," World");

    }

    @Override
    public void loop() {

        telemetry.addData("Running", " Robot");

    }

}

