/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team449.frc2014.commands;

import com.team449.frc2014.OI;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Eyob
 */
public class ShootCommand extends CommandBase {
    
    private final boolean autoExec;   // true if executed by autonomous
    
    public ShootCommand(boolean autoExec){
        requires(roller);
        requires(flinger);
        this.autoExec = autoExec;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        boolean cond = roller.getArm().get().equals(DoubleSolenoid.Value.kForward);
        flinger.setStatus(cond);
        
        if ((OI.safety || autoExec) && cond){
            flinger.setFlinger(true);
            Timer.delay(1.0);
            flinger.setFlinger(false);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
