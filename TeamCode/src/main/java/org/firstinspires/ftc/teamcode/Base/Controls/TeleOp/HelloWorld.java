package org.firstinspires.ftc.teamcode.Base.Controls.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp(name = "TeleOp:HelloWorld", group ="Lessons")

public class HelloWorld extends OpMode {
    @Override
    public void init() {
        telemetry.addData("Hello", "World");
    }
    @Override
    public void loop() {

    }
}
// This is a single line comment

/*
This is a multi-line comment
Comment Line 2
 */