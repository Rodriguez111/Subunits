import java.util.Comparator;

public class SubunitComparator implements Comparator<Subunit> {


    public int compare(Subunit o1, Subunit o2) {

int result = o1.getDepartmentNumber() - o2.getDepartmentNumber();

if(result == 0){
    result = o1.getServiceNumber() - o2.getServiceNumber();
}
        if(result == 0){
            result = o1.getBranchNumber() - o2.getBranchNumber();
        }


        return result;
    }
}
