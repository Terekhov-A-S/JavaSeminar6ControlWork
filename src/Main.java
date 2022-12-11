import model.MyNotebook;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //делаем переменные фильтров статическими чтобы доступ к ним был отовсюду (аля глобальные)
    public static int ram = 0;
    public static int hddSize = 0;
    public static String systemName = "none";
    public static String color = "none";
    public static Set<MyNotebook> notebooks;


    public static void main(String[] args) {
        //создаем множество случайных ноутбуков
        notebooks = createRandomNotebooks();
        //считываем параметры с консоли
        getFiltersParams();
        //показываем отфильтрованные
        showFilteredResultBy(ram, hddSize, systemName, color);
        //напоминаем что в фильтрах введено из консоли
        System.out.println("ВЫБРАННЫЕ ФИЛЬТРЫ: [RAM >= " + ram + "], [HDD >= " + hddSize + "], [операционная система: " + systemName + "], [цвет: " + color + "]");
    }

    private static void showFilteredResultBy(int ram, int hddSize, String systemName, String color) {
        Iterator<MyNotebook> s = notebooks.iterator();
        System.out.println("Отфильтрованные ноутбуки:");
        while (s.hasNext()) {
            MyNotebook tempNoteBook = s.next();

            if (tempNoteBook.getModelRAM() >= ram) {
                if (tempNoteBook.getModelHDDSize() >= hddSize) {
                    if (tempNoteBook.getModelOSName().equals(systemName) || systemName.equals("none")) {
                        if (tempNoteBook.getModelColor().equals(color) || color.equals("none")) {
                            System.out.println("id: " + tempNoteBook.getId() + ", модель: " + tempNoteBook.getModelName() + ", RAM: " + tempNoteBook.getModelRAM() + ", HDD: " + tempNoteBook.getModelHDDSize() + ", операционная система: " + tempNoteBook.getModelOSName() + ", цвет: " + tempNoteBook.getModelColor());
                        }
                    }
                }
            }
        }
    }

    private static void getFiltersParams() {
        Scanner scanner = new Scanner(System.in);
        boolean asking = true;
        int numberOfParameter;
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        while (asking) {
            System.out.print("Введите номер критерия фильтрации (1-4). Для применения фильтра введите 0: ");
            if (scanner.hasNextInt()) {
                numberOfParameter = scanner.nextInt();
                if (numberOfParameter == 0) {
                    asking = false;
                }
                if (numberOfParameter == 1) {
                    System.out.print("RAM >= ");
                    ram = scanner.nextInt();
                } else if (numberOfParameter == 2) {
                    System.out.print("Размер HDD >= ");
                    hddSize = scanner.nextInt();
                } else if (numberOfParameter == 3) {
                    System.out.print("Операционная система (с большой буквы): ");
                    Scanner scannerWord = new Scanner(System.in);
                    systemName = scannerWord.nextLine();
                } else if (numberOfParameter == 4) {
                    Scanner scannerWord = new Scanner(System.in);
                    System.out.print("Цвет: .. ");
                    color = scannerWord.nextLine();
                } else {
                    String wrong = scanner.nextLine();
                    System.out.println(wrong + "Ввод принят, применяю.");
                    System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
                }
            } else {
                System.out.println("Ошибка! вводить нужно только указанные цифры, фильтр не будет применен!");
                asking = false;
                System.out.println("_-=!!!Ошибка фильтрации!!!=-_");
            }
        }
    }

    private static Set<MyNotebook> createRandomNotebooks() {
        Set<MyNotebook> temp = new HashSet<>();
        temp.add(new MyNotebook(1, "Lenovo M123", 6, 512, "Windows 7", "green"));
        temp.add(new MyNotebook(2, "HP PV245655", 8, 1000, "Windows 10", "red"));
        temp.add(new MyNotebook(3, "Samsung P89", 16, 512, "Windows 11", "yellow"));
        temp.add(new MyNotebook(4, "ASUS TX6764", 6, 1000, "Windows 7", "grey"));
        temp.add(new MyNotebook(5, "HUAWEI R127", 8, 2000, "Windows 10", "white"));
        temp.add(new MyNotebook(6, "ACER DF3475", 16, 3000, "Windows 11", "black"));
        temp.add(new MyNotebook(7, "APPLE fgh78", 6, 256, "Windows XP", "silver"));
        temp.add(new MyNotebook(8, "Xiaomi yu79", 32, 512, "Windows 2000", "green"));
        temp.add(new MyNotebook(9, "Xiaomi p83", 16, 128, "Linux", "gold"));
        temp.add(new MyNotebook(10, "APPLE air13", 6, 256, "Os X", "silver"));
        temp.add(new MyNotebook(11, "Lenovo M597", 32, 1024, "Windows 11", "red"));
        temp.add(new MyNotebook(12, "HP PV326749", 8, 2048, "Windows 8", "green"));
        temp.add(new MyNotebook(13, "Samsung X10", 16, 512, "Windows 8.1", "gray"));
        temp.add(new MyNotebook(14, "ASUS Sc8957", 6, 1024, "Windows 7", "yellow"));
        temp.add(new MyNotebook(15, "HUAWEI RX74", 8, 2000, "Windows 10", "white"));
        temp.add(new MyNotebook(16, "ACER RED847958", 32, 3072, "Windows 11", "black"));
        temp.add(new MyNotebook(17, "APPLE sup14", 6, 512, "Mac Os", "silver"));
        temp.add(new MyNotebook(18, "Xiaomi ed14", 16, 128, "Windows 2000", "green"));
        temp.add(new MyNotebook(19, "Xiaomi ml10", 8, 256, "Linux", "gold"));
        temp.add(new MyNotebook(20, "APPLE air12", 2, 128, "Mac Os", "blue"));
        return temp;
    }
}