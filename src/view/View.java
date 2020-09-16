package view;

import db.EmployeeDB;
import models.Employee;
import util.HRManagerUtil;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeDB db = new EmployeeDB();
    private static final String[] EDIT_OPTIONS = new String[]{"Done", "Name", "Birth date", "Job description", "Salary", "Employment date"};
    private boolean editFinished = false;
    private Employee employee;


    /**
     * Show the interface to add a employee to the db
     */
    public void showAddEmployee() {
        System.out.println("Add an Employee:");
        System.out.println();

        employee = getNewEmployee();
        db.addEmployee(employee);
    }

    /**
     * Show the interface to edit a employee to the db
     */
    public void showEditEmployee() {
        idToGetEmployee("edit");

        printEmployee(employee);

        while (!editFinished) {
            printEditMenu();
        }

    }

    private void printEditMenu() {
        for (int i = 1; i <= EDIT_OPTIONS.length; i++) {
            System.out.println(i + ". " + EDIT_OPTIONS[i - 1]);
        }
        System.out.println();
        System.out.println("To edit, please select element between 1 and " + EDIT_OPTIONS.length + ":");

        editMenu();
    }

    private void editMenu() {
        while (!editFinished) {
        int selectedMenuId = 0;
        try {
            selectedMenuId = Integer.parseInt(scanner.nextLine());
        } catch (Exception ignored) { }
            showEditMenu(selectedMenuId);
            db.updateEmployee(employee);
        }
    }

    private void showEditMenu(int selectedMenuId) {
        switch (selectedMenuId) {
            case 1:
                editFinished = true;
                break;
            case 2:
                editName();
                break;
            case 3:
                editBirthdate();
                break;
            case 4:
                editJobDescription();
                break;
            case 5:
                editSalery();
                break;
            case 6:
                editEmploymentDate();
                break;
            default:
                System.out.println("You selected a invalid option. please select again.");
                editMenu();
        }
    }

    /**
     * Show the list of all employees from the db
     */
    public void showListEmployees() {
        List<Employee> employeeList = db.getEmployees();

        System.out.printf("%10s %30s %22s %40s %10s %22s\n", "ID", "NAME",
                "BIRTH DATE", "JOB DESCRIPTION", "SALARY", "EMPLOYMENT DATE");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (Employee employee : employeeList) {
            showEmployee(employee);
        }
    }

    /**
     * Show the interface to delete a employee
     */
    public void showDeleteEmployee() {
        idToGetEmployee("delete");

        db.deleteEmployee(employee);
    }

    private void idToGetEmployee(String function) {
        showListEmployees();
        while (true) {
            System.out.println("Id to " + function + ": ");
            String id = scanner.nextLine();

            employee = null;
            for (Employee e : db.getEmployees()) {
                if (e.getId().equals(id)) {
                    employee = e;
                    break;
                }
            }
            if (employee != null) {
                break;
            }
            System.out.println("Id was not found, please try again!");
        }
    }

    /**
     * Internal method to print out a employee
     *
     * @param employee to show
     */
    private void showEmployee(Employee employee) {
        System.out.printf("%10s %30s %22s %40s %10s %22s\n",
                employee.getId(),
                employee.getPrename() + " " + employee.getSurname(),
                HRManagerUtil.formatter.format(employee.getBirthdate()),
                employee.getJobDescription(),
                employee.getSalary(),
                HRManagerUtil.formatter.format(employee.getEmploymentDate()));
    }

    private Employee getNewEmployee() {
        String prename = prenameGetUserInput();
        String surname = surnameGetUserInput();
        String jobDescription = jobDescriptionGetUserInput();
        Date birthdate = birthdateGetUserInput();
        Double salary = salaryGetUserInput();
        Date employmentDate = employmentDateGetUserInput();

        employee = new Employee(prename, surname, jobDescription, birthdate, salary, employmentDate);

        return employee;
    }

    private String prenameGetUserInput() {
        System.out.print("Prename: ");
        String prename = scanner.nextLine();
        System.out.println();
        return prename;
    }

    private String surnameGetUserInput() {
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.println();
        return surname;
    }

    private String jobDescriptionGetUserInput() {
        System.out.print("Job description: ");
        String jobDescription = scanner.nextLine();
        System.out.println();
        return jobDescription;
    }

    private Date birthdateGetUserInput() {
        System.out.print("Birthdate (dd.MM.yyyy): ");
        return getDateInput();
    }

    private Date getDateInput() {
        String dateString = scanner.nextLine();
        System.out.println();
        Date date;
        try {
            date = HRManagerUtil.formatter.parse(dateString);
        } catch (ParseException exception) {
            exception.printStackTrace();
            System.out.println("Invalid date, please try again!");
            date = employmentDateGetUserInput();
        }
        return date;
    }

    private Double salaryGetUserInput() {
        System.out.print("Salary: ");
        String salaryString = scanner.nextLine();
        System.out.println();
        return Double.parseDouble(salaryString);
    }

    private Date employmentDateGetUserInput() {
        System.out.print("Employment date (dd.MM.yyyy): ");
        return getDateInput();
    }

    private void editEmploymentDate() {
        employee.setEmploymentDate(employmentDateGetUserInput());
    }

    private void editJobDescription() {
        employee.setJobDescription(jobDescriptionGetUserInput());
    }

    private void editBirthdate() {
        System.out.print("Birthdate (dd.MM.yyyy): ");
        try {
            employee.setBirthdate(HRManagerUtil.formatter.parse(scanner.nextLine()));
        } catch (ParseException exception) {
            System.out.println("Invalid date, please try again!");
            editMenu();
        }
    }

    private void editSalery() {
        employee.setSalary(salaryGetUserInput());
    }

    private void editName() {
        employee.setPrename(prenameGetUserInput());
        employee.setSurname(surnameGetUserInput());
    }

    private void printEmployee(Employee employee) {
        System.out.printf("%10s %30s %22s %40s %10s %22s\n", "ID", "NAME",
                "BIRTH DATE", "JOB DESCRIPTION", "SALARY", "EMPLOYMENT DATE");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        showEmployee(employee);
    }

    public void listRetiredEmployees() {
        List<Employee> allEmployees = db.getEmployees();

        System.out.printf("%10s %30s %22s %40s %10s %22s %5s %15s\n", "ID", "NAME",
                "BIRTH DATE", "JOB DESCRIPTION", "SALARY", "EMPLOYMENT DATE", "AGE", "RETIRED IN");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Employee employee : allEmployees) {
            LocalDate birthdate = Instant.ofEpochMilli(employee.getBirthdate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Period ageDiff = Period.between(birthdate, LocalDate.now());
            if(ageDiff.getYears() < 63) {
                continue;
            }
            LocalDate retirementDate = birthdate.plusYears(65);

            Period diffRetirement = Period.between(LocalDate.now(), retirementDate);

            int daysToRetire = diffRetirement.getDays();

            System.out.printf("%10s %30s %22s %40s %10s %22s %5s %15s\n",
                    employee.getId(),
                    employee.getPrename() + " " + employee.getSurname(),
                    HRManagerUtil.formatter.format(employee.getBirthdate()),
                    employee.getJobDescription(),
                    employee.getSalary(),
                    HRManagerUtil.formatter.format(employee.getEmploymentDate()),
                    ageDiff.getYears(),
                    daysToRetire < 1? "Retired" : daysToRetire + " Days");
        }
    }
}
