package org.firstinspires.ftc.teamcode.DACows;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Bulldozers.Robot7901;

/**
 * Created by nova on 11/9/2017.
 */
@Autonomous
public class AutonParking02  extends LinearOpMode{

        Robot7902 robot = new Robot7902();

        public void runOpMode ()throws InterruptedException {
            robot.init(hardwareMap);
            waitForStart();
            this.resetStartTime();
            robot.setDriveZeroPower(DcMotor.ZeroPowerBehavior.BRAKE);
            while (this.getRuntime() < 1 && opModeIsActive()) {
                robot.tankDrive(1, 1);
                robot.writePowers();
            }
            robot.tankDrive(0, 0);
            robot.writePowers();
        }






    }

