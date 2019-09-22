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
		IOTool.print("                 ��ӭ���뾰����Ϣ����                           ");
	    
	    visit();
	    IOTool.print("����Խ��еĲ�����    ");
	    IOTool.print("         1.�������ͼ���ڽӱ�                  ");
	    IOTool.print("         2.��ѯ������Ϣ                            ");
	    IOTool.print("         3.���ξ��㵼��                            ");
	    IOTool.print("         4.�����·��                               ");
	    IOTool.print("         5.�����·�滮 	           ");
	    IOTool.print("         6.������Ϣ�޸�			       ");
	    IOTool.print("         7.�˳�			           ");
	    IOTool.print("�밴��Ӧ�������������еĲ�����             ");
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
    		    	IOTool.print("����������Ҫ��ѯ����ı�ţ�");
        		    
        		    	String num=IOTool.getInput();
    		    	    int n=input(num);
    		    	    if(n!=-1) {
        		    	IOTool.print("������Ϣ��");
        		    	IOTool.print(Graph.findNode(n).getname());
        		    	IOTool.print(Graph.findNode(n).getInfo());
        		    	IOTool.print("�ڽӵ㣺");
        		    	List<String> str=readtxt(pathname2);
        		    	for(String e:str) {
        		    		String[] s=e.split("��");
        		    		if(n==Integer.valueOf(s[0])){
        		    			IOTool.print(s[0]+"->"+s[1]+"       ·�����ȣ�"+s[2]);
        		    		}
        		    	}
        		    	IOTool.print("�Ƿ������ѯ��\n1.��                2.��");
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
    		    	IOTool.print("����������Ҫ��ѯ����ı�ţ�");

        		    	String num=IOTool.getInput();
    		    	    int n=input(num);
    		    	    if(n!=-1)
    		    	    {
    		    	    	IOTool.print("����·�ߣ�");
        		    	    graph.depthFirstSearch(Graph,n);
        		    	    IOTool.print("\n�Ƿ������ѯ��\n1.��                2.��");
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
		    		IOTool.print("���·��������");
    		    	IOTool.print("������������ʼ���յ㾰��ı�ţ��Իس�����һ�����룩��");

        		    	String num1=IOTool.getInput();
        		    	String num2=IOTool.getInput();
    		    	    int start=input(num1);
    		    	    int end=input(num2);
    		    	    if(start!=-1&&end!=-1)
    		    	    {
    		    	    	IOTool.print("���·����");
    		    	    	dijkstra dis=new dijkstra(Graph);
    		    		    dis.Dijkstra(start,end);
        		    	    IOTool.print("\n�Ƿ������ѯ��\n1.��                2.��");
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
		    	IOTool.print("�����·�滮��");
		    	
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
		    		IOTool.print("������Ϣ�޸ģ�");
		    		visit();
    		    	IOTool.print("������������еĲ�����");
    		    	IOTool.print("		1.��Ӿ���           ");
    		    	IOTool.print("		2.���·��           ");
    		    	IOTool.print("		3.�޸ľ�����Ϣ           ");
    		    	IOTool.print("		4.�޸�·����Ϣ           ");
    		    	IOTool.print("		5.ɾ������           ");
    		    	IOTool.print("		6.ɾ��·��           ");
        		    	String num=IOTool.getInput();
        		    	
    		    	    if(num.equals("1"))
    		    	    {
    		    	    	IOTool.print("��Ӿ��㣺");
    		    	    	IOTool.print("�밴��ʽ��������Ӿ�����Ϣ���磺A:��ɽ��ˮ����");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split(":");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("����������������룺");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split(":");
    		    	    	}
    		    	    	addnode(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("���·����");
    		    	    	IOTool.print("�밴��ʽ���������·����Ϣ���磺0-1-100����");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s.length!=3) {
    		    	    		IOTool.print("����������������룺");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	addedge(s[0],s[1],s[2]);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("�޸ľ�����Ϣ��");
    		    	    	IOTool.print("�밴��ʽ���������·����Ϣ���磺A:������������");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split(":");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("����������������룺");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split(":");
    		    	    	}
    		    	    	updatenode(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("�޸�·����Ϣ��");
    		    	    	IOTool.print("�밴��ʽ�������޸�·����Ϣ���磺0-1-100����");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s[0]==str||s[2]==null) {
    		    	    		IOTool.print("����������������룺");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	
    		    	    	updateedge(s[0],s[1],s[2]);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("ɾ�����㣺");
    		    	    	IOTool.print("��������ɾ�������ţ�");
    		    	    	String str=IOTool.getInput();
    		    	    	int n=input(str);
    		    	    	deletenode(n);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("ɾ��·����");
    		    	    	IOTool.print("������������ɾ�������ţ��磺0-1����");
    		    	    	String str=IOTool.getInput();
    		    	    	String[] s=str.split("-");
    		    	    	while(s.length!=2) {
    		    	    		IOTool.print("����������������룺");
    		    	    		str=IOTool.getInput();
    		    	    		s=str.split("-");
    		    	    	}
    		    	    	deleteedge(s[0],s[1]);
    		    	    	visit();
        		    	    IOTool.print("\n�Ƿ����������\n1.��                2.��");
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
    		    	    	IOTool.print("������Ч�����������룡");
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
	    default:IOTool.print("�������");
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
	    		IOTool.print("����������������룺");
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
		IOTool.print("1.����          2.����");
		IOTool.print("������������Ĳ�����");
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
			IOTool.print("������������Ч��ţ�");
			previous();
		}
	}
	public static void clear() throws AWTException 
	{ 
		Robot r = new Robot(); 
		r.mousePress(InputEvent.BUTTON3_MASK); // ��������Ҽ� 
		r.mouseRelease(InputEvent.BUTTON3_MASK); // �ͷ�����Ҽ� 
		r.keyPress(KeyEvent.VK_CONTROL); // ����Ctrl�� 
		r.keyPress(KeyEvent.VK_R); // ����R�� 
		r.keyRelease(KeyEvent.VK_R); // �ͷ�R�� 
		r.keyRelease(KeyEvent.VK_CONTROL); // �ͷ�Ctrl�� 
		r.delay(100); 
	}
	public static void visit() {
		Graph=creategraph();
	    graph.update(Graph);
		IOTool.print("���о��㣺");
		List<String> str=readtxt(pathname1);
	    for(String e:str)
	    {
	    	if(e==null)
	    	{
	    		System.out.println("����Ϊ�գ�");
	    	}
	    	else
	    	{
	    		String[] s=e.split("��");
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
				System.out.println("������Ѵ��ڣ�");
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
			System.out.println("����㲻���ڣ�");
		}
	}
	public static void addnode(String name,String info) {
		if(isExistnode(name)) {
			System.out.println("������Ѵ��ڣ�");
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
			IOTool.print("����Ҫɾ�ĵ㲻���ڣ�");
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
				    System.out.println("����߲����ڣ�");
			}
		}
		else
		{
			System.out.println("����㲻���ڣ�");
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
			System.out.println("����㲻���ڣ�");
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
				    System.out.println("����߲����ڣ�");
			}
		}
		else
		{
			System.out.println("����㲻���ڣ�");
		}
	}
	
}
