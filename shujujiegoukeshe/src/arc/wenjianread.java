package arc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class wenjianread {

	public static String pathname1="D:\\eclipse\\shujujiegoukeshe\\txt\\Vex.txt";
	public static String pathname2="D:\\eclipse\\shujujiegoukeshe\\txt\\Edge.txt";
	public static AdjecentList Graph;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    index();
		    	    
	}
	public static void index()
	{
		IOTool.print("                 欢迎进入景区信息管理                           ");
	    
	    visit();
	    IOTool.print("你可以进行的操作：    ");
	    IOTool.print("         1.输出景点图的邻接表                  ");
	    IOTool.print("         2.查询景点信息                            ");
	    IOTool.print("         3.旅游景点导航                            ");
	    IOTool.print("         4.找最短路径                               ");
	    IOTool.print("         5.铺设电路规划 	           ");
	    IOTool.print("         6.景区信息修改			       ");
	    IOTool.print("         7.退出			           ");
	    IOTool.print("请按相应序号输入你想进行的操作：             ");
	    String in=IOTool.getInput();
	    switch(Integer.valueOf(in)) {
	    case 1:
	    	try{
	    		clear();
	    		visit();
	    		Graph.printadjecentlist();
	    		previous();
	    	}catch(AWTException e) {
	    		e.printStackTrace();
	    	}
	    	break;
	    case 2:
	    	try{
    		    clear();
    		    visit();
    		    boolean flag=true;
    		    while(flag) {
    		    	IOTool.print("请输入你想要查询景点的编号：");
        		    
        		    	String num=IOTool.getInput();
    		    	    int n=input(num);
    		    	    if(n!=-1) {
        		    	IOTool.print("景点信息：");
        		    	IOTool.print(Graph.findNode(n).getname());
        		    	IOTool.print(Graph.findNode(n).getInfo());
        		    	IOTool.print("邻接点：");
        		    	List<String> str=readtxt(pathname2);
        		    	for(String e:str) {
        		    		String[] s=e.split("，");
        		    		if(n==Integer.valueOf(s[0])){
        		    			IOTool.print(s[0]+"->"+s[1]+"       路径长度："+s[2]);
        		    		}
        		    	}
        		    	IOTool.print("是否继续查询？\n1.是                2.否");
        		    	String f=IOTool.getInput();
        		    	if(f.equals("1")) {
        		    		flag=true;
        		    	}
        		    	else
        		    	{
        		    		flag=false;
        		    		previous();
        		    	}
        		    	
        		    }
        		    
    		    }
    	        }catch(AWTException e) {
    		           e.printStackTrace();
    	        }  
	    	break;
	    case 3:
	    	try{
    		    clear();
    		    visit();
    		    boolean flag=true;
    		    while(flag) {
    		    	IOTool.print("请输入你想要查询景点的编号：");

        		    	String num=IOTool.getInput();
    		    	    int n=input(num);
    		    	    if(n!=-1)
    		    	    {
    		    	    	IOTool.print("导航路线：");
        		    	    graph.depthFirstSearch(Graph,n);
        		    	    IOTool.print("\n是否继续查询？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }	
    		    	    }
        		    	
        		    }
    	        }catch(AWTException e) {
    		           e.printStackTrace();
    	        }
	    	    break;
	    case 4:
	    	try{
		    	clear();
		    	visit();
		    	boolean flag=true;
		    	while(flag) {
		    		IOTool.print("最短路径搜索：");
    		    	IOTool.print("请依次输入起始和终点景点的编号（以回车结束一个输入）：");

        		    	String num1=IOTool.getInput();
        		    	String num2=IOTool.getInput();
    		    	    int start=input(num1);
    		    	    int end=input(num2);
    		    	    if(start!=-1&&end!=-1)
    		    	    {
    		    	    	IOTool.print("最短路径：");
    		    	    	dijkstra dis=new dijkstra(Graph);
    		    		    dis.Dijkstra(start,end);
        		    	    IOTool.print("\n是否继续查询？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }	
    		    	    }
        		    	
        		    }
		        }catch(AWTException e) { 
	    		      e.printStackTrace();}
	    	break; 
	    case 5:
	    	try{
		    	clear();
		    	visit();
		    	IOTool.print("铺设道路规划：");
		    	
	    	    	Prim pr=new Prim(Graph);
			        pr.prim(0);
			    previous();
		        }catch(AWTException e) { 
	    		      e.printStackTrace();}
	    	break;
	    case 6:
	    	try{
		    	clear();
		    	boolean flag=true;
		    	while(flag) {
		    		IOTool.print("景区信息修改：");
		    		visit();
    		    	IOTool.print("请输入你想进行的操作：");
    		    	IOTool.print("		1.添加景点           ");
    		    	IOTool.print("		2.添加路径           ");
    		    	IOTool.print("		3.修改景点信息           ");
    		    	IOTool.print("		4.修改路径信息           ");
    		    	IOTool.print("		5.删除景点           ");
    		    	IOTool.print("		6.删除路径           ");
        		    	String num=IOTool.getInput();
        		    	
    		    	    if(num.equals("1"))
    		    	    {
    		    	    	IOTool.print("添加景点：");
    		    	    	IOTool.print("请按格式输入需添加景点信息（如：A:青山绿水）：");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split(":");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("输入错误！请重新输入：");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split(":");
    		    	    	}
    		    	    	addnode(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }	
    		    	    }
    		    	    else if(num.equals("2")) {
    		    	    	IOTool.print("添加路径：");
    		    	    	IOTool.print("请按格式输入需添加路径信息（如：0-1-100）：");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s.length!=3) {
    		    	    		IOTool.print("输入错误！请重新输入：");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	addedge(s[0],s[1],s[2]);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }
    		    	    }
    		    	    else if(num.equals("3")) {
    		    	    	IOTool.print("修改景点信息：");
    		    	    	IOTool.print("请按格式输入需添加路径信息（如：A:柳暗花明）：");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split(":");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("输入错误！请重新输入：");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split(":");
    		    	    	}
    		    	    	updatenode(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }
    		    	    }
    		    	    else if(num.equals("4"))
    		    	    {
    		    	    	IOTool.print("修改路径信息：");
    		    	    	IOTool.print("请按格式输入需修改路径信息（如：0-1-100）：");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s[0]==str||s[2]==null) {
    		    	    		IOTool.print("输入错误！请重新输入：");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	
    		    	    	updateedge(s[0],s[1],s[2]);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }
    		    	    }
    		    	    else if(num.equals("5")) {
    		    	    	IOTool.print("删除景点：");
    		    	    	IOTool.print("请输入需删除景点编号：");
    		    	    	String str=IOTool.getInput();
    		    	    	int n=input(str);
    		    	    	deletenode(n);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }
    		    	    }
    		    	    else if(num.equals("6")) {
    		    	    	IOTool.print("删除路径：");
    		    	    	IOTool.print("请依次输入需删除景点编号（如：0-1）：");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("输入错误！请重新输入：");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	deleteedge(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n是否继续操作？\n1.是                2.否");
        		    	    String f=IOTool.getInput();
        		    	    if(f.equals("1")) {
        		    		     flag=true;
        		    		     try {
        		    		    	 clear();
        		    		     }catch(AWTException e) {
        		    		    	 e.printStackTrace();
        		    		     }
        		    	    }
        		    	    else
        		    	    {
        		    	     	flag=false;
        		    	    	previous();
        		    	    }
    		    	    }
    		    	    else
    		    	    {
    		    	    	IOTool.print("输入无效，请重新输入！");
    		    	    	IOTool.getInput();
    		    	    	flag=true;
    		    	    	previous();
    		    	    }
    		    	    
        		    }
		        }catch(AWTException e) { 
	    		      e.printStackTrace();}
		        break;
	    case 7:
	    	try{
	    	clear();
	    	System.exit(0);
	        }catch(AWTException e) { 
    		      e.printStackTrace();}
	        break;
	    default:IOTool.print("输入错误！");
	    	try{
	    		clear();
	    		index();
	    	}catch(AWTException e) {
	    		e.printStackTrace();
	    	}
	    	break;
	    }
	}
	public static int input(String num)
	{
		try {
		    int n=Integer.parseInt(num);
		    boolean flag=false;
	    	while(flag){
	    		if(Graph.findNode(n)!=null)
	    		{
	    			flag=true;
	    		}
	    		IOTool.print("输入错误，请重新输入：");
	    	    num=IOTool.getInput();
	    	    n=Integer.parseInt(num);  		    		
	    	}
	    	return n;
	    	}catch(NumberFormatException e) {
		    	e.printStackTrace();
		    	return -1;
		    }
	}
	public static void previous() {
		IOTool.print("1.返回          2.结束");
		IOTool.print("请输入接下来的操作：");
		String s=IOTool.getInput();
		if(s.equals("1"))
		{
			try{
	    		clear();
	    		index();
	    	}catch(AWTException e) {
	    		e.printStackTrace();
	    	}
		}
		else if(s.equals("2"))
		{
			try{
				clear();
				System.exit(0);
			}catch(AWTException e) {
				e.printStackTrace();
			}
		}
		else
		{
			IOTool.print("请重新输入有效序号：");
			previous();
		}
	}
	public static void clear() throws AWTException 
	{ 
		Robot r = new Robot(); 
		r.mousePress(InputEvent.BUTTON3_MASK); // 按下鼠标右键 
		r.mouseRelease(InputEvent.BUTTON3_MASK); // 释放鼠标右键 
		r.keyPress(KeyEvent.VK_CONTROL); // 按下Ctrl键 
		r.keyPress(KeyEvent.VK_R); // 按下R键 
		r.keyRelease(KeyEvent.VK_R); // 释放R键 
		r.keyRelease(KeyEvent.VK_CONTROL); // 释放Ctrl键 
		r.delay(100); 
	}
	public static void visit() {
		Graph=creategraph();
	    graph.update(Graph);
		IOTool.print("现有景点：");
		List<String> str=readtxt(pathname1);
	    for(String e:str)
	    {
	    	if(e==null)
	    	{
	    		System.out.println("该行为空！");
	    	}
	    	else
	    	{
	    		String[] s=e.split("，");
	    	    System.out.print("["+s[0]+","+s[1]+"]"+"   ");
	    	}
	    	
	    }
	    System.out.print("\n");
	}
	public static AdjecentList creategraph()
	{
		String[] s1=readtxt(pathname1).toArray(new String[readtxt(pathname1).size()]);
	    String[] s2=readtxt(pathname2).toArray(new String[readtxt(pathname2).size()]);
	    AdjecentList Graph = graph.createGraph(s1,s2);
	    return Graph;
	}
	public static List<String> readtxt(String path) {
		try {
		File filename1=new File(path);
		InputStreamReader reader1= new InputStreamReader(new FileInputStream(filename1));
		BufferedReader br1 = new BufferedReader(reader1); 
		List<String> list1=new ArrayList<String>();
	    String line = "";
	    line = br1.readLine(); 
	    while (line != null) 
	    {
	    	list1.add(line);
	    	line = br1.readLine();
	    } 
	    
	    br1.close();
	   // System.out.println(list2);
	    return list1;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean isExistnode(int n) {
		Node node=Graph.findNode(n);
			if(node!=null)
			{
				return true;
			}
		return false;
	}
	public static boolean isExistnode(String name) {
		Node node=Graph.findNode(name);
		if(node!=null)
		{
			return true;
		}
	return false;
	}
	public static boolean isExistedge(int f,int b) {
		Node front=Graph.findNode(f);
		//System.out.println(front.getnum());
		Edge edge=front.getNextEdge();
		while(edge!=null)
		{
			int n=edge.getBack().getnum();
			//System.out.println(n);
			if(n==b) {
			return true;
		   }
			edge=edge.getNext();
		}
		return false;
	}
	public static boolean isExistedge(String f,String b) {
		Node front=Graph.findNode(f);
		Edge edge=front.getNextEdge();
		while(edge!=null)
		{
			String n=edge.getBack().getname();
			if(n==b) {
				return true;
		  }
			edge=edge.getNext();
		}
		return false;
	}
	public static void addedge(String f,String b,String w) {
		int frontnode=Integer.valueOf(f);
		int backnode=Integer.valueOf(b);
		int weight=Integer.valueOf(w);
		if(isExistnode(frontnode)&&isExistnode(backnode))
		{
			if(isExistedge(frontnode,backnode)) {
				System.out.println("输入边已存在！");
			}
			else {
				Node front=Graph.findNode(frontnode);
				Node back=Graph.findNode(backnode);
				if (front != null && back != null) {
					Edge edge = new Edge();
					edge.setFront(front);
					edge.setBack(back);
					edge.setweight(weight);
					Edge edge1=new Edge();
					edge1.setFront(back);
					edge1.setBack(front);
					edge1.setweight(weight);
					front.addEdge(edge);
					back.addEdge(edge1);
					//System.out.println(edge);
				}
				graph.update(Graph);
			}
		}
		else
		{
			System.out.println("输入点不存在！");
		}
	}
	public static void addnode(String name,String info) {
		if(isExistnode(name)) {
			System.out.println("输入点已存在！");
		}
		else {
			Node node = new Node();
			int n=Graph.getNodes().size();
			Node temp=Graph.findNode(n);
			while(temp!=null) {
				n++;
				temp=Graph.findNode(n);
			}
			node.setnum(n);
			node.setname(name);
			node.setinfo(info);
			node.setnextEdge(null);
		    Graph.addNode(node);
		    graph.update(Graph);
		}
	}
	public static void deletenode(int n) {
		if(isExistnode(n)) {
			Graph.deleteNode(Graph.findNode(n));
			graph.update(Graph);
		}
		else
		{
			IOTool.print("你所要删的点不存在！");
		}
	}
	public static void deleteedge(String f,String b) {
		int front=Integer.valueOf(f);
		int back=Integer.valueOf(b);
		if(isExistnode(front)&&isExistnode(back))
		{
			if(isExistedge(front,back)) {
				Node fr=Graph.findNode(front);
				Node ba=Graph.findNode(back);
				Graph.deleteEdge(fr, ba);
				Graph.deleteEdge(ba, fr);
			    graph.update(Graph);
			}
			else {
				    System.out.println("输入边不存在！");
			}
		}
		else
		{
			System.out.println("输入点不存在！");
		}
	}
	public static void updatenode(String name,String info) {
		if(isExistnode(name))
		{
			Node node=Graph.findNode(name);
			node.setinfo(info);
			graph.update(Graph);
		}
		else
			System.out.println("输入点不存在！");
	}
	public static void updateedge(String f,String b,String w) {
		int front=Integer.valueOf(f);
		int back=Integer.valueOf(b);
		int weight=Integer.valueOf(w);
		if(isExistnode(front)&&isExistnode(back))
		{
			if(isExistedge(front,back)) {
				
				Edge edge=Graph.findNode(front).getNextEdge();
				while(edge!=null) {
					int n=edge.getBack().getnum();
					if(n==back) {
						edge.setweight(weight);
						break;
					}
					edge=edge.getNext();
				}
				Edge edge1=Graph.findNode(back).getNextEdge();
				while(edge1!=null) {
					int n=edge1.getBack().getnum();
					if(n==front) {
						edge1.setweight(weight);
						break;
					}
					edge1=edge1.getNext();
				}
				graph.update(Graph);
			}
			else {
				    System.out.println("输入边不存在！");
			}
		}
		else
		{
			System.out.println("输入点不存在！");
		}
	}
	
}
