package collisionHashmap;

import java.util.Objects;

class Key {
    private String key;

    public Key(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        // All instances will have the same hash code, causing a collision
        return 42;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
        	return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
        	return false;
        }
        Key key1 = (Key) obj;
        return Objects.equals(key, key1.key);
    }

    @Override
    public String toString() {
        return key;
    }
}
