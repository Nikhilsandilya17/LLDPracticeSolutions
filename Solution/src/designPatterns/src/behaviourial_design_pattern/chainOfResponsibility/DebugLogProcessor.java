package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility;

public class DebugLogProcessor extends LogProcessor{

    protected DebugLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogType logType, String message){
        if(logType == LogType.DEBUG){
            System.out.println("DEBUG: "+ message);
        }
        else {
            System.out.println("Skipping DEBUG");
            super.log(logType, message);
        }
    }

}
