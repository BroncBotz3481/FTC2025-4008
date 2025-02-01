package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4008Auto1ParkingRed", group="4008")
public class Team4008AutoRed2025 extends LinearOpMode{

    Team4008HM2025 robot = new Team4008HM2025();
    ElapsedTime Time = new ElapsedTime();
    double multy = 0.3;

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        waitForStart();

        /*
        facing the right to start
        parking (parking autos)
         */
        moveForward(0.4,2200);
        /*
        Other autos we could do:
        */



    }
    public void moveForward (double power, int time){
        robot.DriveRightFront.setPower(-power);//forward is -direction?
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(-power);
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }

}