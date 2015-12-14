package com.founder.xjpt.com.founder.noreas.hotPoint.geometry;

public class CoordTrans {
	private int sWidth;
	private int sHeight;
	private double mminx;
	private double mminy;
	private double mmaxx;
	private double mmaxy;
	private double mWidth;
	private double mHeight;
	private double smx;
	private double smy;
	private double msx;
	private double msy;

	public CoordTrans(double mminx, double mminy, double mmaxx, double mmaxy,
			int sWidth) {
		int sHeight = cacuImgHeight(sWidth, mmaxx - mminx, mmaxy - mminy);
		initParam(mminx, mminy, mmaxx, mmaxy, sWidth, sHeight);
	}

	public CoordTrans(double mminx, double mminy, double mmaxx, double mmaxy,
			int sWidth, int sHeight) {
		initParam(mminx, mminy, mmaxx, mmaxy, sWidth, sHeight);
	}

	private void initParam(double mminx, double mminy, double mmaxx,
			double mmaxy, int sWidth, int sHeight) {
		this.sWidth = sWidth;
		this.sHeight = sHeight;
		this.mminx = mminx;
		this.mminy = mminy;
		this.mmaxx = mmaxx;
		this.mmaxy = mmaxy;

		this.mWidth = getMapWidth();
		this.mHeight = getMapHeight();

		this.smx = (sWidth / this.mWidth);
		this.smy = (sHeight / this.mHeight);
		this.msx = (this.mWidth / sWidth);
		this.msy = (this.mHeight / sHeight);
	}

	public int fromMapX(double mx) {
		int sx = (int) Math.round(this.smx * (mx - this.mminx));
		return sx;
	}

	public int fromMapY(double my) {
		int sy = (int) Math.round(this.smy * (my - this.mminy));
		return this.sHeight - sy;
	}

	public Envelope fromMapEnv(Envelope mapEnv) {
		double mx1 = mapEnv.getMinX();
		double my1 = mapEnv.getMinY();
		double mx2 = mapEnv.getMaxX();
		double my2 = mapEnv.getMaxY();

		int sx1 = fromMapX(mx1);
		int sy1 = fromMapY(my1);
		int sx2 = fromMapX(mx2);
		int sy2 = fromMapY(my2);

		Envelope scrEnv = new Envelope(sx1, sx2, sy1, sy2);
		return scrEnv;
	}

	public double toMapX(int sx) {
		double mx = this.msx * sx + this.mminx;
		return mx;
	}

	public double toMapY(int sy) {
		double my = this.msy * (this.sHeight - sy) + this.mminy;
		return my;
	}

	public Envelope toMapEnv(Envelope scrEnv) {
		int sx1 = (int) scrEnv.getMinX();
		int sy1 = (int) scrEnv.getMinY();
		int sx2 = (int) scrEnv.getMaxX();
		int sy2 = (int) scrEnv.getMaxY();

		double mx1 = toMapX(sx1);
		double my1 = toMapY(sy1);
		double mx2 = toMapX(sx2);
		double my2 = toMapY(sy2);

		Envelope mapEnv = new Envelope(mx1, mx2, my1, my2);
		return mapEnv;
	}

	public Envelope getMapEnvelop() {
		return new Envelope(this.mminx, this.mmaxx, this.mminy, this.mmaxy);
	}

	public double toMapWidth(int sWidth) {
		double mWidth = this.msx * sWidth;
		return mWidth;
	}

	public double toMapHeight(int sHeight) {
		double mHeight = this.msy * sHeight;
		return mHeight;
	}

	public double getMapWidth() {
		if (this.mWidth <= 0.0D) {
			this.mWidth = (this.mmaxx - this.mminx);
		}
		return this.mWidth;
	}

	public double getMapHeight() {
		if (this.mHeight <= 0.0D) {
			this.mHeight = (this.mmaxy - this.mminy);
		}
		return this.mHeight;
	}

	public static int cacuImgHeight(int sWidth, double mWidth, double mHeight) {
		int sHeight = (int) Math.round(mHeight * sWidth / mWidth);
		return sHeight;
	}

	public int cacuImgHeight(int sWidth) {
		int sHeight = (int) Math.round(this.mHeight * sWidth / this.mWidth);
		return sHeight;
	}

	public double getMminx() {
		return this.mminx;
	}

	public double getMminy() {
		return this.mminy;
	}

	public double getMmaxx() {
		return this.mmaxx;
	}

	public double getMmaxy() {
		return this.mmaxy;
	}

	public int getSWidth() {
		return this.sWidth;
	}

	public int getSHeight() {
		return this.sHeight;
	}
}
