import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
class NQReader{
	
	private Scanner info;
	private int width;
	private int height;
	private int noOfQueens;
	private ArrayList<int[]> blockedBlocks = new ArrayList<>();

	//initiator
	public NQReader(String path) throws Exception{

		info = new Scanner(new File(path));
		this.width = Integer.parseInt(info.nextLine());
		this.height = Integer.parseInt(info.nextLine());
		this.noOfQueens = Integer.parseInt(info.nextLine());

		String[] splitter;
		while(info.hasNextLine()){
			splitter = this.info.nextLine().split(",");
			this.blockedBlocks.add(new int[]{Integer.parseInt(splitter[0]),Integer.parseInt(splitter[1])});
		}
	}

	//getters
	public int getWidth() {
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}

	public int getNoOfQeens(){
		return this.noOfQueens;
	}

	public ArrayList<int[]> getBlockedBlocks(){
		return this.blockedBlocks;
	}

}