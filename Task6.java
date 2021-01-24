import java.util.*;
import java.util.stream.*;
class ElectronicDevice implements Comparable<ElectronicDevice>
{
    protected int EnergyConsumption;
    protected int n;
    public boolean isTurnOn;
    public ElectronicDevice(int n){
        this.n=n;
    }
    public void TurnOn(){
        isTurnOn=true;
        EnergyConsumption=n;
    }
    public void TurnOff(){
        isTurnOn=false;
        EnergyConsumption=0;
    }
    @Override
    public int compareTo(ElectronicDevice o){
        return (this.n-o.n);
    }
}
class Device1 extends ElectronicDevice
{
    public Device1(int n){
        super(n);
    }
    public String toString(){
        return "Energy Consumption of device 1: "+EnergyConsumption+" Watts";
    }
}
class Device2 extends ElectronicDevice
{
    public Device2(int n){
        super(n);
    }
    public String toString(){
        return "Energy Consumption of device 2: "+EnergyConsumption+" Watts";
    }
}
class Device3 extends ElectronicDevice
{
    public Device3(int n){
        super(n);
    }
    public String toString(){
        return "Energy Consumption of device 3: "+EnergyConsumption+" Watts";
    }
}
public class Program
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter device energy consumption");
        int n1=sc.nextInt();
        System.out.println("Enter device energy consumption");
        int n2=sc.nextInt();
        System.out.println("Enter device energy consumption");
        int n3=sc.nextInt();
        ElectronicDevice device1=new Device1(n1);
        ElectronicDevice device2=new Device2(n2);
        ElectronicDevice device3=new Device3(n3);
        device1.TurnOn();
        device2.TurnOn();
        device3.TurnOn();
        device3.TurnOff();
        List<ElectronicDevice>TurnOnDevices=Arrays.asList(device1, device2, device3);
        List<ElectronicDevice>TurnOffDevices=Arrays.asList(device1, device2, device3);
        TurnOnDevices=TurnOnDevices.stream().filter(device->device.isTurnOn).collect(Collectors.toList());
        TurnOffDevices=TurnOffDevices.stream().filter(device->!device.isTurnOn).collect(Collectors.toList());
        List<ElectronicDevice>TurnOnDevicesSortedList=TurnOnDevices.stream().sorted().collect(Collectors.toList());
        List<ElectronicDevice>TurnOffDevicesSortedList=TurnOffDevices.stream().sorted().collect(Collectors.toList());
        System.out.println("Turned on devices:");
        TurnOnDevicesSortedList.forEach(System.out::println);
        System.out.println("Turned off devices:");
        TurnOffDevicesSortedList.forEach(System.out::println);
        System.out.println("Enter device energy consumption");
        int EnergyConsumptionValue=sc.nextInt();
        List<ElectronicDevice>SearchDevice=Arrays.asList(device1, device2, device3);
        SearchDevice=TurnOnDevices.stream().filter(device->device.EnergyConsumption==EnergyConsumptionValue).collect(Collectors.toList());
        SearchDevice.forEach(System.out::println);
	}
}
