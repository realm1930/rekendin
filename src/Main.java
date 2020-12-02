import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the amount:");
        int amount = scanner.nextInt();
        List<Integer> dividers = new ArrayList<>();
        System.out.println("Insert the first divider:");
        dividers.add(scanner.nextInt());

        int divider;
        while (dividers.size()<2) {
            System.out.println("Insert the next divider: (" + (2-dividers.size()) + " more to go)");
            divider = scanner.nextInt();
            if (!dividers.contains(divider)) {
                dividers.add(divider);
            }
        }
        dividers.sort(Collections.reverseOrder());
        System.out.print("Dividers are: ");
        System.out.println(dividers);




        int divided1Amount = amount / dividers.get(0);
        int divided1Remainder = amount % dividers.get(0);
        for (int i = 0; i <= divided1Amount; i++) {
            int currentDivided1Amount = amount - (dividers.get(0) * i);
            int divided2Amount = currentDivided1Amount / dividers.get(1);
            int divided2Remainder = currentDivided1Amount % dividers.get(1);
            if (divided2Amount == 0) {
                StringBuilder output = new StringBuilder();
                output.append(dividers.get(0) + ":" + i);
                if (divided1Remainder != 0) {
                    output.append(", Remainder: " + divided1Remainder);
                }
                System.out.println(output);
            } else {
                StringBuilder output = new StringBuilder();
                output.append(dividers.get(0) + ":" + i + "," + dividers.get(1) + ":" + divided2Amount);
                if (divided2Remainder != 0) {
                    output.append(", Remainder: " + divided2Remainder);
                }
                System.out.println(output);
            }
        }
    }
}
