package arc;

import java.util.ArrayList;
import java.util.Collections;

public class dijkstra {
	public AdjecentList gh;
	public dijkstra(AdjecentList graph) {
		this.gh=graph;
	}
	
	//δ������·���ĵ㼯��
	public ArrayList<Integer> unVisited=new ArrayList<Integer>();
	//��������·���ĵ㼯��
	public ArrayList<Integer> hasVisited=new ArrayList<Integer>();
	//��¼����㵽��������һ���·������
	public int distances[];
	//��¼Path[i]��ʾ��S��i�����·���У����i֮ǰ�Ľ��ı��,����Ӧ���ǰһ���ڵ�
	public int paths[];
	/**
	* ��ʼ��������뼰·��
	*/
	public void init(int x,int y ){
	distances=new int[gh.getNodes().size()];
	paths=new int[gh.getNodes().size()];
	for(int i=0;i<distances.length;i++){
		distances[i]=Integer.MAX_VALUE;
	}
	distances[x]=0;
	//����x���ڵĵ�ľ������,����׼��ʼ·��
	for(Edge edge=gh.findNode(x).getNextEdge();edge!=null;edge=edge.getNext()){
		distances[edge.getBack().getnum()]=edge.getweight();
		paths[edge.getBack().getnum()]=x;
	}
	//��ʼ��δ֪���·�㼯�Ϻ���֪���·����
	unVisited.clear();
	hasVisited.clear();
	hasVisited.add(x);
	//�����Ϊδ֪
	for(int i=0;i<gh.getNodes().size();i++){
		if(i!=x){
			unVisited.add(i);
		}
	}
	}
	/**
	* ���x��y�����·��,�����ظ�·��
	* @param x
	* @param y
	*/
	public void Dijkstra(int x,int y){
	init(x,y);
	//���
	System.out.println("��ʼִ��...");
	while(!unVisited.isEmpty()){
		int vertexId=pickMinInUnvisited(x);
		if(vertexId==-1)
			break;
		//������뵽��hasvisited������,����δ�����б���ȥ��
		hasVisited.add(vertexId);
		unVisited.remove((Integer)vertexId);
		//��uΪ���,���ڵĵ�Ϊ�յ���ٽӵ�����ɳڲ���
		relax(vertexId);
	}
	for(int i=0;i<distances.length;i++){
		System.out.println(x+"-->"+i+"����Ϊ"+distances[i]);
	}
	ArrayList<String> mypath=printPath(x,y);
	StringBuilder sb=new StringBuilder();
	sb.append("·��Ϊ:");
	for(int i=0;i<mypath.size();i++){
		sb.append(mypath.get(i)+"-->");
	}
	sb.delete(sb.length()-3,sb.length());
	System.out.println(sb.toString());
	System.out.print("·�߳���Ϊ��");
	System.out.println(distances[y]);
	}
	/**
	 * �����x��y��·��,����path�д�ŵĸõ��ǰһ�����λ��
	 * @param x
	 * @param y
	 */
	public void Dijkstra1(String start,String end)
	{
		if(gh.findNode(start)!=null&&gh.findNode(end)!=null)
		{
			int x=gh.findNode(start).getnum();
			int y=gh.findNode(end).getnum();
			Dijkstra(x,y);
		}
		else
		{
			System.out.println("�������");
		}
		
	}
	public ArrayList<String> printPath(int x,int y){
		ArrayList<String> mypaths=new ArrayList<String>();
		while(y!=x){
			mypaths.add(gh.findNode(y).getname());
			y=paths[y];
		}
		
		mypaths.add(gh.findNode(x).getname());
		//·������,��Ҫ���û���
		Collections.reverse(mypaths);
		return mypaths;
	}
	/**
	* ���������Ե�uΪ���ı�,��ÿһ���߽����ɳڲ�����
	*/
	public void relax(int u){
	for(Edge edge=gh.findNode(u).getNextEdge();edge!=null;edge=edge.getNext()){
		int v=edge.getBack().getnum();
		//��v�����ɳ�,���Ƿ�����distances[v]>distances[u]+w[u][v]
		int w=edge.getweight();
		if(distances[v]>distances[u]+w){
			distances[v]=distances[u]+w;
			//��¼v�����·��ʱ,ǰһ���ڵ�Ϊu
			paths[v]=u;
		}
	}
	}
	/**
	* ��δ������·���ļ������ҵ���ԭ������ĵ�
	* @param x
	*/
	public int pickMinInUnvisited(int x){
	int minIndex=-1;
	int min=Integer.MAX_VALUE;
	for(int i=0;i<distances.length;i++){
		if(unVisited.contains(i)){
			if(distances[i]<min){
				minIndex=i;
				min=distances[i];
			}
		}
	}
	return minIndex;
	}
	 
	
}
