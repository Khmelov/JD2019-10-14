package by.it.zabauniuk.jd02_06.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Report {

    private String title;
    private String startTime;
    private String finishTime;
    List<String> actions;

    public Report(String title, String startTime, String finishTime, List<String> actions) {
        this.title = title;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.actions = actions;
    }

    void reportToFile() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String subPath = this.getClass().getName().replace(this.getClass().getSimpleName(), "")
                .replace(".", File.separator);
        String fullPath = path + subPath + "report.txt";
        try (PrintWriter printWriter = new PrintWriter(
                new FileWriter(fullPath))) {
            printWriter.println(toString());
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.title).append("\n").append("Start time: ").append(this.startTime).append("\n");
        for (int i = 0; i < actions.size(); i++) {
            sb.append(actions.get(i)).append("\n");
        }
        sb.append("Finish time: ").append(this.finishTime);
        return sb.toString();
    }

    public enum Type {
        FULL,
        SHORT
    }

    public static class Builder {
        private Type reportType;
        private String title;
        private String startTime;
        private String finishTime;
        List<String> actions;

        public Builder() {
            actions = new ArrayList<>();
            this.reportType = Type.SHORT;
        }

        public Builder setReportType(Type type) {
            reportType = type;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setFinishTime(String finishTime) {
            this.finishTime = finishTime;
            return this;
        }

        public Builder addAction(String action) {
            actions.add(action);
            return this;
        }

        public Builder addException(CalcException e) {
            if (this.reportType == Type.SHORT) {
                actions.add(Logger.getDate() + " " + Logger.getTime() + " LOG: " + e.getClass().getSimpleName());
            } else if (this.reportType == Type.FULL) {
                actions.add(Logger.getDate() + " " + Logger.getTime() + " LOG: " +
                        e.getClass().getSimpleName() + " " + e.getMessage());
            }
            return this;
        }

        public Report build() {
            return new Report(title, startTime, finishTime, actions);
        }

    }

}