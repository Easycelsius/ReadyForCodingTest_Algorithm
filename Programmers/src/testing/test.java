package testing;

import java.util.Objects;

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int hashCode() {
    	System.out.println(Objects.hash(x,y));
        return Objects.hash(x,y);
    }

    public boolean equals(Object o) {
        return this.x == ((Pair) o).x && this.y == ((Pair) o).y;
    }
}

public class test {
	
	public static void main(String[] args) {
		
		Pair a = new Pair(0, 0);
		Pair b = new Pair(0, 0);
		
		System.out.println(a.hashCode()==b.hashCode());

	}

}
