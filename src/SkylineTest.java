import java.util.Scanner;

/**
 * Created by jo930_000 on 2016-10-18.
 */
public class SkylineTest {
    public static void main(String[] args) {

        Skyline test = new Skyline();
        Scanner scan = new Scanner(System.in);

        System.out.print("건물 수를 입력해주세요 : ");
        int n = scan.nextInt();
        scan.nextLine();

        System.out.println("좌표를 입력해주세요. ( " + n + " ) 개의 건물 (left, height, right)" );
        test.build_constructor(n);

        for(int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] arr;
            arr = input.split(",");

            test.building[i].left = Integer.parseInt(arr[0]);
            test.building[i].height = Integer.parseInt(arr[1]);
            test.building[i].right = Integer.parseInt(arr[2]);
        }
        System.out.println(test.find_skyline(test.building,0, n-1));
        test.print_skyline();
    }
}
