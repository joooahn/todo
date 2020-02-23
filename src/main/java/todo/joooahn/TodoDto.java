package todo.joooahn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoDto implements Comparable<TodoDto>{

	long id;
    String title;
    String name;
    String regDate;
    int sequence;
    String Type;

    public TodoDto() {
    }

    public TodoDto(String title, String name, int sequence) {
        this.title = title;
        this.name = name;
        this.sequence = sequence;
    }

    @Override
	public int compareTo(TodoDto o) {
		// TODO Auto-generated method stub
    	if(this.sequence < o.sequence)
    	{
    		return -1;
    	}
    	else if(this.sequence > o.sequence)
    	{
    		return 1;
    	}
    	else return 0;
	}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegDate() {   
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", name=" + name + ", regDate=" + regDate + ", sequence="
				+ sequence + ", Type=" + Type + "]";
	}

}
