package org.firstinspires.ftc.teamcode.FixIts.Bot_Candace;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "HelloWorld")




public class HelloWorld_Andrew extends OpMode {

    @Override
    public void init() {
        telemetry.addData("Hello","World");

    }

    @Override
    public void loop() {

        telemetry.addData("Running", "Robots");

    }

    }
