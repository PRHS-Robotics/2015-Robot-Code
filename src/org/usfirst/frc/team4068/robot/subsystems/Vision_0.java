package org.usfirst.frc.team4068.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.ColorMode;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision_0 extends AxisCamera{
	public Vision_0(String cameraHost) {
		super(cameraHost);
		// TODO Auto-generated constructor stub
	}
	
	Image frame;
	Image thresholdImage;
	
	NIVision.Range TOTE_RED_RANGE = new NIVision.Range(0, 15);
	NIVision.Range TOTE_GREEN_RANGE = new NIVision.Range(31, 255);
	NIVision.Range TOTE_HUE_RANGE = new NIVision.Range(0, 15);
	
	public void hi(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		thresholdImage = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	}
	
	public void something(){
		
		this.getImage(frame);
		
		NIVision.imaqColorThreshold(thresholdImage, frame, 255, ColorMode.RGB, TOTE_RED_RANGE, TOTE_GREEN_RANGE, TOTE_HUE_RANGE);
		//thresholdImage = frame.thresholdHSL(0, 255, 0, 255, 0, 255);
		//thresholdImage.write("/tmp/threshold.jpg");
		thresholdImage.free();
	}
}
