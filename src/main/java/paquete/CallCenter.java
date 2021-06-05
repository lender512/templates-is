package paquete;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class CallCenter {
    Logger logger = Logger.getLogger(CallCenter.class.getName());
    List<List<CallWorker>> workers = new ArrayList<>();
    Queue<Call> calls = new LinkedList<>();


    private static CallCenter instance = null;

    public static CallCenter getInstance(){
        if (instance == null) {
            instance = new CallCenter();
        }
        return instance;
    }

    private CallCenter(){
        for (var i = 0; i < 3; i++) {
            workers.add(new ArrayList<>());
            for (var j = 0; j < 10; j++) {
                if (i == 0)
                    workers.get(i).add(new Respondent(j));
                else if (i == 1)
                    workers.get(i).add(new Manager(j));
                else
                    workers.get(i).add(new Director(j));
            }
        }
        workers.get(1).get(4).bussy = false;
    }

    public void answerCall() {
        calls.remove();
        for (List<CallWorker> worker : workers) {
            for (CallWorker callWorker: worker) {
                if (!callWorker.bussy) {
                    var id = callWorker.id;
                    var rango = callWorker.getClass().getSimpleName();
                    var message = "Alo from: " + rango + " " + id;
                    logger.info(message);
                }
            }
        }
    }

    public void receiveCall(){
        var call = new Call();
        calls.add(call);
        answerCall();
    }
}
