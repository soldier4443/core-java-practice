package interface_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by soldi on 2017-06-18.
 */

class RColor {
    private int x;
    private int y;
    private int z;

    public RColor(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("color: #%02x%02x%02x", x, y, z);
    }
}
class Mesh {
    private RColor color;
    private int x;
    private int y;

    public Mesh(RColor color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public RColor getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "[x: %d, y: %d, ", x, y)
                + color.toString() + "]";
    }
}
class Meshes {
    private List<Mesh> meshList;

    public Meshes() {
        meshList = new ArrayList<>();
    }

    public List<Mesh> getMeshList() {
        return meshList;
    }
}

// This is my interface!
@FunctionalInterface
interface PixelFunction {
    RColor apply(int x, int y);
}

public class MyOwnFunctionalInterface {

    private static Meshes createMeshFromSize(int x, int y, PixelFunction f) {
        Meshes meshes = new Meshes();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                RColor color = f.apply(i, j);
                meshes.getMeshList().add(new Mesh(color, i, j));
            }
        }

        return meshes;
    }

    public static void main(String[] args) {
        Meshes meshes = createMeshFromSize(10, 25, (x, y) -> new RColor(x, y, x * y) );

        meshes.getMeshList().forEach(System.out::println);
    }
}
