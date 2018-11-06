package com.example.android.inventoryapp1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.inventoryapp1.data.BookDbHelper;
import com.example.android.inventoryapp1.data.BookContract.BookEntry;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;

    private EditText mPriceEditText;

    private EditText mQuantityEditText;

    private EditText mSupplierEditText;

    private EditText mNumberEditText;

    private BookDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        mNameEditText = findViewById(R.id.edit_book_name);
        mPriceEditText = findViewById(R.id.edit_book_price);
        mQuantityEditText = findViewById(R.id.edit_book_quantity);
        mSupplierEditText = findViewById(R.id.edit_supplier_name);
        mNumberEditText = findViewById(R.id.edit_suplier_phone);

        mDbHelper = new BookDbHelper(this);
    }

    public void insertBook() {

        String nameString = mNameEditText.getText().toString().trim();
        String Price = mPriceEditText.getText().toString().trim();
        int price = Integer.parseInt(Price);
        String Quantity = mQuantityEditText.getText().toString().trim();
        int quantity = Integer.parseInt(Quantity);
        String supplier = mSupplierEditText.getText().toString().trim();
        String Number = mNumberEditText.getText().toString().trim();
        int number = Integer.parseInt(Number);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_BOOK_NAME, nameString);
        values.put(BookEntry.COLUMN_BOOK_PRICE, price);
        values.put(BookEntry.COLUMN_BOOK_QUANTITY, quantity);
        values.put(BookEntry.COLUMN_SUPPLIER_NAME, supplier);
        values.put(BookEntry.COLUMN_SUPPLIER_NO, number);

        // Insert a new row for Toto in the database, returning the ID of that new row.
        // The first argument for db.insert() is the pets table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for Toto.
        long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Book Added with the iD " + newRowId, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error in adding book", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                insertBook();
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}