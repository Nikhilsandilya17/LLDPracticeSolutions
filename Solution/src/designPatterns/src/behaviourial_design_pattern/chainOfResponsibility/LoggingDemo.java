package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility;

public class LoggingDemo {
    public static void main(String[] args) {
        LogProcessor logProcessor = new DebugLogProcessor(new ErrorLogProcessor(new InfoLogProcessor(null)));
//        logProcessor.log(LogType.DEBUG, "This is DEBUG");
//        logProcessor.log(LogType.ERROR, "This is ERROR");
        logProcessor.log(LogType.INFO, "This is INFO");
    }
}
