import java.util.Scanner;
import java.util.ArrayList;
class NQReader{
	
	private Scanner info;
	private int width;
	private int height;
	private int noOfQueens;
	private ArrayList<int[]> blockedBlocks = new ArrayList<>();

	public NQReader(String path){

		info = new Scanner(path);
		this.width = info.nextInt();
		this.height = info.nextInt();
		this.noOfQueens = info.nextInt();

		String line;
		String[] blockRaw;
		int[] infoBB = new int[2];
		for(int counter=0;info.hasNextInt();counter++){
			line = info.nextLine();
			blockRaw = line.split(",");
			infoBB[0] = Integer.parseInt(blockRaw[0]);
			infoBB[1] = Integer.parseInt(blockRaw[1]);
			blockedBlocks.add(infoBB);
		}

	}

}