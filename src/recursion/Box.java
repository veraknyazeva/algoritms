package recursion;

import java.util.List;

public class Box {
    private List<Box> boxes;
    private String key;

    public Box() {

    }

    public Box(String key) {
        this.key = key;
    }

    public Box(List<Box> boxes) {
        this.boxes = boxes;
    }

    public Box(List<Box> boxes, String key) {
        this.boxes = boxes;
        this.key = key;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<Box> boxes) {
        this.boxes = boxes;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isKeyPresent() {
        if (key != null) {
            return true;
        }
        return false;
    }
}

