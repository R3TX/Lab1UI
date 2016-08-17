package lab1ui.gr7.compumovil.udea.edu.co.lab1ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

/**
 * Created by andersson.villa on 17/08/16.
 */
public class AdapterItem implements AdapterView.OnItemSelectedListener {
    String stringSelected;
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        stringSelected = parent.getItemAtPosition(position).toString();
    }

    public String getStringSelected() {
        return stringSelected;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
