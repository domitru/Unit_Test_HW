package Two;
// Задание 2.
//Разработайте и протестируйте метод numberInInterval,
//который проверяет, попадает ли переданное число в интервал (25;100).
// (код приложен в презентации)
public class Range {
    public boolean numberInInterval (int number){
        return (number < 100 && number > 25);
    }
}
