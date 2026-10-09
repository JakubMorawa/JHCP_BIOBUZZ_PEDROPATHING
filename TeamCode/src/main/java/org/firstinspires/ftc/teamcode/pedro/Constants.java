
package org.firstinspires.ftc.teamcode.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.follower.Follower;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.TwoWheelConfig;
import com.pedropathing.revhub.localizers.TwoWheelLocalizer;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
                
    // 1. Mecanum drivetrain
    public static MecanumConfig drivetrainConfig =
        new MecanumConfig(c -> {
        
        c.frontLeftName.set("left_front");
        c.backLeftName.set("left_back");
        c.frontRightName.set("right_front");
        c.backRightName.set("right_back");
        
        // Example directions only.
        // Confirm these using the drivetrain tuner.
        c.frontLeftDirection.set(
        DcMotorSimple.Direction.REVERSE);
        c.backLeftDirection.set(
        DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(
        DcMotorSimple.Direction.FORWARD);
        c.backRightDirection.set(
        DcMotorSimple.Direction.FORWARD);
        
        c.manualBrakeMode.set(true);
    });
    
    // 2. Two-wheel localization
    // Replace this with the complete configuration generated
    // by Pedro's Two Wheel Tuner.
    public static TwoWheelConfig localizerConfig =
            new TwoWheelConfig(c -> {
            
            // Set encoder names, IMU orientation,
            // encoder scales, directions, and offsets
            // using the generated tuner configuration.
            });
    
    // 3. Path-following algorithm
    // These are starting defaults, NOT tuned robot values.
    public static ForesightConfig foresightConfig =
        new ForesightConfig(c -> {
            
            c.headingDriveRatio.set(0.5);
            c.brakeAtEnd.set(true);
            
            c.translationalDeviationTolerance.set(2.5);
            c.headingDeviationTolerance.set(Math.toRadians(11.25));
            c.cosineScale.set(false);
            
            c.brakeAggression.set(1.0);
            c.maxBrakingPower.set(0.2);
            
            c.maxAccelerationConstraint.set(
            ForesightConfig.Constraint.NONE);
            c.maxVelocityConstraint.set(
            ForesightConfig.Constraint.NONE);
            c.maxDecelerationConstraint.set(
            ForesightConfig.Constraint.NONE);
            
            c.coastDownToVelocity.set(0.0);
        }
    );
    
    // 4. Create the follower
    public static Follower create(HardwareMap hardwareMap) {
        return new Follower(
                new TwoWheelLocalizer(
                        hardwareMap, localizerConfig),
                new Mecanum(
                        hardwareMap, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
