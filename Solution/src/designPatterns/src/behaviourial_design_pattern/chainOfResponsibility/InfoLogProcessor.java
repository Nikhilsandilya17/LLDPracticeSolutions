package designPatterns.src.behaviourial_design_pattern.chainOfResponsibility;

public class InfoLogProcessor extends LogProcessor{

    protected InfoLogProcessor(LogProcessor logProcessor) {
        super(logProcessor);
    }

    @Override
    public void log(LogType logType, String message){
        if(logType==LogType.INFO){
            System.out.println("INFO: " + message);
        }
        else {
            System.out.println("Skipping INFO");
            super.log(logType ,message);
        }
    }
}
