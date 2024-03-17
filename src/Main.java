import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String pathToGames = "C://Games";
    static StringBuilder sb = new StringBuilder();
    static void touch(String fileName) throws IOException {
        File file = new File(pathToGames + fileName);
        sb.append(file.createNewFile() ?  "Файл " + fileName + " создан" :  "Ошибка создания файла " + fileName).append("\n");
    }

    static void mkdir(String dirName){
        File dir = new File(pathToGames + dirName);
        sb.append(dir.mkdir() ?  "Каталог " + dirName + " создан" :  "Ошибка создания директории " + dirName).append("\n");

    }

    public static void main(String[] args) {

        List<String> dir = List.of("src", "res", "savegames", "temp", "src//main", "src//test", "res//drawables","res//vectors", "res//icons");
        List<String> file = Arrays.asList("temp//temp.txt", "src//main//Main.java", "src//main//Utils.java");
        dir.forEach(Main::mkdir);
        file.forEach(fileName -> {
            try {
                touch(fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        try (FileWriter writer = new FileWriter(pathToGames+"temp//temp.txt")) {
            writer.write(String.valueOf(sb));
            writer.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage()).append("\n");
        }
    }
}

//    public static void main(String[] args) {
//        StringBuilder tempText = new StringBuilder();
//
//        File dirGames = new File("C://Games");
//        if (dirGames.mkdir()) {
//            tempText.append(" - Создана папка Games\n");
//        } else {
//            tempText.append(" -  папка Games не создана или уже существует\n");
//        }
//
//        File dirSrc = new File(dirGames, "src");
//        File dirRes = new File(dirGames, "res");
//        File dirSavegames = new File(dirGames, "savegames");
//        File dirTemp = new File(dirGames, "temp");
//        if (dirSrc.mkdir() && dirSavegames.mkdir() && dirRes.mkdir()
//                && dirTemp.mkdir()) {
//            tempText.append(" - В папке Games была создана новая папка или папки:\n");
//        } else {
//            tempText.append(" - В папке Games не все созданы папки или они уже существуют\n");
//        }
//
//        File dirMain = new File(dirSrc, "main");
//        File dirTest = new File(dirSrc, "test");
//        if (dirMain.mkdir() && dirTest.mkdir()) {
//            tempText.append(" - В папке src созданы новые папки или папка:\n");
//        } else {
//            tempText.append(" - В папке src не все созданы папки или уже существуют\n");
//        }
//
//        File fileMain = new File(dirMain, "Main.java");
//        File fileUtils = new File(dirMain, "Utils.java");
//        try {
//            if (fileMain.createNewFile() && fileUtils.createNewFile()) {
//                tempText.append(" - В папке main созданы новые файлы или файл: \n");
//            } else {
//                tempText.append(" - В папке main не все созданы файлы или они существуют\n");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        File fileTemp = new File(dirTemp, "temp.txt");
//        try {
//            if (fileTemp.createNewFile()) {
//                tempText.append(" - В папке temp создан новый файл:\n");
//            } else {
//                tempText.append(" - В папке temp не все созданы файлы или они существуют\n");
//            }
//        } catch (IOException e) {
//            System.out.println("1 " + e.getMessage());
//        }
//
//        File dirDrawables = new File(dirRes, "drawables");
//        File dirIcons = new File(dirRes, "icons");
//        File dirVectors = new File(dirRes, "vectors");
//
//        if (dirDrawables.mkdir() && dirIcons.mkdir() && dirVectors.mkdir()) {
//            tempText.append(" - В папке res созданы новые папки или папка:\n");
//        } else {
//            tempText.append(" - В папке Games не все созданы папки или они уже существуют\n");
//        }
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp, true))) {
//            tempText.append("Ждем следующего запуска програмы:\n");
//            bw.write(tempText.toString());
//            bw.flush();
//
//        } catch (Exception e) {
//            System.out.println("2" + e.getMessage());
//        }
//    }
//}