package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name="HelloWorld_Jack")

public class HelloWorld_Jack extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hellow","World");

    }

    @Override
    public void loop() {

       telemetry.addData("Running"," Robot");

    }

}