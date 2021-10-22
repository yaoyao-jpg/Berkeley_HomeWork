public class DebugExercise3 {
    public static long countTurnips(In in) {
        long totalTurnips = 0L;
        while (!in.isEmpty()) {
            String vendor = in.readString();
            String foodType = in.readString();
            double cost = in.readDouble();
            long numAvailable = in.readInt();
            if (foodType.equals("turnip")) {
                 totalTurnips += numAvailable;
                // System.out.println(totalTurnips+" "+numAvailable);
            }
        }
        return totalTurnips;
    }

    public static void main(String[] args) {
        In in = new In("foods.csv");
        System.out.println(countTurnips(in));
    }
}