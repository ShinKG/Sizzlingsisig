import java.util.ArrayList;
import java.util.Random;
public class NQnode {
    private NQnode parent;
    private String[][] map;
    private int noOfQueens;
    private ArrayList<int[]> blockedBlocks;
    private ArrayList<int[]> queenLocation = new ArrayList<>();
    private int conflict;

    public NQnode(int w, int h, int nOQ, ArrayList<int[]> bB){
        this.parent = null;
        this.map = new String[w][h];
        this.noOfQueens = nOQ;
        this.blockedBlocks = bB;
        if(randomQueen())System.out.println("queenGened");
        mapper();
    }

    public NQnode(NQnode p,int w, int h, int nOQ, ArrayList<int[]> bB, ArrayList<int[]>qL){
        this.parent = p;
        this.map = new String[w][h];
        this.noOfQueens = nOQ;
        this.blockedBlocks = bB;
        this.queenLocation = qL;
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
         x = placer.nextInt(map.length);
        y = placer.nextInt(map[0].length);
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

    public void findConflict(){
        int x,y,confliction=0;
        for(int i=0;i<queenLocation.size();i++){

            //north
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y>0){
                y--;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //north-east
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y>0&&x<map.length-1){
                y--;x++;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //east
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(x<map.length-1){
                x++;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //south-east
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y<map[x].length-1&&x<map.length-1){
                y++;x++;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //south
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y<map[x].length-1){
                y++;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //south-west
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y<map[x].length-1&&x>0){
                y++;x--;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //west
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(x>0){
                x--;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }

            //north-west
            x=queenLocation.get(i)[0];
            y=queenLocation.get(i)[1];
            while(y>0&&x>0){
                y--;x--;
                if(map[x][y].equals("Q")){
                    confliction++;
                    break;
                }
                if(map[x][y].equals("B")) break;
            }
            this.conflict = confliction;
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
    public int getConflict(){
        return this.conflict;
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
    public void setQueenLocation (ArrayList<int[]> queenLocation){
        this.queenLocation = queenLocation;
    }

}
