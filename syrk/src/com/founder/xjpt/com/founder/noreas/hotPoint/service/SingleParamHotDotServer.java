package com.founder.xjpt.com.founder.noreas.hotPoint.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.imageio.ImageIO;
import com.founder.xjpt.com.founder.noreas.hotPoint.geometry.Envelope;
import com.founder.xjpt.com.founder.noreas.hotPoint.geometry.LonLat;
import com.founder.xjpt.com.founder.noreas.hotPoint.hotspot.HotspotMode;
import com.founder.xjpt.com.founder.noreas.hotPoint.hotspot.HotspotView;
import com.founder.xjpt.com.founder.noreas.hotPoint.hotspot.RedColorTable;
import com.founder.xjpt.com.founder.noreas.xmlOpe.XMLOpeUtils;

public class SingleParamHotDotServer {
	private int maxValue = 1000;
	
	public String getHotPotPic(double[][] xy,String strEnve, double resolution, double radius,Map<String, Integer> colorMap, int alpha) {
		String fileName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".png";
		LonLat[] lonlats = getLonlats(xy);
		String[] enveArr = strEnve.split(",");
		Envelope enve = new Envelope(Double.valueOf(enveArr[0]),Double.valueOf(enveArr[1]), Double.valueOf(enveArr[2]), Double.valueOf(enveArr[3]));
		HotspotMode mode = HotspotMode.getInstance(enve, HotspotMode.MODE_SUM,resolution, this.maxValue, null, radius);
		mode.buildMode(lonlats);
		mode.doSimpleStat();
		HotspotView view = new HotspotView(mode, new RedColorTable(colorMap,this.maxValue, alpha));
		BufferedImage image = view.getImage(true);
		String imagePath = XMLOpeUtils.getAppointPathFile("");
		if (!imagePath.endsWith("/"))imagePath = imagePath + "/";
		imagePath = imagePath + "temp/" + fileName;
		try {
			ImageIO.write(image, "PNG", new FileOutputStream(new File(imagePath)));
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return imagePath;
	}
	
	private LonLat[] getLonlats(double[][] xy) {
		LonLat[] lonLats = new LonLat[xy.length];
		for (int i = 0; i < xy.length; i++) {
			lonLats[i] = new LonLat(xy[i][0], xy[i][1]);
		}
		return lonLats;
	}
}
