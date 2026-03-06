package designpattern;

import java.util.ArrayList;
import java.util.List;

//被观察者
interface Subject{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String msg);
}
interface Observer{
    void update(String msg);
}
class SubjectA implements Subject{
    private List<Observer> observers;
    SubjectA(){
        observers=new ArrayList<>();
    }
    @Override
    public void attach(Observer observer) {
       observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        for(Observer observer:observers){
            observer.update(msg);
        }
    }
}
class ObserverA implements Observer{
    @Override
    public void update(String msg) {
        System.out.println("ObserverA: "+msg);
    }
}
class ObserverB implements Observer{
    @Override
    public void update(String msg) {
        System.out.println("ObserverB: "+msg);
    }
}
public class ObserverSubjectDemo {
    public static void main(String[] args) {
        SubjectA subjectA=new SubjectA();
        subjectA.attach(new ObserverA());
        subjectA.attach(new ObserverB());
        subjectA.notifyObservers("hello world");
    }
}
