package com.founder.xjpt.com.founder.noreas.hotPoint.hotspot;

import com.founder.xjpt.com.founder.noreas.hotPoint.geometry.Envelope;
import com.founder.xjpt.com.founder.noreas.hotPoint.geometry.LonLat;

public class HotspotMode {
	public static int MODE_SUM = 1;

	public static int MODE_MAX = 2;

	public static int MODE_MIN = 3;

	public static int MODE_AVG = 4;
	Envelope envelope;
	private int maxWeight = 100;

	private int model = MODE_SUM;
	private Easing easing;
	private int maxValue = 0;

	private int minValue = 0;

	private int avgValue = 0;
	private double radius;
	private double radiateRadius;
	private double width;
	private double height;
	private int rowAmount;
	private int columnAmount;
	private int[][] reseaus;
	private boolean ifStated = false;

	public static HotspotMode getInstance(Envelope envelope, int model,
			double radius, int maxWeight, Easing easing, double radiateRadius) {
		HotspotMode hotspotMode = new HotspotMode();
		hotspotMode.maxWeight = maxWeight;

		if (model != MODE_SUM) {
			throw new RuntimeException("不支持的mode");
		}
		if (easing == null) {
			easing = new DefaultEasing(maxWeight);
		}

		hotspotMode.envelope = envelope;
		hotspotMode.radius = radius;
		hotspotMode.model = model;
		hotspotMode.easing = easing;

		hotspotMode.width = (envelope.getMaxX() - envelope.getMinX());
		hotspotMode.height = (envelope.getMaxY() - envelope.getMinY());

		hotspotMode.rowAmount = (int) Math.ceil(hotspotMode.height / radius);
		hotspotMode.columnAmount = (int) Math.ceil(hotspotMode.width / radius);
		//System.out.println(hotspotMode.height + " - " + radius + " - "+ hotspotMode.rowAmount);
		//System.out.println(hotspotMode.width + " - " + radius + " - " + hotspotMode.columnAmount);
		hotspotMode.radiateRadius = radiateRadius;
		return hotspotMode;
	}

	public void doSimpleStat() {
		int sum = 0;
		int count = 0;
		int maxValue = -2147483648;
		int minValue = 2147483647;
		for (int i = 0; i < this.reseaus.length; i++) {
			for (int j = 0; j < this.reseaus[i].length; j++) {
				int v = this.reseaus[i][j];
				if (v > 0) {
					count++;
					sum += v;
					if (v > maxValue) {
						maxValue = v;
					}
					if (v < minValue) {
						minValue = v;
					}
				}
			}
		}
		if (count != 0) {
			this.avgValue = (sum / count);
		}
		this.maxValue = maxValue;
		this.minValue = minValue;
		this.ifStated = true;
	}

	private void addValue(int x, int y, int value, int row, int column) {
		if (x == 0) {
			if (y == 0) {
				if ((row >= 0) && (row < this.rowAmount) && (column >= 0)
						&& (column < this.columnAmount)) {
					this.reseaus[row][column] += value;
				}
			} else if ((row >= 0) && (row < this.rowAmount)) {
				int newColumn = column + y;
				if ((newColumn >= 0) && (newColumn < this.columnAmount)) {
					this.reseaus[row][newColumn] += value;
				}
				newColumn = column - y;
				if ((newColumn >= 0) && (newColumn < this.columnAmount)) {
					this.reseaus[row][newColumn] += value;
				}
			}

		} else if (y == 0) {
			if ((column >= 0) && (column < this.columnAmount)) {
				int newRow = row + x;
				if ((newRow >= 0) && (newRow < this.rowAmount)) {
					this.reseaus[newRow][column] += value;
				}
				newRow = row - x;
				if ((newRow >= 0) && (newRow < this.rowAmount))
					this.reseaus[newRow][column] += value;
			}
		} else {
			int newRow = row + x;
			int newColumn = column + y;
			if ((newRow >= 0) && (newRow < this.rowAmount) && (newColumn >= 0)
					&& (newColumn < this.columnAmount)) {
				this.reseaus[newRow][newColumn] += value;
			}
			newRow = row + x;
			newColumn = column - y;
			if ((newRow >= 0) && (newRow < this.rowAmount) && (newColumn >= 0)
					&& (newColumn < this.columnAmount)) {
				this.reseaus[newRow][newColumn] += value;
			}
			newRow = row - x;
			newColumn = column + y;
			if ((newRow >= 0) && (newRow < this.rowAmount) && (newColumn >= 0)
					&& (newColumn < this.columnAmount)) {
				this.reseaus[newRow][newColumn] += value;
			}
			newRow = row - x;
			newColumn = column - y;
			if ((newRow >= 0) && (newRow < this.rowAmount) && (newColumn >= 0)
					&& (newColumn < this.columnAmount)) {
				this.reseaus[newRow][newColumn] += value;
			}
		}
	}

