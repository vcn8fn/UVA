import java.awt.Point;

public class Node {
	Point pt = null;
	double g = 0;
	double h = 0;
	double f = 0;
	Node p = null;

	Node(Point pt, double gx, double hx) {
		//point
		this.pt = pt;
		this.g = gx;
		this.h = hx;
		this.f = 0;
		//parent
		this.p = null;
	}
	
	public Point getPoint() {
		return pt;
	}
	
	public void setPoint(Point pt) {
		this.pt = pt;
	}

	public double getG() {
		return g;
	}

	public void setG(double gx) {
		g = gx;
	}

	public double getH() {
		return h;
	}

	public void setH(double hx) {
		h = hx;
	}

	public double getF() {
		return f;
	}

	public void setF(double fx) {
		f = fx;
	}
	
	//parent node
	public Node getP() {
		return p;
	}

	public void setP(Node parent) {
		this.p = parent;
	}
}
