package br.ufrpe.ip2_heranca.movablePoint;

public class MovablePoint extends Point {
	
	private float		xSpeed = 0.0f;
	private float		ySpeed = 0.0f;
	
	public MovablePoint() {
		super();
	}

	public MovablePoint(float xSpeed, float ySpeed) {
		super();
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public float getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}

	public float getySpeed() {
		return ySpeed;
	}

	public void setySpeed(float ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void setSpeed(float xSpeed, float ySpeed) {
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public float[] getSpeed() {
		float[] xy = new float[2];
		xy[0] = xSpeed;
		xy[1] = ySpeed;
		return xy;
	}

	@Override
	public String toString() {
		return super.toString() + "| xSpeed=" + xSpeed + "| ySpeed=" + ySpeed;
	}
		
}
