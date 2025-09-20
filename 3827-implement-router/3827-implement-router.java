import java.util.*;

class Packet {
    public int source;
    public int destination;
    public int timestamp;
    public Packet(int src, int dest, int ts) {
        this.source = src;
        this.destination = dest;
        this.timestamp = ts;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet p = (Packet) o;
        return source == p.source && destination == p.destination && timestamp == p.timestamp;
    }
    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

class Router {
    private final int memoryLimit;
    private final Queue<Packet> packetQueue = new LinkedList<>();
    private final Set<Packet> uniquePackets = new HashSet<>();
    private final Map<Integer, List<Integer>> destinationTimestamps = new HashMap<>();
    // Index to track already forwarded packets per destination for time queries
    private final Map<Integer, Integer> processedPacketIndex = new HashMap<>();

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(packet)) return false;

        if (packetQueue.size() == memoryLimit) {
            forwardPacket();
        }
        packetQueue.add(packet);
        uniquePackets.add(packet);
        destinationTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (packetQueue.isEmpty()) return new int[0];
        Packet nextPacket = packetQueue.poll();
        uniquePackets.remove(nextPacket);
        processedPacketIndex.put(nextPacket.destination, processedPacketIndex.getOrDefault(nextPacket.destination, 0) + 1);
        return new int[]{nextPacket.source, nextPacket.destination, nextPacket.timestamp};
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destinationTimestamps.containsKey(destination)) return 0;
        List<Integer> timestamps = destinationTimestamps.get(destination);
        int startIndex = processedPacketIndex.getOrDefault(destination, 0);
        int lower = firstGreaterEqual(timestamps, startIndex, startTime);
        int upper = firstGreater(timestamps, lower, endTime);
        return upper - lower;
    }

    // Binary search helper: first index >= target
    private int firstGreaterEqual(List<Integer> timestamps, int start, int target) {
        int l = start, r = timestamps.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (timestamps.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // Binary search helper: first index > target
    private int firstGreater(List<Integer> timestamps, int start, int target) {
        int l = start, r = timestamps.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (timestamps.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
