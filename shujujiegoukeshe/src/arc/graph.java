package arc;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
public class graph {
		/*public static void breadthFirstSearch(AdjecentList graph){
			Map<Node, Integer> visited = createVisit(graph);
			List<Edge> eSet = new ArrayList<Edge>();
			Node first = null;
			for(Node node : graph.getNodes()){
				if (visited.get(node) == 0) {
					first = node;
					break;
				}
			}
			if (first == null) 
				return;
			List<Node> queue = new ArrayList<>();
			queue.add(first);
			while(!queue.isEmpty()){
				Node queueNode = queue.get(0);
				queue.remove(0);
				visited.put(queueNode, 1);
				
				Edge edge = queueNode.getNextEdge();
				while (edge != null) {
					Node back = edge.getBack();
					if (visited.get(back) == 0) {
						eSet.add(edge);
						visited.put(back, 1);
						queue.add(back);
					}
					edge = edge.getNext();
				}
			}
			IOTool.print("BFS edges: ");
			for(Edge edge : eSet){
				System.out.println(edge);
			}
		}*/
		
		public static void depthFirstSearch(AdjecentList graph,int num){
			Map<Node, Integer> visited = createVisit(graph);
			Map<Edge,Integer> visit=createvisit(graph);
			Node first = graph.findNode(num);
			if (first != null) {
				//System.out.print(path1);
				DFS(first,visited,visit,stack);
			}
			count=0;
		}
		public static Stack<Node> stack=new Stack<Node>();
		private static void DFS(Node node, Map<Node, Integer> visited,Map<Edge,Integer> visit,Stack<Node> stack){
			visited.put(node,1);
			//System.out.println(visited.size());
			stack.add(node);
			while(!stack.isEmpty())
			{
				Node adjvex=getfirstunvisited(stack.peek(),visited,visit);
				if(stack.size()==visited.size())
				{
					printPath(stack);
					Node n=stack.pop();
					visited.put(n,0);
					Node n1=stack.peek();
					Edge edge=n1.getNextEdge();
					while(edge!=null) {
						if(edge.getBack().getnum()==n.getnum())
							sum=sum-edge.getweight();
						edge=edge.getNext();
					}
					break;
				}
				if(adjvex!=null) {
				         //stack.add(adjvex);
				         DFS(adjvex,visited,visit,stack);       
			     }else {
			    	 Node n=stack.pop();
			    	 visited.put(n,0);
			    	 Edge edge=n.getNextEdge();
			    	 while(edge!=null)
			    	 {
			    		 visit.put(edge,0);
			    		 edge=edge.getNext();
			    	 }
			    	 
			    	 if(!stack.isEmpty())
			    	 {
			    		 Node n1=stack.peek();
			    		 Edge edge1=n1.getNextEdge();
						 while(edge1!=null) {
							if(edge1.getBack().getnum()==n.getnum())
								sum=sum-edge1.getweight();
							edge1=edge1.getNext();
						}
			    	 }
			     }
			}
		}
		
		public static Node getfirstunvisited(Node node,Map<Node,Integer> visited,Map<Edge,Integer> visit) 
		{
			   Edge edge = node.getNextEdge();
			   //System.out.println(edge);
			   while(edge != null){
			          Node back = edge.getBack();
			          if(visited.get(back)==0&&visit.get(edge)==0)
			          {
			        	  visit.put(edge, 1);
			        	  sum+=edge.getweight();
			        	  return back;
			          }
			    	  edge=edge.getNext();
			   }
			return null;
		}
		public static int count=0;
		public static int sum=0;
		private static void printPath(Stack<Node> stack)
		{
			count++;
			StringBuilder sb=new StringBuilder();
			for(Node node:stack) {
				sb.append(node.getname()+"->");
				
			}
			sb.delete(sb.length()-2, sb.length());
			System.out.println(count+":"+sb.toString()+"   sum:"+sum);
		}
		public static Map<Node, Integer> createVisit(AdjecentList graph){
			Map<Node, Integer> visited = new HashMap<Node, Integer>();
			for(Node node : graph.getNodes()){
				visited.put(node, 0);
			}
			return visited;
		}
		public static Map<Edge, Integer> createvisit(AdjecentList graph){
			Map<Edge, Integer> visit = new HashMap<Edge, Integer>();
			for(Node node:graph.getNodes())
			{
			   Edge edge=node.getNextEdge();
			   while(edge!=null)
			   {
				   visit.put(edge, 0);
				   edge=edge.getNext();
			   }
			}
			return visit;
		}
		public static AdjecentList createGraph(String []list1,String []list2){
			//输入点集
			
			AdjecentList graph = new AdjecentList();
			for(String nodeInfo : list1){
				if(nodeInfo==null)
				{
					IOTool.print("数据读入错误！");
				}
				else
				{
					Node node = new Node();
				    node.setnode(nodeInfo);
				    graph.addNode(node);
				}
			}
			//输入边集
	
			for(String edgeInfo : list2){
				if(edgeInfo!=null)
				{
					String []pair = edgeInfo.split("，");
				try {
					int frontNode =Integer.parseInt(pair[0]);
					int backNode =Integer.parseInt(pair[1]);
					int weight=Integer.parseInt(pair[2]);
					Node front = graph.findNode(frontNode);
					Node back = graph.findNode(backNode);
					if (front != null && back != null) {
						Edge edge = new Edge();
						edge.setFront(front);
						edge.setBack(back);
						edge.setweight(weight);
						front.addEdge(edge);
					}
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
				}else
					IOTool.print("数据读入错误！");
				
			}
			return graph;
		}
		public static String pathname1="D:\\eclipse\\shujujiegoukeshe\\txt\\Vex.txt";
		public static String pathname2="D:\\eclipse\\shujujiegoukeshe\\txt\\Edge.txt";
		public static void writetxt(String path,List<String> content)
		{
			try {
				
				BufferedWriter bw=new BufferedWriter(new FileWriter(path));
				for(String s:content) {
					bw.write(s);
				    bw.newLine();
				}
				
				bw.flush();
				bw.close();
				
				//IOTool.print("更新点成功！");
			}catch(IOException e) {
				IOTool.print("更新点失败！");
				e.printStackTrace();
			}
		}
		public static void update(AdjecentList graph) {
			List<String> str1=new ArrayList<String>();
			List<String> str2=new ArrayList<String>();
			for(Node node:graph.getNodes()) {
				str1.add(node.getnum()+"，"+node.getname()+"，"+node.getInfo());
				
				Edge edge=node.getNextEdge();
				Node nextnode=new Node();
				while(edge!=null) {
					if(edge.getweight()>Integer.MIN_VALUE)
					{
						nextnode=edge.getBack();
					    str2.add(edge.getFront().getnum()+"，"+nextnode.getnum()+"，"+edge.getweight());
					}					
					edge=edge.getNext();
				}
			}
			writetxt(pathname1,str1);
			writetxt(pathname2,str2);
		}
}
