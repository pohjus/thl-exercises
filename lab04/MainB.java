import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class MainB {
    public static void main(String[] args) throws IOException {
        var inputPath = Path.of("file.txt");
        var outputPath = Path.of("output.txt");

        // Read the content of the file inputPath, use Files.readString
        var content = Files.readString(inputPath);

        // Process the content of the file
        var processedContent = content.lines()
            .filter(line -> !line.isBlank())
            .map(line -> line.repeat(3))
            .collect(Collectors.joining("\n"));

        // Write the processed content to the output file
        Files.writeString(outputPath, processedContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}