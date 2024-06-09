package WorkInFileLesson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WorkInFileLesson {
    private static String mainPath = "C:\\Users\\juliya\\Desktop\\Games\\";
    private static String[] makeDirList = {"src", "res", "savegames", "temp"};
    private static String[] makeDirListSRC = {"main", "test"};
    private static String[] makeDirListRES = {"drawables", "vectors", "icons"};
    private static String[] makeFileListMain = {"Main.java", "Utils.java"};
    private static String[] makeFileListTemp = {"temp.txt"};

    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append("Создание папок в Games ");
        builder.append(makeNewDirectory(mainPath, makeDirList, 1));
        builder.append("\nСоздание папок в src.. ");
        String paphSRC = mainPath + "src\\";
        builder.append(makeNewDirectory(paphSRC, makeDirListSRC, 1));
        builder.append("\nСоздание папок в res.. ");
        String paphRES = mainPath + "res\\";
        builder.append(makeNewDirectory(paphRES, makeDirListRES, 1));

        builder.append("Создание файлов в папках...");
        String paphFileMain = paphSRC + "main\\";
        builder.append(makeNewDirectory(paphFileMain, makeFileListMain, 2));
        String paphFileTEMP = mainPath + "temp\\";
        builder.append(makeNewDirectory(paphFileTEMP, makeFileListTemp, 2));

        //Запись результата в файл
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\juliya\\Desktop\\Games\\temp\\temp.txt"));
            writer.append(builder);
            writer.append("\nЗагрузка в файл завершена!");
            writer.close();
        } catch (IOException e) {
            builder.append("Невозможно записать/прочитать файл");
        }
    }
    static String makeNewDirectory(String pathDirectory, String[] dirList, int param) throws IOException {
        String paramStr = (param == 1) ? "\nПапка " : " \nФайл ";
        String result = "";
        File newDyrectory = new File(pathDirectory);
        if (newDyrectory.isDirectory()) {
            for (String dir : dirList) {
                String newFolderPaph = pathDirectory + dir;
                File newFolder = new File(newFolderPaph);
                if (newFolder.exists()) {
                    result += paramStr + dir + " уже существует ";
                    continue;
                } else {
                    result += paramStr + dir + " нет. \n Идет создание..." + newFolder.getAbsolutePath();
                    if (param == 1) {
                        newFolder.mkdir();
                    } else {
                        newFolder.createNewFile();
                    }
                    result += paramStr + dir + " создана ";
                }
            }
        } else {
            result += paramStr + pathDirectory + " не существует";
        }
        return result;
    }
}
