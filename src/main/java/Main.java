import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Block block1 = new SimpleBlock("Red", "Wood");
        Block block2 = new SimpleBlock("Blue", "Stone");
        Block block3 = new SimpleBlock("Green", "Wood");

        // Tworzenie kompozytowego bloku z podblokami
        List<Block> subBlocks = new ArrayList<>();
        subBlocks.add(new SimpleBlock("Yellow", "Wood"));
        subBlocks.add(new SimpleBlock("Yellow", "Stone"));
        CompositeBlock compositeBlock = new CompositeBlockImpl(subBlocks);

        // Tworzenie listy bloków
        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(compositeBlock);

        // Tworzenie obiektu Wall
        Wall wall = new Wall(blocks);

        // Przykłady użycia metod
        Optional<Block> foundBlock = wall.findBlockByColor("Red");
        if (foundBlock.isPresent()) {
            System.out.println("Found block by color: " + foundBlock.get());
        } else {
            System.out.println("No block found by color.");
        }

        List<Block> foundBlocks = wall.findBlocksByMaterial("Wood");
        System.out.println("Found blocks by material: " + foundBlocks);

        int totalBlocks = wall.count();
        System.out.println("Total number of blocks: " + totalBlocks);
    }
}

class SimpleBlock implements Block {
    private String color;
    private String material;

    public SimpleBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "SimpleBlock{color='" + color + "', material='" + material + "'}";
    }
}

class CompositeBlockImpl implements CompositeBlock {
    private List<Block> blocks;

    public CompositeBlockImpl(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }
}
