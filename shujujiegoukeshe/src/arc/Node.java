package arc;

public class Node {
	private int num;
	private String name;
	private String info;
    private Edge nextEdge;
    
    public int getnum() {
	    return num;
	}
	public String getname() {
	    return name;
	}
	public String getInfo() {
		return info;
	}
	public void setnum(int num) {
		this.num=num;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setinfo(String info) {
		this.info=info;
	}
	public void setnextEdge(Edge edge) {
		this.nextEdge=edge;
	}
	public void setnode(String str) {
		String []array=str.split("£¬");

		try {
		    this.num=Integer.parseInt(array[0]);
			this.name=array[1];
			this.info=array[2];
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
	
	public Edge getNextEdge() {
		return nextEdge;
	}
 
	public void addEdge(Edge edge){
		if (this.getNextEdge() == null) 
			this.nextEdge = edge;
		else {
			Edge p = this.getNextEdge();
			while(p.getNext() != null)
				p = p.getNext();
			p.setNext(edge);
		}
	}
	
}
