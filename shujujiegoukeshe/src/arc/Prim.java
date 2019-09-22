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
        int[] lowcost = new int[n];  //���¼��ϵ���СȨ   
        int[] mid= new int[n];//��ȡǰ�����  
        List<String> list=new ArrayList<String>();//�����洢�������˳��
        int i, j, min, minid , sum = 0;  
      //��ʼ����������
        for(i=1;i<n;i++)  
        {  
            lowcost[i]=getWeight(start,i);  //��ʼ����0Ϊ��㵽�����ڵ��Ȩ��
            mid[i]=0;  //��¼ÿ���ڵ�����Ϊ0
        }  
        list.add(c[0]);  
        //һ����Ҫ����n-1����
        for(i=1;i<n;i++)  
        {  
             min=Integer.MAX_VALUE;  
             minid=0;  
           //ÿ���ҵ����뼯������ĵ�
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
             System.out.println(c[mid[minid]] + "��" + c[minid] + " Ȩֵ��" + min);
        	 //����õ�󣬸��������㵽���ϵľ���
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
