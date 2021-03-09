import java.util.*;
import java.util.stream.*;

class House{
    private int id;
    private int FlatNumber;
    private int Square;
    private int Floor;
    private int RoomQuantity;
    private String Street;
    private String BuildingType;
    private int Lifespan;
    List<House>list=new ArrayList<>();
    public House(){

    }
    public void setSquare(int Square){
        this.Square=Square;
    }
    public int getSquare(){
        return this.Square;
    }
    public void setFloor(int Floor){
        this.Floor=Floor;
    }
    public int getFloor(){
        return this.Floor;
    }
    public void setRoomQuantity(int RoomQuantity){
        this.RoomQuantity=RoomQuantity;
    }
    public int getRoomQuantity(){
        return this.RoomQuantity;
    }
    public String toString(){
        return "Square: "+Square+'\n'+"Floor: "+Floor+'\n'+"RoomQuantity: "+RoomQuantity+'\n';
    }
    public void CreateArray(int n1, int n2, int n3){
        House house=new House();
        house.setRoomQuantity(n1);
        house.setFloor(n2);
        house.setSquare(n3);
        list.add(house);
        System.out.println(list);
    }
    public void Search(int room, int UpperBound, int LowerBound, int square){
        if(list.isEmpty()){
            throw new NegativeArraySizeException("no data");
        }else if(UpperBound==0&&LowerBound==0&&square==0&&room>0){
            list=list.stream().filter(l->l.getRoomQuantity()==room).collect(Collectors.toList());
            System.out.println(list);
        }else if(room==0&&UpperBound==0&&LowerBound==0&&square>0){
            list=list.stream().filter(l->l.getSquare()>square).collect(Collectors.toList());
            System.out.println(list);
        }else if(square==0&&UpperBound>0||LowerBound>0&&room>0){
            list=list.stream().filter(l->l.getRoomQuantity()==room).collect(Collectors.toList());
            list=list.stream().filter(l->l.getFloor()<UpperBound&&l.getFloor()>LowerBound).collect(Collectors.toList());
            System.out.println(list);
        }else{
            throw new NullPointerException("no parameters entered");
        }
    }
}
public class Main{
    public static void main(String[] args){
        House house1=new House();
        House house2=new House();
        House house3=new House();
        house1.CreateArray(5, 3, 27);
        house2.CreateArray(4, 7, 19);
        house3.CreateArray(2, 5, 35);
        System.out.println("Result:");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter room quantity to search (if none enter 0)");
        int room=sc.nextInt();
        System.out.println("Enter upper bound of floor to search (if none enter 0)");
        int UpperBound=sc.nextInt();
        System.out.println("Enter lower bound of floor to search (if none enter 0)");
        int LowerBound=sc.nextInt();
        System.out.println("Enter square value to search (if none enter 0)");
        int square=sc.nextInt();
        house1.Search(room, UpperBound, LowerBound, square);
        house2.Search(room, UpperBound, LowerBound, square);
        house3.Search(room, UpperBound, LowerBound, square);
    }
}
