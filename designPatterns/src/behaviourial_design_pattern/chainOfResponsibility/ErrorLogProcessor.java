package behaviourial_design_pattern.chainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor{

    protected ErrorLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogType logType, String message){
        if(logType == LogType.ERROR){
            System.out.println("ERROR: " + message);
        }
        else {
            System.out.println("Skipping ERROR");
            super.log(logType, message);
        }
    }
}
