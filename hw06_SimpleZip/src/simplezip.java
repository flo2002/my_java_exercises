import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class simplezip {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "-p":
                    pack(args[++i]);
                    break;
                case "-u":
                    unpack(args[++i]);
                    break;
                default:
                    printManual();
            }
        }
        if (args.length == 0) {
            printManual();
        }
    }

    private static void pack(String zipFileName) throws IOException {
        Path path = Paths.get(".");

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            Files.walk(path)
                .filter(Files::isRegularFile)
                .forEach(filePath -> {
                    String fileName = filePath.toString().substring(path.toString().length() + 1);
                    try {
                        zipOut.putNextEntry(new ZipEntry(fileName));
                        Files.copy(filePath, zipOut);
                        zipOut.closeEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        }
    }

    private static void unpack(String strPath) throws IOException {
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(strPath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String fileName = entry.getName();
                Path path = Paths.get(fileName);
                if (!entry.isDirectory()) {
                    Files.copy(zipIn, path);
                } else {
                    Files.createDirectories(path);
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        }
    }

    private static void printManual() {
        System.out.println("Usage: java simplezip [-p|-u] <archivename>");
        System.out.println("-p: pack");
        System.out.println("-u: unpack");
    }
}
