package appejemplo.tta.intel.ehu.eus.appejemplo;

/**
 * Created by nerea on 13/01/17.
 */
public class Test {

    private String wording;
    private String choice;

    public Test(String wording, String choice){
        this.choice=choice;
        this.wording=wording;
    }

    public String getWording(){ //enunciado
        return wording;
    }

    public String  getChoice(){ //respestas
        return choice;
    }
}

