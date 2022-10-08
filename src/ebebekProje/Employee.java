package ebebekProje;

import java.time.LocalDate;
import java.time.Period;

public class Employee {

    String name;
    double salary;
    int workHours;
    int hireYear;
    double totalSalary;
    double toplamMaaş;

    Employee(String name, double salary, int workHours, int hireYear) {

        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;
        this.totalSalary=salary+tax(salary)+bonus(workHours);
        this.toplamMaaş=totalSalary+raiseSalary(hireYear, totalSalary);
    }

    public static void main(String[] args) {

        Employee s1=new Employee("Selahattin", 5500, 55, 2006);
        System.out.println(s1);

    }

    public double raiseSalary(int hireYear, double totalSalary) {


        int bugün= LocalDate.of(2021, 10, 6).getYear();
        int workYear=bugün-hireYear;
        double raiseSalary=0;

        if (workYear>19) {
            raiseSalary=totalSalary*0.15;
        } else if(workYear>9) {
            raiseSalary=totalSalary*0.10;
        } else {
            raiseSalary=totalSalary*0.05;
        }
        return raiseSalary;
    }

    public int bonus(int workHours) {
        int bonus = 0;
        if (workHours>40) {
            bonus=(workHours-40)*30;
        }else {
            bonus=0;
        }
        return bonus;
    }

    public double tax(double salary) {
        double tax;
        if (salary<1000) {
            tax=0;
        } else {
            tax=salary*0.03;
        }
        return tax;
    }


    public String toString() {

        return
                "Adı                : " + name
                        +"\nMaaşı              : " + salary
                        +"\nÇalışma Saati      : " + workHours
                        +"\nBaşlangıç Yılı     : " + hireYear
                        +"\nVergi              : " + tax(salary)
                        +"\nBonus              : " + bonus(workHours)
                        +"\nMaaş Artışı        : " + raiseSalary(hireYear, totalSalary)
                        +"\nVergi ve bonuslarla: " + totalSalary
                        +"\nToplam Maaş        : " + toplamMaaş;

    }


}

