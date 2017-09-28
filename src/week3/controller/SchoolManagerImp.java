package week3.controller;

import week3.controller.enums.EnumChange;
import week3.controller.enums.EnumSort;
import week3.model.Student;
import week3.model.StudentGroup;

public class SchoolManagerImp implements SchoolManager {

	private StudentGroup group = new StudentGroup();
	private MyScanner scanner = new IO();

	@Override
	public void showMenu() {
		scanner.write("Menu");
		scanner.write("1) ADD STUDENT");
		scanner.write("2) REMOVE STUDENT");
		scanner.write("3) SEARCH SRUDENT");
		scanner.write("4) EDIT STUDENT");
		scanner.write("5) SORT STUDENTS");
		scanner.write("6) SHOW STUDENTS");
		scanner.write("7) EXIT");
	}

	@Override
	public void addStudent() {
		group.add(new Student(scanner.readString("Enter the first name"), scanner.readString("Enter the last name"),
				scanner.readInt("Enter your age"), scanner.readDouble("Enter your avarage mark")));

		scanner.write("student successfully added");
	}

	@Override
	public void removeStudent() {
		scanner.write("Remove option");
		scanner.write("1) REMOVE BY ID");
		scanner.write("2) REMOVE BY NAME");
		int inChoose = scanner.readInt("Choose your act");
		scanner.write(group.getString());
		if (inChoose == 1) {
			group.remove(scanner.readInt("Enter student id"));
			scanner.write("Student removed");
		} else if (inChoose == 2) {
			group.removeValue(scanner.readString("Enter the first name"), scanner.readString("Enter the last name"));
			scanner.write("Student removed");
		} else {
			scanner.write("Incorrect choose");
		}

	}

	@Override
	public void searchStudent() {
		Student studentString = group.search(scanner.readString("Enter the first name"));
		if (studentString != null) {
			scanner.write(studentString);
			scanner.readString("Enter anything to see the menu");
		}else {
			scanner.write("Did not search anithing");
		}
	}

	@Override
	public void sortStudents() {
		// Stufrnt[] students = group.sort();
		// group.toString();

		scanner.write("Which parameter to sort?");
		scanner.write("1) SORT BY FIRST NAME");
		scanner.write("2) SORT BY LAST NAME");
		scanner.write("3) SORT BY AGE");
		scanner.write("4) SORT BY AVERAGE MAKR");
		EnumSort inChoose = EnumSort.getSort(scanner.readInt("Choose your act"));
		switch (inChoose) {
		case SORT_BY_FIRST_NAME:{
			scanner.write(group.getString(group.sortByFirstName()));
			scanner.readString("Enter anything to see the menu");
			break;
		}
		case SORT_BY_LAST_NAME:{
			scanner.write(group.getString(group.sortByLastName()));
			scanner.readString("Enter anything to see the menu");
			break;
		}
		case SORT_BY_AGE:{
			scanner.write(group.getString(group.sortByAge()));
			scanner.readString("Enter anything to see the menu");
			break;
		}
		case SORT_BY_AVERAGE_MAKR:{
			scanner.write(group.getString(group.sortByAverageMark()));
			scanner.readString("Enter anything to see the menu");
			break;
		}
		case DEFAULT:{
			scanner.write(group.getString());
			scanner.readString("Enter anything to see the menu");
		}
		}

	}

	@Override
	public void showAllStudents() {
		scanner.write(group.getString());
		scanner.readString("Enter anything to see the menu");

	}

	@Override
	public void editStudent() {
		scanner.write("Searching...");
		int index = group.searchIndexName(scanner.readString("Enter the first name"),
				scanner.readString("Enter the last name"));
		if (index == -1) {
			scanner.write("Not result");
			return;
		}
		scanner.write("Which parameter you want to change?");
		scanner.write("1) CHANGE FIRST NAME");
		scanner.write("2) CHANGE LAST NAME");
		scanner.write("3) CHANGE AGE");
		scanner.write("4) CHANGE AVERAGE MAKR");
		scanner.write("5) CHANGE ALL");

		EnumChange inChoose = EnumChange.getChange(scanner.readInt("Choose your act"));
		switch (inChoose) {
		case CHANGE_FIRST_NAME: {
			group.edit(index, scanner.readString("Enter the first name"), group.get(index).getLastName(), 
					group.get(index).getAge(), group.get(index).getAverageMark());
			break;
		}
		case CHANGE_LAST_NAME: {
			group.edit(index, group.get(index).getFirstName(), scanner.readString("Enter the last name"), 
					group.get(index).getAge(), group.get(index).getAverageMark());
			break;
		}
		case CHANGE_AGE: {
			group.edit(index, group.get(index).getFirstName(), group.get(index).getLastName(), 
					scanner.readInt("Enter the age"), group.get(index).getAverageMark());
			break;
		}
		case CHANGE_AVERAGE_MAKR: {
			group.edit(index, group.get(index).getFirstName(), group.get(index).getLastName(), 
					group.get(index).getAge(), scanner.readDouble("Enter the avarage mark"));
			break;
		}
		case CHANGE_ALL: {
			group.edit(index, scanner.readString("Enter the first name"), scanner.readString("Enter the last name"), 
					scanner.readInt("Enter the age"), scanner.readDouble("Enter the avarage mark"));
		}
		}
	}
}