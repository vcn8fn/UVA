import java.awt.Point;
import world.Robot;
import world.World;
import java.util.*;

public class MyRobotClass extends Robot {
	
	private World myWorld;
	private boolean isProbabilistic;
	
	public MyRobotClass(World myWorld, boolean isProbabilistic) {
		this.myWorld = myWorld;
		this.isProbabilistic = isProbabilistic;
	}

	@Override
	public void travelToDestination() {
		
		//uncertain
		if (!this.isProbabilistic) {
			travelToDestinationCertain();
		}
		
		//certain
		else {
			travelToDestinationUncertain();
		}
		
	}
	
	protected void travelToDestinationCertain() {
				
		int numRows = myWorld.numRows();
		int numCols = myWorld.numCols();
		
		double gx = 0;
		double hx = 0;
		double fx = 0;
		Node[][] nodes = new Node[numRows][numCols];
		
		Point startPt = myWorld.getStartPos();
		Point finishPt = myWorld.getEndPos();
		
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				Point tmpPt = new Point(i, j);
				hx = (double)tmpPt.distance(finishPt);
				Node tmpNode = new Node(tmpPt, gx, hx);
				nodes[i][j] = tmpNode;
//				System.out.println(nodes[i][j].getPoint() + " " + nodes[i][j].getG() + " " + nodes[i][j].getH());
			}
		}
		
		Node parent = nodes[(int)startPt.getX()][(int)startPt.getY()];
		open.add(parent);
		//set g(x) & parent
		while(!closed.contains(nodes[(int)finishPt.getX()][(int)finishPt.getY()])) {
			//if a valid node exists
			//if not a wall
			//if not in closed list
			//check re-routes
			//set parent to node
			//calculate g(x)
			//calculate f(x)
			//add to open list
									
			//south
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY() < numCols) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY())).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//southeast
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY()+1 < numCols) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY()+1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//east
			if (parent.getPoint().getX() < numRows && parent.getPoint().getY()+1 < numCols) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX(), (int)parent.getPoint().getY()+1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//northeast
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY()+1 < numCols) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY()+1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//north
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY() < numCols) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY())).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//northwest
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY()-1 >= 0) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY()-1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//west
			if (parent.getPoint().getX() < numRows && parent.getPoint().getY()-1 >= 0) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX(), (int)parent.getPoint().getY()-1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//southwest
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY()-1 >= 0) {
				if (!super.pingMap(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY()-1)).equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//put parent node in closed list & remove from open list
			closed.add(parent);
			open.remove(parent);

			//find lowest f(x) value in open list
			//remove it from open & add it to closed
			//set new parent node
			Node nextNode = Collections.min(open, new FComparator());
//			super.move(nextNode.getPoint());
//			System.out.println(nextNode.getPoint().getX() + ", " + nextNode.getPoint().getY());
			open.remove(nextNode);
			closed.add(nextNode);
			parent = nextNode;
		}
		
		//trace finish node back to start node
		Node n = nodes[(int)finishPt.getX()][(int)finishPt.getY()];
		ArrayList<Node> pathStartFinish = new ArrayList<Node>();
		pathStartFinish.add(n);
		while (n.getP() != null) {
//			System.out.println(n.getPoint().getX() + ", " + n.getPoint().getY());
			pathStartFinish.add(n.getP());
			n = n.getP();
		}
		
		Collections.reverse(pathStartFinish);
		
		//traverse path in order (move along the path but don't count the first node)
		for (int i = 1; i < pathStartFinish.size(); i++) {
			Point tmpPt = pathStartFinish.get(i).getPoint();
			//print moves
//			System.out.println(tmpPt);
			super.move(tmpPt);
		}
		
	}
	
	protected void travelToDestinationUncertain() {
		
		//change numPings to determine how exhaustive the algo is
		int numPings = 9;
		
		int numRows = myWorld.numRows();
		int numCols = myWorld.numCols();
		
		double gx = 0;
		double hx = 0;
		double fx = 0;
		Node[][] nodes = new Node[numRows][numCols];
		
		Point startPt = myWorld.getStartPos();
		Point finishPt = myWorld.getEndPos();
		
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				Point tmpPt = new Point(i, j);
				hx = (double)tmpPt.distance(finishPt);
				Node tmpNode = new Node(tmpPt, gx, hx);
				nodes[i][j] = tmpNode;
//				System.out.println(nodes[i][j].getPoint() + " " + nodes[i][j].getG() + " " + nodes[i][j].getH());
			}
		}
		
		Node parent = nodes[(int)startPt.getX()][(int)startPt.getY()];
		open.add(parent);
		//set g(x) & parent
		while(!closed.contains(nodes[(int)finishPt.getX()][(int)finishPt.getY()])) {
			//if a valid node exists
			//if not a wall
			//if not in closed list
			//check re-routes
			//set parent to node
			//calculate g(x)
			//calculate f(x)
			//add to open list
									
			//south
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY() < numCols) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY()), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//southeast
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY()+1 < numCols) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY()+1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//east
			if (parent.getPoint().getX() < numRows && parent.getPoint().getY()+1 < numCols) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX(), (int)parent.getPoint().getY()+1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//northeast
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY()+1 < numCols) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY()+1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()+1])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()+1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//north
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY() < numCols) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY()), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//northwest
			if (parent.getPoint().getX()-1 >= 0 && parent.getPoint().getY()-1 >= 0) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()-1, (int)parent.getPoint().getY()-1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()-1][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//west
			if (parent.getPoint().getX() < numRows && parent.getPoint().getY()-1 >= 0) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX(), (int)parent.getPoint().getY()-1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//southwest
			if (parent.getPoint().getX()+1 < numRows && parent.getPoint().getY()-1 >= 0) {
				String pingResult = pingManyTimes(new Point((int)parent.getPoint().getX()+1, (int)parent.getPoint().getY()-1), numPings);
				if (!pingResult.equals("X")) {
					if (!closed.contains(nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()-1])) {
						Node n = nodes[(int)parent.getPoint().getX()+1][(int)parent.getPoint().getY()-1];
						if (open.contains(n)) {
							double tmpfx = (parent.getG()+1) + (n.getH());
							if (n.getF() < tmpfx) {
								n.setP(parent.getP());
							}
							else {
								n.setP(parent);
								n.setG(parent.getG()+1);
							}
						}
						else {
							n.setP(parent);
							n.setG(parent.getG()+1);
						}
						fx = (n.getG()) + (n.getH());
						n.setF(fx);
						open.add(n);
					}
				}
			}
			
			//put parent node in closed list & remove from open list
			closed.add(parent);
			open.remove(parent);

			//find lowest f(x) value in open list
			//remove it from open & add it to closed
			//set new parent node
			Node nextNode = Collections.min(open, new FComparator());
