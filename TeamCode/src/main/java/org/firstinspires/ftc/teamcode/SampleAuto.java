package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="SampleAuto", group="4008")
public class SampleAuto extends LinearOpMode {

    Team4008HM2025 robot = new Team4008HM2025();
    ElapsedTime Time = new ElapsedTime();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);

        telemetry.update();
        waitForStart();

        Time.reset();
        driveForward(6, 0.5, 2500);
        armAngleChange(1300, 0.5, 2500);

//        turn(-500, 0.5, 1500);
//        strafeRight(12, 0.5, 1500);


    }


    public double inchesToTicks (double inches){
        return (inches * 537.7)/(2 * Math.PI * 1.9);
    }

    public void driveForward(double inches, double power, int time) {

        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);

        while (opModeIsActive() && Time.milliseconds() < time
                && robot.DriveLeftFront.getCurrentPosition() < inchesToTicks(inches)
                && robot.DriveRightBack.getCurrentPosition() < inchesToTicks(inches))
        {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

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
                && robot.DriveLeftFront.getCurrentPosition() < inchesToTicks(inches)
                && robot.DriveRightBack.getCurrentPosition() < inchesToTicks(inches))
        {
            telemetry.addData("Encoder Val", robot.DriveLeftFront.getCurrentPosition());
        }
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);

        Time.reset();

    }

    public void armAngleChange(double ticks, double power, int time){ //guess ur ticks : )
        robot.LeftArm.setPower(power);
        robot.RightArm.setPower(power * -1);

        while (opModeIsActive() && Time.milliseconds() < time
                && robot.LeftArm.getCurrentPosition() < ticks
                && robot.RightArm.getCurrentPosition() < ticks)
        {
            telemetry.addData("Arm Encoder Vals", robot.LeftArm.getCurrentPosition());
        }

        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);

        Time.reset();
    }

    public void slideChange(double inches, double power, int time){
        robot.LeftSlide.setPower(power);
        robot.RightSlide.setPower(power * -1);

        while (opModeIsActive() && Time.milliseconds() < time
                && robot.LeftSlide.getCurrentPosition() < inchesToTicks(inches)
                && robot.RightSlide.getCurrentPosition() < inchesToTicks(inches))
        {
            telemetry.addData("Slide Encoder Vals", robot.LeftSlide.getCurrentPosition());
        }

        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);

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