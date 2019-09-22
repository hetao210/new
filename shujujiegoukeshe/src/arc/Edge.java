package arc;

public class Edge {
	private Node front;
	private Node back;
	private int weight;
	private Edge next;
	
	public Node getFront() {
		return front;
	}
	public Node getBack() {
		return back;
	}
	public int getweight() {
		return weight;
	}
	public void setFront(Node front) {
		this.front = front;
	}
	public void setBack(Node back) {
		this.back = back;
	}
	public void setweight(int weight) {
		this.weight = weight;
	}
	public String toString() {
		String s = "" + front.getname() + "->";
		return s;
	}
	public Edge getNext() {
		return next;
	}
	public void setNext(Edge next) {
		this.next = next;
	}
	public void setEdge(Edge edge) {
		this.front=edge.getFront();
		this.back=edge.getBack();
		this.weight=edge.getweight();
		this.next=edge.getNext();
	}
}
