import java.io.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder tempText = new StringBuilder();

        File dirGames = new File("C://Games");
        if (dirGames.mkdir()) {
            tempText.append(" - Создана папка Games\n");
        } else {
            tempText.append(" -  папка Games не создана или уже существует\n");
        }

        File dirSrc = new File(dirGames, "src");
        File dirRes = new File(dirGames, "res");
        File dirSavegames = new File(dirGames, "savegames");
        File dirTemp = new File(dirGames, "temp");
        if (dirSrc.mkdir() && dirSavegames.mkdir() && dirRes.mkdir()
                && dirTemp.mkdir()) {
            tempText.append(" - В папке Games была создана новая папка или папки:\n");
        } else {
            tempText.append(" - В папке Games не все созданы папки или они уже существуют\n");
        }

        File dirMain = new File(dirSrc, "main");
        File dirTest = new File(dirSrc, "test");
        if (dirMain.mkdir() && dirTest.mkdir()) {
            tempText.append(" - В папке src созданы новые папки или папка:\n");
        } else {
            tempText.append(" - В папке src не все созданы папки или уже существуют\n");
        }

        File fileMain = new File(dirMain, "Main.java");
        File fileUtils = new File(dirMain, "Utils.java");
        try {
            if (fileMain.createNewFile() && fileUtils.createNewFile()) {
                tempText.append(" - В папке main созданы новые файлы или файл: \n");
            } else {
                tempText.append(" - В папке main не все созданы файлы или они существуют\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File fileTemp = new File(dirTemp, "temp.txt");
        try {
            if (fileTemp.createNewFile()) {
                tempText.append(" - В папке temp создан новый файл:\n");
            } else {
                tempText.append(" - В папке temp не все созданы файлы или они существуют\n");
            }
        } catch (IOException e) {
            System.out.println("1 " + e.getMessage());
        }

        File dirDrawables = new File(dirRes, "drawables");
        File dirIcons = new File(dirRes, "icons");
        File dirVectors = new File(dirRes, "vectors");

        if (dirDrawables.mkdir() && dirIcons.mkdir() && dirVectors.mkdir()) {
            tempText.append(" - В папке res созданы новые папки или папка:\n");
        } else {
            tempText.append(" - В папке Games не все созданы папки или они уже существуют\n");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemp, true))) {
            tempText.append("Ждем следующего запуска програмы:\n");
            bw.write(tempText.toString());
            bw.flush();

        } catch (Exception e) {
            System.out.println("2" + e.getMessage());
        }
    }
}