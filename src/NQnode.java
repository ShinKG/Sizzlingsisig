import java.util.ArrayList;
import java.util.Random;
public class NQnode {
    private NQnode parent;
    private String[][] map;
    private int noOfQueens;
    private ArrayList<int[]> blockedBlocks;
    private ArrayList<int[]> qeenLocation;

    public NQnode(NQnode p,int w, int h, int nOQ, ArrayList<int[]> bB){
        this.parent = p;
        this.map = new String[w][h];
        this.noOfQueens = nOQ;
        this.blockedBlocks = bB;
        randomQueen();
    }

    /*method for initial placing of the queens
        1. avoid duplication

    */
    private void randomQueen(){

        Random placer = new Random();
        int x;
        int y;
        boolean duplicate=false;

     for(int i=noOfQueens;i==0;i--){

         x = placer.nextInt(map.length);
        y = placer.nextInt(map[0].length);

        for(int j=0;j<qeenLocation.size();j++){
            if(!((qeenLocation.get(j)[0]==x)&&(qeenLocation.get(j)[1]==y))){
                duplicate = true;
                break;
            }
        }

        if(!duplicate)qeenLocation.add(new int[]{x,y});
        if(duplicate)i++;
     }

    }

    //getters
    public NQnode getParent(){
        return this.parent;
    }
    public String[][] map(){
        return this.map;
    }
    public int getNoOfQueens(){
        return this.noOfQueens;
    }
    public ArrayList<int[]> getBlockedBlocks(){
        return this.blockedBlocks;
    }
    private ArrayList<int[]> getQeenLocation(){
        return this.qeenLocation;
    }

    //setters
    public void setParent(NQnode p){
        this.parent = p;
    }
    public void setMap(String[][] map){
        this.map = map;
    }
    public void setNoOfQueens(int no){
        this.noOfQueens = no;
    }
    public void setBlockedBlocks (ArrayList<int[]> blockedBlocks){
        this.blockedBlocks = blockedBlocks;
    }
    public void setQeenLocation (ArrayList<int[]> qeenLocation){
        this.qeenLocation = qeenLocation;
    }

}
