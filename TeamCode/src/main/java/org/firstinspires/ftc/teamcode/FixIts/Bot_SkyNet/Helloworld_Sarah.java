package org.firstinspires.ftc.teamcode.FixIts.Bot_SkyNet;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "TeleOp:Helloworld_Sarah")

public class Helloworld_Sarah extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello", "World" );
    }

    @Override
    public void loop() {
        telemetry.addData("Running", "Robot");
    }
}