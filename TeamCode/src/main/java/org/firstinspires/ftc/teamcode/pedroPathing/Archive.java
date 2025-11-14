package org.firstinspires.ftc.teamcode.pedroPathing;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Archive {
    private DcMotor FL, FR, BL, BR, fly;
    private CRServo ls, rs;
    private ElapsedTime myTimer = new ElapsedTime();
    private int drivetrainconvert = 17;


    // Declaring the motors for a class that does not have OpModes
    public Archive(HardwareMap hardwareMap) {

        ///     hardwareMap is a type of HardwareMap that is automatically
        ///     declared in LinearOpMode. What we are doing here is replacing
        ///     that with a different variable name (I chose to not change),
        ///     because we are not running anything with OpMode.
        fly = hardwareMap.get(DcMotor.class,"flywheel");

        ls = hardwareMap.get(CRServo.class,"leftServo");
        rs = hardwareMap.get(CRServo.class,"rightServo");

        FL = hardwareMap.get(DcMotor.class, "frontLeft");
        FR = hardwareMap.get(DcMotor.class, "frontRight");
        BL = hardwareMap.get(DcMotor.class, "backLeft");
        BR = hardwareMap.get(DcMotor.class, "backRight");

        // directions
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
        fly.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    // setting the speed of the flywheel
    public void flywheelSet(double speed) {
        fly.setDirection(DcMotorSimple.Direction.REVERSE);
        fly.setPower(speed);
    }

    // pushing the ball into the flywheel, launching.
    public void launching(int number) {
        // start counting
        myTimer.reset();

        for (int i = 0; i < number; i++) {
            ls.setPower(0.5);
            rs.setPower(0.5);

            // wait 0.4 seconds
            while (myTimer.seconds() >= 0.4) {

                ///     I did try:
                ///
                ///     if(myTimer.seconds() < 0.4) {
                ///
                ///     }
                ///
                ///     the problem is that it only checks once,
                ///     and I need it to wait. It has a line under
                ///     it because the loop is empty which is bad.

            }

            // if you got lost we still inside the for loop
            // and we are now turing off the motors
            // and recounting the time
            ls.setPower(0);
            rs.setPower(0);
            // reset timer for the next shot
            myTimer.reset();
        }
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

    // Pusher method, kinda don't need it
    public void push(double power) {
        ls.setPower(-power); // reverse if needed
        rs.setPower(power);
    }


}
