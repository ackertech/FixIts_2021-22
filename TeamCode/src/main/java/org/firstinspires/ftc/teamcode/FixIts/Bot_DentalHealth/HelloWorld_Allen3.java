package org.firstinspires.ftc.teamcode.FixIts.Bot_DentalHealth;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@Disabled
@TeleOp(name = "TeleOp:HelloWorld_Allen3", group ="Lessons")

public class HelloWorld_Allen3 extends OpMode {

    @Override
    public void init() {

        telemetry.addData("Hello", "World");
    }
    @Override
    public void loop() {
        telemetry.addData("Running", "Robot");
    }

}
