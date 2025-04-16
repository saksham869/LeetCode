import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        // Fill the queue with indices 0 to n-1
        for (int i = 0; i < n; i++) {
            queue.offer(i);
        }

        // Sort the deck
        Arrays.sort(deck);

        // Place cards in the correct position
        for (int card : deck) {
            int index = queue.poll();         // Get index to place the card
            result[index] = card;

            if (!queue.isEmpty()) {
                queue.offer(queue.poll());    // Move next index to the back
            }
        }

        return result;
    }
}
