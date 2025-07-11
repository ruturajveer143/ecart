package com.screenshot;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.baseclass.BaseClass;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class ScreenShotUtil {

	public static String captureSC(String path) {
//		TakesScreenshot sc = (TakesScreenshot) BaseClass.getDriver();
//		File src = sc.getScreenshotAs(OutputType.FILE);
//
//		try {
//			Files.copy(src.toPath(), new File(path).toPath());
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//		return path;

		Screenshot shot = new AShot().takeScreenshot(BaseClass.getDriver());
		try {
			ImageIO.write(shot.getImage(), "png", new File(path));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return path;

	}

}
