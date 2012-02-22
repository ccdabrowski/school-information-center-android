/**
 * 
 */
package com.sst.school;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author rjha02
 * 
 */
public class FinderMain extends Activity {
	/** Called when the activity is first created. */
	SQLiteDatabase dh;
	ContentValues values;
	// CustomCursorAdapter adapter = null;
	// ImageHandling ih = null;
	GridView gvImage;
	TextView tvImage;
	private int count;
	private Cursor imagecursor, actualimagecursor;
	private int image_column_index, actual_image_column_index;
	BitmapDrawable setMe;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		gvImage = (GridView) findViewById(R.id.SocialNetworkingImageGrid);
		// tvImage = (TextView) findViewById(R.id.gridviewimage_title);
		// gvImage.setAdapter(new ImageAdapter(getApplicationContext()));
		gvImage.setAdapter(new ImageAdapter(this));
		gvImage.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				if (position == 0) {
					Intent onlineExam = new Intent(FinderMain.this,
							OnlineExam.class);
					System.out.println("onlineExam pressed");
					startActivity(onlineExam);
				}
				if (position == 1) {
					Intent infoCenter = new Intent(FinderMain.this,
							InfoCenter.class);
					System.out.println("infoCenter pressed");
					startActivity(infoCenter);
				}
				if (position == 2) {
					Intent classSchedular = new Intent(FinderMain.this,
							ClassSchedular.class);

					System.out.println("ClassSchedular pressed");
					startActivity(classSchedular);

				}
				if (position == 3) {
					Intent examSchedular = new Intent(FinderMain.this,
							ExamSchedular.class);
					System.out.println("ExamSchedular pressed");
					startActivity(examSchedular);
				}
				if (position == 4) {
					Intent studentList = new Intent(FinderMain.this,
							StudentList_ClassWise_SectionWise.class);
					System.out.println("studentList pressed");
					startActivity(studentList);
				}
				if (position == 5) {
					Intent teacherList = new Intent(FinderMain.this,
							TeacherList_SubjectWise.class);
					System.out.println("teacherList pressed");
					startActivity(teacherList);
				}
				if (position == 6) {
					Intent teacherAttendence = new Intent(FinderMain.this,
							wifi_Teacher_Attendence.class);
					System.out.println("teacherAttendence pressed");
					startActivity(teacherAttendence);
				}

				if (position == 7) {
					Intent enquirySystem = new Intent(FinderMain.this,
							EnquirySystem.class);
					System.out.println("teacherAttendence pressed");
					startActivity(enquirySystem);
				}
				if (position == 8) {
					Intent aboutCollege = new Intent(FinderMain.this,
							AboutCollege.class);
					System.out.println("teacherAttendence pressed");
					startActivity(aboutCollege);
				}
			}
		});

	}

	/*
	 * private void insertData(String title, byte[] bitmapData) {
	 * 
	 * if (values != null) { values.clear(); } if (dh == null) {
	 * AndroidContext.setContext(this); dh =
	 * DatabaseHelper.getInstance().getDb(); } values.put("title", title);
	 * values.put("logoimage", bitmapData);
	 * 
	 * dh.insert(DatabaseHelper.AIOSN_LOGO, null, values); }
	 */

	public class ImageAdapter extends BaseAdapter {
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return mThumbIds.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) { // if it's not recycled, initialize some
				// attributes
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(mThumbIds[position]);
			return imageView;
		}

		// references to our images
		private Integer[] mThumbIds = {R.drawable.online_exam,
				R.drawable.news_info_center, R.drawable.class_schedule,
				R.drawable.exam_schedule, R.drawable.student_list,
				R.drawable.teacher_list, R.drawable.wifi_attendence,
				R.drawable.enquiry_system, R.drawable.about_college};

	}
}
