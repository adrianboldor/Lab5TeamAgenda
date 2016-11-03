public class PersonAgenda {

    static Person[] nameList = new Person[2]; // store the names
    static int index=0;

    public static void main(String[] args) {
        int option=0;

        do {

            // afisare meniu
            System.out.println();
            System.out.println("1.List names");
            System.out.println("2.Add a name");
            System.out.println("3.Modify a name");
            System.out.println("4.Delete a name");
            System.out.println("5.Exit");

            //selectare optiune
            option=SkeletonJava.readIntConsole("Select an option:");

            switch (option) {
                case 1: listNames();break;
                case 2: addName();break;
                case 3: modifyName();break;
                case 4: deleteName();break;
            }


        }
        while(option!=5);

    }

    static void add() {

        // de optimizat cand se umple agenda

        // de optimizat daca deja exista o pers cu acel nume

        if(index<nameList.length) {
            String name = SkeletonJava.readStringConsole("Input the name:");
            String number = SkeletonJava.readStringConsole("Input the number:");

            Person p = new Person();
            p.name=name;
            p.phoneNumber=number;
            nameList[index] = p;
            index++;
        }
        else
        {
            System.out.println("gata memoria, schimba telul ");
        }
    }

    static void listNames(){

        for (int i=0;i<nameList.length;i++) {
            if (nameList[i] == null) {
                System.out.println("Position " + (i+1) + " is empty");
            } else {
                System.out.print((i+1)+".");
                nameList[i].printPerson();
            }
        }
        System.out.println();
    }

    static int addName() {


        String name = SkeletonJava.readStringConsole("Input name:");
        int foundName = findName(name);

        if (foundName>=0){
            String goForward = SkeletonJava.readStringConsole("Name already exists, continue to add? [y]:");
            if (goForward.charAt(0)!='y') {
                return 0;
            }

        }

        if (index < nameList.length) {

            Person p = new Person();
            p.name = name;
            p.phoneNumber = SkeletonJava.readStringConsole("Input phone number:");
            nameList[index] = p;
            index++;
        }
        else {
            int freePos = searchEmpty();
            if (freePos >= 0) {
                Person p = new Person();
                p.name = name;
                p.phoneNumber = SkeletonJava.readStringConsole("Input phone number:");
                nameList[freePos] = p;
            }
            else {
                System.out.println("Out of Memory");
            }
        }
        return 0;

    }

    static int searchEmpty(){

        int i=0;
        do{
            if(nameList[i]==null){
                return i;
            }
            i++;
        }while(i<nameList.length);
        return -1;
    }



    static void deleteName() {

        String oldName = SkeletonJava.readStringConsole("Input the name to delete:");

        int foundPos = findName(oldName);

        if(foundPos>=0){
            nameList[foundPos] = null;
            System.out.println("Name was deleted");
        }



    }

    static void modifyName() {


        String oldName = SkeletonJava.readStringConsole("Input the name to modify:");

        int foundPos = findName(oldName);

        if(foundPos>=0){
            nameList[foundPos].name = SkeletonJava.readStringConsole("Input the new name:");
            nameList[foundPos].phoneNumber = SkeletonJava.readStringConsole("Input number:");

            System.out.println("Name replaced");
        }




    }

    static int findName(String name){
        int i=0;
        boolean isFound = false;

        do{
            if(nameList[i]!=null) {
                isFound = compareStrings(name, nameList[i].name);
            }
            i++;
            //System.out.println(nameList.length);
            //System.out.println("while cycle "+i);
        }while(i<nameList.length && !isFound);

        if(isFound) {
            System.out.println("I found it on position " + i);

            return i - 1;
        }
        else{
            //System.out.println("Name not found");
            return -1;
        }


    }

    static boolean compareStrings(String first, String second){

        //System.out.println(first+" "+second);

        if (first==null || second==null){
            //System.out.println("One string is null");
            return false;

        }
        if (first.length()!=second.length()){
            //System.out.println("String length differs");
            return false;
        }
        else{
            for (int i=0;i<first.length();i++)
            {
                if(first.charAt(i)!=second.charAt(i)){
                    //System.out.println("String char differs");
                    return false;
                }
            }
        }

        return true;
    }


}
