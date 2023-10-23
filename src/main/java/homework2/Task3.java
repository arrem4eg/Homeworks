package homework2;

public class Task3 {
    public static void main(String[] args) {

        double L = 10.5;    // довжина сторони
        double H = 15;      // висота піраміді
        double S;           // площa основи квадратної піраміди
        double V;           // об'єм квадратної піраміди

        S = L * L;
        V = (S * H) / 3;

        System.out.println("об'єм квадратної піраміди дорівнює:  " + V);

    }
}
