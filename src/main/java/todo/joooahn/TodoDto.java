package todo.joooahn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoDto {
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

    public String getRegDate() throws ParseException {
    	//String to Date
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date to = format.parse(regDate);
    	
    	//Date to String
    	format = new SimpleDateFormat("yyyy.MM.dd");
    	regDate = format.format(to);
   
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
