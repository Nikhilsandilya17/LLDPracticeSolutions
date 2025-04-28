package behaviourial_design_pattern.chainOfResponsibility;

public abstract class LogProcessor {

    private LogType logType;

    LogProcessor nextLogProcessor;

    protected LogProcessor(LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(LogType logType, String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.log(logType, message);
        }
    }

}
