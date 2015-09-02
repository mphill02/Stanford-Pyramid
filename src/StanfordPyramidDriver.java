
public class StanfordPyramidDriver {

	public static  final int BASE_COUNT = 15;
	public static final int WIDTH = 20;
	public static final int HEIGHTH = 20;
	public static final String TITLE = "Stanford Pyramid";

	public StanfordPyramidDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args) {
	    StanfordPyramid box = new StanfordPyramid(WIDTH, HEIGHTH, BASE_COUNT, TITLE);
	    box.show();
	}
}
