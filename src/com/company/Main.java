package com.company;

public class Main {

    public static void main(String[] args) {
        Station dfm = new RadioDFM();
        Radio radio = new Radio();
        radio.setStation(dfm);

        for(int i=0; i<10; i++){
            radio.play();
            radio.nextStation();

        }
    }
}
//Context
class Human{
    private Activity state;
    public void setState(Activity s) {this.state = s;}

    public void doSomething() {
        state.doSomething(this);
    }
}
//State
interface Activity{
    void doSomething(Human context);
}

//State
interface Station{
    void play();
}
class Radio7 implements Station{
    public void play() {System.out.println("Радио 7...");}
}
class RadioDFM implements Station{
    public void play() {System.out.println("Радио DFM");}
}
class VestiFM implements Station{
    public void play() {System.out.println("Вести FM");}
}

//Context
class Radio{
    Station station;
    void setStation(Station st){station = st;}
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        }
        else if(station instanceof RadioDFM){
            setStation(new VestiFM());
        }
        else if(station instanceof VestiFM){
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}