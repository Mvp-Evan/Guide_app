package guid;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.management.VMOption;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GuidSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Circle n0;

    @FXML
    private Circle n1;

    @FXML
    private Circle n2;

    @FXML
    private Circle n4;

    @FXML
    private Circle n6;

    @FXML
    private Circle n3;

    @FXML
    private Circle n5;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line7;

    @FXML
    private Line line8;

    @FXML
    private Line line6;

    @FXML
    private Line line2;

    @FXML
    private Line line5;

    @FXML
    private Line line1;


    @FXML
    private Button beginguide;

    @FXML
    private TextField startinput;

    @FXML
    private TextField endinput;

    @FXML
    private Button back;
    @FXML
    private Button otherpath;

    Line[] lines = new Line[8];
    Circle[] nodes = new Circle[7];
    void listLines(){
        lines[0] = line1;
        lines[1] = line2;
        lines[2] = line3;
        lines[3] = line4;
        lines[4] = line5;
        lines[5] = line6;
        lines[6] = line7;
        lines[7] = line8;
    }
    void listNodes(){
        nodes[0] = n0;
        nodes[1] = n1;
        nodes[2] = n2;
        nodes[3] = n3;
        nodes[4] = n4;
        nodes[5] = n5;
        nodes[6] = n6;
    }

    @FXML
    void backToFirst(MouseEvent event)  throws Exception {
        main.MainScene mainScene = new main.MainScene();
        mainScene.showWindow();
        Stage stage = (Stage) line1.getScene().getWindow();
        stage.close();
    }

    @FXML
    void otherpath(MouseEvent event) {
        int v,e;
        v = getStartNode();
        e = getEndNode();
        int[] list=new int[2];
        if(v>=e){
            list[0]=e;
            list[1]=v;
        }
        else {
            list[1]=e;
            list[0]=v;
        }
        int cur=0,dt=0;
        int[] opath1;
        int[] opath2;
        if(list[0]==0){ cur=0;}
        else if(list[0]==1){ cur=12;}
        else if(list[0]==2){ cur=22;}
        else if(list[0]==3){ cur=30;}
        else if(list[0]==4){ cur=36;}
        else if(list[0]==5){ cur=40;}
        else if(list[0]==6){ cur=0;}
        dt = list[1]-list[0]-1;
        cur = cur+dt;
        opath1 = fool[cur];
        opath2 = fool[cur+1];
        int opl1=opath1.length;
        int opl2=opath2.length;
        for (int i =0;i<opl1-1;i++){
            if ((opath1[i] == 0 && opath1[i+1]==1)||(opath1[i] == 1 && opath1[i+1]==0)){lines[2].setStrokeWidth(3);lines[2].setStroke(Color.BLUE);}
            else if ((opath1[i] == 0 && opath1[i+1]==3)||(opath1[i] == 3 && opath1[i+1]==0)){lines[0].setStrokeWidth(3);lines[0].setStroke(Color.BLUE);}
            else if ((opath1[i] == 1 && opath1[i+1]==2)||(opath1[i] == 2 && opath1[i+1]==1)){lines[3].setStrokeWidth(3);lines[3].setStroke(Color.BLUE);}
            else if ((opath1[i] == 2 && opath1[i+1]==4)||(opath1[i] == 4 && opath1[i+1]==2)){lines[6].setStrokeWidth(3);lines[6].setStroke(Color.BLUE);}
            else if ((opath1[i] == 2 && opath1[i+1]==6)||(opath1[i] == 6 && opath1[i+1]==2)){lines[4].setStrokeWidth(3);lines[4].setStroke(Color.BLUE);}
            else if ((opath1[i] == 3 && opath1[i+1]==5)||(opath1[i] == 5 && opath1[i+1]==3)){lines[1].setStrokeWidth(3);lines[1].setStroke(Color.BLUE);}
            else if ((opath1[i] == 4 && opath1[i+1]==6)||(opath1[i] == 6 && opath1[i+1]==4)){lines[7].setStrokeWidth(3);lines[7].setStroke(Color.BLUE);}
            else if ((opath1[i] == 5 && opath1[i+1]==6)||(opath1[i] == 6 && opath1[i+1]==5)){lines[5].setStrokeWidth(3);lines[5].setStroke(Color.BLUE);}
        }
        for (int i =0;i<opl2-1;i++){
            if ((opath2[i] == 0 && opath2[i+1]==1)||(opath2[i] == 1 && opath2[i+1]==0)){lines[2].setStrokeWidth(3);lines[2].setStroke(Color.BLUE);}
            else if ((opath2[i] == 0 && opath2[i+1]==3)||(opath2[i] == 3 && opath2[i+1]==0)){lines[0].setStrokeWidth(3);lines[0].setStroke(Color.BLUE);}
            else if ((opath2[i] == 1 && opath2[i+1]==2)||(opath2[i] == 2 && opath2[i+1]==1)){lines[3].setStrokeWidth(3);lines[3].setStroke(Color.BLUE);}
            else if ((opath2[i] == 2 && opath2[i+1]==4)||(opath2[i] == 4 && opath2[i+1]==2)){lines[6].setStrokeWidth(3);lines[6].setStroke(Color.BLUE);}
            else if ((opath2[i] == 2 && opath2[i+1]==6)||(opath2[i] == 6 && opath2[i+1]==2)){lines[4].setStrokeWidth(3);lines[4].setStroke(Color.BLUE);}
            else if ((opath2[i] == 3 && opath2[i+1]==5)||(opath2[i] == 5 && opath2[i+1]==3)){lines[1].setStrokeWidth(3);lines[1].setStroke(Color.BLUE);}
            else if ((opath2[i] == 4 && opath2[i+1]==6)||(opath2[i] == 6 && opath2[i+1]==4)){lines[7].setStrokeWidth(3);lines[7].setStroke(Color.BLUE);}
            else if ((opath2[i] == 5 && opath2[i+1]==6)||(opath2[i] == 6 && opath2[i+1]==5)){lines[5].setStrokeWidth(3);lines[5].setStroke(Color.BLUE);}
        }



    }

    @FXML
    void guideBegin(MouseEvent event) {
        int v,e;
        v = getStartNode();
        e = getEndNode();
        int[] path = dijkstra(v,e);
        int len = path.length;
        listLines();
        listNodes();
        for(int i=0;i<len;i++){
            //System.out.println(path[i]);
            nodes[path[i]].setFill(Color.RED);
        }
        for (int i=0;i<len-1;i++){
            if ((path[i] == 0 && path[i+1]==1)||(path[i] == 1 && path[i+1]==0)){
                lines[2].setStrokeWidth(2);
                lines[2].setStroke(Color.RED);
            }
            else if ((path[i] == 0 && path[i+1]==3)||(path[i] == 3 && path[i+1]==0)){lines[0].setStrokeWidth(2);lines[0].setStroke(Color.RED);}
            else if ((path[i] == 1 && path[i+1]==2)||(path[i] == 2 && path[i+1]==1)){lines[3].setStrokeWidth(2);lines[3].setStroke(Color.RED);}
            else if ((path[i] == 2 && path[i+1]==4)||(path[i] == 4 && path[i+1]==2)){lines[6].setStrokeWidth(2);lines[6].setStroke(Color.RED);}
            else if ((path[i] == 2 && path[i+1]==6)||(path[i] == 6 && path[i+1]==2)){lines[4].setStrokeWidth(2);lines[4].setStroke(Color.RED);}
            else if ((path[i] == 3 && path[i+1]==5)||(path[i] == 5 && path[i+1]==3)){lines[1].setStrokeWidth(2);lines[1].setStroke(Color.RED);}
            else if ((path[i] == 4 && path[i+1]==6)||(path[i] == 6 && path[i+1]==4)){lines[7].setStrokeWidth(2);lines[7].setStroke(Color.RED);}
            else if ((path[i] == 5 && path[i+1]==6)||(path[i] == 6 && path[i+1]==5)){lines[5].setStrokeWidth(2);lines[5].setStroke(Color.RED);}
        }
    }

    @FXML
    void initialize() {
        assert n0 != null : "fx:id=\"n0\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n1 != null : "fx:id=\"n1\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n2 != null : "fx:id=\"n2\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n4 != null : "fx:id=\"n4\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n6 != null : "fx:id=\"n6\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n3 != null : "fx:id=\"n3\" was not injected: check your FXML file 'Guide.fxml'.";
        assert n5 != null : "fx:id=\"n5\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line3 != null : "fx:id=\"line3\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line4 != null : "fx:id=\"line4\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line7 != null : "fx:id=\"line7\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line8 != null : "fx:id=\"line8\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line6 != null : "fx:id=\"line6\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line2 != null : "fx:id=\"line2\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line5 != null : "fx:id=\"line5\" was not injected: check your FXML file 'Guide.fxml'.";
        assert line1 != null : "fx:id=\"line1\" was not injected: check your FXML file 'Guide.fxml'.";
        assert beginguide != null : "fx:id=\"beginguide\" was not injected: check your FXML file 'Guide.fxml'.";
        assert startinput != null : "fx:id=\"startinput\" was not injected: check your FXML file 'Guide.fxml'.";
        assert endinput != null : "fx:id=\"endinput\" was not injected: check your FXML file 'Guide.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Guide.fxml'.";

    }
    public  int getStartNode(){
        String temp = startinput.getText();
        int node=0;
        if(temp.equals("中博湖")){node = 0;}
        else if(temp.equals("图书馆")){node = 1;}
        else if(temp.equals("鼎山")){node = 2;}
        else if(temp.equals("计算机学科楼")){node = 3;}
        else if(temp.equals("南区运动场")){node = 4;}
        else if(temp.equals("北区运动场")){node = 5;}
        else if(temp.equals("大学生活动中心")){node = 6;}
        return node;
    }
    public  int getEndNode(){
        String temp = endinput.getText();
        int node=0;
        if(temp.equals("中博湖")){node = 0;}
        else if(temp.equals("图书馆")){node = 1;}
        else if(temp.equals("鼎山")){node = 2;}
        else if(temp.equals("计算机学科楼")){node = 3;}
        else if(temp.equals("南区运动场")){node = 4;}
        else if(temp.equals("北区运动场")){node = 5;}
        else if(temp.equals("大学生活动中心")){node = 6;}
        return node;
    }

        public static int[][] fool = {
                {0,3,2,1},
                {0,3,5,6,2,1},
                {0,3,2},
                {0,3,5,6,2},
                {0,1,2,4,6,5,3},
                {0,1,2,6,5,3},
                {0,3,5,6,4},
                {0,1,2,6,4},
                {0,1,2,6,5},
                {0,1,2,4,6,5},
                {0,3,5,6},
                {0,1,2,4,6},
                {1,0,3,2},
                {1,0,3,5,6,2},
                {1,2,6,5,3},
                {1,2,4,6,5,3},
                {1,0,3,2,4},
                {1,2,3,5,6,4},
                {1,0,3,5},
                {1,2,4,6,5},
                {1,0,3,5,6},
                {1,2,4,6},
                {2,1,0,3},
                {2,4,6,5,3},
                {2,6,4},
                {2,3,5,6,4},
                {2,1,0,3,5},
                {2,4,6,5},
                {2,4,6},
                {2,1,0,3,5,6},
                {3,0,1,2,4},
                {3,0,1,2,6,4},
                {3,0,1,2,6,5},
                {3,0,1,2,4,6,5},
                {3,0,1,2,4,6},
                {3,0,1,2,6},
                {4,2,6,5},
                {4,2,1,0,3,5},
                {4,2,6},
                {4,2,1,0,3,5,6},
                {5,3,0,1,2,6},
                {5,3,0,1,2,4,6},
        };
        public static int[][] edges = {
                {0, 5, 0, 10, 0, 0, 0},
                {5, 0, 3, 0, 0, 0, 0},
                {0, 3, 0, 0, 4, 0, 6},
                {10, 0, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 0, 0, 6},
                {0, 0, 0, 5, 0, 0, 4},
                {0, 0, 6, 0, 6, 4, 0}
        };// 存储图的边的二维数组
        public static int[] vexs={0,1,2,3,4,5,6};// 存储图的顶点的一维数组
        public static int numOfVexs = 7;// 顶点的实际数量
        public static int maxNumOfVexs = 7;// 顶点的最大数量
        public static boolean[] visited;// 判断顶点是否被访问过`


    public static int[] dispath(int[] path, boolean[] S, int v,int e)
    {
        int i, j, k,d=0,record = 0;
        int[] apath = new  int[maxNumOfVexs];//存放一条最短路径(逆向)及其顶点个数
            i = e;
            if(S[i] == true && i != v) {
                d = 0;
                apath[d] = i;//添加路径上的终点
                k = path[i];
                while (k != v) {
                    d++;
                    apath[d] = k;
                    k = path[k];
                }
                d++;
                apath[d] = v;//添加路径上的起点
            }
        int[] temp = new int[d+1];
        int tempk = 0;
        temp[tempk] = apath[d];
        tempk++;
        for (j = d - 1; j >= 0; j--){//再输出其余顶
            temp[tempk] = apath[j];
            tempk++;}
        return temp;
    }

        public static int[] dijkstra(int v, int e) {
            if (v < 0 || v >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        boolean[] st = new boolean[numOfVexs];// 默认初始为false
        int[] distance = new int[numOfVexs];// 存放源点到其他点的矩离
            int[] path = new  int[numOfVexs];

        for (int i = 0; i < numOfVexs; i++)
            for (int j = i + 1; j < numOfVexs; j++) {
                if (edges[i][j] == 0) {
                    edges[i][j] = Integer.MAX_VALUE;
                    edges[j][i] = Integer.MAX_VALUE;
                }
            }
        for (int i = 0; i < numOfVexs; i++) {
            distance[i] = edges[v][i];
            if(edges[v][i]<Integer.MAX_VALUE){path[i] = v;}
            else {path[i] = -1;}
        }
        st[v] = true;
        path[v] = 0;
        // 处理从源点到其余顶点的最短路径
        for (int i = 0; i < numOfVexs; ++i) {
            int min = Integer.MAX_VALUE;
            int index=-1;
            // 比较从源点到其余顶点的路径长度
            for (int j = 0; j < numOfVexs; ++j) {
                // 从源点到j顶点的最短路径还没有找到
                if (st[j]==false) {
                    // 从源点到j顶点的路径长度最小
                    if (distance[j] < min) {
                        index = j;
                        min = distance[j];
                    }
                }
            }
            //找到源点到索引为index顶点的最短路径长度
            if(index!=-1)
                st[index] = true;
            // 更新当前最短路径及距离
            for (int w = 0; w < numOfVexs; w++){
                if (st[w] == false) {
                    if (edges[index][w] != Integer.MAX_VALUE
                            && (min + edges[index][w] < distance[w])){
                        distance[w] = min + edges[index][w];
                        path[w] = index;}
                }}

        }
        int[] display;
        display = dispath(path,st,v,e);
        return display ;}
    }



