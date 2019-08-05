package normalatlasgenerator.DataStructures;

public class SpriteData {

    public SpriteData(String name, boolean isRotate, Vector2 position, Vector2 size, Vector2 origin, Vector2 offset, int index) {
        this.name = name;
        this.isRotate = isRotate;
        this.position = position;
        this.size = size;
        this.origin = origin;
        this.offset = offset;
        this.index = index;
    }

    private final String name;
    private final boolean isRotate;
    private final Vector2 position;
    private final Vector2 size;
    private final Vector2 origin;
    private final Vector2 offset;
    private final int index;

    public String getName() {
        return name;
    }

    public boolean isRotate() {
        return isRotate;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getSize() {
        return size;
    }

    public Vector2 getOrigin() {
        return origin;
    }

    public Vector2 getOffset() {
        return offset;
    }

    public int getIndex() {
        return index;
    }
}
