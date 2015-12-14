package com.founder.xjpt.com.founder.noreas.hotPoint.hotspot;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class HotspotView {
	private HotspotMode mode;
	private ColorTable colorTable;

	public HotspotView(HotspotMode mode, ColorTable colorTable) {
		this.mode = mode;
		this.colorTable = colorTable;
	}

	public BufferedImage getImage(boolean hightlight) {
		BufferedImage image = new BufferedImage(this.mode.getColumnAmount(),this.mode.getRowAmount(), 2);
		WritableRaster raster = image.getRaster();
		int[][] reseaus = this.mode.getReseaus();
		for (int i = 0; i < reseaus.length; i++) {
			for (int j = 0; j < reseaus[i].length; j++) {
				if (reseaus[i][j] == 0)continue;
				int[] color = this.colorTable.getARGB(reseaus[i][j]);
				raster.setPixel(j, i, color);
			}
		}
		return image;
	}
}
