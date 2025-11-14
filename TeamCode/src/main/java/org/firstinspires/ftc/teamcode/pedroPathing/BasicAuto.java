package org.firstinspires.ftc.teamcode.pedroPathing;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous (name="BasicAuto", group="Linear OpMode")
@Configurable
@Disabled
public class BasicAuto extends LinearOpMode {
    Archive robot = new Archive(hardwareMap);

    public ElapsedTime time = new ElapsedTime();
    @Override
    public void runOpMode() throws InterruptedException {
// Declaring motors

            CRServo ls, rs;
            ls = hardwareMap.get(CRServo.class, "leftServo");
            rs = hardwareMap.get(CRServo.class, "rightServo");

            DcMotor FL, FR, BL, BR, fly;
            FL = hardwareMap.get(DcMotor.class, "frontLeft");
            FR = hardwareMap.get(DcMotor.class, "frontRight");
            BL = hardwareMap.get(DcMotor.class, "backLeft");
            BR = hardwareMap.get(DcMotor.class, "backRight");

            fly = hardwareMap.get(DcMotor.class, "flywheel");

            FR.setDirection(DcMotorSimple.Direction.REVERSE);
            BR.setDirection(DcMotorSimple.Direction.REVERSE);

            fly.setDirection(DcMotorSimple.Direction.REVERSE);
            ls.setDirection(DcMotorSimple.Direction.REVERSE);




            waitForStart();


            if (opModeIsActive()) {

                // tesing to see if both work

                // fly.setPower(.8);
                robot.flywheelSet(.8);
                robot.drive(-30);
                time.reset();

                if (time.seconds() >= 0.4) {

                    robot.launching(3);

                    robot.drive(30);
                }


            }


    }




}
