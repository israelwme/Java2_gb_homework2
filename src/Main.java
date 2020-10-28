public class Main {
    public static final int xLength = 4;
    public static final int yLength = 4;

    public static void main(String[] args) {

        //1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
        //   при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        //2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
        //   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
        //   или текст вместо числа), должно быть брошено исключение MyArrayDataException,
        //   с детализацией в какой именно ячейке лежат неверные данные.
        //3. В методе main() вызвать полученный метод,
        //   обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.


        String[][] str = new String[4][4];
        str = FillStr(str);
        str[2][0] = "AA";
        printArray(str);
        WorkArray(str);
    }

    private static void WorkArray(String[][] array) {
        int x = array[0].length, y = array.length;
        if (x != xLength || y != yLength) {
            try {
                throw new MyArraySizeException("Размер должен быть 4x4");
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        }

        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException("Ошибка формата переменной в ячейке - " + i + " , " + j);
                    } catch (MyArrayDataException myArrayDataException) {
                        myArrayDataException.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Сумма значений массива (исключая ошибки) = " + sum);
    }

    private static String[][] FillStr(String[][] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                k++;
                array[i][j] = Integer.toString(k);
            }
        }
        return array;
    }

    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}