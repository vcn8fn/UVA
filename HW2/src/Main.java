import java.awt.Point;
import world.World;

public class Main {

	public static void main(String[] args) {
		try {
			boolean isProbabilistic = true;
			World myWorld = new World("myInputFile2.txt", isProbabilistic);
			
			MyRobotClass myRobot = new MyRobotClass(myWorld, isProbabilistic);
			myRobot.addToWorld(myWorld);
			
			System.out.println();
			
			System.out.println("WORLD INFO:");
			System.out.println("startPos: " + myWorld.getStartPos());
			System.out.println("endPos: " + myWorld.getEndPos());
			System.out.println("numCols: " + myWorld.numCols());
			System.out.println("numRows: " + myWorld.numRows());
			
			System.out.println();
			
			myRobot.travelToDestination();
			
			System.out.println("ROBOT INFO:");
			System.out.println("numMoves: " + myRobot.getNumMoves());
			System.out.println("numPings: " + myRobot.getNumPings());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
