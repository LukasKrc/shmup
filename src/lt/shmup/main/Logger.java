package lt.shmup.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String logFolder;
    private BufferedWriter logFileWriter;
    private DateFormat logTimeFormat;
    private String lineSeparator;

    private Logger() {
        this.logFolder = this.getLogFolder();
        this.createLogDirectory();
        File file = this.createLogFile();
        this.logFileWriter = this.createFileWriter(file);
        this.logTimeFormat = new SimpleDateFormat("HH:mm:ss");
        this.lineSeparator = System.getProperty("line.separator");
    }

    private void createLogDirectory() {
        File directory = new File(this.logFolder);
        try {
            directory.mkdir();
        } catch (Exception e) {
            System.out.println(
                "Could not create log folder in path" + this.logFolder
            );
        }
    }

    private File createLogFile() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String filePath = this.logFolder + dateFormat.format(date) + ".log";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.isDirectory()) {
            this.logFolder = filePath;
            return this.createLogFile();
        }

        return file;
    }

    private BufferedWriter createFileWriter(File file) {
        try {
            return new BufferedWriter(
                new FileWriter(file, true)
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getLogFolder() {
        URL location = Logger
                .class
                .getProtectionDomain()
                .getCodeSource()
                .getLocation();
        location.getFile();
        return location.getFile() + "logs/";
    }

    private static Logger instance;

    public static Logger getInstance() {
        if (Logger.instance == null) {
            Logger.instance = new Logger();
        }

        return Logger.instance;
    }

    public void log(String message) {
        if (this.logFileWriter == null) {
            return;
        }
        Date date = new Date();
        String logMessage = this.logTimeFormat.format(date)
            + ": "
            + message
            + "\n";
        try {
            this.logFileWriter.write(logMessage);
            this.logFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}