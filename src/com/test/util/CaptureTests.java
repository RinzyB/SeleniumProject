package com.test.util;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureTests {

	private final static Logger logger = LogManager.getLogger(CaptureTests.class);
	private static ScreenRecorder recorder;

	/**
	 * 
	 * @param cdriver
	 * @param name
	 */
	public void takeSS(WebDriver cdriver, String name) {
		logger.trace("In takeSS()..");
		// take full screenshot and store in project location
		try {
			File scrFile = ((TakesScreenshot) cdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(getFilePath(name)));
		} catch (IOException e) {
			logger.error("IOException during file screenshot copy! " + e.getLocalizedMessage());
		}
	}

	public void takeElementSS(WebElement element, String name) {
		logger.trace("In takeElementSS()..");
		// take full screenshot and store in project location
		try {
			File srcFile = element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(getFilePath(name)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IOException during file screenshot copy! " + e.getLocalizedMessage());
		}
	}

	private String getFilePath(String fileName) {
		logger.debug("Checking if SS folder exists..");
		File folder = new File(Constants.screenshotsFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		} else if (!folder.isDirectory()) {
			logger.fatal("\"" + Constants.screenshotsFolder + "\" is not a directory.");
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
		return Constants.screenshotsFolder + fileName + "_" + dateFormat.format(new Date()) + ".png";
	}

	public void startTestRecording() {
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		// Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		// Rectangle rectSize = new Rectangle(0, 0, dim.height, dim.width);
		File videoFolder = new File(Constants.recordingFolder);

		try {
			recorder = new ScreenRecorder(gc, gc.getBounds(),
					new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
							Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
					null /*
							 * new Format(MediaTypeKey, MediaType.AUDIO, EncodingKey, ENCODING_PCM_SIGNED,
							 * FrameRateKey, new Rational(48000, 1), SampleSizeInBitsKey, 16, ChannelsKey,
							 * 2, SignedKey, true, ByteOrderKey, ByteOrder.BIG_ENDIAN)
							 */, videoFolder);
			recorder.start();
		} catch (IOException | AWTException e) {
			logger.error("Exception while recording! " + e.getMessage());
		}
	}

	public void stopTestRecording() {
		logger.debug("Stopping test recording..");
		try {
			recorder.stop();
		} catch (IOException e) {
			logger.error("Exception while trying to stop recording! " + e.getMessage());
		}
	}
}
