package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="SampleAuto", group="4008")
public class SampleAuto extends LinearOpMode {

    Team4008HM2025 robot = new Team4008HM2025();
    ElapsedTime Time = new ElapsedTime();

    double armStart = robot.LeftArm.getCurrentPosition();
    double slideStart = robot.RightSlide.getCurrentPosition();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);

        telemetry.update();

        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        robot.RightSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.RightSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.LeftArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.LeftArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        waitForStart();

        Time.reset();
        driveForward(12, 0.5, 1500);
        turn(-500, 0.5, 1500);
        strafeRight(12, 0.5, 1500);


    }


    public double ticksToDistance (double inches){
        return (inches * 537.7)/(4 * Math.PI);
    }

    public void driveForward(double inches, double power, int time) {



        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);

        while (opModeIsActive() && Time.milliseconds() < time
                && robot.DriveLeftFront.getCurrentPosition() < ticksToDistance(inches)
                && robot.DriveRightBack.getCurrentPosition() < ticksToDistance(inches))
        {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Time.reset();

    }
//if power is negative in the argument, it will turn the other way
    public void turn(int ticks, double power, int sleep) {
        robot.DriveLeftBack.setTargetPosition(-ticks);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftBack.setPower(-power);

        robot.DriveRightBack.setTargetPosition(ticks);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightBack.setPower(power);

        robot.DriveLeftFront.setTargetPosition(-ticks);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveLeftFront.setPower(-power);

        robot.DriveRightFront.setTargetPosition(ticks);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.DriveRightFront.setPower(power);
        sleep(sleep);
    }

    public void strafeRight(double inches, double power, int time) {

        robot.DriveRightFront.setPower(-power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(-power);

        while (opModeIsActive() && Time.milliseconds() < time
                && robot.DriveLeftFront.getCurrentPosition() < ticksToDistance(inches)
                && robot.DriveRightBack.getCurrentPosition() < ticksToDistance(inches))
        {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        Time.reset();

    }

    public double isNegitive(double encoder){

        return encoder >= 0? 0.75: -0.75;
    }
    public void returnToStartPose(){
        while (robot.LeftArm.getCurrentPosition() >= 100
            || -100 <= robot.LeftArm.getCurrentPosition()){

            robot.LeftArm.setPower(isNegitive(robot.LeftArm.getCurrentPosition()));
            robot.RightSlide.setPower(isNegitive(robot.LeftArm.getCurrentPosition()));

        }
    }
}