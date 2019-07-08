package net.lzzy.algorithm;

import android.util.SparseArray;
import android.widget.EdgeEffect;

import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class BusMap extends SimpleMap{
    private SparseArray<String> vertexes;
    private int start,target;
    private double minDistance;

    public BusMap(int v) {
        super(v);
        vertexes=new SparseArray<>();
        for (int i=0;i<v;i++){
            vertexes.append(i,String.valueOf(i));
        }
    }
    public void setStart(int start){
        this.start=start;
    }
    public  void setTarget(int target){
        this.target=target;
    }
    public void rename(int i,String name){
        vertexes.setValueAt(i,name);
    }
    private void tryWay(int curVertex,double distance){
        if (minDistance>0&&distance>minDistance){
            return;
        }
        if (curVertex==target){
            if (minDistance==0||minDistance>distance){
                minDistance=distance;
            }
            return;
        }
        List<Edge>vEdges=getConnectedEdges(curVertex);
        for (Edge edge:vEdges){
            if (visited.contains(edge.getTarget())){
                continue;
            }
            visited.add(edge.getTarget());
            tryWay(edge.getTarget(),distance+edge.getDistance());
            visited.remove(edge.getTarget());
        }
    }
   private double[][]floyd(){
        double[][]distances=new double[vertexCount][vertexCount];
        for (int i=0;i<vertexCount;i++){
            for (int j=0;j<vertexCount;j++){
                distances[i][j]=999999;
            }
        }
        for (Edge edge:edges){
            distances[edge.getSource()][edge.getTarget()]=edge.getDistance();
        }
        for (int k=0;k<vertexCount;k++){
            for (int i=0;i<vertexCount;i++){
                for (int j=0;j<vertexCount;j++){
                    if (distances[i][j]>distances[i][k]
                        +distances[k][j]){
                        distances[i][j]=distances[i][k]+distances[k][j];
                    }
                }
            }
        }
       return distances;
   }

}
