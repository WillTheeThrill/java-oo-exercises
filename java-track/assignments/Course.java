

import java.util.ArrayList;

public class Course {

	String name;
	String[] roster;
	int credits,seatNumber;
	public ArrayList<Student> list = new ArrayList<>();

	public Course (String name,int credits,int seatNumber){
		this.name = name;
		this.credits = credits;
		this.seatNumber = seatNumber;

	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getRemainingSeats() {
		return seatNumber;
	}

	public void setRemainingSeats(int seatNumber) {
		this.seatNumber = seatNumber;
	}


	public boolean addStudent(Student student){
		boolean added = false;
		if(list.isEmpty()){
			System.out.println("List is empty" + getRemainingSeats());
			list.add(student);
			setRemainingSeats(getRemainingSeats()-1);
			added=true;
			System.out.println( "Seats remaining" + getRemainingSeats());

		}else {
			if(list.contains(student.getName())){
				System.out.println("Name already exists");
			}else{
				System.out.println("person added");
				if(getRemainingSeats()>0){
					list.add(student);
					setRemainingSeats(getRemainingSeats()-1);
					added=true;
				}
			}
		}
		return added;
	}

	public String generateRoster(){

		if(list.size()>0){
			for(int i = 0;i<list.size();){
				String roster = list.get(i).getName();
				return roster;
			}
		}	
		return "Noone is in this class,maybe you aren't interesting.";
	}
    public double averageGPA(){
    	double agpa = 0;
    	for(int i=0;i<list.size();i++){
					agpa += list.get(i).getGPA();
    	}
    	
    	agpa = agpa/list.size();
    	return agpa;
    }	
	public String toString(){
		return "Course name: " + this.name + " " + this.credits;
	}
	public static void main(String[] args) {
		
		Course oneoone = new Course("Judo",5,5);
		Student will = new Student("Will","Thrill",123456);	
		
		System.out.println(oneoone.addStudent(will));
		System.out.println(oneoone.generateRoster());
	
	}

}
