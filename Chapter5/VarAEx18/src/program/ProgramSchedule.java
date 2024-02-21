package program;

import java.util.List;
import java.util.ArrayList;

public class ProgramSchedule {
    private class Program {
        private int channel;
        private String name;

        public Program(int channel, String name){
            this.channel = channel;
            this.name = name;
        }

        public int getChannel() {
            return channel;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Channel: " + channel + ", Program: " + name;
        }
    }

    private List<Program> programs;

    public ProgramSchedule() {
        programs = new ArrayList<>();
    }

    public void addProgram(int channel, String name){
        Program program = new Program(channel, name);
        programs.add(program);
    }

    public List<Program> getAllPrograms() {
        return programs;
    }


    public static void main(String[] args) {
        ProgramSchedule schedule = new ProgramSchedule();

        schedule.addProgram( 1, "News");
        schedule.addProgram(2, "Movie");
        schedule.addProgram(3, "Sports");

        List<Program> programList = schedule.getAllPrograms();

        for(Program p : programList){
            System.out.println(p);
        }
    }
}
