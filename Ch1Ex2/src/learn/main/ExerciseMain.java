package learn.main;

import learn.output.OutputInfo;

public class ExerciseMain {
    public static void main(String[] args) {
        String developer = "Kruglikovsky";
        String assigned = "02.02.2023 12:40";
        String completed = "06.02.2023 10:00";
        OutputInfo out = new OutputInfo();
        out.outputInfo(developer, assigned, completed);
    }
}
