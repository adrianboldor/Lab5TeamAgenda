/**
 * Created by icondor on 29/10/16.
 */
public class Person {


    String name;
    String phoneNumber;

    public void printPerson(){
        System.out.println(name+" "+phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
