package db;

import models.Employee;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import util.HRManagerUtil;

public class EmployeeDB {

    private List<Employee> employees;

    public EmployeeDB() {
        addMockData();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void updateEmployee(Employee employee) {
        employees.set(getOldIndexInList(employee), employee);
    }

    private int getOldIndexInList(Employee employee) {
        for (Employee e : employees) {
            if(e.getId().equals(employee.getId())) {
                return employees.indexOf(e);
            }
        }
        return 0;
    }

    private void addMockData() {
        
        List<Employee> mockData = new ArrayList<>();

        try {
            mockData.add(new Employee("Max", "Muster", "IT Analyst", HRManagerUtil.formatter.parse("16.11.1980"), 30000.00, HRManagerUtil.formatter.parse("01.03.2001")));
            mockData.add(new Employee("Rora", "Farish", "HR Employee", HRManagerUtil.formatter.parse("12.12.1988"), 64000.00, HRManagerUtil.formatter.parse("01.02.2005")));
            mockData.add(new Employee("Gena", "Pudan", "Junior Designer", HRManagerUtil.formatter.parse("28.01.1990"), 35000.00, HRManagerUtil.formatter.parse("01.04.2001")));
            mockData.add(new Employee("Benji", "Caress", "Senior Visual Merchandise Associate", HRManagerUtil.formatter.parse("30.05.1992"), 42000.00, HRManagerUtil.formatter.parse("01.07.2010")));
            mockData.add(new Employee("Windham", "Duggan", "IT Trainee", HRManagerUtil.formatter.parse("24.07.2002"), 12000.00, HRManagerUtil.formatter.parse("01.08.2018")));
            mockData.add(new Employee("Nessa", "Sizland", "Full Stack Developer", HRManagerUtil.formatter.parse("19.09.2000"), 32540.00, HRManagerUtil.formatter.parse("01.08.2020")));
            mockData.add(new Employee("Mead", "Hunton", "Entry Level - Associate Designer", HRManagerUtil.formatter.parse("27.07.1971"), 45678.26, HRManagerUtil.formatter.parse("01.07.1990")));
            mockData.add(new Employee("Jeniffer", "Sevin", "Front End Developer", HRManagerUtil.formatter.parse("30.04.1983"), 86473.30, HRManagerUtil.formatter.parse("01.06.1999")));
            mockData.add(new Employee("Clayborn", "Redler", "Director", HRManagerUtil.formatter.parse("31.03.1951"), 126980.00, HRManagerUtil.formatter.parse("23.06.1970")));
            mockData.add(new Employee("Wandis", "Ellit", "Strategic Data Analyst", HRManagerUtil.formatter.parse("03.06.1953"), 14532.16, HRManagerUtil.formatter.parse("01.02.1970")));
            mockData.add(new Employee("Rolph", "Liven", "Product Designer", HRManagerUtil.formatter.parse("09.07.1966"), 50640.00, HRManagerUtil.formatter.parse("16.01.1989")));
            mockData.add(new Employee("Lotta", "Buncombe", "Banking Relationship Specialist", HRManagerUtil.formatter.parse("18.11.1993"), 12345.67, HRManagerUtil.formatter.parse("01.07.2012")));
            mockData.add(new Employee("Thaddus", "Gergler", "Wealth Management Banking Specialist", HRManagerUtil.formatter.parse("16.10.1997"), 98765.12, HRManagerUtil.formatter.parse("01.04.2016")));
            mockData.add(new Employee("Huntlee", "McMurtyr", "Intern", HRManagerUtil.formatter.parse("05.08.1997"), 12120.00, HRManagerUtil.formatter.parse("01.09.2019")));
            mockData.add(new Employee("Leonelle", "Diben", "Electronic Banking Specialist", HRManagerUtil.formatter.parse("01.02.1990"), 100000.11, HRManagerUtil.formatter.parse("01.08.2009")));
            mockData.add(new Employee("Stanislaus", "Carp", "Consumer Banking Global Analytics", HRManagerUtil.formatter.parse("23.04.1981"), 85421.00, HRManagerUtil.formatter.parse("01.10.2005")));
            mockData.add(new Employee("Wynn", "Oriel", "Virtual Banking Specialist", HRManagerUtil.formatter.parse("12.05.1985"), 98453.00, HRManagerUtil.formatter.parse("14.12.1999")));
            mockData.add(new Employee("Galvin", "Babington", "CEO", HRManagerUtil.formatter.parse("01.05.1966"), 250000.00, HRManagerUtil.formatter.parse("01.11.1985")));
            mockData.add(new Employee("Annie", "MacAskie", "Financial Specialist", HRManagerUtil.formatter.parse("25.08.1969"), 29000.45, HRManagerUtil.formatter.parse("01.07.1988")));
            mockData.add(new Employee("Thedrick", "Bruun", "HR Coordinator", HRManagerUtil.formatter.parse("01.12.2000"), 55000.99, HRManagerUtil.formatter.parse("01.07.2020")));
        } catch (ParseException parseException) {
            System.out.println("Error parsing mockData Date " + parseException.getMessage());
            System.exit(1);
        }

        employees = mockData;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
