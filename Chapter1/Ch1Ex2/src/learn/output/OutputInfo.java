package learn.output;

public class OutputInfo {
    public void outputInfo(String dev, String assigned, String completed) {
        System.out.println("Разработчик: " + dev);
        System.out.println("Дата и время получения задания: " + assigned);
        System.out.println("Дата и время сдачи задания: " + completed);
    }
}
