package red.itvirtuoso.materialsearchviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class BasicActivity extends AppCompatActivity {
    private static final String TAG = BasicActivity.class.getName();
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        searchView = new MaterialSearchView(this);
        searchView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_main).getParent();
        while (viewGroup != null) {
            if (viewGroup instanceof ActionBarOverlayLayout) {
                viewGroup = (ViewGroup) viewGroup.getParent();
                viewGroup.addView(searchView);
                break;
            }
            viewGroup = (ViewGroup) viewGroup.getParent();
        }


        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }
}