//			super.move(nextNode.getPoint());
//			System.out.println(nextNode.getPoint().getX() + ", " + nextNode.getPoint().getY());
			open.remove(nextNode);
			closed.add(nextNode);
			parent = nextNode;
		}
		
		//trace finish node back to start node
		Node n = nodes[(int)finishPt.getX()][(int)finishPt.getY()];
		ArrayList<Node> pathStartFinish = new ArrayList<Node>();
		pathStartFinish.add(n);
		while (n.getP() != null) {
//			System.out.println(n.getPoint().getX() + ", " + n.getPoint().getY());
			pathStartFinish.add(n.getP());
			n = n.getP();
		}
		
		Collections.reverse(pathStartFinish);
		
		//traverse path in order (move along the path but don't count the first node)
		for (int i = 1; i < pathStartFinish.size(); i++) {
			Point tmpPt = pathStartFinish.get(i).getPoint();
			//print moves
//			System.out.println(tmpPt);
			super.move(tmpPt);
		}

	}
	
	protected String pingManyTimes(Point potentialPt, int numPings) {
		String pingResult = "";
		int countX = 0;
		
		//ping up to numPings and count the number of X's
		for (int i = 0; i < numPings; i++) {
			String tmpResult = super.pingMap(potentialPt);
			if (tmpResult.equals("X")) {
				countX++;
			}
		}
		
		//see if the frequency of X's pinged occurs more than 50% of the time
		//if not larger than 50% of the time, then return a movable location
		if ((double)countX/(double)numPings > 0.5) {
			pingResult = "X";
		}
		else {
			pingResult = "O";
		}
		
		return pingResult;
	}
	
}