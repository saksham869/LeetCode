import java.util.*;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Step 1: Sort the deck in ascending order
        Arrays.sort(deck);

        // Step 2: Initialize a deque to simulate the process
        Deque<Integer> deque = new LinkedList<>();

        // Step 3: Simulate the process in reverse
        for (int i = deck.length - 1; i >= 0; i--) {
            // Move the current front card to the back
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            // Place the current card at the front
            deque.addFirst(deck[i]);
        }

        // Step 4: Convert the deque to an array and return
        int[] result = new int[deck.length];
        int i = 0;
        for (int card : deque) {
            result[i++] = card;
        }
        return result;
    }
}
