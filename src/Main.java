/*
 Задача
 Сделать игру "Камень, ножницы, бумага"
  */

    /*
    1) Игра человека с компьютером
    1.1) Сделать генератор ходов компьютера
    Решение
    Делаем генератор случайных чисел в диапазоне 3 чисел, затем в зависимости от сгенерированного числа, выбираем строку,
    которая будет ходом компьютера
    1.2) Реализовать возможность хода для игрока
    Решение
    Сделать ввод с консоли.
    1.3)
    Решение
    Создать метод, принимающий ходы игрока и компьютера и выдающий результат.
    1.4)
    Сделать игру бесконечной
    Решение
    Использовать бесконечный цикл while

    После реализации логики игры в методе main, структурировать программу при помощи методов.

    1.5)
    Добавить проверку правильности хода для человека
    Решение
    Создадим метод checkMove, который будет принимать ход человека и проверять его правильность


     */

/*
Заметки
При разбиении функционала на методы важно стремиться к тому, чтобы один метод выполнял одну задачу, существует
антипаттерн "Божественный метод", т.е. метод, который выполняет несколько задач(всемогущий метод), такой подход делает
программу неповоротливой и может серьезно навредить при повторном использовании метода
 */

import java.util.Random;
import java.util.Scanner;

public class Main {

static Random random = new Random();  //  Генератор случайных чисел

static String compStr = "";     // Строки для ходов

static String humanStr = "";

static Scanner scanner = new Scanner(System.in);   // Сканер для считывания хода игрока



public static void main(String[] args) {   // Главный метод(точка входа). Отсюда начинает исполняться программа

        while (true) {            // Бесконечный цикл
                //Зона  кода, которая генерирует ход компьютера. Идеально подойдет для выноса в отдельный метод
//        int n = random.nextInt(3);  // Генерируем ход компьютера
//
//        if (n == 0) {                  // Присваиваем строка в зависимости от числа
//        compStr = "Камень";
//        }
//
//        if (n == 1) {
//        compStr = "Ножницы";
//        }
//
//        if (n == 2) {
//        compStr = "Бумага";
//        }
                makeComputerMove();

                // Зона определяющая ход человека, тоже выносится в отдельный метод
//        System.out.println("Введите свой вариант: ");   // Просим сделать ход человека
//        humanStr = scanner.next();    // Считываем ход человека
                makeHumanMove();

                if(!checkMove(humanStr)){     // Если получили false, выводим предупреждение и игнорируем итерацию цикла
                 System.out.println("Неправильный ход. Введите заново");
                 continue;     // Команда пропустить текущую итерацию, начнет цикл следующую итерацию цикла
                }


                // Зона определяющая победителя. Выносим ее в отдельный метод
//        System.out.println("Ваш ход: " + humanStr + " Ход компьютера: " + compStr );    // Выводим ходы
//        System.out.println(checkWinner(compStr, humanStr));      // Выводим результат. Вызываем метод проверки победителя

                checkWinner();     // Пример использования полиморфизма - в данной программе два метода с названием checkWinner
        }

}

static boolean checkMove(String humanStr) {  // Проверяем совпадает ли введенное человеком слово с одним из допустимых ходов,
                                             // если нет, возвращаем false
        if(humanStr.equals("Ножницы")){
                return true;
        }
        if(humanStr.equals("Камень")){
                return true;
        }
        if(humanStr.equals("Бумага")){
                return true;
        }

        return false;
}

        static void checkWinner(){
        System.out.println("Ваш ход: " + humanStr + " Ход компьютера: " + compStr );    // Выводим ходы
        System.out.println(checkWinner(compStr, humanStr));      // Выводим результат. Вызываем метод проверки победителя
}

static void makeHumanMove(){
        System.out.println("Введите свой вариант: ");   // Просим сделать ход человека
        humanStr = scanner.next();    // Считываем ход человека
}

static void makeComputerMove(){
        int n = random.nextInt(3);  // Генерируем ход компьютера

        if (n == 0) {                  // Присваиваем строка в зависимости от числа
        compStr = "Камень";
        }

        if (n == 1) {
        compStr = "Ножницы";
        }

        if (n == 2) {
        compStr = "Бумага";
        }
}

static String checkWinner(String comp, String hum){     // Метод лоя проверки победителя

        if(comp.equals("Камень") && hum.equals("Ножницы")){      // Проверяем кто победил
        return "Победа компьютера";
        }
        if(comp.equals("Камень") && hum.equals("Бумага")){
        return "Победа человека";
        }
        if(comp.equals("Ножницы") && hum.equals("Бумага")){
        return "Победа компьютера";
        }
        if(comp.equals("Ножницы") && hum.equals("Камень")){
        return "Победа человека";
        }

        if(comp.equals("Бумага") && hum.equals("Ножницы")){
        return "Победа человека";
        }
        if(comp.equals("Бумага") && hum.equals("Камень")){
        return "Победа компьютера";
        }

        return "Ничья";           // Если никто не победил, значит ходы совпали, поэтому ничья
        }
}
