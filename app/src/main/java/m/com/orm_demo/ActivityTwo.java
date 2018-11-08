package m.com.orm_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.activeandroid.query.Select;

import java.util.List;

public class ActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_details);

        TextView t1 =  findViewById(R.id.textView2);
        TextView t2 =  findViewById(R.id.textView3);
        TextView t3 =  findViewById(R.id.textView4);

        //orm

        List <StudentBO> stuDet =  getAll();

        if (stuDet != null)
        {
            StudentBO s = stuDet.get((stuDet.size())-1);

            t1.setText(s.name);
            t2.setText(s.email);
            t3.setText(s.aNumber);

            s.name ="new name";
            s.save();


        }

    }

    private List<StudentBO> getAll() {

        return new Select()
                .from(StudentBO.class)
                .orderBy("tableName ASC")
                .execute();
    }
}
