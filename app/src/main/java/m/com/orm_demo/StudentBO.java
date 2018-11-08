package m.com.orm_demo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Student")
public class StudentBO extends Model{

    public StudentBO() {
        super();
    }

    @Column(name = "tableName")
    public String name;

    @Column(name = "tableEmail")
    public String email;

    @Column(name = "studentid")
    public String aNumber;



}
