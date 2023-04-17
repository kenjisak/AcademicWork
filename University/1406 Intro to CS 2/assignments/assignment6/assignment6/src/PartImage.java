import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PartImage {
    private boolean[][]	pixels;
    private boolean[][]	visited;
    private int	rows;
    private int	cols;
    private int counter = 0;
    //Creates a new, blank PartImage with the given rows (r) and columns (c)
    public PartImage(int r, int c) {
        rows = r;
        cols = c;
        visited = new boolean[r][c];
        pixels = new boolean[r][c];
    }

    //Creates a new PartImage containing rw rows and cl columns
    //Initializes the 2D boolean pixel array based on the provided byte data
    //A 0 in the byte data is treated as false, a 1 is treated as true
    public PartImage(int rw, int cl, byte[][] data) {
        this(rw,cl);
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (data[r][c] == 1)
                    pixels[r][c] = true;
                else
                    pixels[r][c]= false;
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public boolean getPixel(int r, int c) { return pixels[r][c]; }

    public void print() {
        for (int r=0; r<rows; r++) {
            StringBuilder str= new StringBuilder();
            for (int c=0; c<cols; c++) {
                if (pixels[r][c]){
                    str.append("*");
                }else{
                    str.append("-");
                }
            }
            System.out.println(str);
        }
    }

    public Point2D findStart() {
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (pixels[r][c]){
                   return new Point2D(r,c);
                }
            }

        }
        return null;
    }

    public int partSize() {
        int counter =0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (pixels[r][c]){
                    counter++;
                }
            }

        }
        return counter;
    }
    private void expandFromperim(int r,int c){
        //pixels[r][c] = false;

        //counter++;
        //check current pixel, if theres a white square up down left or right then set to visited and add 1
        //next check to the right, if right pixel is black/true then check if above pixel is white/false, if it is then add 1
       // if(pixels[r][c]){
        visited[r][c] = true;
            try {//checks for white squares surrounding current black pixel and adds counter to perim
                if(!pixels[r + 1][c] && !visited[r + 1][c]){//checks if the surrounding has not been visited and is a white square
                    //pixels[r][c] = false;
                    counter++;
                    //expandFromperim(r+1,c);
                }else if(pixels[r + 1][c] && !visited[r + 1][c]){
                    expandFromperim(r+1,c);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                counter++;
            }
            try {
                if(!pixels[r - 1][c] && !visited[r - 1][c]){
                   // pixels[r][c] = false;
                    counter++;
                    //expandFromperim(r-1,c);
                }else if(pixels[r - 1][c] && !visited[r - 1][c]){
                    expandFromperim(r-1,c);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                counter++;
            }
            try {
                if(!pixels[r][c+1] && !visited[r][c+1]){
                    //pixels[r][c] = false;
                    counter++;
                    //expandFromperim(r,c+1);
                }else if(pixels[r][c+1]&& !visited[r][c+1]){
                    expandFromperim(r,c+1);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                counter++;
            }
            try {
                if(!pixels[r][c-1]&& !visited[r][c-1]){
                    //pixels[r][c] = false;
                    counter++;
                    //expandFromperim(r,c-1);
                }else if(pixels[r][c-1]&& !visited[r][c-1]){
                    expandFromperim(r,c-1);
                }
            }catch (ArrayIndexOutOfBoundsException e){
                counter++;
            }
    }
    private void expandFrom(int r, int c) {
        //check if that side is in bounds, if it is check if its a black pixel, if it is then expand from
        //for whoever marks this, dont mind my stupidity with trying to figure out this method and the messy code below this. at least the effort shows
        pixels[r][c] = false;
        try {
            if(pixels[r + 1][c]){
                expandFrom(r+1,c);
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try {
            if(pixels[r - 1][c]){
                expandFrom(r-1,c);
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try {
            if(pixels[r][c+1]){
                expandFrom(r,c+1);
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }
        try {
            if(pixels[r][c-1]){
                expandFrom(r,c-1);
            }
        }catch (ArrayIndexOutOfBoundsException e){
        }
        /*
         Point2D currentpixel = new Point2D(r,c);
         visited[r][c] = true;
         pixels[r][c] = false;
         //print();
         //System.out.println();
         boolean checkpixelsup,checkpixelsdown,checkpixelsleft,checkpixelsright;
        /////////////////
         try{
             checkpixelsup = pixels[currentpixel.getX()-1][currentpixel.getY()];
           //  System.out.println(checkpixelsup);
         }catch (ArrayIndexOutOfBoundsException e){
             checkpixelsup = false;
         }
        try{
            checkpixelsdown = pixels[currentpixel.getX()+1][currentpixel.getY()];
          //  System.out.println(checkpixelsdown);
        }catch (ArrayIndexOutOfBoundsException e){
            checkpixelsdown = false;
        }
        try{
            checkpixelsleft = pixels[currentpixel.getX()][currentpixel.getY()-1];
           // System.out.println(checkpixelsleft);
        }catch (ArrayIndexOutOfBoundsException e){
            checkpixelsleft = false;
        }
        try{
            checkpixelsright = pixels[currentpixel.getX()][currentpixel.getY()+1];
          //  System.out.println(checkpixelsright);
        }catch (ArrayIndexOutOfBoundsException e){
            checkpixelsright = false;
        }
        /////////////////////
        if (checkpixelsup){
            //visited[currentpixel.getX()-1][currentpixel.getY()] = true;
            //pixels[currentpixel.getX()-1][currentpixel.getY()] = false;
            currentpixel.setX(currentpixel.getX()-1);
            currentpixel.setY(currentpixel.getY());
            expandFrom(currentpixel.getX(),currentpixel.getY());
        }
        if (checkpixelsdown){
            //visited[currentpixel.getX()+1][currentpixel.getY()] = true;
            //pixels[currentpixel.getX()+1][currentpixel.getY()] = false;
            currentpixel.setX(currentpixel.getX()+1);
            currentpixel.setY(currentpixel.getY());
            expandFrom(currentpixel.getX(),currentpixel.getY());
        }
        if (checkpixelsleft){
            //visited[currentpixel.getX()][currentpixel.getY()-1] = true;
            // pixels[currentpixel.getX()][currentpixel.getY()-1] = false;
            currentpixel.setX(currentpixel.getX());
            currentpixel.setY(currentpixel.getY()-1);
            expandFrom(currentpixel.getX(),currentpixel.getY());
        }
        if (checkpixelsright){
            //visited[currentpixel.getX()][currentpixel.getY()+1] = true;
            //pixels[currentpixel.getX()][currentpixel.getY()+1] = false;
            currentpixel.setX(currentpixel.getX());
            currentpixel.setY(currentpixel.getY()+1);
            expandFrom(currentpixel.getX(),currentpixel.getY());
        }
        ///////////////////
        */
//change to appropriate base case
        /*
        if (!checkpixelsup & !checkpixelsdown & !checkpixelsleft & !checkpixelsright) {
            System.out.println("base case");
            for (int rw=0; rw<rows; rw++) {
                for (int cl=0; cl<cols; cl++) {
                    if (visited[rw][cl]){
                        counter++;
                    }
                }
            }
            for (int rr=0; rr<rows; rr++) {
                StringBuilder str= new StringBuilder();
                for (int cc=0; cc<cols; cc++) {
                    if (visited[rr][cc]){
                        str.append("*");
                    }else{
                        str.append("-");
                    }
                }
                System.out.println(str);
            }
            return counter;
        }
        */
//base case if surrounding pixels are white/false
        //if not all are white then check up down left right. set the pixel to white once visited
        //then nested for loop to count number of occurences of true in visited

        //return counter;//for now remove later
        //simpler way?starting pixel as

    }
    private int perimeterOf(int r, int c) {
        expandFromperim(r,c);
        return counter;
    }

    public boolean isBroken(){
        Point2D p = findStart();
        expandFrom((int)p.getX(), (int)p.getY());

        /*
        for (int rw=0; rw<rows; rw++) {
            for (int cl=0; cl<cols; cl++) {
                if (visited[rw][cl]){
                    counter++;
                }
            }
        }

        for (int r=0; r<rows; r++) {
            StringBuilder str= new StringBuilder();
            for (int c=0; c<cols; c++) {
                if (pixels[r][c]){
                    str.append("*");
                }else{
                    str.append("-");
                }
            }
            System.out.println(str);
        }

        System.out.println(partSize());


         */
        return (partSize() != 0);

    }

    public int perimeter() {
        Point2D p = findStart();

        /*
        for (int r=0; r<rows; r++) {
            StringBuilder str= new StringBuilder();
            for (int c=0; c<cols; c++) {
                if (visited[r][c]){
                    str.append("*");
                }else{
                    str.append("-");
                }
            }
            System.out.println(str);
        }

         */
        return perimeterOf((int)p.getX(), (int)p.getY());
    }

    public int countPieces(){
        Point2D p = findStart();
        int counter = 1;
        expandFrom((int)p.getX(), (int)p.getY());
        if (partSize() == 0){
            return counter;
        }else {
            do {
                Point2D d = findStart();
                expandFrom((int) d.getX(), (int) d.getY());
                counter++;
            } while (partSize() != 0);
        }
        return counter ;
    }

    public static PartImage readFromFile(String fileName) throws InvalidPartImageException {
        //read line by line, adding a counter to the row var
        //then read characters in that said line ,adding a counter to column
        //if all the columns arent the same then invalidpartimage exception, use the class invalid to return it as a new object

        byte[][] data;
        try{
        String path = System.getProperty("user.dir");
        Scanner infile = new Scanner(new File(path+"\\"+fileName));

        int rows = 0;
        int cols = 0;
        String line ="";
        while (infile.hasNextLine()){
            rows++;
            line = infile.nextLine();
        }
        cols = line.split(",").length;
        infile = new Scanner(new File(path+"\\"+fileName));
        data = new byte[rows][cols];
        String[] currentline;

        for (int i = 0; i<rows;i++){
            currentline = infile.nextLine().split(",");
            if (currentline.length != cols){
                throw new InvalidPartImageException(path+"\\"+fileName);
            }
            for (int j = 0; j<cols;j++){
                if(!currentline[j].equals("1") & !currentline[j].equals("0")){
                    throw new InvalidPartImageException(path+"\\"+fileName);
                }
                data[i][j] = Byte.parseByte(currentline[j]);
            }
        }
        //System.out.println(Arrays.deepToString(data));
        return new PartImage(rows,cols,data);
        }catch (FileNotFoundException e){
            //System.out.println("file error");
            return null;
        }catch (IOException e) {
            //System.out.println("invalid input");
            return null;
        }


    }
}