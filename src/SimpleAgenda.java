public class SimpleAgenda {

    static String[] nameList = new String[2]; // store the names
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
            if (nameList[i] == null) {                                          //daca stringul e gol se specifica ca pozitia e goala
                System.out.println("Position " + (i + 1) + " is empty");
            } else {                                                            //altfel  se afiseaza stringul si pozitia
                System.out.println(nameList[i] + " is on position " + (i + 1));

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

            nameList[index] = name;
            index++;
        }
        else {
            int freePos = searchEmpty();
            if (freePos >= 0) {

                nameList[freePos] = name;
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
            nameList[foundPos] = SkeletonJava.readStringConsole("Input the new name:");

            System.out.println("Name replaced");
        }




    }

    static int findName(String name){
        int i=0;
        boolean isFound = false;

        do{
            isFound = compareStrings(name,nameList[i]);
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
