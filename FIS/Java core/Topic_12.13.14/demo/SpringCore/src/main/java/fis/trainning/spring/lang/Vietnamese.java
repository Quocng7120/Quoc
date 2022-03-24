package fis.trainning.spring.lang;

public class Vietnamese implements Language {

    @Override
    public String getGreeting() {
        return "Xin Chao";
    }

    @Override
    public String getBye() {
        return "Tam Biet";
    }
}
