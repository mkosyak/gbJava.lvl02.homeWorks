package ru.geekBrains.l02.lesson_01;

import ru.geekBrains.l02.lesson_01.obstacles.*;
import ru.geekBrains.l02.lesson_01.subjects.*;


/**
 * 2. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 * 3. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 * соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
 * не смог пробежать и т.д.).
 * 4. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 * 5. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 * 6. * Добавить класс Team, который будет содержать: название команды, массив из 4-х участников (т.е. в конструкторе
 * можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию,
 * метод вывода информации обо всех членах команды.
 * 7. * Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий, метод который будет
 * просить команду пройти всю полосу;
 * То есть в итоге должно быть:
 * public static void main(String[] args) {
 * Course c = new Course(...);         // Создаем полосу препятствий
 * Team team = new Team(...);          // Создаем команду
 * c.doIt(team);                       // Просим команду пройти полосу
 * team.showResults();                 // Показываем результаты
 * }
 */
public class MainRun {
    public static void main(String args[]) {

// ---- Participants Preparation
        System.out.printf("%n ---->> Array of the Participants initialization:");
        Subjects[] participantsArr = new Subjects[]{
                new Cat(),
                new Human("Batman", 1550F, 7.9F, 12.1F ),
                new Robot("Robo*Dft" ),
                new Cat("Cat_DFT"),
                new Human("CatWoman",550F, 12.9F, 10.1F),
                new Robot("Wall-e",550F, 12.9F, 10.1F),
                new Human("Penguin-man", 45F, 0.3F, 0.8F ),
                new Robot("RoboCop", 2048F, 16.3F, 30.8F ),
                new Cat("Cat_01", 50F, 5.1F, 8.1F )
        };

// ---- Obstacles Preparation
        System.out.printf("%n");
        System.out.printf("%n ---->> Array of the obstacles initialization:");
        Obstacles[] obstaclesArr = new Obstacles[]{
                new RunningTrack(100.0F),
                new Wall(4.5F),
                new RunningTrack(200.0F),
                new Pit(3.1F),
                new RunningTrack(150.5F),
        };

// ---- run Course of the obstacles
        System.out.printf("%n");
        System.out.printf("%n ---->> Start Course of the obstacles: ");
        CourseManager c = new CourseManager();
        c.runCourse(obstaclesArr, participantsArr);

    }
}
