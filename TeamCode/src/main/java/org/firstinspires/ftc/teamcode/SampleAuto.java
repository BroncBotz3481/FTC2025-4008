package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="SampleAuto", group="4008")
public class SampleAuto extends LinearOpMode{

    Team4008HM2025 robot = new Team4008HM2025();



    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        robot.Servo.setPosition(0);//have 3 sec to put in the sample
        sleep(3000);
        robot.Servo.setPosition(0.4);
        waitForStart();


        robot.LeftSlide.setPower(-0.8);
        robot.RightSlide.setPower(0.8);
        sleep(2000);//7500-max height
        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);

        //moving forward to the basket
        robot.DriveRightFront.setPower(-0.6);
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(-0.6);
        robot.DriveLeftBack.setPower(-0.6);
        sleep(1450);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

        sleep(1000);



        //rotate left
        robot.DriveRightFront.setPower(-0.6);
        robot.DriveLeftFront.setPower(0.6);
        robot.DriveRightBack.setPower(-0.6);
        robot.DriveLeftBack.setPower(0.6);
        sleep(150);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);


        robot.LeftArm.setPower(-0.7);
        robot.RightArm.setPower(0.7);
        sleep(250);
        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);
            sleep(2000);

        robot.Servo.setPosition(0);
        sleep(5000);

        /*
        robot.LeftArm.setPower(0.7);
        robot.RightArm.setPower(-0.7);
        sleep(250);
        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);
            sleep(2000);

        robot.DriveRightFront.setPower(0.6);
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(0.6 );
        robot.DriveLeftBack.setPower(-0.6);
        sleep(200);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);



        robot.DriveRightFront.setPower(-0.6);
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(-0.6);
        robot.DriveLeftBack.setPower(-0.6);
        sleep(1450);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

        sleep(1000);

        //move right
        robot.DriveRightFront.setPower(0.6);
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(-0.6);
        robot.DriveLeftBack.setPower(0.6);
        sleep(500);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

        sleep(500);
        robot.DriveRightFront.setPower(0.6);
        robot.DriveLeftFront.setPower(-0.6);
        robot.DriveRightBack.setPower(0.6);
        robot.DriveLeftBack.setPower(-0.6);
        sleep(400);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

        robot.LeftArm.setPower(-0.7);
        robot.RightArm.setPower(0.7);
        sleep(600);
        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);
        sleep(1000);


        robot.LeftSlide.setPower(-0.8);
        robot.RightSlide.setPower(0.8);
        sleep(3750);
        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);

        robot.Servo.setPosition(0.4);








         */

    }

}