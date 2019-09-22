package arc;

import java.util.ArrayList;
import java.util.Collections;

public class dijkstra {
	public AdjecentList gh;
	public dijkstra(AdjecentList graph) {
		this.gh=graph;
	}
	
	//未求出最短路径的点集合
	public ArrayList<Integer> unVisited=new ArrayList<Integer>();
	//已求出最短路径的点集合
	public ArrayList<Integer> hasVisited=new ArrayList<Integer>();
	//记录从起点到其他任意一点的路径长度
	public int distances[];
	//记录Path[i]表示从S到i的最短路径中，结点i之前的结点的编号,即对应点的前一个节点
	public int paths[];
	/**
	* 初始化各点距离及路径
	*/
	public void init(int x,int y ){
	distances=new int[gh.getNodes().size()];
	paths=new int[gh.getNodes().size()];
	for(int i=0;i<distances.length;i++){
		distances[i]=Integer.MAX_VALUE;
	}
	distances[x]=0;
	//把与x相邻的点的距离求出,并标准初始路径
	for(Edge edge=gh.findNode(x).getNextEdge();edge!=null;edge=edge.getNext()){
		distances[edge.getBack().getnum()]=edge.getweight();
		paths[edge.getBack().getnum()]=x;
	}
	//初始化未知最短路点集合和已知最短路集合
	unVisited.clear();
	hasVisited.clear();
	hasVisited.add(x);
	//其余点为未知
	for(int i=0;i<gh.getNodes().size();i++){
		if(i!=x){
			unVisited.add(i);
		}
	}
	}
	/**
	* 求从x到y的最短路径,并返回该路径
	* @param x
	* @param y
	*/
	public void Dijkstra(int x,int y){
	init(x,y);
	//如果
	System.out.println("开始执行...");
	while(!unVisited.isEmpty()){
		int vertexId=pickMinInUnvisited(x);
		if(vertexId==-1)
			break;
		//将其加入到已hasvisited集合中,并从未访问列表中去除
		hasVisited.add(vertexId);
		unVisited.remove((Integer)vertexId);
		//对u为起点,相邻的点为终点的临接点进行松弛操作
		relax(vertexId);
	}
	for(int i=0;i<distances.length;i++){
		System.out.println(x+"-->"+i+"距离为"+distances[i]);
	}
	ArrayList<String> mypath=printPath(x,y);
	StringBuilder sb=new StringBuilder();
	sb.append("路径为:");
	for(int i=0;i<mypath.size();i++){
		sb.append(mypath.get(i)+"-->");
	}
	sb.delete(sb.length()-3,sb.length());
	System.out.println(sb.toString());
	System.out.print("路线长度为：");
	System.out.println(distances[y]);
	}
	/**
	 * 求出从x到y的路径,由于path中存放的该点的前一个点的位置
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
			System.out.println("输入错误");
		}
		
	}
	public ArrayList<String> printPath(int x,int y){
		ArrayList<String> mypaths=new ArrayList<String>();
		while(y!=x){
			mypaths.add(gh.findNode(y).getname());
			y=paths[y];
		}
		
		mypaths.add(gh.findNode(x).getname());
		//路径倒置,需要反置回来
		Collections.reverse(mypaths);
		return mypaths;
	}
	/**
	* 考察所有以点u为起点的边,对每一条边进行松弛操作。
	*/
	public void relax(int u){
	for(Edge edge=gh.findNode(u).getNextEdge();edge!=null;edge=edge.getNext()){
		int v=edge.getBack().getnum();
		//对v进行松弛,看是否满足distances[v]>distances[u]+w[u][v]
		int w=edge.getweight();
		if(distances[v]>distances[u]+w){
			distances[v]=distances[u]+w;
			//记录v的最短路径时,前一个节点为u
			paths[v]=u;
		}
	}
	}
	/**
	* 从未求出最短路径的集合中找到与原点最近的点
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
