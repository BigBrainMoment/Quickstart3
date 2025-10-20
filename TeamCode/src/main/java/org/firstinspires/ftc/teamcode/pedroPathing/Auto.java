package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Auto", group = "Examples")
public abstract class Auto extends OpMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;

    private final Pose startPose = new Pose(8,70, Math.toRadians(0));
    private final Pose poseuna = new Pose(25, 70, Math.toRadians(0));
    private final Pose posedos = new Pose(25, 26, Math.toRadians(0));
    private final Pose posetres = new Pose(50, 33.5, Math.toRadians(0));
    private final Pose posecuatro = new Pose(50, 12.948, Math.toRadians(0));
    private final Pose posecinco = new Pose(-20, 35, Math.toRadians(0));
    private final Pose poseseis = new Pose(50, 25.856, Math.toRadians(0));
}
