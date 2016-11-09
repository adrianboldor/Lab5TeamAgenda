public class PersonAgenda {

    static Person[] nameList = new Person[5]; // store the names
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

    static void addName() {


        int freePos = searchEmpty();
        if (freePos >= 0) {                                 //verifica daca exista pozitie libera

            String name = SkeletonJava.readStringConsole("Input name:");

            int foundName = findName(name);
            boolean goForward = true;

            if (foundName>=0){                               //verifica daca exista deja numele si solicita confirmare de continuare daca il gaseste
                String checkForward = SkeletonJava.readStringConsole("Name already exists, continue to add? [y]:");
                if (checkForward.charAt(0)!='y') {
                    goForward = false;
                }

            }
            if (goForward) {
                Person p = new Person();
                p.setName(name);
                p.setPhoneNumber(SkeletonJava.readStringConsole("Input phone number:"));
                nameList[freePos] = p;

                if (index < nameList.length){
                    index++;
                }
            }
        }
        else {
            System.out.println("Out of Memory");
        }


    }

    static int searchEmpty(){  //daca nu gaseste pozitie libera va returna -1, altfel retuneaza pozitia libera

        //TODO pastreaza pozitiile care au fost sterse si evita cautarea in toata lista

        int foundEmpty = -1;

        if (index < nameList.length) {
            foundEmpty = index;
        }
        else {
            int i = 0;

            do {
                if (nameList[i] == null) {
                    foundEmpty = i;
                }
                i++;
            } while (i < nameList.length);
        }

        return foundEmpty;
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
            nameList[foundPos].setName(SkeletonJava.readStringConsole("Input the new name:"));
            nameList[foundPos].setPhoneNumber(SkeletonJava.readStringConsole("Input number:"));

            System.out.println("Name replaced");
        }
    }

    static int findName(String name){
        int i=0;
        boolean isFound = false;
        int foundPos = -1;

        do{
            if(nameList[i]!=null) {        //trebuie verificat inainte ca oniectul nu este null altfel compararea va arunca exceptie
                isFound = name.equalsIgnoreCase(nameList[i].getName());
            }
            i++;
        }while(i<nameList.length && !isFound);

        if(isFound) {
            System.out.println("I found it on position " + i);
            foundPos =  i-1;
        }

        return foundPos;
    }



}
