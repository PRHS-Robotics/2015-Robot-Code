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
	
	public void hi(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	}
	
	public void something(){
		BinaryImage thresholdImage;
		
		try {
			this.getImage(frame);
			NIVision.imaqColorThreshold(thresholdImage, frame, 255, ColorMode.RGB, 0-15, 31-255, 0-15);
			//thresholdImage = frame.thresholdHSL(0, 255, 0, 255, 0, 255);
			thresholdImage.write("/tmp/threshold.jpg");
			thresholdImage.free();

			} catch (NIVisionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
