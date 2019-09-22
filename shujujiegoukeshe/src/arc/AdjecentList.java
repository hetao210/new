package arc;

import java.util.ArrayList;
import java.util.List;

public class AdjecentList {
	private List<Node> nodes = new ArrayList<Node>();
	 
	public List<Node> getNodes() {
		return nodes;
	}
 
	public void addNode(Node node){
		nodes.add(node);
	}
	
	public void deleteNode(Node node) {
		nodes.remove(node);
	}
	public Node findNode(int data){
		for(Node node : nodes){
			if (node.getnum()==data) {
				return node;
			}
		}
		return null;
	}
	public Node findNode(String name){
		for(Node node : nodes){
			if (node.getname().equals(name)) {
				return node;
			}
		}
		return null;
	}
	public Node findFirst(){
		if (nodes != null) {
			return nodes.get(0);
		}
		return null;
	}
	public void deleteEdge(Node front,Node back)
	{
		Edge edge=front.getNextEdge();
		while(edge!=null)
		{
			if(edge.getBack().getnum()==back.getnum())
			{
				edge.setweight(Integer.MIN_VALUE);
				break;
			}
			edge=edge.getNext();
		}
	}
	public void printadjecentlist()
	{
		System.out.println("邻接表存储的图：");
		for(Node node:nodes) {
			System.out.print(node.getname()+"-->");
			//如果存在邻接点
			Edge edge=node.getNextEdge();
			Node nextnode=new Node();
			while(edge!=null) {
				if(edge.getweight()>Integer.MIN_VALUE)
				{
					nextnode=edge.getBack();
				    System.out.print(nextnode.getname()+"-->");
				}
				edge=edge.getNext();
			}
			System.out.print("null");
			System.out.println();
		}
	}
}
