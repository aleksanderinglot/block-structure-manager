# Block Structure Manager

This is a program for managing block structures in a system. It allows for searching blocks based on color and material, as well as counting all blocks in the structure.

## Project Structure

The project consists of the following files:

- `Main.java` - the main program class containing the `main` method for testing the functionality.
- `Wall.java` - the implementation of the `Structure` interface representing a wall composed of blocks.
- `Block.java` - an interface defining basic methods for blocks.
- `CompositeBlock.java` - an interface extending `Block` and defining the `getBlocks` method for a block composite.
- `SimpleBlock.java` - an implementation of the `Block` interface representing a single block.
- `CompositeBlockImpl.java` - an implementation of the `CompositeBlock` interface representing a composite of blocks.
- `Structure.java` - an interface defining operations on block structures.

## How to Run the Program

1. Clone the repository to your local computer.
2. Open the project in a Java-supported IDE.
3. Run the `Main.java` class.
4. The console will display sample program outputs.

## Usage Examples

```java
// Creating individual blocks
Block block1 = new SimpleBlock("Red", "Wood");
Block block2 = new SimpleBlock("Blue", "Stone");

// Creating a block composite
List<Block> subBlocks = new ArrayList<>();
subBlocks.add(new SimpleBlock("Yellow", "Wood"));
subBlocks.add(new SimpleBlock("Yellow", "Stone"));
CompositeBlock compositeBlock = new CompositeBlockImpl(subBlocks);

// Creating a list of blocks
List<Block> blocks = new ArrayList<>();
blocks.add(block1);
blocks.add(block2);
blocks.add(compositeBlock);

// Creating a Wall object
Wall wall = new Wall(blocks);

// Searching for a block by color
Optional<Block> foundBlock = wall.findBlockByColor("Red");
if (foundBlock.isPresent()) {
    System.out.println("Found a block with color red: " + foundBlock.get());
} else {
    System.out.println("No block found with the specified color.");
}

// Searching for blocks by material
List<Block> foundBlocks = wall.findBlocksByMaterial("Wood");
System.out.println("Found blocks with wood material: " + foundBlocks);

// Counting all blocks
int totalBlocks = wall.count();
System.out.println("Total number of blocks: " + totalBlocks);
