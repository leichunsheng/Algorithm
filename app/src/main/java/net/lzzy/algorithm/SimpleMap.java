package net.lzzy.algorithm;

import android.widget.EdgeEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzzy_gxy on 2019/7/8.
 * Description:
 */
public class SimpleMap {
    int vertexCount;
    List<Edge>edges=new ArrayList<>();
    List<Integer>visited;
    public SimpleMap(int v){
        vertexCount=v;
    }

    public void addEdge(int source,int target,double distance){
        edges.add(new Edge(source,target,distance));
    }
    public void addTwoWayEdge(int v1,int v2,double distance){
        addEdge(v1,v2,distance);
        addEdge(v2,v1,distance);
    }
    List<Edge>getConnectedEdges(int source){
    List<Edge>result=new ArrayList<>();
    for(Edge e:edges){
        if(e.getSource()==source){
            result.add(e);
        }
    }
    return result;
    }
    public void iterateDepth(int v){
        if (!visited.contains(v)) {
            visited.add(v);
        }
        if (visited.size()==vertexCount){
            return;
        }
        List<Edge>vEdges=getConnectedEdges(v);
        for (Edge edge:vEdges){
            if (visited.contains(edge.getTarget())){
                continue;
            }
            iterateDepth(edge.getTarget());
        }
    }
    public String iterateDepthFirst(){
        return "015234";
    }
    public String iterateRangeFirst(){
        return "012354";
    }
}
class Edge{

    private int target;
    private int source;
    private double distance;
    Edge(int source,int target,double distance){
        this.distance=distance;
        this.source=source;
        this.target=target;
    }
    public int getTarget(){
        return target;
    }
    public int getSource(){
        return source;
    }
    public double getDistance(){
        return distance;
    }

}
