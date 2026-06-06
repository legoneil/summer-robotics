package org.firstinspires.ftc.teamcode.autonomous;

import static java.lang.Math.toRadians;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name="sampleAutoTraj")
public class sampleAutoTraj extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(new Vector2d(-59.9, -69.6), Math.toRadians(270));
        Pose2d postShot1Pose = new Pose2d(new Vector2d(-23.6, 23.3), Math.toRadians(140));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Action shootPreLoad = drive.actionBuilder(beginPose)
                .lineToYLinearHeading(20, Math.toRadians(140))
                .strafeTo(new Vector2d(-23.6, 23.3))
                .build();
        Action collectBalls1 = drive.actionBuilder(postShot1Pose)
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-58, 30), Math.toRadians(270))
                .waitSeconds(1)
                .lineToY(20)
                .build();
        waitForStart();

        if (opModeIsActive()) {
            Actions.runBlocking(shootPreLoad);
            Actions.runBlocking(collectBalls1);
        }
    }
}