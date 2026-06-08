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
        Pose2d beginPose = new Pose2d(new Vector2d(-54, 55), Math.toRadians(315));
        Pose2d shot_pose = new Pose2d(new Vector2d(-23.6, 23.3), Math.toRadians(140));
        Pose2d shot_2_spot = new Pose2d(new Vector2d(-58.2, 20.6), Math.toRadians(270));
        Pose2d collect_spot_2 = new Pose2d(new Vector2d(-57, -5.5), Math.toRadians(270));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        Action shootPreLoad = drive.actionBuilder(beginPose)
                .strafeToSplineHeading(new Vector2d(-23.6, 23.3), Math.toRadians(140))
                .build();
        Action collectBalls1 = drive.actionBuilder(shot_pose)
                .waitSeconds(1)
                .strafeToSplineHeading(new Vector2d(-58, 30), Math.toRadians(270))
                .waitSeconds(1)
                .lineToY(20)
                .build();
        Action shoot_ball_2 = drive.actionBuilder(shot_2_spot)
                .waitSeconds(2)
                .strafeToSplineHeading(new Vector2d(-23.6, 23.3), Math.toRadians(140))
                .build();
        Action collectBalls2 = drive.actionBuilder(shot_pose)
                .waitSeconds(2)
                .strafeToSplineHeading(new Vector2d(-57, -5.5), Math.toRadians(270))
                .build();
        Action shoot_ball_3 = drive.actionBuilder(collect_spot_2)
                .waitSeconds(2)
                .strafeToSplineHeading(new Vector2d(-23.6, 23.3), Math.toRadians(140))
                .waitSeconds(2)
                .build();
        Action go_to_final_pos = drive.actionBuilder(shot_pose)
                .strafeToSplineHeading(new Vector2d(-23, 27), Math.toRadians(180))
                        .build();



        waitForStart();

        if (opModeIsActive()) {
            Actions.runBlocking(shootPreLoad);
            Actions.runBlocking(collectBalls1);
            Actions.runBlocking(shoot_ball_2);
            Actions.runBlocking(collectBalls2);
            Actions.runBlocking(shoot_ball_3);
            Actions.runBlocking(go_to_final_pos);
        }
    }
}