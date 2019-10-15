import java.util.ArrayList;
import java.util.Random;
public class NQnode {
    private NQnode parent;
    private String[][] map;
    private int noOfQueens;
    private ArrayList<int[]> blockedBlocks;
    private ArrayList<int[]> queenLocation = new ArrayList<>();

    public NQnode(NQnode p,int w, int h, int nOQ, ArrayList<int[]> bB){
        this.parent = p;
        this.map = new String[w][h];
        this.noOfQueens = nOQ;
        this.blockedBlocks = bB;
        if(randomQueen())System.out.println("queenGened");
        mapper();
    }

    /*method for initial placing of the queens
        1. avoid duplication
        2. avoid blockedblocks

    */
    private boolean randomQueen(){

        Random placer = new Random();
        int x;
        int y;
        boolean duplicate=false;

     for(int i=noOfQueens;i>0;i--){
         x = placer.nextInt(map.length);System.out.println("x : "+x);
        y = placer.nextInt(map[0].length);System.out.println("y : "+y);
        //if a queen at the randomized coordination exist, it is duplication
        for(int j=0;j<queenLocation.size();j++){
            if(((queenLocation.get(j)[0]==x)&&(queenLocation.get(j)[1]==y))){
                duplicate = true;
                break;
            }
        }

        //if a blocked block is at the randomized coordination exist, it is duplication
         for(int j=0;j<blockedBlocks.size();j++){
             if(((blockedBlocks.get(j)[0]==x)&&(blockedBlocks.get(j)[1]==y))){
                 duplicate = true;
                 break;
             }
         }

        //if it is not duplicated at all, place queen there
        if(!duplicate)queenLocation.add(new int[]{x,y});
        //if it is, reset current counter and continue loop
        if(duplicate)i++;

        duplicate=false;
     }
        return true;
    }

    //map the Elements in arraylist onto map
    private void mapper(){
        //Fill Queen
        for(int i=0; i<queenLocation.size();i++){
            this.map[queenLocation.get(i)[0]][queenLocation.get(i)[1]] = "Q";
        }
        //Fill BBlocks
        for(int i=0;i<blockedBlocks.size();i++){
            this.map[blockedBlocks.get(i)[0]][blockedBlocks.get(i)[1]] = "B";
        }
        //Fill empty if each block is not B or Q
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(map[i][j]==null)map[i][j] = "E";
            }
        }
    }

    //getters
    public NQnode getParent(){
        return this.parent;
    }
    public String[][] getMap(){
        return this.map;
    }
    public int getNoOfQueens(){
        return this.noOfQueens;
    }
    public ArrayList<int[]> getBlockedBlocks(){
        return this.blockedBlocks;
    }
    public ArrayList<int[]> getQueenLocation(){
        return this.queenLocation;
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
        this.queenLocation = qeenLocation;
    }

}
