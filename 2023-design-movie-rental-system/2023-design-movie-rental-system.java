

public class MovieRentingSystem {

    private Map<Integer, TreeSet<ShopEntry>> available;
    private Map<Long, Integer> priceMap;
    private TreeSet<RentedEntry> rented;

    private static class ShopEntry implements Comparable<ShopEntry> {
        int price, shop;
        ShopEntry(int price, int shop) {
            this.price = price; this.shop = shop;
        }
        public int compareTo(ShopEntry other) {
            if (this.price != other.price) return this.price - other.price;
            return this.shop - other.shop;
        }
        public boolean equals(Object o) {
            if (!(o instanceof ShopEntry)) return false;
            ShopEntry other = (ShopEntry)o;
            return this.price == other.price && this.shop == other.shop;
        }
        public int hashCode() {
            return Objects.hash(price, shop);
        }
    }

    private static class RentedEntry implements Comparable<RentedEntry> {
        int price, shop, movie;
        RentedEntry(int price, int shop, int movie) {
            this.price = price; this.shop = shop; this.movie = movie;
        }
        public int compareTo(RentedEntry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }
        public boolean equals(Object o) {
            if (!(o instanceof RentedEntry)) return false;
            RentedEntry other = (RentedEntry)o;
            return this.price == other.price && this.shop == other.shop && this.movie == other.movie;
        }
        public int hashCode() {
            return Objects.hash(price, shop, movie);
        }
    }

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        priceMap = new HashMap<>();
        rented = new TreeSet<>();

        for (int[] entry : entries) {
            int shop = entry[0], movie = entry[1], price = entry[2];
            available.putIfAbsent(movie, new TreeSet<>());
            available.get(movie).add(new ShopEntry(price, shop));
            priceMap.put(combine(shop, movie), price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;
        TreeSet<ShopEntry> set = available.get(movie);
        Iterator<ShopEntry> it = set.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            ShopEntry se = it.next();
            result.add(se.shop);
            count++;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(combine(shop, movie));
        ShopEntry se = new ShopEntry(price, shop);
        TreeSet<ShopEntry> set = available.get(movie);
        if (set != null) {
            set.remove(se);
        }
        rented.add(new RentedEntry(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(combine(shop, movie));
        ShopEntry se = new ShopEntry(price, shop);
        if (!available.containsKey(movie)) {
            available.put(movie, new TreeSet<>());
        }
        available.get(movie).add(se);
        rented.remove(new RentedEntry(price, shop, movie));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<RentedEntry> it = rented.iterator();
        int count = 0;
        while (it.hasNext() && count < 5) {
            RentedEntry re = it.next();
            result.add(Arrays.asList(re.shop, re.movie));
            count++;
        }
        return result;
    }

    private long combine(int shop, int movie) {
        return ((long)shop << 32) | (movie & 0xffffffffL);
    }
}