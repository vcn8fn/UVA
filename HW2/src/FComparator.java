import java.util.*;

public class FComparator implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return new Double(n1.getF()).compareTo(new Double(n2.getF()));
	}
}