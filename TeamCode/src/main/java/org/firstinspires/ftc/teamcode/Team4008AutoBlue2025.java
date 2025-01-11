package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Team4008AutoBlue2025", group="4008")
public class Team4008AutoBlue2025 extends LinearOpMode {

    Team4008HM2025 robot = new Team4008HM2025();
    ElapsedTime Time = new ElapsedTime();

    @Override
    public void runOpMode() {
        robot.Map(hardwareMap);
        robot.Servo.setPosition(0);//Giving time for putting the blocks in the claw before auto starts
        sleep(3000);
        robot.Servo.setPosition(0.4);
        waitForStart();


       /*
       Facing left to start
       Reach the ascent zone

        */
        //put the starting block in the high basket
        moveForward(0.5,1000); //1250?closer
        slideUp(0.5,1000);


        /*moveForward(0.4,1800);
       //slideUp(0.4,2000);
        moveRight(0.4,4000);
        moveBackward(0.4,1250);
*/




    }

    public void moveForward (double power, int time){
        robot.DriveRightFront.setPower(-power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(-power);
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveBackward (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power);
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }
    public void moveRight (double power, int time){
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(-power );
        robot.DriveLeftBack.setPower(power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }

    public void moveLeft (double power, int time){
        robot.DriveRightFront.setPower(-power);
        robot.DriveLeftFront.setPower(power);
        robot.DriveRightBack.setPower(power );
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }

    public void turnRight(double power, int time){//90 degree?
        robot.DriveRightFront.setPower(power);
        robot.DriveLeftFront.setPower(-power);
        robot.DriveRightBack.setPower(power );
        robot.DriveLeftBack.setPower(-power);
        sleep(time);
        robot.DriveRightFront.setPower(0);
        robot.DriveLeftFront.setPower(0);
        robot.DriveRightBack.setPower(0);
        robot.DriveLeftBack.setPower(0);
    }



    public void armForward (double armPower, int time){//forward


        //*0.75 for arm
        robot.LeftArm.setPower(armPower * 0.75);
        robot.RightArm.setPower(armPower * -1 * 0.75);
        sleep(time);
        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);


    }
    public void armBackward (double armPower, int time){//backward


        //*0.75 for arm
        robot.LeftArm.setPower(armPower * -1 * 0.75);
        robot.RightArm.setPower(armPower * 0.75);
        sleep(time);
        robot.LeftArm.setPower(0);
        robot.RightArm.setPower(0);


    }


    public void slideUp(double slidePower, int time) {//up
        robot.LeftSlide.setPower(slidePower * 1);
        robot.RightSlide.setPower(slidePower );
        sleep(time);
        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);

    }


    public void slideDown(double slidePower, int time) {//down
        robot.LeftSlide.setPower(slidePower* -1);
        robot.RightSlide.setPower(slidePower);
        sleep(time);
        robot.LeftSlide.setPower(0);
        robot.RightSlide.setPower(0);
    }




}