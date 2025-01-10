package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4008Auto1ParkingRed", group="4008")
public class SampleAuto extends LinearOpMode{

    Team4008HM2025 robot = new Team4008HM2025();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();

        robot.LeftSlide.setPower(0.5);
        robot.RightSlide.setPower(-0.5);

        sleep(1000);
        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);


        robot.DriveRightFront.setPower(-0.6);//forward is -direction?
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(-0.6);
        robot.DriveLeftBack.setPower(-0.6);
        sleep(1000);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);





    }

}