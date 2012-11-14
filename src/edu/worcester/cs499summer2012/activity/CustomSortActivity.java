/*
 * CustomSortActivity.java
 * 
 * Copyright 2012 Jonathan Hasenzahl, James Celona, Dhimitraq Jorgji
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.worcester.cs499summer2012.activity;

import android.os.Bundle;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import edu.worcester.cs499summer2012.R;
import edu.worcester.cs499summer2012.adapter.ComparatorListAdapter;
import edu.worcester.cs499summer2012.database.TasksDataSource;

/**
 * 
 * @author Jonathan Hasenzahl
 */
public final class CustomSortActivity extends SherlockListActivity {

	/**************************************************************************
	 * Static fields and methods                                              *
	 **************************************************************************/

	/**************************************************************************
	 * Private fields                                                         *
	 **************************************************************************/

	private TasksDataSource data_source;
	private static ComparatorListAdapter adapter;

	/**************************************************************************
	 * Class methods                                                          *
	 **************************************************************************/

	/**************************************************************************
	 * Overridden parent methods                                              *
	 **************************************************************************/

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Assign the layout to this activity
		setContentView(R.layout.activity_custom_sort);

		// Open the database
		data_source = TasksDataSource.getInstance(this);

		// Create an adapter for the task list
		adapter = new ComparatorListAdapter(this, data_source.getComparators());
		setListAdapter(adapter);
		
		// Allow Action bar icon to act as a button
        ActionBar action_bar = getSupportActionBar();
        action_bar.setHomeButtonEnabled(true);
        action_bar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_custom_sort, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_custom_sort_accept:
		case android.R.id.home:
			finish();

		default:
			return super.onOptionsItemSelected(item);
		}
	}
}