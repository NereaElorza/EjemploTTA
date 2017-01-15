package appejemplo.tta.intel.ehu.eus.appejemplo;

/**
 * Created by nerea on 13/01/17.
 */
public class User {
    private int id;
    private String name;
    private int lessonNum;
    private String lessonTit;
    private int nextTest;
    private int nextExercise;

    public User(int id, String name, int lessonNum, String lessonTit, int nextTest, int nextExercise){
        this.id=id;
        this.name=name;
        this.lessonNum=lessonNum;
        this.lessonTit=lessonTit;
        this.nextTest=nextTest;
        this.nextExercise=nextExercise;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getLessonNum(){
        return lessonNum;
    }
    public String getLessonTit(){
        return lessonTit;
    }
    public int getNextTest(){
        return nextTest;
    }
    public int getNextExercise(){
        return nextExercise;
    }


}
