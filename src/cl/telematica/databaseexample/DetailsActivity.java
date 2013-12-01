package cl.telematica.databaseexample;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import cl.telematica.databaseexample.adapters.RssAdapterDetail;
import cl.telematica.databaseexample.database.DataBaseClass;
import cl.telematica.databaseexample.models.EarthQuakeDataModel;

public class DetailsActivity extends Activity {

	//private String url = null;
	//private WebView webView;
	//private ProgressBar mProgressBar;
	private ListView hPBarLayout;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		DataBaseClass dbInstance = new DataBaseClass(this);
		SQLiteDatabase db = dbInstance.getReadableDatabase();
		
		List <EarthQuakeDataModel> list = new ArrayList<EarthQuakeDataModel>();
		
		Cursor c = db.rawQuery("SELECT * FROM alumnos", null);
		if (c.moveToFirst()) {
			do {
				EarthQuakeDataModel model = new EarthQuakeDataModel();
				model.title = c.getString(1);
				model.magnitude = "Magnitude: "+c.getString(2);
				model.location = "Location: "+c.getString(3);
				model.depth = "Depth: "+c.getString(4);
				model.latitude = "Lat: "+c.getString(5);
				model.longitude = "Lng: "+c.getString(6);
				model.dateTime = "DateTime: "+c.getString(7);
				list.add(model);
			} while (c.moveToNext());
		}
		c.close();
		
		hPBarLayout = (ListView) findViewById(R.id.listView1);
		
		RssAdapterDetail adapter = new RssAdapterDetail(getApplicationContext(), R.string.app_name, list);
		hPBarLayout.setAdapter(adapter);
		

		// Agregado de Pancho
		// url = getIntent().getStringExtra(url);
		//
		// webView = (WebView) findViewById(R.id.webView);
		// hPBarLayout = (RelativeLayout) findViewById(R.id.hPBarLayout);
		// mProgressBar = (ProgressBar)
		// findViewById(R.id.legacy_navigation_progressBar);
		//
		// webView.getSettings().setJavaScriptEnabled(true);
		// webView.getSettings().setBuiltInZoomControls(true);

		// webView.setWebChromeClient(new WebChromeClient() {
		// public void onProgressChanged(WebView view, int progress)
		// {
		// mProgressBar.setProgress(progress);
		// }
		// });
		//
		// webView.setWebViewClient(new WebViewClient() {
		// @Override
		// public void onReceivedError(WebView view, int errorCode, String
		// description, String failingUrl)
		// {
		// // Handle the error
		// }
		//
		// @Override
		// public boolean shouldOverrideUrlLoading(WebView view, String url)
		// {
		// view.loadUrl(url);
		// return true;
		// }
		//
		// @Override
		// public void onPageStarted(WebView view, String url, Bitmap favicon){
		// hPBarLayout.setVisibility(View.VISIBLE);
		// super.onPageStarted(view, url, favicon);
		// }
		//
		// @Override
		// public void onPageFinished(WebView view, String url){
		// hPBarLayout.setVisibility(View.GONE);
		// super.onPageFinished(view, url);
		// }
		// });

		// }
		// }
		//
		// webView.loadUrl(url);
	}

}
