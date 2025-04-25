package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name="SampleAuto", group="4008")
public class SampleAuto extends LinearOpMode {

    Team4008HM2025 robot = new Team4008HM2025();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();

        driveForwardandBack(-500, 0.5, 0);
        turn(-500, 0.5, 0);
        strafe(-500, 0.5, 1000);


    }

    public void driveForwardandBack(int targetDistance, double power, int sleep) {
        robot.DriveLeftBack.setTargetPosition(targetDistance);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftBack.setPower(power);

        robot.DriveRightBack.setTargetPosition(targetDistance);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightBack.setPower(power);

        robot.DriveLeftFront.setTargetPosition(targetDistance);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftFront.setPower(power);

        robot.DriveRightFront.setTargetPosition(targetDistance);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightFront.setPower(power);
        sleep(sleep);

    }
//if power is negative in the argument, it will turn the other way
    public void turn(int targetDistance, double power, int sleep) {
        robot.DriveLeftBack.setTargetPosition(-targetDistance);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftBack.setPower(-power);

        robot.DriveRightBack.setTargetPosition(targetDistance);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightBack.setPower(power);

        robot.DriveLeftFront.setTargetPosition(-targetDistance);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftFront.setPower(-power);

        robot.DriveRightFront.setTargetPosition(targetDistance);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightFront.setPower(power);
        sleep(sleep);
    }

    public void strafe(int targetDistance, double power, int sleep) {
        robot.DriveLeftBack.setTargetPosition(-targetDistance);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftBack.setPower(-power);

        robot.DriveRightBack.setTargetPosition(targetDistance);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightBack.setPower(power);

        robot.DriveLeftFront.setTargetPosition(targetDistance);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftFront.setPower(power);

        robot.DriveRightFront.setTargetPosition(-targetDistance);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightFront.setPower(-power);
        sleep(sleep);
    }
}