package org.firstinspires.ftc.teamcode.Bulldozers;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.General.PossibleColors;

/**
 * Created by nova on 11/6/2017.
 */

public class Robot7901 {
    DcMotor left, right, rightIntake, leftIntake, rightLift, leftLift;
    double leftPower, rightPower, leftIntakePower, rightIntakePower, leftLiftPower, rightLiftPower, jewelServoPosition;
    ColorSensor colorSensor;
    Servo jewelServo;
    final double SERVO_DOWN_POSITION = -1, SERVO_UP_POSITION = 1;
    double driveBaseMultiplyer = 1;

    public void init(HardwareMap hwMap) {
        left = hwMap.dcMotor.get("left");
        right = hwMap.dcMotor.get("right");
        rightIntake = hwMap.dcMotor.get("rightIntake");
        leftIntake = hwMap.dcMotor.get("leftIntake");
        rightLift = hwMap.dcMotor.get("rightLift");
        leftLift = hwMap.dcMotor.get("leftLift");
        colorSensor = hwMap.colorSensor.get("colorSensorGround");
        jewelServo = hwMap.servo.get("jewelServo");
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        rightIntake.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void tankDrive(double leftPower, double rightPower) {
        this.leftPower = leftPower;
        this.rightPower = rightPower;

    }

    public void writePowers() {
        left.setPower(leftPower * driveBaseMultiplyer);
        right.setPower(rightPower * driveBaseMultiplyer);
        leftIntake.setPower(leftIntakePower);
        rightIntake.setPower(rightIntakePower);
        leftLift.setPower(leftLiftPower);
        rightLift.setPower(rightLiftPower);
    }

    public void setIntakePower(double leftIntakePower, double rightIntakePower){
        this.leftIntakePower = leftIntakePower;
        this.rightIntakePower = rightIntakePower;
    }

    public void setLiftPower(double leftLiftPower, double rightLiftPower){
        this.leftLiftPower = leftLiftPower;
        this.rightLiftPower = rightLiftPower;
    }

    public void setJewelServoPosition (double jewelServoPosition){
        this.jewelServoPosition = jewelServoPosition;
    }

    public void setJewelServoDown () {
        setJewelServoPosition(0);
    }
    public void setJewelServoUp (){
        setJewelServoPosition(1);
    }




    public PossibleColors readColor(int red, int green, int blue) {
        float[] hsv = new float[3];
        Color.RGBToHSV(red, blue, green, hsv);
        float hue = hsv[0];
        float saturation = hsv[1];
        float value = hsv[2];
        if (hue < 10 || hue > 177.5) {
            return PossibleColors.RED;
        } else if (hue < 120 || hue > 105) {
            return PossibleColors.BLUE;
        } else {
            return PossibleColors.UNKOWN;
        }
    }

    public boolean colorSensorSeesColor(PossibleColors color) {
        return (readColor(colorSensor.red(), colorSensor.blue(), colorSensor.green()) == color);}

    public void setDriveZeroPower (DcMotor.ZeroPowerBehavior zeroPowerBehavior){
        right.setZeroPowerBehavior(zeroPowerBehavior);
        left.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void setDriveBaseMultiplier(double multiplier){
        this.driveBaseMultiplyer = multiplier;
    }
}





