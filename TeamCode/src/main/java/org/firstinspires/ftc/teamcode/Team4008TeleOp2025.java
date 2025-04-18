package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//people who able to access this: 1
@TeleOp(name = "Team4008TeleOp2025", group = "4008")
public class Team4008TeleOp2025 extends LinearOpMode {
    Team4008HM2025 robot = new Team4008HM2025();


    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        telemetry.addData("Say", "TeleOp Starting");
        telemetry.update();
        robot.DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.Servo.setPosition(0.4);
        robot.Servo.setPosition(0);

        int count = 0;
        //robot.Lights.setPattern(RevBlinkinLedDriver.BlinkinPattern.BEATS_PER_MINUTE_PARTY_PALETTE);
        waitForStart();

        while (opModeIsActive()) {
            boolean speedslow = gamepad1.right_bumper;
            double mag = speedslow ? 0.5 : 1.0;

            double y = gamepad1.left_stick_y; // Remember, this is reversed!
            double x = -gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = -gamepad1.right_stick_x;


          /*  if (robot.Touched.isPressed()) {
                telemetry.addData("Touch", robot.Touched.isPressed());
                telemetry.update();
            } */

            // hello
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.5);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;



            robot.DriveLeftFront.setPower(frontLeftPower * mag);
            robot.DriveLeftBack.setPower(backLeftPower * mag);
            robot.DriveRightFront.setPower(frontRightPower * mag);
            robot.DriveRightBack.setPower(backRightPower * mag);

            double slidePower = gamepad2.left_stick_y;//up and down
            robot.LeftSlide.setPower(slidePower);
            robot.RightSlide.setPower(slidePower * -1);

            double armPower = gamepad2.right_stick_y * 0.75;//forward and backward
            robot.LeftArm.setPower(armPower);
            robot.RightArm.setPower(armPower * -1);

            //robot.Servo.setPosition(0.25);


            if(gamepad2.y) {
                robot.Servo.setPosition(0.4);//close
            }

            if(gamepad2.a) {
                robot.Servo.setPosition(0);//open
            }

            if(gamepad2.x) {
                robot.wrist.setPosition(0.5);//close
            }

            if(gamepad2.b) {
                robot.wrist.setPosition(0);//open
            }
//          just in case situation:
//          if(gamepad2.b) {
            telemetry.addData("RightFront", robot.DriveRightFront.getCurrentPosition());
            telemetry.addData("RightBack", robot.DriveRightBack.getCurrentPosition());
            telemetry.addData("LeftFront", robot.DriveLeftFront.getCurrentPosition());
            telemetry.addData("LeftBack", robot.DriveLeftBack.getCurrentPosition());
            telemetry.addData("Servo Position", robot.Servo.getPosition());//getCurrentPosition?
            telemetry.addData("LeftSide", robot.DriveLeftBack.getCurrentPosition());
            telemetry.addData("LeftArm", robot.DriveLeftBack.getCurrentPosition());
            telemetry.update();

            if (gamepad1.dpad_up){
                moveForward(mag);
            } else if (gamepad1.dpad_down){
                moveBackward(mag);
            } else if (gamepad1.dpad_left){
                moveLeft(mag);
            } else if (gamepad1.dpad_right){
                moveRight(mag);
            }


//            double Arm1 = gamepad2.right_stick_y;
//            double Arm2 = gamepad2.left_stick_y;
//            robot.Arm1.setPower(Arm1);
//            robot.Arm2.setPower(Arm2);
            // left bumper is open, right bumper is close
//            if (gamepad2.right_bumper) {
//                robot.Intake.setPosition(1.0);
//            }
//            if (gamepad2.left_bumper){
//                robot.Intake.setPosition(0.3);
//            }

//            if(gamepad2.y){
//                robot.Arm1.setPower(.9);
//            }
//            else if (gamepad2.x){
//                robot.Arm1.setPower(-1);
//            }
//            else {
//                robot.Arm1.setPower(0);


        }

    }
    public void moveLeft (double power){

        robot.DriveLeftFront.setPower(-power); robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power);   robot.DriveRightBack.setPower(-power);
    }
    public void moveRight (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(power); robot.DriveRightFront.setPower(-power);
        robot.DriveLeftBack.setPower(-power); robot.DriveRightBack.setPower(power);
    }
    public void moveForward (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(-power); robot.DriveRightFront.setPower(-power);
        robot.DriveLeftBack.setPower(-power);  robot.DriveRightBack.setPower(-power);
    }
    public void moveBackward (double power){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(power); robot.DriveRightFront.setPower(power);
        robot.DriveLeftBack.setPower(power);  robot.DriveRightBack.setPower(power);
    }
    public void stopDriveTrainMotors (){
        // Left Wheels                         //Right Wheels
        robot.DriveLeftFront.setPower(0);      robot.DriveRightFront.setPower(0);
        robot.DriveRightBack.setPower(0);      robot.DriveLeftBack.setPower(0);

    }
}