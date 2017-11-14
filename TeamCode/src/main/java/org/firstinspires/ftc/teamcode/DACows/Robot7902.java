package org.firstinspires.ftc.teamcode.DACows;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.General.PossibleColors;

public class Robot7902 {
    public DcMotor rightRear, leftRear, rightFront, leftFront, glyphLift, glyphSmasher;
    public double rightRearPower, leftRearPower, rightFrontPower, leftFrontPower, glyphLiftPower, glyphSmasherPower, jewelServoPosition;
    public ColorSensor colorSensor;
    public Servo jewelServo;
    public final double SERVO_DOWN_POSITION = 0, SERVO_UP_POSITION = .6;
    public double driveBaseMultiplier = 1;

    public void init (HardwareMap hwMap){
        rightRearPower = leftRearPower = rightFrontPower = leftFrontPower = glyphLiftPower = glyphSmasherPower = 0;
        jewelServoPosition = SERVO_UP_POSITION;
        rightRear = hwMap.dcMotor.get("rightRear");
        leftRear = hwMap.dcMotor.get("leftRear");
        rightFront = hwMap.dcMotor.get("rightFront");
        leftFront = hwMap.dcMotor.get("leftFront");
        glyphLift = hwMap.dcMotor.get("glyphLift");
        glyphSmasher = hwMap.dcMotor.get("glyphSmasher");
        colorSensor = hwMap.colorSensor.get("colorSensorGround");
        jewelServo = hwMap.servo.get("jewelServo");
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void drive (double rightRearPower, double leftRearPower, double rightFrontPower, double leftFrontPower) {
        this.rightRearPower = rightRearPower;
        this.leftRearPower = leftRearPower;
        this.rightFrontPower = rightFrontPower;
        this.leftFrontPower = leftFrontPower;
    }
    public void tankDrive (double l, double r ){
        drive(r,l,r,l);
    }

    public void setDriveZeroPower (DcMotor.ZeroPowerBehavior zeroPowerBehavior){
        rightRear.setZeroPowerBehavior(zeroPowerBehavior);
        leftRear.setZeroPowerBehavior(zeroPowerBehavior);
        rightFront.setZeroPowerBehavior(zeroPowerBehavior);
        leftFront.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void writePowers (){
        rightRear.setPower(rightRearPower * driveBaseMultiplier);
        leftRear.setPower(leftRearPower * driveBaseMultiplier);
        rightFront.setPower(rightFrontPower * driveBaseMultiplier);
        leftFront.setPower(leftFrontPower * driveBaseMultiplier);
        glyphLift.setPower(glyphLiftPower);
        glyphSmasher.setPower(glyphSmasherPower); 
        jewelServo.setPosition(jewelServoPosition);
    }
    public void setGlyphLiftPower (double glyphLiftPower){
        this.glyphLiftPower = glyphLiftPower;
    }

    public void setGlyphSmasherPower (double glyphSmasherPower){
        this.glyphSmasherPower = glyphSmasherPower;
    }
    public void setJewelServoPosition (double jewelServoPosition){
        this.jewelServoPosition = jewelServoPosition;
    }

    public void setJewelServoDown () {
        this.setJewelServoPosition(0);
    }
    public void setJewelServoUp (){
        this.setJewelServoPosition(1);
    }


    public void driveAll (double speed) {
        this.drive(speed, speed, speed, speed);
    }

    public PossibleColors readColor(int red, int green, int blue) {
        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);
        float hue = hsv[0];
        float saturation = hsv[1];
        float value = hsv[2];
        if(hue == 0 && saturation == 0 & value == 0){
            return PossibleColors.UNKOWN;
        } if (inRange(hue, 150, 280)) {
            return PossibleColors.BLUE;
        } else if (hue < 20 || hue > 350){
            return PossibleColors.RED;
        } else {
            return PossibleColors.UNKOWN;
        }
    }

    public boolean inRange(double x, double min, double max){
        return (x > min && x < max);
    }


    public boolean colorSensorSeesColor(PossibleColors color) {
        return (readColor(colorSensor.red(), colorSensor.blue(), colorSensor.green()) == color);
    }

    public float[] colorSensorHSV(){
        float[] hsv = new float[3];
        Color.RGBToHSV(colorSensor.red(), colorSensor.green(), colorSensor.blue(), hsv);
        return hsv;
    }
    public void setDriveBaseMultiplyer(double multiplier){
        this.driveBaseMultiplier = multiplier;

    }



}