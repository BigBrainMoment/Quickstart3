package org.firstinspires.ftc.teamcode.pedroPathing;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Archive extends LinearOpMode {
    DcMotor FL;
    DcMotor FR;
    DcMotor BL;
    DcMotor BR;

    int drivetrainconvert = 17;
    double CPR = 537.7;
    int armCPR = 8192;
    double diameter = 9.6; // Replace with your wheel/spool's diameter
    double circumference = Math.PI * diameter;


    private ElapsedTime myTimer = new ElapsedTime();
    public void launch(int number){
        CRServo ls, rs;
        ls = hardwareMap.get(CRServo.class,"leftServo");
        rs = hardwareMap.get(CRServo.class,"rightServo");
        myTimer.time();

        for(int i = 0; i <= number; i++){
            ls.setPower(.5);
            rs.setPower(.5);

            if(myTimer.seconds() == 0.5){
                ls.setPower(0);
                rs.setPower(0);
                myTimer.reset();
            }

        }

    }
    public void fly(double speed){
        DcMotor fly;
        fly = hardwareMap.get(DcMotor.class,"flywheel");
        fly.setDirection(DcMotorSimple.Direction.REVERSE);

        fly.setPower(speed);
    }

    public void push(double degrees){
        CRServo ls, rs;
        ls = hardwareMap.get(CRServo.class,"leftServo");
        rs = hardwareMap.get(CRServo.class,"rightServo");
        ls.setDirection(DcMotorSimple.Direction.REVERSE);

        rs.setPower(degrees);
        ls.setPower(degrees);
    }

    public void resetencoders() {

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //the following means that the program does not use pid feedback loop for accurate motor movements. this is necessary for encoder-based autonomous programs.
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void drive(int desiredPosition) {
        FL.setTargetPosition(desiredPosition*drivetrainconvert); // Tells the motor that the position it should go to is desiredPosition
        FR.setTargetPosition(desiredPosition*drivetrainconvert); // Tells the motor that the position it should go to is desiredPosition
        BL.setTargetPosition(desiredPosition*drivetrainconvert); // Tells the motor that the position it should go to is desiredPosition
        BR.setTargetPosition(desiredPosition*drivetrainconvert); // Tells the motor that the position it should go to is desiredPosition

        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (FL.isBusy() || FR.isBusy() || BR.isBusy() || BL.isBusy()){
            FL.setPower(0.5);
            FR.setPower(0.5);
            BL.setPower(0.5);
            BR.setPower(0.5);
        }
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }
    @Override
    public void runOpMode() throws InterruptedException {

    }

}


