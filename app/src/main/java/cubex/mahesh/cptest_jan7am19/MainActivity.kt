package cubex.mahesh.cptest_jan7am19

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readAllContacts()

        srch.setOnClickListener {
            readIndividualContact()
        }

    } // onCreate( )

    fun  readIndividualContact( )
    {
        var cResolver = contentResolver   //1
        /*
         * (@RecentlyNonNull Uri uri,
         * @RecentlyNullable String[] projection,
          * @RecentlyNullable String selection,
           * @RecentlyNullable String[] selectionArgs,
            * @RecentlyNullable String sortOrder */
        var c:Cursor = cResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            "display_name=?",
            arrayOf(et1.text.toString()),
            null)     //2

        val from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER)
        val to = intArrayOf(R.id.name,R.id.number)

/* Context context, int layout, Cursor c,
 String[] from, int[] to, int flags*/
        var cAdapter = SimpleCursorAdapter(
            this@MainActivity,
            R.layout.indiview,c,from,to,0)   // 3
        lview.adapter = cAdapter   // 4
    }


    fun  readAllContacts( )
    {
        var cResolver = contentResolver   //1
        /*
         * (@RecentlyNonNull Uri uri,
         * @RecentlyNullable String[] projection,
          * @RecentlyNullable String selection,
           * @RecentlyNullable String[] selectionArgs,
            * @RecentlyNullable String sortOrder */
        var c:Cursor = cResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,null,null,
            null)     //2

        val from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER)
        val to = intArrayOf(R.id.name,R.id.number)

/* Context context, int layout, Cursor c,
 String[] from, int[] to, int flags*/
        var cAdapter = SimpleCursorAdapter(
            this@MainActivity,
            R.layout.indiview,c,from,to,0)   // 3
        lview.adapter = cAdapter   // 4
    }
}
