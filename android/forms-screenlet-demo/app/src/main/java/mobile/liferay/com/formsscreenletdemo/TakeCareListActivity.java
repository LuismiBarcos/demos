package mobile.liferay.com.formsscreenletdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.liferay.mobile.screens.asset.AssetEntry;
import com.liferay.mobile.screens.asset.list.AssetListScreenlet;
import com.liferay.mobile.screens.base.list.BaseListListener;
import com.liferay.mobile.screens.util.AndroidUtil;
import java.util.List;

public class TakeCareListActivity extends AppCompatActivity implements BaseListListener<AssetEntry> {

	private AssetListScreenlet assetListScreenlet;
	private final String ENTRY_ID = "entryId";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_care_list);

		assetListScreenlet = findViewById(R.id.asset_list_screenlet);
		assetListScreenlet.setListener(this);
	}

	@Override
	public void onListPageFailed(int startRow, Exception e) {
		int icon = R.drawable.default_error_icon;
		int backgroundColor =
			ContextCompat.getColor(this, com.liferay.mobile.screens.viewsets.lexicon.R.color.lightRed);
		String message = getString(R.string.request_failed);

		AndroidUtil.showCustomSnackbar(assetListScreenlet, message, Snackbar.LENGTH_LONG, backgroundColor, Color.WHITE,
			icon);
	}

	@Override
	public void onListPageReceived(int startRow, int endRow, List<AssetEntry> entries, int rowCount) {

	}

	@Override
	public void onListItemSelected(AssetEntry element, View view) {
		Intent intent = new Intent(this, TakeCareVideoActivity.class);
		intent.putExtra(ENTRY_ID, Long.valueOf(element.getValues().get(ENTRY_ID).toString()));
		startActivity(intent);
	}

	@Override
	public void error(Exception e, String userAction) {

	}
}
