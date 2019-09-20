package br.ufrpe.ip2_heranca.point3D;

public class Point3D extends Point2D {
	private float	z=0.0f;

	public Point3D(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}

	public Point3D() {
		super();
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public void setXYZ(float x, float y, float z) {
		this.z = z;
		setXY(x,y);
	}
	
	
}
