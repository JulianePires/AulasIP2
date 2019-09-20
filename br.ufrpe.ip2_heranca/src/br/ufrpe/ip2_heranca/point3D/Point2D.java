package br.ufrpe.ip2_heranca.point3D;

public abstract class Point2D {
	private float	x = 0.0f;
	private float	y = 0.0f;
	
	public Point2D() {
		super();
	}

	public Point2D(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float[] getXY() {
		float[] xy = new float[2];
		xy[0] = x;
		xy[1] = y;
		return xy;
	}
	
	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}
}