	private int calculateMaxRow(int row, int loop) {
		return (int) Math.ceil(Math.sqrt(loop * loop - row * row));
	}

	public void buildMode(LonLat[] lonlats) {
		this.reseaus = new int[this.rowAmount][this.columnAmount];

		int loop = getLoop();

		Envelope bufferEnve = getBufferEnvelope(this.envelope,
				this.radiateRadius);
		for (int i = 0; i < lonlats.length; i++) {
			LonLat lonlat = lonlats[i];
			int[] rc = getReseau(lonlats[i]);
			if (bufferEnve.contain(lonlat))
				for (int row = 0; row <= loop; row++) {
					int maxColumn = calculateMaxRow(row, loop);
					for (int column = 0; column <= maxColumn; column++) {
						double dis = Math.sqrt(row * row + column * column);
						int value = this.easing.calculate(dis / loop);
						addValue(row, column, value, rc[0], rc[1]);
					}
				}
		}
	}

	private Envelope getBufferEnvelope(Envelope enve, double radius) {
		Envelope bufferEnvelope = new Envelope();
		double minX = enve.getMinX();
		double maxX = enve.getMaxX();
		double minY = enve.getMinY();
		double maxY = enve.getMaxY();
		bufferEnvelope.setMinX(minX - radius);
		bufferEnvelope.setMaxX(maxX + radius);
		bufferEnvelope.setMinY(minY - radius);
		bufferEnvelope.setMaxY(maxY + radius);
		return bufferEnvelope;
	}

	private int[] getReseau(LonLat lonlat) {
		double width = lonlat.getX() - this.envelope.getMinX();
		double height = this.envelope.getMaxY() - lonlat.getY();

		int row = (int) (height / this.radius);
		int column = (int) (width / this.radius);

		return new int[] { row, column };
	}

	private int getLoop() {
		return (int) Math.ceil(this.radiateRadius / this.radius);
	}

	public double getRdiateRadius() {
		return this.radiateRadius;
	}

	public int getColumnAmount() {
		return this.columnAmount;
	}

	public Easing getEasing() {
		return this.easing;
	}

	public Envelope getEnvelope() {
		return this.envelope;
	}

	public double getHeight() {
		return this.height;
	}

	public int getMaxValue() {
		if (this.ifStated) {
			return this.maxValue;
		}

		throw new RuntimeException("必须先调用doSimpleStat开始统计，才能得到返回值!");
	}

	public int getMaxWeight() {
		return this.maxWeight;
	}

	public int getMinValue() {
		if (this.ifStated) {
			return this.minValue;
		}

		throw new RuntimeException("必须先调用doSimpleStat开始统计，才能得到返回值!");
	}

	public int getModel() {
		return this.model;
	}

	public double getRadius() {
		return this.radius;
	}

	public int getRowAmount() {
		return this.rowAmount;
	}

	public double getWidth() {
		return this.width;
	}

	public int getAvgVlaue() {
		if (this.ifStated) {
			return this.avgValue;
		}

		throw new RuntimeException("必须先调用doSimpleStat开始统计，才能得到返回值!");
	}

	public int[][] getReseaus() {
		return this.reseaus;
	}
}
