//Вариант 5
//Разработать класс для хранения информации о футбольных командах:
//Название, город, место_в_лиге, количество_побед
//и реализовать алгоритм работы с массивом данных объектов, в котором
//требуется:
//– определить команду с самым большим количеством побед;
//– определить команды с количеством побед больше среднего;
//– упорядочить массив по убыванию мест в лиге;
//– организовать поиск по названию команды, исправление одного из полей и вывод полной информации о команде после редактирования.

import java.util.Scanner;

class Team{
    String name;
    String city;
    int rating;
    int winstreak;
}

public class ArchiveWithMethods {
    public static Scanner sc;

    //Заполнение массива Team
    public static Team[] fillTeam(Team[]comand){
        for (int i = 0; i < comand.length; i++){
            comand[i] = new Team();
            System.out.println("Name: ");
            comand[i].name = sc.nextLine();
            System.out.println("City: ");
            comand[i].city = sc.nextLine();
            System.out.println("Rating: ");
            comand[i].rating = sc.nextInt();
            System.out.println("Win streak: ");
            comand[i].winstreak = sc.nextInt();
            sc.nextLine();
        }
        return comand;
    }

    //Вывод массива с командами
    public static void printTeam(Team[]comand){
        for (int i = 0; i < comand.length; i++){
            System.out.println("Name: " + comand[i].name + "; City: " + comand[i].city + "; Rating: " + comand[i].rating + "; Win Streak: " + comand[i].winstreak);
        }
    }

    //Нахождение команды с наибольшим количеством побед
    public static int findHighestWinStreak(Team[] comand){
        int highestWinStreak = 0;
        int highScore = comand[highestWinStreak].winstreak;
        for (int i = 0; i < comand.length; i++){
            if (comand[i].winstreak > highScore){
                highestWinStreak = i;
                highScore = comand[highestWinStreak].winstreak;
            }
        }
        return highestWinStreak;
    }

    //Вывод одной команды
    public static void printComand(Team comand){
        System.out.println("Name: " + comand.name + "; City: " + comand.city + "; Rating: " + comand.rating + "; Win Streak: " + comand.winstreak);
    }

    //определить команды с количеством побед больше среднего;
    public static double avgWins(Team[] comand){
        double middleStreak = 0;
        for (int i = 0; i < comand.length; i++){
            middleStreak += comand[i].winstreak;
        }
        double mid = middleStreak/comand.length;
        return mid;
    }

    public static void printMid(Team[] comand, double avgWins){
        for (int i = 0; i < comand.length; i++){
            if (comand[i].winstreak > avgWins){
                printComand(comand[i]);
            }
        }
    }

    //порядок по убыванию мест команд
    public static void sortTeams(Team[]comand){
        for (int i = 0; i < comand.length-1; i++){
            for (int j = 0; j < comand.length - 1 - i; j++){
                if (comand[j].rating > comand[j+1].rating){
                    Team rab = comand[j];
                    comand[j] = comand[j+1];
                    comand[j+1]=rab;
                }
            }
        }
    }

    //поиск команд по названию
    public static int searchTeamByName(Team[]comand, String searchName){
        int searchIndex = -1;
        for (int i = 0; i < comand.length; i++){
            if (comand[i].name.equals(searchName)){
                searchIndex = i;
            }
        }
        return searchIndex;
    }

    public static void main(String[] args){
        sc = new Scanner(System.in);
        System.out.println("Введите количество команд: ");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();

        Team[] comand = new Team[count];
        comand = fillTeam(comand);
        printTeam(comand);

        double AvgWins = avgWins(comand);
        System.out.println("\nСреднее значение: ");
        System.out.println("avgWins = " + AvgWins);
        System.out.println("\nКоманды с количеством побед больше среднего: ");
        printMid(comand, AvgWins);

        int indexHighestWinStreak = findHighestWinStreak(comand);
        System.out.println("\nКоманда с самым большим количеством побед");
        printComand(comand[indexHighestWinStreak]);


        sortTeams(comand);
        System.out.println("\nРейтинг команд по убыванию мест: ");
        printTeam(comand);

        System.out.println("\nВведите название команды: ");
        String searchName = sc.nextLine();
        int searchIndex = searchTeamByName(comand,searchName);
        if(searchIndex!=-1){
            System.out.println("Найдена команда: ");
            printComand(comand[searchIndex]);
            System.out.println("\nВыберите поле которое хотите исправить");
            System.out.println("Name, City, Rating, Win streak");
            String redPole = sc.nextLine();
            switch (redPole){
                case "Name":{
                    System.out.println("New Name");
                    String newName = sc.nextLine();
                    comand[searchIndex].name = newName;
                    break;
                }
                case "City":{
                    System.out.println("New City");
                    String newCity = sc.nextLine();
                    comand[searchIndex].city = newCity;
                    break;
                }
                case "Rating":{
                    System.out.println("New Rating");
                    int newRating = sc.nextInt();
                    comand[searchIndex].rating = newRating;
                    break;
                }
                case "Win streak":{
                    System.out.println("New Streak");
                    int newStreak = sc.nextInt();
                    comand[searchIndex].rating = newStreak;
                    break;
                }
            }
            System.out.println("\nОтредактированная информация: ");
            printComand(comand[searchIndex]);
        }
        else{
            System.out.println("Ничего не найдено");
        }
    }
}
