package m.com.orm_demo;

import com.activeandroid.Configuration;
import com.activeandroid.content.ContentProvider;

public class DBContentProvider extends ContentProvider {

    @Override
    protected Configuration getConfiguration() {
        Configuration.Builder builder = new Configuration.Builder(getContext());
        builder.addModelClass(StudentBO.class);
        return builder.create();
    }}
