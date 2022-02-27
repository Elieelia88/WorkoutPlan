package WORKOUTPLAN.Model.WorkoutPlan.Workouts;

public class Workout {
    private String wid,name,muscle,type,image,premium;

    public Workout(String wid, String name, String muscle, String type, String image, String premium) {
        this.wid = wid;
        this.name = name;
        this.muscle = muscle;
        this.type = type;
        this.image = image;
        this.premium = premium;
    }

    public Workout(String name, String muscle, String type, String image, String premium) {
        this.name = name;
        this.muscle = muscle;
        this.type = type;
        this.image = image;
        this.premium = premium;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "wid='" + wid + '\'' +
                ", name='" + name + '\'' +
                ", muscle='" + muscle + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", premium='" + premium + '\'' +
                '}'+'\n';
    }
}
