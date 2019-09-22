package arc;

import java.util.List;
import java.util.ArrayList;

public class Prim {
	public AdjecentList graph;
	
	public Prim(AdjecentList graph) {
		this.graph=graph;
	}
	
	public void prim(int start)
	{
		int n=graph.getNodes().size();
		String[] c=new String[n] ;
		for(int i=0;i<n;i++)
		{
			c[i]=graph.findNode(i).getname();
		}
        int[] lowcost = new int[n];  //到新集合的最小权   
        int[] mid= new int[n];//存取前驱结点  
        List<String> list=new ArrayList<String>();//用来存储加入结点的顺序
        int i, j, min, minid , sum = 0;  
      //初始化辅助数组
        for(i=1;i<n;i++)  
        {  
            lowcost[i]=getWeight(start,i);  //初始是以0为起点到各个节点的权重
            mid[i]=0;  //记录每个节点的起点为0
        }  
        list.add(c[0]);  
        //一共需要加入n-1个点
        for(i=1;i<n;i++)  
        {  
             min=Integer.MAX_VALUE;  
             minid=0;  
           //每次找到距离集合最近的点
             for(j=1;j<n;j++)  
             {  
                 if(lowcost[j]!=0&&lowcost[j]<min)  
                 {  
                     min=lowcost[j];  
                     minid=j;  
                 }  
             }  
               
             if(minid==0) return;  
             list.add(c[minid]);  
             lowcost[minid]=0;  
             sum+=min;  
             System.out.println(c[mid[minid]] + "到" + c[minid] + " 权值：" + min);
        	 //加入该点后，更新其它点到集合的距离
             for(j=1;j<n;j++)  
             {  
                 if(lowcost[j]!=0&&lowcost[j]>getWeight(minid,j))  
                 {  
                     lowcost[j]=getWeight(minid,j);  
                     mid[j]=minid;  
                 }  
             }  
        }  
        System.out.println("sum:" + sum);  
          
	}
	
	private int getWeight(int start,int end) {
		if(start==end)
			return 0;
		Edge edge=graph.findNode(start).getNextEdge();
		while(edge!=null) {
			if(end==(edge.getBack().getnum())){
				return edge.getweight();
			}
			edge=edge.getNext();
		}
		return Integer.MAX_VALUE;
	}
}
