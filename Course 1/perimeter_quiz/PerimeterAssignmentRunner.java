import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num_points = 0;
        for (Point currpt: s.getPoints()){
            num_points = num_points +1;
        }
        return num_points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt: s.getPoints()){
            double side = prevPt.distance(currPt);
            if (side > largest){
                largest = side;
            }
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        for (Point currPt : s.getPoints()){
            double currX = currPt.getX();
           if (currX > largestX){
               largestX = currX;
           }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles(DirectoryResource dr) {
        double max = 0;
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double perimeter = getPerimeter(s);
             if (perimeter > max){
                 max = perimeter;
                }
        }
        return max;
    }

    public String getFileWithLargestPerimeter(DirectoryResource dr) {
        File temp = null; 
        double max = 0;
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             double perimeter = getPerimeter(s);
             if (perimeter >= max){
                 max = perimeter;
                 temp = f;
             }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        double num_points = getNumPoints(s);
        double largest_side = getLargestSide(s);
        double largest_x = getLargestX(s);
        double average_l = getAverageLength(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + num_points);
        System.out.println("largest side = " + largest_side);
        System.out.println("largest x = " + largest_x);
        System.out.println("average length = " + average_l);
    }
    
    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        System.out.println("Maximum perimeter = " + getLargestPerimeterMultipleFiles(dr));
    }

    public void testFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        System.out.println("File with maximum perimeter = " + getFileWithLargestPerimeter(dr));
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
