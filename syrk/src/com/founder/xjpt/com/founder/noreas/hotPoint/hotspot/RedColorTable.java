package com.founder.xjpt.com.founder.noreas.hotPoint.hotspot;

import java.util.Map;

public class RedColorTable implements ColorTable {
	private int defaultAlpha = 160;
	@SuppressWarnings("unused")
	private int maxValue = 100;
	public int[] colorConstant = new int[21];

	int[][] colors = { { 0, 255, 0 }, { 25, 255, 0 }, { 51, 255, 0 }, { 76, 255, 0 },
			{ 102, 255, 0 }, { 127, 255, 0 }, { 153, 255, 0 }, { 178, 255, 0 },
			{ 204, 255, 0 }, { 229, 255, 0 }, { 255, 255, 0 }, { 255, 229, 0 },
			{ 255, 204, 0 }, { 255, 178, 0 }, { 255, 153, 0 }, { 255, 127, 0 },
			{ 255, 102, 0 }, { 255, 76, 0 }, { 255, 51, 0 }, { 255, 25, 0 }, { 255, 0, 0 } };

	public int[] getARG(int value) {
		throw new RuntimeException("方法不可用");
	}

	public RedColorTable() {
	}

	public RedColorTable(Map<String, Integer> colorMap, int maxValue, int alpha) {
		this.defaultAlpha = (int) (alpha / 100.0D * 255.0D);
		this.maxValue = maxValue;
		int value0 = ((Integer) colorMap.get("00ff00")).intValue();
		int value5 = ((Integer) colorMap.get("ffff00")).intValue();
		int value10 = ((Integer) colorMap.get("ff0000")).intValue();

		this.colorConstant[0] = (value0 * maxValue);
		this.colorConstant[10] = (value5 * maxValue);
		this.colorConstant[20] = (value10 * maxValue);

		int stepValue = -(this.colorConstant[0] - this.colorConstant[10]) / 9;

		this.colorConstant[1] = (this.colorConstant[0] + stepValue);
		this.colorConstant[2] = (this.colorConstant[1] + stepValue);
		this.colorConstant[3] = (this.colorConstant[2] + stepValue);
		this.colorConstant[4] = (this.colorConstant[3] + stepValue);
		this.colorConstant[5] = (this.colorConstant[4] + stepValue);
		this.colorConstant[6] = (this.colorConstant[5] + stepValue);
		this.colorConstant[7] = (this.colorConstant[6] + stepValue);
		this.colorConstant[8] = (this.colorConstant[7] + stepValue);
		this.colorConstant[9] = (this.colorConstant[8] + stepValue);

		stepValue = -(this.colorConstant[5] - this.colorConstant[20]) / 9;

		this.colorConstant[11] = (this.colorConstant[10] + stepValue);
		this.colorConstant[12] = (this.colorConstant[11] + stepValue);
		this.colorConstant[13] = (this.colorConstant[12] + stepValue);
		this.colorConstant[14] = (this.colorConstant[13] + stepValue);
		this.colorConstant[15] = (this.colorConstant[14] + stepValue);
		this.colorConstant[16] = (this.colorConstant[15] + stepValue);
		this.colorConstant[17] = (this.colorConstant[16] + stepValue);
		this.colorConstant[18] = (this.colorConstant[17] + stepValue);
		this.colorConstant[19] = (this.colorConstant[18] + stepValue);
	}

	public int[] getARGB(int value) {
		int[] argb = new int[4];
		for (int i = this.colorConstant.length - 1; i > 0; i--) {
			if (value < this.colorConstant[i] * 0.95D)
				continue;
			argb[3] = this.defaultAlpha;
			argb[0] = this.colors[i][0];
			argb[1] = this.colors[i][1];
			argb[2] = this.colors[i][2];
			break;
		}

		return argb;
	}
}
