package  com.example.class_attendence;
public class modelclass {
    static String SectionName;
    static String DepartmentName;
    static String SemesterNo;
    static int noOfWeeks;

    public static void setSectionName(String semesterName) {
        SectionName = semesterName;
    }

    public static void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public static void setSemesterNo(String semesterNo) {
        SemesterNo = semesterNo;
    }

    public static void setNoOfWeeks(int noOfWeeks) {
        modelclass.noOfWeeks = noOfWeeks;
    }

    public static String getSectionName() {
        return SectionName;
    }

    public static String getDepartmentName() {
        return DepartmentName;
    }

    public static String getSemesterNo() {
        return SemesterNo;
    }

    public static int getNoOfWeeks() {
        return noOfWeeks;
    }
    public modelclass(){

    }
    public modelclass(String SectionName,String DepartmentName,String SemesterNo,int noOfWeeks ) {
        this.SectionName=SectionName;
        this.DepartmentName=DepartmentName;
        this.SemesterNo=SemesterNo;
        this.noOfWeeks=noOfWeeks;
    }
}
