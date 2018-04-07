package az.itstep.azjava.testapp.model;

public class Employee {

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String department;
    /*
    /employee
        GET -> list<employee>
        POST employee -> saved employee with generated ID
        PUT employee -> updated employee

        /{id}
            DELETE -> delete employee with ID == {id}
            GET -> get employee with ID == {id}

     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
