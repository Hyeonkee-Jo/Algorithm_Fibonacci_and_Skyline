import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jo930_000 on 2016-10-18.
 */
public class Skyline {

    Building[] building;

    public class Building {
        int left, height, right;

        public Building() {
            this.left = 0;
            this.height = 0;
            this.right = 0;
        }

        public Building(int left, int height, int right) {
            this.left = left;
            this.height = height;
            this.right = right;
        }
    }

    public class Point {
        int x, height;

        public Point() {
            this.x = 0;
            this.height = 0;
        }

        public Point(int left, int height) {
            this.x = left;
            this.height = height;
        }

        public String toString() {
            return this.x + ", " + this.height;
        }
    }

    public void build_constructor(int n) {
        this.building = new Building[n];

        for(int i = 0 ; i < n; i++) {
            this.building[i] = new Building();
        }
    }

    // find skyline using divide and conquer
    public ArrayList<Point> find_skyline(Building[] build, int start, int end) {
        if( start == end ) {
            ArrayList<Point> partition_skyline = new ArrayList<Point>();
            partition_skyline.add(new Point(build[start].left, build[start].height)); // append skyline
            partition_skyline.add(new Point(build[end].right, 0));
            return partition_skyline;
        }

        int mid = ( start + end ) / 2;
        ArrayList<Point> sky1 = this.find_skyline(build, start, mid);
        ArrayList<Point> sky2 = this.find_skyline(build, mid+1, end);
        return merge_skyline(sky1, sky2);
    }

    public ArrayList<Point> merge_skyline(ArrayList<Point> sky1, ArrayList<Point> sky2) {
        ArrayList<Point> skyline = new ArrayList<Point>();
        int current_height1 = 0;
        int current_height2 = 0;
        int current_x, max_h;

        while(sky1.size()>0 && sky2.size()>0) {
            if(sky1.get(0).x < sky2.get(0).x) {
                current_x = sky1.get(0).x;
                current_height1 = sky1.get(0).height;
                max_h = current_height1;

                if(current_height2 > max_h) {
                    max_h = current_height2;
                }
                skyline.add(new Point(current_x, max_h));
                sky1.remove(0);
            }

            else {
                current_x = sky2.get(0).x;
                current_height2 = sky2.get(0).height;
                max_h = current_height1;

                if(current_height2 > max_h) {
                    max_h = current_height2;
                }
                skyline.add(new Point(current_x, max_h));
                sky2.remove(0);
            }
        }

        while(sky1.size() > 0) {
            skyline.add(new Point(sky1.get(0).x, sky1.get(0).height));
            sky1.remove(0);
        }

        while(sky2.size() > 0) {
            skyline.add(new Point(sky2.get(0).x, sky2.get(0).height));
            sky2.remove(0);
        }

        return skyline;
    }

    // Skyline Print
    public void print_skyline() {
        int size = this.find_skyline(this.building, 0 , this.building.length-1).size();

        for(int i = 0; i < size; i++) {
            if( i != 0 && i != size-1 && this.find_skyline(this.building, 0 , this.building.length-1).get(i-1).height == this.find_skyline(this.building, 0 , this.building.length-1).get(i).height) {

            }
            else
            if(i == size-1) System.out.print(this.find_skyline(this.building, 0 , this.building.length-1).get(i));
            else System.out.print(this.find_skyline(this.building, 0 , this.building.length-1).get(i)+", ");
        }
    }

}
