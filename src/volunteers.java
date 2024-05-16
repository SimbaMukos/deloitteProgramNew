import java.util.HashMap;
import java.util.Map;

    class HighestAbsolutePairFinder {
        public static void main(String[] args) {
            int[] tab1 = {3, 2, -2, 5, -3};
            int[] tab2 = {1, 1, 2, -1, 2, -1};
            int[] tab3 = {1, 2, 3, -4};
            int[] tab4 = {1, 1};

            System.out.println(findHighestAbsolutePair(tab1));
            System.out.println(findHighestAbsolutePair(tab2));
            System.out.println(findHighestAbsolutePair(tab3));
            System.out.println(findHighestAbsolutePair(tab4));
        }

        private static String findHighestAbsolutePair(int[] array) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int maxPairValue = 0;

            // Count occurrences of each absolute value
            for (int num : array) {
                int absNum = Math.abs(num);
                countMap.put(absNum, countMap.getOrDefault(absNum, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > 1 && arrayContains(array, entry.getKey()) && arrayContains(array, -entry.getKey())) {
                    if (entry.getKey() > maxPairValue) {
                        maxPairValue = entry.getKey();
                    }
                }
            }

            if (maxPairValue == 0) {
                return "No such pair found";
            } else {
                return "Pair found: " + maxPairValue + " and " + -maxPairValue;
            }
        }

        private static boolean arrayContains(int[] array, int value) {
            for (int num : array) {
                if (num == value) {
                    return true;
                }
            }
            return false;
        }
    }

