package org.usfirst.frc.team4068.robot.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.ColorMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ParticleFilterCriteria2;
import com.ni.vision.NIVision.MeasurementType;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.RGBValue;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision_0 extends AxisCamera{
	public Vision_0(String cameraHost) {
		super(cameraHost);
		// TODO Auto-generated constructor stub
	}
	
	Image frame;
	Image thresholdImage;
	RGBValue shit;
	
	NIVision.Range TOTE_RED_RANGE = new NIVision.Range(0, 15);
	NIVision.Range TOTE_GREEN_RANGE = new NIVision.Range(31, 255);
	NIVision.Range TOTE_HUE_RANGE = new NIVision.Range(0, 15);
	double AREA_MINIMUM = 0.5; //Default Area minimum for particle as a percentage of total image area
	NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	
	public void hi(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		thresholdImage = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MINIMUM, 100.0, 0, 0);
		shit = new RGBValue();
	}
	
	public void something(){
		
		this.getImage(frame);
		
		NIVision.imaqColorThreshold(thresholdImage, frame, 255, ColorMode.RGB, TOTE_RED_RANGE, TOTE_GREEN_RANGE, TOTE_HUE_RANGE);
		
		//int numParticles = NIVision.imaqCountParticles(thresholdImage, 1);
		//SmartDashboard.putNumber("Masked particles", numParticles);
		NIVision.imaqWriteFile(thresholdImage, "/test.jpg", shit);
		thresholdImage.free();
	}
}
