public class SimpleAgenda {

    static String[] nameList = new String[2]; // store the names
    static int index=0;

    public static void main(String[] args) {


        int option=0;

        do {

            // afisare meniu
            System.out.println();
            System.out.println("1.Show names");
            System.out.println("2.Add a name");
            System.out.println("3.Modify a name");
            System.out.println("4.Delete a name");
            System.out.println("5.Exit");

            //selectare optiune
            option=SkeletonJava.readIntConsole("Select an option:");

            switch (option) {
                case 1: showNames();break;
                case 2: addName();break;
                case 3: modifyName();break;

            }


        }
        while(option!=5);

    }

    static void showNames(){

        for (int i=0;i<nameList.length;i++) {
            if (nameList[i] == null) {                                          //daca stringul e gol se specifica ca pozitia e goala
                System.out.println("Position " + (i + 1) + " is empty");
            } else {                                                            //altfel se se afiseaza stringul si pozitia
                System.out.println(nameList[i] + " is on position " + (i + 1));

            }
        }
        System.out.println();
    }

    static void addName() {

        // de optimizat cand se umple agenda

        // de optimizat daca deja exista o pers cu acel nume

        if(index<nameList.length) {
            String name = SkeletonJava.readStringConsole("Input name:");
            nameList[index] = name;
            index++;
        }
        else
        {
            System.out.println("OOM");
        }
    }



    static void del() {

        // citeste un nume
        // il cauta in array
        //daca il gaseste il sterge  asa listName[unde l-a gasit]=null sau "";

    }

    static void modifyName() {


        String oldName = SkeletonJava.readStringConsole("Input the name to modify:");

        int i=0;
        boolean isFound = false;

        do{
            if(compareStrings(oldName,nameList[i])){
                isFound = true;
            }
        }while(i<nameList.length || !isFound);

        System.out.println("I found" + nameList.length);
        // citeste un nume
        // il cauta in array
        // daca il gaseste cere noul nume si il substituie pe cel vechi cu cel nou
    }

    static boolean compareStrings(String first, String second){
        if (first.length()!=second.length()){
            return false;
        }
        else{
            for (int i=0;i<first.length();i++)
            {
                if(first.charAt(i)!=second.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

}
