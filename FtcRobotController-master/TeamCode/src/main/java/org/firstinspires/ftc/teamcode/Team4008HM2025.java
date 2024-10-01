package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;

public class Team4008HM2025 {
    public DcMotor DriveRightBack = null;
    public DcMotor DriveLeftBack = null;
    public DcMotor DriveLeftFront = null;
    public DcMotor DriveRightFront = null;
    public DcMotor RightSlide = null;
    public DcMotor LeftSlide = null;
//I fixed it



    //public NormalizedColorSensor ColorSensor = null;



    //public ElapsedTime period  = new ElapsedTime();

    // public Team4008HMNew() {}

    HardwareMap hwMap = null;
    //FIX AND USE IT
    public void Map(HardwareMap hardwareMap)
    {
        hwMap = hardwareMap;
        DriveLeftFront = hwMap.get(DcMotor.class,"DriveLeftFront"); //0
        DriveRightFront = hwMap.get(DcMotor.class,"DriveRightFront"); //1
        DriveLeftBack = hwMap.get(DcMotor.class,"DriveLeftBack"); //2
        DriveRightBack = hwMap.get(DcMotor.class,"DriveRightBack"); //3
        //   Lights = hwMap.get(RevBlinkinLedDriver.class,"Lights");

        DriveLeftFront.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightFront.setDirection(DcMotor.Direction.REVERSE);
        DriveRightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveLeftBack.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightBack.setDirection(DcMotor.Direction.REVERSE);
        DriveRightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


//        Turret = hwMap.get(DcMotor.class,"Turret");
//        Turret.setDirection(DcMotorSimple.Direction.REVERSE);
//        Turret.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        //IntakeLift.setDirection(DcMotor.Direction.REVERSE);

        RightSlide = hwMap.get(DcMotor.class, "RightSlide");
        RightSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        RightSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        LeftSlide = hwMap.get(DcMotor.class, "LeftSlide");
        LeftSlide.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftSlide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




//        Arm2 = hwMap.get(DcMotor.class, "Arm2");
//        Arm2.setDirection(DcMotorSimple.Direction.REVERSE);
//        Arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Arm2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

//        Intake = hwMap.get(Servo.class, "Servo1");

        //Arm = hwMap.get(DcMotor.class, "Arm");

//        ColorSensor = hwMap.get(NormalizedColorSensor.class, "sensor");

    }
}
