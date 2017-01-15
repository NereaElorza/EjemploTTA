package appejemplo.tta.intel.ehu.eus.appejemplo;

/**
 * Created by nerea on 15/01/17.
 */
public class Choice {
    private int id;
    private String advise;
    private String answer;

    public Choice(int id, String advise, String answer){
        this.id=id;
        this.advise=advise;
        this.answer=answer;
    }

    public String getAdvise() {
        return advise;
    }

    public int getId() {
        return id;
    }
    public String getAnswer(){
        return advise;
    }
}
