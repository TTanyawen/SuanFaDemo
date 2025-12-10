package duoxiancheng;

import java.util.concurrent.Semaphore;

public class TheadDemo03_Semaphore {
    private static final int PARKING_SLOTS=3;
    private static final Semaphore semaphore=new Semaphore(PARKING_SLOTS);
    private static final char[] parkingLot=new char[]{'-','-','-'};
    public static void main(String[] args) {
        printParkingLot();
        for(int i=0;i<8;i++){//8个车
            int finalI= i;
            new Thread(()->{
                try{
                    semaphore.acquire();
                    synchronized (parkingLot){
                        for(int j=0;j<PARKING_SLOTS;j++){
                            if(parkingLot[j]=='-'){
                                parkingLot[j]=(char)('A'+finalI);
                                printParkingLot();
                                break;
                            }
                        }
                    }

                    Thread.sleep((long)(Math.random()*10)*1000);
                    synchronized (parkingLot){
                        for(int j=0;j<PARKING_SLOTS;j++){
                            if(parkingLot[j]==(char)('A'+finalI)){
                                parkingLot[j]='-';
                                printParkingLot();
                                break;
                            }
                        }
                    }
                    semaphore.release();
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    private static void printParkingLot() {
        for(int i=0;i<3;i++){
            System.out.print(parkingLot[i]+" ");
        }System.out.println();
    }
}
