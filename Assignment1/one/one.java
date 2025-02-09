class Employee
{
	String name;
	double salary;
 
	Employee(String name , double salary){
	this.name=name;
	this.salary=salary;
	}
}

class SlipPrinter
{
	void print(Employee employee)
	{
		System.out.println("Employee:"+employee.name+"     ,     Salary:$"+employee.salary);
	}
}

interface EmployeeData{
	void save(Employee employee);
}

class SaveToDatabase implements EmployeeData
{
	public void save(Employee employee)
	{
		System.out.println("Saving Employee to database...");
}
}

class SaveToFile implements EmployeeData 
{
	public void save(Employee employee)
	{
		System.out.println("Saving Employee to File...");
	}
}

public class one
{
	public static void main(String [] args)
	{
		
		Employee emp= new Employee("Pravesh Subba",450000);
		
		SlipPrinter printkro = new SlipPrinter();
		printkro.print(emp);
 		
		EmployeeData dbsave = new SaveToDatabase();
		dbsave.save(emp);
		
		EmployeeData fsave = new SaveToFile();
		dbsave.save(emp);

	}
}	
