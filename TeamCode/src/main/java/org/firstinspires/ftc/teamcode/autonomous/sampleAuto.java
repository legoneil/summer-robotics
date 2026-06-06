package org.firstinspires.ftc.teamcode.autonomous;

import static java.lang.Math.toRadians;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous(name="sampleAuto")
public class sampleAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(new Vector2d(0, 63), Math.toRadians(270));
        MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
        waitForStart();
        Action path = drive.actionBuilder(beginPose)
                .lineToYLinearHeading(20, Math.toRadians(140))
                .strafeTo(new Vector2d(-23.6, 23.3))
                .build();

        Actions.runBlocking(new SequentialAction(path));
    }
}