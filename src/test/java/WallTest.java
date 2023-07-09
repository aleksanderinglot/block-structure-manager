import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    private List<Block> blocks;
    private Wall wall;

    @BeforeEach
    public void setUp() {
        blocks = new ArrayList<>();
        blocks.add(new SimpleBlock("Red", "Wood"));
        blocks.add(new SimpleBlock("Blue", "Stone"));
        blocks.add(new SimpleBlock("Green", "Wood"));

        CompositeBlock compositeBlock = new CompositeBlockImpl(Arrays.asList(
                new SimpleBlock("Yellow", "Wood"),
                new SimpleBlock("Yellow", "Stone")
        ));
        blocks.add(compositeBlock);

        wall = new Wall(blocks);
    }

    @Test
    public void testFindBlockByColor() {
        Optional<Block> foundBlock = wall.findBlockByColor("Red");
        assertTrue(foundBlock.isPresent());
        assertEquals("Red", foundBlock.get().getColor());
    }

    @Test
    public void testFindBlocksByMaterial() {
        List<Block> foundBlocks = wall.findBlocksByMaterial("Wood");
        assertEquals(3, foundBlocks.size());
        assertTrue(foundBlocks.stream().allMatch(block -> block.getMaterial().equals("Wood")));
    }

    @Test
    public void testCount() {
        int totalBlocks = wall.count();
        assertEquals(5, totalBlocks);
    }
}
