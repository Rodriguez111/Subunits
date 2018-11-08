public class Subunit {

    private String department = "";
    private String service = "";
    private String branch = "";

    private int departmentNumber = -1;
    private  int serviceNumber = -1;
    private int branchNumber = -1;


    public Subunit(String department, String service, String branch) {




       if(!department.equals("")) {
           this.departmentNumber = Integer.parseInt(department.substring(1));
           this.department = department;
       }

        if(!service.equals("")) {
            this.serviceNumber = Integer.parseInt(service.substring(2));
            this.service = "\\"+service;
        }

        if(!branch.equals("")) {
            this.branchNumber = Integer.parseInt(branch.substring(3));
            this.branch = "\\"+branch;
        }

    }

    public String getDepartment() {
        return department;
    }

    public String getService() {
        return service;
    }

    public String getBranch() {
        return branch;
    }


    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public int getBranchNumber() {
        return branchNumber;
    }
}
