package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Disabled
@TeleOp(name = "TeleOp:Hello World Noah")

public class helloworld_noah extends OpMode {
    @Override
    public void init() {

        telemetry.addData("Hello", "World");
    }
    @Override
    public void loop() {

        telemetry.addData("I'll be", " back");
    }
}
