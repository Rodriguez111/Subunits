import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        String [] array = new String[7];
        array[0] = "K1\\SK1";
        array[1] = "K1\\SK2";
        array[2] = "K1\\SK1\\SSK1";
        array[3] = "K1\\SK1\\SSK2";
        array[4] = "K2";
        array[5] = "K2\\SK1\\SSK1";
        array[6] = "K2\\SK1\\SSK2";



        HashSet<String> listOfStrings = new HashSet();

        for(int i = 0; i<array.length; i++ ){

          String string = array[i];
            listOfStrings.add(string);

            while(string.indexOf("\\") != -1){
                string = string.substring(0, string.lastIndexOf("\\"));
                listOfStrings.add(string); //запллняем сет уникальными подразделениями
            }
        }


        ArrayList<Subunit> listOfUnits = new ArrayList();

        for(String eachString : listOfStrings){

            String department;
            String service = "";
            String branch = "";

            String[] stringToArray = eachString.split("\\\\");
                if(stringToArray.length == 1){
                    department = stringToArray[0];
                }
                else if(stringToArray.length == 2){
                    department = stringToArray[0];
                    service = stringToArray[1];
                }
                else {
                    department = stringToArray[0];
                    service = stringToArray[1];
                    branch = stringToArray[2];
                }

            listOfUnits.add(new Subunit(department, service, branch ));

        }


        Collections.sort(listOfUnits, new SubunitComparator());
        System.out.println("Прямая сортировка:");
        for (Subunit eachUnit : listOfUnits){
            System.out.println(eachUnit.getDepartment()+eachUnit.getService()+eachUnit.getBranch());
        }

        Collections.sort(listOfUnits, new Comparator<Subunit>() {
            public int compare(Subunit o1, Subunit o2) {

            //для обратной сортировки заполняем отсутствующие величины максимальной величиной
            int o1ServiceNumber = o1.getServiceNumber()==-1?Integer.MAX_VALUE:o1.getServiceNumber();
             int o2ServiceNumber = o2.getServiceNumber()==-1?Integer.MAX_VALUE:o2.getServiceNumber();

             int o1BranchNumber = o1.getBranchNumber()==-1?Integer.MAX_VALUE:o1.getBranchNumber();
             int o2BranchNumber = o2.getBranchNumber()==-1?Integer.MAX_VALUE:o2.getBranchNumber();


                int result = o2.getDepartmentNumber() - o1.getDepartmentNumber()  ;

                if(result == 0){
                    result = o2ServiceNumber - o1ServiceNumber;
                }
                if(result == 0){
                    result = o2BranchNumber - o1BranchNumber;
                }


                return result;
            }
        });
        System.out.println();
        System.out.println("Обратная сортировка:");
        for (Subunit eachUnit : listOfUnits){
            System.out.println(eachUnit.getDepartment()+eachUnit.getService()+eachUnit.getBranch());
        }




    }
}
