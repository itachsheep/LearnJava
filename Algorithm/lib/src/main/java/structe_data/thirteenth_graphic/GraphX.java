package structe_data.thirteenth_graphic;

/**
 * Created by taowei on 2017/7/25.
 * 2017-07-25 16:30
 * Algorithm
 * structe_data.thirteenth_graphic
 */

public class GraphX {
    private int MAX_VERTS = 20;
    private Vertex vertexList[];//顶点数组
    private int adjMat[][]; //邻接矩阵
    private int nVerts;//当前顶点个数
    public GraphX(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j = 0; j < MAX_VERTS; j++){
            for(int k = 0; k < MAX_VERTS; k++){
                adjMat[j][k] = 0;
            }
        }
    }

    public void adVertext(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start,int end) {
        //添加一个边，比如 顶点 1 和 3之间
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    //找到与顶点v相邻但是又没有访问过的顶点
    public int getAdjUnvisited(int v){
        for(int j = 0; j < nVerts; j++){
            if(adjMat[v][j] == 1 &&
                    vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }
    //深度优先搜索dfs
    public void dfs(){
        /**
         * 1,用peek检查栈顶顶点
         * 2，找到这个顶点的还未访问的邻接节点
         * 3，如果没有找到，出栈
         * 4，如果找到这样的顶点，访问这个顶点
         */

        vertexList[0].wasVisited = true;

    }
}
